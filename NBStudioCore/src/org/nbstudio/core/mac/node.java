/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.mac;

import java.awt.Image;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;

/**
 *
 * @author daimor
 */
public class node extends AbstractNode {

    public node(Children children, Lookup lookup) {
        super(children, lookup);
    }

    public node(String name) {
        super(Children.LEAF);
        setDisplayName(name);
    }

    public node(Children children) {
        super(children);
    }

    @Override
    public Image getIcon(int type) {
        return ImageUtilities.loadImage("org/nbstudio/core/mac/mac.gif");
    }

    @Override
    public Image getOpenedIcon(int type) {
        return getIcon(type);
    }
}
