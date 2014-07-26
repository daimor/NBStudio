/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import org.nbstudio.cachefilesystem.CacheFileObject;
import org.nbstudio.core.Connection;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author daimor
 */
public class RoutinesNode extends ConnectionFolderNode {

    public RoutinesNode(Connection conn) throws IntrospectionException {
        this(conn, null);
    }

    public RoutinesNode(Connection conn, CacheFileObject folder) throws IntrospectionException {
        super(conn, (folder == null) ? "Routines" : folder.getName());
        Children.Array children = new Children.Array();
        ArrayList<Node> nodes = new ArrayList<>();
        folder = (folder == null) ? (CacheFileObject) conn.getFileSystem().getRoot() : folder;
        CacheFileObject[] routines = folder.getChildren("*.mac,*.int");
        for (CacheFileObject fileObject : routines) {
            try {
                if (fileObject.isFolder()) {
                    nodes.add(new RoutinesNode(conn, fileObject));
                } else {
                    nodes.add(DataObject.find(fileObject).getNodeDelegate());
                }
            } catch (DataObjectNotFoundException ex) {
                System.out.println("routinesNode: " + ex.getLocalizedMessage());
            }
        }
        children.add(nodes.toArray(new Node[nodes.size()]));
        setChildren(children);
    }
}
