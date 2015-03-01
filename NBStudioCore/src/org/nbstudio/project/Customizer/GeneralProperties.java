/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.project.customizer;

import javax.swing.JComponent;
import javax.swing.JPanel;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 *
 * @author daimor
 */
public class GeneralProperties implements ProjectCustomizer.CompositeCategoryProvider {

    private static final String GENERAL = "General";

    @ProjectCustomizer.CompositeCategoryProvider.Registration(
            projectType = "org-nbstudio-project", position = 10)
    public static GeneralProperties createGeneral() {
        return new GeneralProperties();
    }

    @NbBundle.Messages("LBL_Config_General=General")
    @Override
    public ProjectCustomizer.Category createCategory(Lookup lkp) {
        return ProjectCustomizer.Category.create(
                GENERAL,
                Bundle.LBL_Config_General(),
                null);
    }

    @Override
    public JComponent createComponent(ProjectCustomizer.Category category, Lookup lkp) {
        return new JPanel();
    }
}
