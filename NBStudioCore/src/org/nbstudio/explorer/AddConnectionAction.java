/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.AbstractAction;
import org.nbstudio.core.Connection;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileLock;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

/**
 *
 * @author daimor
 */
@ActionID(
        category = "RootActions",
        id = "org.nbstudio.core.AddConnectionAction")
@ActionRegistration(
        displayName = "#FN_addbutton")
@Messages(
        "FN_addbutton=Add Connection")
public class AddConnectionAction extends AbstractAction {

    private final DataFolder folder;

    public AddConnectionAction(DataFolder df) {
        folder = df;
    }

    @Messages({
        "FN_askurl_msg=server:port/namespace",
        "FN_askurl_title=New Connection",
        "FN_askurl_err=Invalid URL: |",
        "FN_cannotConnect_err=Cannot Connect!"
    })
    @Override
    public void actionPerformed(ActionEvent ae) {
        NotifyDescriptor.InputLine nd = new NotifyDescriptor.InputLine(
                Bundle.FN_askurl_msg(),
                Bundle.FN_askurl_title(),
                NotifyDescriptor.OK_CANCEL_OPTION,
                NotifyDescriptor.PLAIN_MESSAGE);
        Object result = DialogDisplayer.getDefault().notify(nd);
        if (result.equals(NotifyDescriptor.OK_OPTION)) {
            String urlString = nd.getInputText();
            String namespace = urlString.split("/")[1];
            urlString = urlString.split("/")[0];
            if (!urlString.contains(":")) {
                urlString += ":1972";
            }
            String address = urlString.split(":")[0];
            int port = Integer.parseInt(urlString.split(":")[1]);


            Connection conn = new Connection("conn", address, port, namespace);

            FileObject fld = folder.getPrimaryFile();
            String baseName = "Connection";
            int ix = 1;
            while (fld.getFileObject(baseName + ix, "ser") != null) {
                ix++;
            }
            try {
                FileObject writeTo = fld.createData(baseName + ix, "ser");
                FileLock lock = writeTo.lock();
                try {
                    ObjectOutputStream str = new ObjectOutputStream(writeTo.getOutputStream(lock));
                    try {
                        str.writeObject(conn);
                    } finally {
                        str.close();
                    }
                } finally {
                    lock.releaseLock();
                }
            } catch (IOException ioe) {
                Exceptions.printStackTrace(ioe);
            }
        }
    }
}
