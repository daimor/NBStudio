/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import java.awt.Image;
import javax.swing.Action;
import org.nbstudio.core.Connection;
import org.openide.actions.DeleteAction;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.ImageUtilities;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author daimor
 */
public class ConnectionNode extends AbstractNode {

    ConnectionNode(final Connection conn) {
        super(Children.LEAF, Lookups.fixed(conn));
        setDisplayName(conn.getTitle());
        setChildren(new ConnectionNodes(conn));
    }

    class ConnectionNodes extends Children.Array {

        private Connection conn;

        public ConnectionNodes(Connection conn) {
            this.conn = conn;
        }

        @Override
        protected void addNotify() {
            AbstractNode[] nodes = new AbstractNode[1];
            try {
                nodes[0] = new RoutinesNode(conn);
            } catch (Exception ex) {
            }
            this.add(nodes);
        }
    }

    @Override
    public Image getIcon(int type) {
        return ImageUtilities.loadImage("org/nbstudio/core/conn.gif");
    }

    @Override
    public Image getOpenedIcon(int type) {
        return getIcon(type);
    }

    @Override
    public Action[] getActions(boolean context) {
        return new Action[]{
            SystemAction.get(DeleteAction.class)
        };
    }
//
//    @Override
//    public boolean canDestroy() {
//        return true;
//    }
}
