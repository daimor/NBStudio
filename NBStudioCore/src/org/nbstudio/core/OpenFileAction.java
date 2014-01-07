/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import org.nbstudio.cachefilechooser.CacheFileChooser;
import org.nbstudio.cachefilesystem.CacheFileSystemView;
import org.nbstudio.cachefilesystem.CacheFileView;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.cookies.OpenCookie;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.filesystems.URLMapper;
import org.openide.loaders.DataObject;
import org.openide.util.NbBundle.Messages;
import org.openide.util.NbPreferences;

/**
 *
 * @author daimor
 */
@ActionID(category = "File", id = "org.mycore.OpenFileAction")
@ActionRegistration(displayName = "#CTL_OpenFileAction")
@ActionReference(path = "Menu/File", position = 10)
@Messages("CTL_OpenFileAction=Open File")
public class OpenFileAction implements ActionListener {

    static {
//        URL.setURLStreamHandlerFactory(new CacheURLHandlerFactory());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            CacheFileSystemView fsv = new CacheFileSystemView();
            Preferences preferences = NbPreferences.forModule(getClass());


            Map<String, Connection> connections = Connection.getConnections();
            for (Map.Entry<String, Connection> entry : connections.entrySet()) {
                String connectionName = entry.getKey();
                Connection connection = entry.getValue();
                fsv.addRoot(connection.getAssociatedConnection(), connectionName);
            }

            fsv.setShowSystemFiles(preferences.getBoolean("FileDialog.ShowSystemFiles", false));
            fsv.setShowGeneratedFiles(preferences.getBoolean("FileDialog.ShowGeneratedFiles", false));

            CacheFileChooser fileChooser = new CacheFileChooser(fsv);
            fileChooser.setFileView(new CacheFileView());
            fileChooser.setMultiSelectionEnabled(true);
            int height = preferences.getInt("FileDialog.Height", 500);
            int width = preferences.getInt("FileDialog.Width", 700);
            fileChooser.setPreferredSize(new Dimension(width, height));

            int answer = fileChooser.showOpenDialog(null);
            preferences.putBoolean("FileDialog.ShowSystemFiles", fsv.getShowSystemFiles());
            preferences.putBoolean("FileDialog.ShowGeneratedFiles", fsv.getShowGeneratedFiles());
            preferences.putInt("FileDialog.Height", fileChooser.getHeight());
            preferences.putInt("FileDialog.Width", fileChooser.getWidth());
            preferences.sync();
            if (answer == JFileChooser.APPROVE_OPTION) {
                File[] files = fileChooser.getSelectedFiles();
                System.out.println("selected files: ");
                for (File file : files) {
                    System.out.println(file.getAbsolutePath() + " - " + file.toURI() + " - " + file.toURI().toURL());

                    FileObject fileObject = URLMapper.findFileObject(file.toURI().toURL());
                    DataObject dataObject = DataObject.find(fileObject);
                    DataObject.find(fileObject).
                            getLookup().lookup(OpenCookie.class).open();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
