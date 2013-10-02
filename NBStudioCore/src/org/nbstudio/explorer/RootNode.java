/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import javax.swing.Action;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Utilities;

/**
 *
 * @author daimor
 */
public class RootNode extends FilterNode {

    public RootNode(Node filterNode) throws DataObjectNotFoundException {
        super(filterNode, new ChildNode(filterNode));
    }

    @Override
    public Action[] getActions(boolean bln) {
        return new Action[] {
            Utilities.actionsForPath("Actions/RootActions").get(0)
        };
    }
}
