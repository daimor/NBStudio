/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import javax.swing.JFileChooser;
import org.nbstudio.cachefilechooser.CacheFileChooser;
import org.nbstudio.cachefilechooser.CacheFileNameExtensionFilter;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.cookies.OpenCookie;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.URLMapper;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;

/**
 *
 * @author daimor
 */
@ActionID(category = "System", id = "org.netbeans.modules.openfile.OpenFileAction")
@ActionRegistration(displayName = "org.nbstudio.Bundle#CTL_OpenFileAction")
//@ActionReference(path = "Menu/File", position = 800)
public class OpenFileAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            CacheFileChooser fileChooser = new CacheFileChooser() {
                @Override
                public void updateUI() {
                    addChoosableFileFilter(new CacheFileNameExtensionFilter("Macro Routine", new String[]{"mac"}));
                    addChoosableFileFilter(new CacheFileNameExtensionFilter("Intermediate Routine", new String[]{"int", "mvi"}));
                    addChoosableFileFilter(new CacheFileNameExtensionFilter("Include File", new String[]{"inc"}));
                    addChoosableFileFilter(new CacheFileNameExtensionFilter("Basic File", new String[]{"bas"}));
                    addChoosableFileFilter(new CacheFileNameExtensionFilter("Class definition", new String[]{"cls"}));
                    addChoosableFileFilter(new CacheFileNameExtensionFilter("Cache Server Pages", new String[]{"csp"}));
                    addChoosableFileFilter(new CacheFileNameExtensionFilter("Other Files", new String[]{"xml", "js", "css", "xsl", "xsd"}));
                    super.updateUI();
                }
            };

            int answer = fileChooser.showOpenDialog(null);
            if (answer == JFileChooser.APPROVE_OPTION) {
                File[] files = fileChooser.getSelectedFiles();
                for (File file : files) {
                    FileObject fileObject = URLMapper.findFileObject(file.toURI().toURL());
                    DataObject.find(fileObject).
                            getLookup().lookup(OpenCookie.class).open();
                }
            }
        } catch (HeadlessException | MalformedURLException | DataObjectNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
