/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio;

/**
 *
 * @author daimor
 */
public class Localize {
    
    public static String getMessage(String resName) {
        return org.openide.util.NbBundle.getMessage(Localize.class, resName);
    }
}
