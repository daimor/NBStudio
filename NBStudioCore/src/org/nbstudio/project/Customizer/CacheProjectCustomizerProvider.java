/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.project.customizer;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.nbstudio.project.CacheProject;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.spi.project.ui.CustomizerProvider;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.awt.StatusDisplayer;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author daimor
 */
public class CacheProjectCustomizerProvider implements CustomizerProvider {

    public final CacheProject project;
    public static final String CUSTOMIZER_FOLDER_PATH = "Projects/org-nbstudio-project/Customizer";

    public CacheProjectCustomizerProvider(CacheProject project) {
        this.project = project;
    }

    @Override
    public void showCustomizer() {
        Dialog dialog = ProjectCustomizer.createCustomizerDialog(
                //Path to layer folder:
                CUSTOMIZER_FOLDER_PATH,
                //Lookup, which must contain, at least, the Project:
                Lookups.fixed(project),
                //Preselected category:
                "",
                //OK button listener:
                new OKOptionListener(),
                //HelpCtx for Help button of dialog:
                null);
        dialog.setTitle(ProjectUtils.getInformation(project).getDisplayName());
        dialog.setVisible(true);
    }

    private class OKOptionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            StatusDisplayer.getDefault().setStatusText("OK button clicked for "
                    + project.getProjectDirectory().getName() + " customizer!");
        }
    }

}
