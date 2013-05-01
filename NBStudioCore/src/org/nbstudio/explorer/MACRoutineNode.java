/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.explorer;

import java.awt.Image;
import org.nbstudio.utils.Logger;
import org.openide.loaders.DataObject;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author daimor
 */
public class MACRoutineNode extends AbstractNode {

    public MACRoutineNode(String name, DataObject rtn) {
        super(Children.LEAF, Lookups.fixed(rtn));
        Logger.Log("MACRoutineNode: "+rtn);
        setDisplayName(name);
    }

    @Override
    public Image getIcon(int type) {
        return ImageUtilities.loadImage("org/nbstudio/core/mac/mac.gif");
    }

    @Override
    public Image getOpenedIcon(int type) {
        return getIcon(type);
    }
    
    

//    @Override
//    public Action[] getActions(boolean context) {
//        ArrayList<Action> actions = new ArrayList<Action>();
////        actions.add(new MyOpenAction());
//        actions.add(SystemAction.get(OpenAction.class));
//        actions.add(SystemAction.get(RenameAction.class));
//        actions.add(SystemAction.get(FileSystemAction.class));  // HERE
//        actions.add(SystemAction.get(PropertiesAction.class));
//        return actions.toArray(new Action[0]);
//    }
//
//    @Override
//    protected Sheet createSheet() {
//        Sheet sheet = Sheet.createDefault();
//        Sheet.Set set = Sheet.createPropertiesSet();
//        MACRoutine obj = getLookup().lookup(MACRoutine.class);
//        
//        try {
//            Property dateProp = new PropertySupport.Reflection(obj, Date.class, "getDate", null);
//            dateProp.setName("date");
//            set.put(dateProp);
//
//            Logger.Log("createSheet "+obj.getName());
//            Property nameProp = new PropertySupport.Reflection(obj, String.class, "getName", null);
//            nameProp.setName("name");
//            set.put(nameProp);
//
//        } catch (Exception ex) {
//            Logger.LogError("createSheet error: "+ex.getMessage());
//        }
//        sheet.put(set);
//        return sheet;
//    }
//
//    private class MyOpenAction extends AbstractAction {
//
//        public MyOpenAction() {
//            putValue(NAME, "myOpen");
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            Logger.Log("myOpenAction");
//            MACRoutine rtn = getLookup().lookup(MACRoutine.class);
//            System.out.println("rtn: " + rtn);
//            System.out.println("rtn: " + rtn.getName());
//            JOptionPane.showMessageDialog(null, "Hello from NBStudio");
//        }
//    }
//

}
