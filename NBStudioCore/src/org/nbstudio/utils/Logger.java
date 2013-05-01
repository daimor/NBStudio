/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.utils;

import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;

/**
 *
 * @author daimor
 */
public class Logger {
    
    private static InputOutput io = IOProvider.getDefault().getIO("Task", true);

    public Logger() {
    }

    public static final void Log(String str) {
        io.getOut().println(str);
        io.getOut().close();
    }

    public static final void LogError(String str) {
        io.getErr().println(str);
        io.getErr().close();
    }
}
