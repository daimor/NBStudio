/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import com.intersys.objects.Database;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.AbstractAction;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.loaders.DataFolder;
import org.openide.util.NbBundle.Messages;
import org.nbstudio.Localize;
import org.nbstudio.core.Connection;
import org.nbstudio.utils.Logger;
import org.openide.filesystems.FileLock;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

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
    private EditConnection editConnection = new EditConnection();
    private DialogDescriptor d = null;

    public AddConnectionAction(DataFolder df) {
        folder = df;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ((ae.getSource() == DialogDescriptor.CANCEL_OPTION)
                || (ae.getSource() == DialogDescriptor.CLOSED_OPTION)) {
            d.setClosingOptions(null);
        } else if (ae.getSource() == DialogDescriptor.OK_OPTION) {
            editConnection.setErrorMsg("");
            String name = editConnection.getServerName();
            String address = editConnection.getAddr();
            int superPort = editConnection.getSuperPort();
            if ((address.isEmpty()) || (superPort == 0)) {
                editConnection.setErrorMsg(Localize.getMessage("AddConnectionErrorAddress"));
                return;
            }
            String namespace = editConnection.getNamespace();
            String username = editConnection.getUsername();
            String password = editConnection.getPassword();
            Connection conn = new Connection(name, address, superPort, namespace, username, password);
            Database db = conn.getAssociatedConnection();
            if (db == null) {
                editConnection.setErrorMsg(Localize.getMessage("AddConnectionErrorConnect"));
                return;
            }
            d.setClosingOptions(null);
            /// Save added connect
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
        } else {
            d = new DialogDescriptor(editConnection, Localize.getMessage("AddConnectionTitle"), true, this);
            d.setClosingOptions(new Object[]{}); // not closeable
            editConnection.setErrorMsg("");
            DialogDisplayer.getDefault().notifyLater(d);
        }
    }
}
