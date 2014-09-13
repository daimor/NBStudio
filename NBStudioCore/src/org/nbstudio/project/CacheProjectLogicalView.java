/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.project;

import java.awt.Image;
import javax.swing.Action;
import org.nbstudio.core.Connection;
import org.netbeans.spi.project.ui.LogicalViewProvider;
import org.netbeans.spi.project.ui.support.CommonProjectActions;
import org.netbeans.spi.project.ui.support.NodeFactorySupport;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;

/**
 *
 * @author daimor
 */
public class CacheProjectLogicalView implements LogicalViewProvider {

    private final CacheProject project;
    private final Connection conn;
    private final String projectName;

    public CacheProjectLogicalView(CacheProject project) {
        this.project = project;
        this.projectName = project.getProjectDirectory().getName();
        this.conn = project.getConnection();
//        FileObject projectFO = project.getProjectDirectory();
//        try {
//            CacheFileSystem fs;
//            fs = (CacheFileSystem) projectFO.getFileSystem();
//            this.conn = fs.getConnection();
//        } catch (FileStateInvalidException ex) {
//            throw new InternalError("Error open project");
//        }
    }

    @Override
    public Node createLogicalView() {
        try {
            FileObject projectDirectory = project.getProjectDirectory();
            DataFolder projectFolder = DataFolder.findFolder(projectDirectory);
            Node nodeOfProjectFolder = projectFolder.getNodeDelegate();
            return new ProjectNode(nodeOfProjectFolder, project);
        } catch (DataObjectNotFoundException donfe) {
            Exceptions.printStackTrace(donfe);
            return new AbstractNode(Children.LEAF);
        }
    }

    @Override
    public Node findPath(Node root, Object target) {
        return null;
    }

    private final class ProjectNode extends FilterNode {

        final CacheProject project;

        public ProjectNode(Node node, CacheProject project) throws DataObjectNotFoundException {
            super(node,
                    NodeFactorySupport.createCompositeChildren(project, "Projects/org-nbstudio-project/Nodes"),
//                    new FilterNode.Children(node),
                    new ProxyLookup(
                            new Lookup[]{
                                Lookups.singleton(project),
                                node.getLookup()
                            }
                    ));
            this.project = project;
        }

        @Override
        public Action[] getActions(boolean arg0) {
            return new Action[]{
                CommonProjectActions.newFileAction(),
                CommonProjectActions.copyProjectAction(),
                CommonProjectActions.deleteProjectAction(),
                CommonProjectActions.closeProjectAction(),
                CommonProjectActions.customizeProjectAction()
            };
        }

        @Override
        public Image getIcon(int type) {
            return ImageUtilities.loadImage("resources/prjFilesIcon.gif");
        }

        @Override
        public Image getOpenedIcon(int type) {
            return getIcon(type);
        }

        @Override
        public String getDisplayName() {
            return project.getProjectDirectory().getName();
        }
    }

//    class ProjectNodes extends Children.Array {
//
//        public ProjectNodes() {
//        }
//
//        @Override
//        protected void addNotify() {
//            ConnectionFolderNode[] nodesArr = new ConnectionFolderNode[2];
//            if (project.getProjectDirectory().isRoot()) {
//                try {
//                    nodesArr[0] = new ClassesNode(conn);
//                    nodesArr[1] = new RoutinesNode(conn);
//                } catch (IntrospectionException ex) {
//                }
//            } else {
//                try {
//                    List<CacheFileObject> classFiles = new ArrayList<>();
//                    List<CacheFileObject> routineFiles = new ArrayList<>();
//                    CacheFileSystem fs = conn.getFileSystem();
//                    CacheFileObject root = (CacheFileObject) fs.getRoot();
//
//                    CacheQuery q = new CacheQuery(conn.getAssociatedConnection(), "%Studio.Project", "ProjectItemsList");
//                    java.sql.ResultSet rs = q.execute(new Object[]{projectName});
//                    while (rs.next()) {
//                        String fileName = rs.getString("Name");
//                        String fileType = rs.getString("Type");
//                        CacheFileObject fo;
//
//                        if (null != fileType) {
//                            switch (fileType) {
//                                case "MAC":
//                                    fo = new CacheFileObject(fs, root, fileName);
//                                    routineFiles.add(fo);
//                                    break;
//                                case "CLS":
//                                    fo = new CacheFileObject(fs, root, fileName + ".cls");
//                                    classFiles.add(fo);
//                                    break;
//                            }
//                        }
//                    }
//
//                    nodesArr[0] = new ProjectSubNodes(conn, "Classess", classFiles);
//                    nodesArr[1] = new ProjectSubNodes(conn, "Routines", routineFiles);
//                } catch (CacheException | IntrospectionException | SQLException | DataObjectNotFoundException ex) {
//                }
//            }
//            this.add(nodesArr);
//        }
//    }

//    class ProjectSubNodes extends ConnectionFolderNode {
//
//        public ProjectSubNodes(Connection conn, String name, List<CacheFileObject> files) throws IntrospectionException, DataObjectNotFoundException {
//            super(conn, name);
//
//            Children.Array children = new Children.Array();
//            ArrayList<Node> nodes = new ArrayList<>();
//
//            for (CacheFileObject file : files) {
//                nodes.add(DataObject.find(file).getNodeDelegate());
//            }
//
//            children.add(nodes.toArray(new Node[nodes.size()]));
//            setChildren(children);
//        }
//    }
}
