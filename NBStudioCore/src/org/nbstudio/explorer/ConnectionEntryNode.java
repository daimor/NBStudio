/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import com.intersys.objects.Database;
import java.awt.Image;
import java.beans.IntrospectionException;
import javax.swing.Action;
import org.nbstudio.core.Connection;
import org.openide.actions.OpenAction;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.ImageUtilities;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author daimor
 */
public class ConnectionEntryNode  extends AbstractNode {

    private Connection conn;

    public ConnectionEntryNode(Connection conn, String name) throws IntrospectionException {
        super(Children.LEAF, Lookups.fixed(conn));
        setDisplayName(name);
        this.conn = conn;
    }
    
    public final Database getAssocatedConnection()
    {
        return conn.getAssociatedConnection();
    }
    
    @Override
    public Image getIcon(int type) {
        return ImageUtilities.loadImage("org/nbstudio/core/folderClosed.gif");
    }

    @Override
    public Image getOpenedIcon(int type) {
        return ImageUtilities.loadImage("org/nbstudio/core/folderOpened.gif");
    }

    /**
     * Providing the Open action on a feed entry
     */
    @Override
    public Action[] getActions(boolean popup) {
        return new Action[]{
            SystemAction.get(OpenAction.class)
        };
    }

    @Override
    public Action getPreferredAction() {
        return getActions(false)[0];
    }

//    public static final class BrowserTopComponent extends TopComponent {
//        public BrowserTopComponent(ConnectionEntry entry) {
//            setName(entry.getTitle());
//            setLayout(new BorderLayout());
//            JEditorPane editorPane = new JEditorPane();
//            editorPane.setEditable(false);
//            SyndContent description = entry.getDescription();
//            if (description != null) {
//                editorPane.setContentType("text/html");
//                editorPane.setText(description.getValue());
//            }
//            add(new JScrollPane(editorPane), BorderLayout.CENTER);
//            putClientProperty(/*PrintManager.PRINT_PRINTABLE*/"print.printable", true);
//        }
//    }
    
}
