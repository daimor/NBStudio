/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import com.intersys.objects.Database;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.nbstudio.core.Connection;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileSystem;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;

/**
 *
 * @author daimor
 */
public class ChildNode extends FilterNode.Children {

    ChildNode(Node Connection) {
        super(Connection);
    }

    @Override
    protected Node[] createNodes(Node n) {
        FileObject fo = n.getLookup().lookup(FileObject.class);
        boolean wrongFile = false;
        if (fo != null && fo.isFolder()) {
            try {
                return new Node[]{new RootNode(n)};
            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
        } else {
            try {
                if ((fo == null) || (!fo.getExt().equalsIgnoreCase("properties"))) {
                    throw new InternalError("IncompatibleExtFile");
                }
                Connection conn = new Connection(fo);

                if (conn == null) {
                    throw new InternalError();
                }
                Database db = conn.getAssociatedConnection();
                FileSystem fs = conn.getFileSystem();
                FileObject fob = fs.getRoot();
                try {
                    DataObject data = DataObject.find(fob);
                    Node tmpNode = data.getNodeDelegate();
                    tmpNode.setDisplayName(conn.getTitle());
                    return new Node[]{
                        tmpNode
//                        new ConnectionNode(conn)
                    };
                } catch (Exception ioe) {
                    Exceptions.printStackTrace(ioe);
                }
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            } catch (InternalError ex) {
                try {
                    fo.delete();
                } catch (IOException ex1) {
                }
                return new Node[]{};
            }
        }
        return new Node[]{new FilterNode(n)};
    }
}
