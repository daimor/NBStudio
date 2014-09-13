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

    static class FilteredNodeChildren extends FilterNode.Children {

        private final CacheFileObject folder;
        private final CacheProject project;
        private final String filter;

        public FilteredNodeChildren(Node node, CacheProject project, String filter) {
            super(node);
            this.project = project;
            this.filter = filter;
            DataObject dataObject = (DataObject) node.getLookup().lookup(DataObject.class);
            assert dataObject != null;
            folder = (CacheFileObject) dataObject.getPrimaryFile();
            Logger.Log("FilteredNode: " + node);
        }

        @Override
        protected Node copyNode(Node node) {
            return new FilteredNode(node, null, project, filter);
        }

        @Override
        protected Node[] createNodes(Node key) {
            List<Node> result = new ArrayList<>();
//            DataObject dataObject = (DataObject) key.getLookup().lookup(DataObject.class);
//            assert dataObject != null;
//            CacheFileObject folder = (CacheFileObject) dataObject.getPrimaryFile();
//            CacheFileObject[] classes = folder.getChildren(this.filter);
//            Logger.Log("createNodes: " + key);
//            for (CacheFileObject fileObject : classes) {
//                try {
//                    Node node = DataObject.find(fileObject).getNodeDelegate();
//                    Logger.Log("createNodes4Node: " + node);
//                    result.add(node);
////                    result.add(copyNode(node));
////                    if (fileObject.isFolder()) {
////                        //                        setc
//////                        result.add(new FilteredNode(node, project, filter));
////                    } else {
////                        
////                    }
//                } catch (DataObjectNotFoundException ex) {
//                }
//            }
//            for (Node node : super.createNodes(key)) {
//                Logger.Log("createNodes4Node2: " + node);
//                DataObject dataObject = (DataObject) node.getLookup().lookup(DataObject.class);
//                if (dataObject != null) {
//                    FileObject fileObject = dataObject.getPrimaryFile();
//                    Logger.Log("fileObject: " + fileObject);
//                    //                    File file = FileUtil.toFile(fileObject);
//                    //                    if (fileFilter.accept(file)) {
//                    result.add(node);
//                    //                    }
//                }
//            }
            return result.toArray(new Node[result.size()]);
        }

    }

    public FilteredNode(Node node, String nodeName, CacheProject project, String filter) {
        super(node);
        if (nodeName != null) {
            disableDelegation(DELEGATE_SET_DISPLAY_NAME | DELEGATE_GET_DISPLAY_NAME);
            Logger.Log(node + " - " + nodeName + " - " + this);
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
//                Logger.Log("file: " + file + " - " + node);
            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
        }

        children.add(nodes.toArray(new Node[nodes.size()]));
        setChildren(children);
    }

}
