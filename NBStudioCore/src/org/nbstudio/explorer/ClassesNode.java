/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import org.nbstudio.cachefilesystem.CacheFileObject;
import org.nbstudio.core.Connection;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author daimor
 */
public class ClassesNode extends ConnectionFolderNode {

    public ClassesNode(Connection conn) throws IntrospectionException {
        this(conn, null);
    }

    public ClassesNode(Connection conn, CacheFileObject folder) throws IntrospectionException {
        super(conn, (folder == null) ? "Classess" : folder.getName());
        Children.Array children = new Children.Array();
        ArrayList<Node> nodes = new ArrayList<Node>();
        folder = (folder == null) ? (CacheFileObject) conn.getFileSystem().getRoot() : folder;
        CacheFileObject[] classes = folder.getChildren("*.cls");
        for (CacheFileObject fileObject : classes) {
            try {
                if (fileObject.isFolder()) {
                    nodes.add(new ClassesNode(conn, fileObject));
                } else {
                    nodes.add(DataObject.find(fileObject).getNodeDelegate());
                }
            } catch (DataObjectNotFoundException ex) {
            }
        }
        children.add(nodes.toArray(new Node[nodes.size()]));
        setChildren(children);
    }
}
