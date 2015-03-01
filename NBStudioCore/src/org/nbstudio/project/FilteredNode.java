/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.project;

import java.util.ArrayList;
import java.util.List;
import org.nbstudio.cachefilesystem.CacheFileObject;
import org.nbstudio.utils.Logger;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;

/**
 *
 * @author daimor
 */
class FilteredNode extends FilterNode {

    public FilteredNode(Node node, String nodeName, CacheProject project, String filter) {
        super(node);
        if (nodeName != null) {
            disableDelegation(DELEGATE_SET_DISPLAY_NAME | DELEGATE_GET_DISPLAY_NAME);
            setDisplayName(nodeName);
        }
        Children.Array children = new Children.Array();
        ArrayList<Node> nodes = new ArrayList<>();

        DataObject dataObject = (DataObject) node.getLookup().lookup(DataObject.class);
        assert dataObject != null;
        CacheFileObject folder = (CacheFileObject) dataObject.getPrimaryFile();
        CacheFileObject[] files = folder.getChildren(filter);
        for (CacheFileObject file : files) {
            try {
                if (project.containsItem(file.getFullName())) {
                    node = DataObject.find(file).getNodeDelegate();
                    if (file.isFolder()) {
                        nodes.add(new FilteredNode(node, null, project, filter));
                    } else {
                        nodes.add(node);
                    }
                }
            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
        }

        children.add(nodes.toArray(new Node[nodes.size()]));
        setChildren(children);
    }
}
