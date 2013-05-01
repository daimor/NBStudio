/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import org.nbstudio.explorer.RootNode;
import com.intersys.objects.Database;
import java.io.IOException;
import org.nbstudio.core.Connection;
import org.nbstudio.filesystems.ISCFileSystem;
import org.nbstudio.utils.Logger;
import org.openide.cookies.InstanceCookie;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileSystem;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.loaders.InstanceDataObject;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

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
        if (fo != null && fo.isFolder()) {
            try {
                return new Node[]{new RootNode(n)};
            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
        } else {
            Connection conn = getConnection(fo.getLookup());
            Database db = conn.getAssociatedConnection();
            FileSystem fs = new ISCFileSystem(db);
            FileObject fob = fs.getRoot();
            if (conn != null) {
                try {
                    DataObject data = DataObject.find(fob);
                    Node tmpNode = data.getNodeDelegate();
                    Logger.Log("node: " + tmpNode);
                    return new Node[]{
                        tmpNode
//                        new ConnectionNode(conn)
                    };
                } catch (Exception ioe) {
                    Exceptions.printStackTrace(ioe);
                }
            }
        }
        return new Node[]{new FilterNode(n)};
    }

    /**
     * Looking up a feed
     */
    private static Connection getConnection(Lookup lkp) {
        InstanceCookie ck = lkp.lookup(InstanceDataObject.class);
        if (ck == null) {
            throw new IllegalStateException("Bogus file in feeds folder: "
                    + lkp.lookup(FileObject.class));
        }
        try {
            return (Connection) ck.instanceCreate();
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return null;
    }
}
