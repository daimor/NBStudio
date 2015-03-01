/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.project;

import org.nbstudio.cachefilesystem.CacheFileObject;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.NodeFactory;
import org.netbeans.spi.project.ui.support.NodeFactorySupport;
import org.netbeans.spi.project.ui.support.NodeList;
import org.openide.loaders.DataFolder;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;

/**
 *
 * @author daimor
 */
@NodeFactory.Registration(projectType = "org-nbstudio-project-sources", position = 20)
public class RoutinesNodeFactory implements NodeFactory {

    @Override
    public NodeList<?> createNodes(Project p) {
        CacheProject project = p.getLookup().lookup(CacheProject.class);
        assert project != null;
        CacheFileObject rootFolder = (CacheFileObject) project.getConnection().getFileSystem().getRoot();
        DataFolder projectFolder = DataFolder.findFolder(rootFolder);
        Node nodeOfProjectFolder = projectFolder.getNodeDelegate();
        FilterNode node = new FilterNode(nodeOfProjectFolder);
        return NodeFactorySupport.fixedNodeList(new FilteredNode(node, "Routines", project, "*.mac,*.int"));
    }
}
