/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core;

import java.io.IOException;
import java.util.Map;
import java.util.ResourceBundle;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        ResourceBundle rb = ResourceBundle.getBundle("org/nbstudio/version");
        System.setProperty("netbeans.buildnumber", rb.getString("FULLVERSION"));
    }
}
