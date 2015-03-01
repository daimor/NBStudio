/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.project;

import com.intersys.objects.CacheDatabase;
import com.intersys.objects.CacheException;
import com.intersys.objects.CacheQuery;
import com.intersys.objects.Database;
import java.awt.Component;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipInputStream;
import javax.swing.JComponent;
import javax.swing.event.ChangeListener;
import javax.swing.text.Document;
import javax.swing.text.Element;
import org.netbeans.api.templates.TemplateRegistration;
import org.netbeans.spi.project.ui.support.NodeList;
import org.netbeans.spi.project.ui.support.ProjectChooser;
import org.netbeans.spi.project.ui.templates.support.Templates;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.xml.XMLUtil;
import org.xml.sax.InputSource;

@TemplateRegistration(
        folder = "Project/MUMPS",
        content = "CacheProject.zip",
        displayName = "#CacheProjectWizardIterator_displayName",
        iconBase = "org/nbstudio/project/project.gif",
        targetName = "CacheProject",
        description = "CacheProject.html")
@Messages("CacheProjectWizardIterator_displayName=InterSystems Caché")
public final class CacheProjectWizardIterator implements WizardDescriptor.InstantiatingIterator<WizardDescriptor> {

    private int index;
    private WizardDescriptor wizard;
    private List<WizardDescriptor.Panel<WizardDescriptor>> panels;

    private List<WizardDescriptor.Panel<WizardDescriptor>> getPanels() {
        if (panels == null) {
            panels = new ArrayList<>();
            panels.add(new CacheProjectWizardPanel1());
            panels.add(new CacheProjectWizardPanel2());
            String[] steps = createSteps();
            for (int i = 0; i < panels.size(); i++) {
                Component c = panels.get(i).getComponent();
                if (steps[i] == null) {
                    // Default step name to component name of panel. Mainly
                    // useful for getting the name of the target chooser to
                    // appear in the list of steps.
                    steps[i] = c.getName();
                }
                if (c instanceof JComponent) { // assume Swing components
                    JComponent jc = (JComponent) c;
                    jc.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, i);
                    jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DATA, steps);
                    jc.putClientProperty(WizardDescriptor.PROP_AUTO_WIZARD_STYLE, true);
                    jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DISPLAYED, true);
                    jc.putClientProperty(WizardDescriptor.PROP_CONTENT_NUMBERED, true);
                }
            }
        }
        return panels;
    }

    @Override
    public Set<?> instantiate() throws IOException {
        Set<FileObject> resultSet = new LinkedHashSet<>();
        File dirF = FileUtil.normalizeFile((File) wizard.getProperty("projdir"));
        dirF.mkdirs();

        Properties propsProject = new Properties();
        propsProject.setProperty("server.addr", (String) wizard.getProperty("addr"));
        propsProject.setProperty("server.port", (String) wizard.getProperty("port"));
        propsProject.setProperty("server.namespace", (String) wizard.getProperty("namespace"));
        String cacheProjectName = (String) wizard.getProperty("cacheProjectName");
        propsProject.setProperty("server.project", (cacheProjectName == null) ? "" : cacheProjectName);
        propsProject.setProperty("server.login", (String) wizard.getProperty("login"));
        propsProject.setProperty("server.pass", (String) wizard.getProperty("pass"));
        
        FileObject template = Templates.getTemplate(wizard);
        FileObject dir = FileUtil.toFileObject(dirF);
        unZipFile(template.getInputStream(), dir, propsProject);

        resultSet.add(dir);

        File parent = dirF.getParentFile();
        if (parent != null && parent.exists()) {
            ProjectChooser.setProjectsFolder(parent);
        }

        return resultSet;
    }

    @Override
    public void initialize(WizardDescriptor wizard) {
        this.wizard = wizard;
        wizard.putProperty("WizardPanel_TestConnectionError", "");
    }

    @Override
    public void uninitialize(WizardDescriptor wizard) {
        panels = null;
    }

    @Override
    public WizardDescriptor.Panel<WizardDescriptor> current() {
        return getPanels().get(index);
    }

    @Override
    public String name() {
        return index + 1 + ". from " + getPanels().size();
    }

    @Override
    public boolean hasNext() {
        return index < getPanels().size() - 1;
    }

    @Override
    public boolean hasPrevious() {
        return index > 0;
    }

    @Override
    public void nextPanel() {
        if ((index == 0) && (!testConnection())) {
            return;
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index++;
    }

    public static Database getConnection(WizardDescriptor wizard, String nsp) throws CacheException {
        String addr = (String) wizard.getProperty("addr");
        String port = (String) wizard.getProperty("port");
        String login = (String) wizard.getProperty("login");
        String pass = (String) wizard.getProperty("pass");
        String connString = "jdbc:Cache://" + addr + ":" + port + "/" + nsp;
        pass = (pass.isEmpty() && login.isEmpty()) ? "SYS" : pass;
        login = login.isEmpty() ? "_SYSTEM" : login;
        return CacheDatabase.getLightDatabase(connString, login, pass);
    }

    boolean testConnection() {
        wizard.putProperty("WizardPanel_TestConnectionError", "");
        Database conn = null;
        try {
            conn = getConnection(wizard, "%SYS");
            CacheQuery query = new CacheQuery(conn, "%SYS.Namespace", "List");
            ResultSet rs = query.execute();
            List<String> nspList = new ArrayList<>();
            while (rs.next()) {
                String nsp = rs.getString("Nsp");
                nspList.add(nsp);
            }
            wizard.putProperty("WizardPanel_NSPList", nspList);
        } catch (CacheException ex) {
            String message = ex.getLocalizedMessage();
            String[] messages = message.split("\\[Cache JDBC\\]");
            message = messages[messages.length - 1];

            wizard.putProperty("WizardPanel_TestConnectionError", message);
            return false;
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
            wizard.putProperty("WizardPanel_TestConnectionError", ex.getLocalizedMessage());
            return false;
        } finally {
            if (conn != null && conn.isOpen()) {
                try {
                    conn.close();
                } catch (CacheException ex) {
                }
            }
        }
        return true;
    }

    @Override
    public void previousPanel() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        index--;
    }

    // If nothing unusual changes in the middle of the wizard, simply:
    @Override
    public void addChangeListener(ChangeListener l) {
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
    }
    // If something changes dynamically (besides moving between panels), e.g.
    // the number of panels changes in response to user input, then use
    // ChangeSupport to implement add/removeChangeListener and call fireChange
    // when needed

    // You could safely ignore this method. Is is here to keep steps which were
    // there before this wizard was instantiated. It should be better handled
    // by NetBeans Wizard API itself rather than needed to be implemented by a
    // client code.
    private String[] createSteps() {
        String[] beforeSteps = (String[]) wizard.getProperty("WizardPanel_contentData");
        assert beforeSteps != null : "This wizard may only be used embedded in the template wizard";
        String[] res = new String[(beforeSteps.length - 1) + panels.size()];
        for (int i = 0; i < res.length; i++) {
            if (i < (beforeSteps.length - 1)) {
                res[i] = beforeSteps[i];
            } else {
                res[i] = panels.get(i - beforeSteps.length + 1).getComponent().getName();
            }
        }
        return res;
    }

    private static void unZipFile(InputStream source, FileObject projectRoot, Properties props) throws IOException {
        try {
            ZipInputStream str = new ZipInputStream(source);
            ZipEntry entry;
            while ((entry = str.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    FileUtil.createFolder(projectRoot, entry.getName());
                } else {
                    FileObject fo = FileUtil.createData(projectRoot, entry.getName());
                    if ("cacheProject.properties".equals(entry.getName())) {
                        // Special handling for setting properties
                        filterProjectProperties(fo, str, props);
                    } else {
                        writeFile(str, fo);
                    }
                }
            }
        } finally {
            source.close();
        }
    }

    private static void writeFile(ZipInputStream str, FileObject fo) throws IOException {
        try (OutputStream out = fo.getOutputStream()) {
            FileUtil.copy(str, out);
        }
    }

    private static void filterProjectProperties(FileObject fo, ZipInputStream str, Properties props) throws IOException {
        try {
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileUtil.copy(str, baos);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            
            Properties propsOriginal = new Properties();            
            propsOriginal.load(bais);
            Properties propsProject = new Properties();
            propsProject.putAll(propsOriginal);
            propsProject.putAll(props);
            
            try (OutputStream out = fo.getOutputStream()) {
                propsProject.store(out, "Caché Project Properties File");
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
            writeFile(str, fo);
        }
    }

}
