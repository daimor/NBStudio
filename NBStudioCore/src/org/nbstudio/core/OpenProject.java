/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core;

import org.nbstudio.project.CacheProject;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.JFileChooser;
import org.nbstudio.cachefilechooser.CacheFileChooser;
import org.nbstudio.cachefilechooser.CacheFileNameExtensionFilter;
import org.nbstudio.cachefilesystem.CacheFileSystem;
import org.netbeans.api.project.ProjectManager;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.URLMapper;

/**
 *
 * @author daimor
 */
//@ActionID(category = "Project", id = "org.netbeans.modules.project.ui.OpenProject")
//@ActionRegistration(
//        displayName = "org.nbstudio.Bundle#CTL_OpenProject",
//        iconBase = "org/nbstudio/core/resources/openProject.png")
public class OpenProject implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            CacheFileChooser fileChooser = new CacheFileChooser();
            fileChooser.setMultiSelectionEnabled(false);
            fileChooser.getFileSystemView().setShowProjectFiles(true);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new CacheFileNameExtensionFilter("Project files", new String[]{"prj"}));
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int answer = fileChooser.showOpenDialog(null);
            if (answer == JFileChooser.APPROVE_OPTION) {
                File[] files;
                if (fileChooser.isMultiSelectionEnabled()) {
                    files = fileChooser.getSelectedFiles();
                } else {
                    files = new File[]{fileChooser.getSelectedFile()};
                }
                for (File file : files) {
                    URL fileURL = file.toURI().toURL();
                    FileObject fileObject = URLMapper.findFileObject(fileURL);
                    CacheProject prj = (CacheProject) ProjectManager.getDefault().findProject(fileObject);
                    CacheFileSystem fs = (CacheFileSystem) fileObject.getFileSystem();
//                    if (fs.getConnection().addProject(prj)) {
////                        OpenProjects.getDefault().open(new Project[]{prj}, false);
//                    }
                }
            }
        } catch (HeadlessException | IOException | IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }
}
