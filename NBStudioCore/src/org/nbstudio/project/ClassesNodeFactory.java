/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.project;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import org.nbstudio.cachefilesystem.CacheFileObject;
import org.nbstudio.project.FilteredNode.FilteredNodeChildren;
import org.nbstudio.utils.Logger;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.NodeFactory;
import org.netbeans.spi.project.ui.support.NodeFactorySupport;
import org.netbeans.spi.project.ui.support.NodeList;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObject;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;

/**
 *
 * @author daimor
 */
@NodeFactory.Registration(projectType = "org-nbstudio-project-sources", position = 10)
public class ClassesNodeFactory implements NodeFactory {

    @Override
    public NodeList<?> createNodes(Project p) {
        CacheProject project = p.getLookup().lookup(CacheProject.class);
        assert project != null;
        CacheFileObject rootFolder = (CacheFileObject) project.getConnection().getFileSystem().getRoot();
        DataFolder projectFolder = DataFolder.findFolder(rootFolder);
        Node nodeOfProjectFolder = projectFolder.getNodeDelegate();
        return NodeFactorySupport.fixedNodeList(new FilteredNode(nodeOfProjectFolder, "Classes", project, "*.cls"));
    }

//    private static class ClassesNode extends FilterNode {
//
//        public ClassesNode(Node node, CacheProject project) {
//            super(node,
//                    new FilteredNodeChildren(node, project, "*.cls"),
//                    new ProxyLookup(
//                            new Lookup[]{
//                                Lookups.singleton(project),
//                                node.getLookup()
//                            }
//                    ));
////            setDisplayName("Classes");
//        }
//        
//
//        @Override
//        public Image getIcon(int type) {
//            return ImageUtilities.loadImage("org/nbstudio/core/folderClosed.gif");
//        }
//
//        @Override
//        public Image getOpenedIcon(int type) {
//            return ImageUtilities.loadImage("org/nbstudio/core/folderOpened.gif");
//        }
//    }

}
