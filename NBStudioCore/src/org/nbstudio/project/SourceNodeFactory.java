/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.project;

import com.intersys.objects.Database;
import java.awt.Image;
import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.event.ChangeListener;
import org.nbstudio.cachefilesystem.CacheFileObject;
import org.nbstudio.core.Connection;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.NodeFactory;
import org.netbeans.spi.project.ui.support.NodeFactorySupport;
import org.netbeans.spi.project.ui.support.NodeList;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
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
@NodeFactory.Registration(projectType = "org-nbstudio-project", position = 10)
public class SourceNodeFactory implements NodeFactory {

    @Override
    public NodeList<?> createNodes(Project p) {
        CacheProject project = p.getLookup().lookup(CacheProject.class);
        assert project != null;
        FileObject projectDirectory = project.getProjectDirectory();
        DataFolder projectFolder = DataFolder.findFolder(projectDirectory);
        Node nodeOfProjectFolder = projectFolder.getNodeDelegate();
        return NodeFactorySupport.fixedNodeList(new SourceNode(nodeOfProjectFolder, project));
    }

    private static class SourceNode extends FilterNode {

        public SourceNode(Node node, CacheProject project) {
            super(node,
                    NodeFactorySupport.createCompositeChildren(project, "Projects/org-nbstudio-project-sources/Nodes"),
                    new ProxyLookup(
                    new Lookup[]{
                Lookups.singleton(project),
                node.getLookup()
            }));
            setDisplayName("Source");
        }

        @Override
        public Image getIcon(int type) {
            return ImageUtilities.loadImage("org/nbstudio/core/folderClosed.gif");
        }

        @Override
        public Image getOpenedIcon(int type) {
            return ImageUtilities.loadImage("org/nbstudio/core/folderOpened.gif");
        }
    }

    private static class ClassesNodeList implements NodeList<ConnectionFolderNode> {

        private final CacheProject project;
        private final Connection conn;
        private CacheFileObject folder;

        public ClassesNodeList(CacheProject project) {
            this(project, null);
        }

        public ClassesNodeList(CacheProject project, CacheFileObject folder) {
            this.project = project;
            this.conn = project.getConnection();
            this.folder = folder;
        }

        @Override
        public List<ConnectionFolderNode> keys() {
            List<ConnectionFolderNode> nodes = new ArrayList<>();
            try {
                nodes.add(new ClassesNode(project));
                nodes.add(new RoutinesNode(project));
            } catch (IntrospectionException ex) {
            }
            return nodes;
        }

        @Override
        public Node node(ConnectionFolderNode node) {
            return new FilterNode(node);
        }

        @Override
        public void addChangeListener(ChangeListener l) {
        }

        @Override
        public void removeChangeListener(ChangeListener l) {
        }

        @Override
        public void addNotify() {
        }

        @Override
        public void removeNotify() {
        }
    }

    private static class ConnectionFolderNode extends AbstractNode {

        private final CacheProject project;

        public ConnectionFolderNode(CacheProject project, String name) throws IntrospectionException {
            super(Children.LEAF, Lookups.fixed(project));
            setDisplayName(name);
            this.project = project;
        }

        public final Database getAssocatedConnection() {
            return project.getConnection().getAssociatedConnection();
        }

        @Override
        public Image getIcon(int type) {
            return ImageUtilities.loadImage("org/nbstudio/core/folderClosed.gif");
        }

        @Override
        public Image getOpenedIcon(int type) {
            return ImageUtilities.loadImage("org/nbstudio/core/folderOpened.gif");
        }
    }

    private static class ClassesNode extends ConnectionFolderNode {

        public ClassesNode(CacheProject project) throws IntrospectionException {
            this(project, null);
        }

        public ClassesNode(CacheProject project, CacheFileObject folder) throws IntrospectionException {
            super(project, (folder == null) ? "Classess" : folder.getName());
            Children.Array children = new Children.Array();
            ArrayList<Node> nodes = new ArrayList<>();
            folder = (folder == null) ? (CacheFileObject) project.getConnection().getFileSystem().getRoot() : folder;
            try {
                nodes.add(DataObject.find(folder).getNodeDelegate());
            } catch (DataObjectNotFoundException ex) {
                ex.printStackTrace();
            }
            children.add(nodes.toArray(new Node[nodes.size()]));
            setChildren(children);
        }
    }

    private static class RoutinesNode extends ConnectionFolderNode {

        public RoutinesNode(CacheProject project) throws IntrospectionException {
            this(project, null);
        }

        public RoutinesNode(CacheProject project, CacheFileObject folder) throws IntrospectionException {
            super(project, (folder == null) ? "Routines" : folder.getName());
            Children.Array children = new Children.Array();
            ArrayList<Node> nodes = new ArrayList<>();
            folder = (folder == null) ? (CacheFileObject) project.getConnection().getFileSystem().getRoot() : folder;
            CacheFileObject[] routines = folder.getChildren("*.mac,*.int");
            for (CacheFileObject fileObject : routines) {
                try {
                    if (fileObject.isFolder()) {
                        nodes.add(new RoutinesNode(project, fileObject));
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
}
