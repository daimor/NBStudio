/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import java.io.IOException;
import javax.swing.Action;
import org.openide.cookies.InstanceCookie;
import org.openide.filesystems.AbstractFileSystem.List;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.loaders.InstanceDataObject;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.Utilities;

/**
 *
 * @author daimor
 */
public class RootNode extends FilterNode {

    public RootNode(Node filterNode) throws DataObjectNotFoundException {
        super(filterNode, new ChildNode(filterNode));
    }

//    @Override
//    public String getDisplayName() {
//        return "Connections";
//    }
//
    @Override
    public Action[] getActions(boolean bln) {
        return new Action[] {
            Utilities.actionsForPath("Actions/RootActions").get(0)
        };
    }
}
