/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.NAME;
import javax.swing.JOptionPane;
import org.nbstudio.Localize;
import org.nbstudio.core.Connection;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.filesystems.FileAttributeEvent;
import org.openide.filesystems.FileChangeListener;
import org.openide.filesystems.FileEvent;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileRenameEvent;
import org.openide.filesystems.FileUtil;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;

/**
 *
 * @author daimor
 */
public class ConnectionsNode extends AbstractNode {

    private final FileObject connectionsFolder;

    public ConnectionsNode(FileObject connectionsFolder, String name) {
        super(Children.LEAF);
        this.connectionsFolder = connectionsFolder;
        setDisplayName(name);
        refresh();
    }

    private boolean isRoot() {
        return connectionsFolder.equals(FileUtil.getConfigFile("Connections"));
    }

    public final void refresh() {
        if (isRoot()) {
            Connection.clearConnections();
        }
        setChildren(new ConnectionsNodes());
    }

    class ConnectionsNodes extends Children.Array {

        public ConnectionsNodes() {
        }

        @Override
        protected void addNotify() {
            List<Node> nodes4Add = new ArrayList<>();
            FileObject[] children = connectionsFolder.getChildren();
            for (FileObject fileObject : children) {
                try {
                    if (fileObject.isFolder()) {
                        nodes4Add.add(new ConnectionsNode(fileObject, fileObject.getName()));
                    } else {
                        Connection conn = new Connection(fileObject);
                        nodes4Add.add(new ConnectionNode(conn));
                    }
                } catch (Exception ex) {
                    System.out.println("Error load connection file: " + fileObject.getNameExt() + " - " + ex.getLocalizedMessage());
                    try {
                        fileObject.delete();
                    } catch (IOException ex1) {
                    }
                }
            }
            this.add(nodes4Add.toArray(new Node[nodes4Add.size()]));
        }
    }

    @Override
    public Action[] getActions(boolean context) {
        return new Action[]{
            new AddConnection(),
            new AddFolder(),
            null,
            new Refresh(),
            null,
            new DeleteFolder()
        };
    }

    @Override
    public Image getIcon(int type) {
        return ImageUtilities.loadImage("org/nbstudio/core/folderClosed.gif");
    }

    @Override
    public Image getOpenedIcon(int type) {
        return ImageUtilities.loadImage("org/nbstudio/core/folderOpened.gif");
    }

    class AddConnection extends AbstractAction {

        private EditConnection editConnection = new EditConnection();
        private DialogDescriptor d = null;

        public AddConnection() {
            putValue(NAME, "Add connection");
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
                /// Save added connect
                FileObject fld = connectionsFolder;
                String baseName = name;
                if (fld.getFileObject(baseName, "properties") != null) {
                    int ix = 1;
                    while (fld.getFileObject(baseName + ix, "properties") != null) {
                        ix++;
                    }
                    baseName += ix;
                }
                FileObject writeTo = null;
                Connection conn = null;
                try {
                    writeTo = fld.createData(baseName, "properties");
                    conn = new Connection(writeTo, name, address, superPort, namespace, username, password);
                    Database db = conn.getAssociatedConnection();
                    System.out.println("AddConnection: " + db);
                    if (db == null) {
                        editConnection.setErrorMsg(Localize.getMessage("AddConnectionErrorConnect"));
                        System.out.println("AddConnectionError: db is null for " + conn.toString());
                        conn.delete();
                        return;
                    } else {
                        System.out.println("AddConnection: " + db.getConnectionString());
                        conn.save();
                        conn.close();
                        refresh();
                        d.setClosingOptions(null);
                    }
                } catch (Exception ex) {
                    Exceptions.printStackTrace(ex);
                    if (conn != null) {
                        try {
                            conn.delete();
                        } catch (Exception ex1) {
                        }
                    }
                }
            } else {
                d = new DialogDescriptor(editConnection, Localize.getMessage("AddConnectionTitle"), true, this);
                d.setClosingOptions(new Object[]{}); // not closeable
                editConnection.setErrorMsg("");
                DialogDisplayer.getDefault().notifyLater(d);
            }
        }
    }

    class AddFolder extends AbstractAction {

        public AddFolder() {
            putValue(NAME, "Add folder");
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            String newFolderName = (String) JOptionPane.showInputDialog(
                    null,
                    "Please enter folder name for connections:",
                    "Add folder",
                    JOptionPane.QUESTION_MESSAGE);

            if ((newFolderName != null) && (newFolderName.length() > 0)) {
                try {
                    connectionsFolder.createFolder(newFolderName);
                    refresh();
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }
    }

    class DeleteFolder extends AbstractAction {

        public DeleteFolder() {
            putValue(NAME, "Delete folder");
        }

        @Override
        public boolean isEnabled() {
            return !isRoot();
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                connectionsFolder.delete();
            } catch (Exception ex) {
            } finally {
                refresh();
            }
        }
    }

    class Refresh extends AbstractAction {

        public Refresh() {
            putValue(NAME, "Refresh");
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            refresh();
        }
    }
}
