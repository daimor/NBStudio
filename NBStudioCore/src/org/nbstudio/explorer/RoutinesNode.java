/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import com.intersys.objects.CacheQuery;
import com.intersys.objects.Database;
import java.beans.IntrospectionException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.nbstudio.core.Connection;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileSystem;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author daimor
 */
public class RoutinesNode extends ConnectionEntryNode {

    public RoutinesNode(Connection conn) throws IntrospectionException {
        super(conn, "MAC Routines");
        Refresh();
    }

    private void Refresh() {
        try {
            Database db = this.getAssocatedConnection();
            CacheQuery qryRoutines = new CacheQuery(db, "%Library.Routine", "RoutineList");
            final ResultSet rsRoutines = qryRoutines.execute("*.mac");
            Children.SortedArray children = new Children.SortedArray();
            children.setComparator(new NodeComparator());
            ArrayList<Node> nodes = new ArrayList<Node>();
            while (rsRoutines.next()) {
                String rtnName = rsRoutines.getString("Name");
                FileSystem fs = FileUtil.createMemoryFileSystem();
                FileObject fob = fs.getRoot().createData(rtnName.substring(0, rtnName.length()-4 ), "mac");

                DataObject data = DataObject.find(fob);
                nodes.add(data.getNodeDelegate());
            }
            children.add(nodes.toArray(new Node[nodes.size()]));
            rsRoutines.close();
            db.close();
            setChildren(children);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
