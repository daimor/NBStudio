/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.utils;

import com.intersys.objects.SList;
import java.util.Iterator;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;

/**
 *
 * @author daimor
 */
public class Logger {

    private static final InputOutput io = IOProvider.getDefault().getIO("Task", false);

    public Logger() {
    }

    public static final void Log(String str) {
        io.getOut().println(str);
        io.getOut().close();
    }

    public static final void LogAdd(String str) {
        io.getOut().print(str);
        io.getOut().close();
    }

    public static final void Log(SList list) {
        for (Iterator<String> it = list.iterator(); it.hasNext();) {
            String str = it.next();
            str = (str == null) ? "" : str;
            io.getOut().println(str);
        }
        io.getOut().close();
    }

    public static final void LogError(String str) {
        io.getErr().println(str);
        io.getErr().close();
    }
}
