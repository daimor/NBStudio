/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.mac;

import java.io.IOException;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.MIMEResolver;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.nodes.CookieSet;
import org.openide.nodes.Node;
import org.openide.text.CloneableEditorSupport;
import org.openide.text.DataEditorSupport;
import org.openide.util.NbBundle.Messages;

@Messages({
    "LBL_mac_LOADER=MAC files"
})
@MIMEResolver.ExtensionRegistration(
        displayName = "#LBL_mac_LOADER",
        mimeType = "text/isc-mac",
        extension = {"mac", "MAC", "int", "INT"})
@DataObject.Registration(
        mimeType = "text/isc-mac",
        displayName = "#LBL_mac_LOADER",
        iconBase = "org/nbstudio/core/mac/mac.gif",
        position = 300)
@ActionReferences({
    @ActionReference(
            path = "Loaders/text/isc-mac/Actions",
            id
            = @ActionID(category = "System", id = "org.openide.actions.OpenAction"),
            position = 100,
            separatorAfter = 200),
//    @ActionReference(
//            path = "Loaders/text/isc-mac/Actions",
//            id =
//            @ActionID(category = "Edit", id = "org.openide.actions.CutAction"),
//            position = 300),
//    @ActionReference(
//            path = "Loaders/text/isc-mac/Actions",
//            id =
//            @ActionID(category = "Edit", id = "org.openide.actions.CopyAction"),
//            position = 400,
//            separatorAfter = 500),
//    @ActionReference(
//            path = "Loaders/text/isc-mac/Actions",
//            id =
//            @ActionID(category = "Edit", id = "org.openide.actions.DeleteAction"),
//            position = 600),
//    @ActionReference(
//            path = "Loaders/text/isc-mac/Actions",
//            id =
//            @ActionID(category = "System", id = "org.openide.actions.RenameAction"),
//            position = 700,
//            separatorAfter = 800),
//    @ActionReference(
//            path = "Loaders/text/isc-mac/Actions",
//            id =
//            @ActionID(category = "System", id = "org.openide.actions.SaveAsTemplateAction"),
//            position = 900,
//            separatorAfter = 1000),
    @ActionReference(
            path = "Loaders/text/isc-mac/Actions",
            id
            = @ActionID(category = "System", id = "org.openide.actions.FileSystemAction"),
            position = 1100,
            separatorAfter = 1200),
//    @ActionReference(
//            path = "Loaders/text/isc-mac/Actions",
//            id =
//            @ActionID(category = "System", id = "org.openide.actions.ToolsAction"),
//            position = 1300),
    @ActionReference(
            path = "Loaders/text/isc-mac/Actions",
            id
            = @ActionID(category = "System", id = "org.openide.actions.PropertiesAction"),
            position = 1400)
})
public class macDataObject extends MultiDataObject {

    public macDataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
//        registerEditor("text/isc-mac", false);
        registerEntry(pf);
        CookieSet cookies = getCookieSet();

        final CloneableEditorSupport support = DataEditorSupport.create(this, getPrimaryEntry(), cookies);
//        support.addPropertyChangeListener(
//                new PropertyChangeListenerImpl(support));
        cookies.add((Node.Cookie) support);
    }

    @Override
    protected int associateLookup() {
        return 1;
    }

//    @Override
//    protected Node createNodeDelegate() {
////        return new node(super.getName());
//        return super.createNodeDelegate(); //To change body of generated methods, choose Tools | Templates.
//    }
}
