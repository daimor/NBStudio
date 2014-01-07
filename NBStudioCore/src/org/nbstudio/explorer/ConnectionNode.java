/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.nbstudio.core.Connection;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author daimor
 */
public class ConnectionNode extends AbstractNode {

    private final Connection conn;

    public ConnectionNode(final Connection conn) {
        super(Children.LEAF, Lookups.fixed(conn));
        this.conn = conn;
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
            AbstractNode[] nodes = new AbstractNode[2];
            try {
                nodes[0] = new ClassesNode(conn);
                nodes[1] = new RoutinesNode(conn);
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
            new DeleteConnection()
        };
    }

    @Override
    public boolean canDestroy() {
        return true;
    }

    class DeleteConnection extends AbstractAction {

        public DeleteConnection() {
            putValue(NAME, "Delete Connection");
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                conn.delete();
                Node parentNode = getParentNode();
                if (parentNode instanceof ConnectionsNode) {
                    ((ConnectionsNode) parentNode).refresh();
                }
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }
}
