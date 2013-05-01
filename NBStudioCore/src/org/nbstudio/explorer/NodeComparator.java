/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import java.text.Collator;
import java.util.Comparator;
import org.openide.nodes.Node;

/**
 *
 * @author daimor
 */
public class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node n1, Node n2){
        Collator coltr = Collator.getInstance();
        return coltr.compare(n1.getName(), n2.getName());
    }
}
