/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.cls;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
    "LBL_cls_LOADER=Files of cls"
})
@MIMEResolver.ExtensionRegistration(
        displayName = "#LBL_cls_LOADER",
        mimeType = "text/isc-cls",
        extension = {"cls", "CLS"})
@DataObject.Registration(
        mimeType = "text/isc-cls",
        iconBase = "org/nbstudio/core/cls/class.png",
        displayName = "#LBL_cls_LOADER",
        position = 300)
@ActionReferences({
    @ActionReference(
            path = "Loaders/text/isc-cls/Actions",
            id
            = @ActionID(category = "System", id = "org.openide.actions.OpenAction"),
            position = 100,
            separatorAfter = 200),
//    @ActionReference(
//            path = "Loaders/text/isc-cls/Actions",
//            id =
//            @ActionID(category = "Edit", id = "org.openide.actions.CutAction"),
//            position = 300),
//    @ActionReference(
//            path = "Loaders/text/isc-cls/Actions",
//            id =
//            @ActionID(category = "Edit", id = "org.openide.actions.CopyAction"),
//            position = 400,
//            separatorAfter = 500),
//    @ActionReference(
//            path = "Loaders/text/isc-cls/Actions",
//            id =
//            @ActionID(category = "Edit", id = "org.openide.actions.DeleteAction"),
//            position = 600),
//    @ActionReference(
//            path = "Loaders/text/isc-cls/Actions",
//            id =
//            @ActionID(category = "System", id = "org.openide.actions.RenameAction"),
//            position = 700,
//            separatorAfter = 800),
//    @ActionReference(
//            path = "Loaders/text/isc-cls/Actions",
//            id =
//            @ActionID(category = "System", id = "org.openide.actions.SaveAsTemplateAction"),
//            position = 900,
//            separatorAfter = 1000),
    @ActionReference(
            path = "Loaders/text/isc-cls/Actions",
            id
            = @ActionID(category = "System", id = "org.openide.actions.FileSystemAction"),
            position = 1100,
            separatorAfter = 1200),
//    @ActionReference(
//            path = "Loaders/text/isc-cls/Actions",
//            id =
//            @ActionID(category = "System", id = "org.openide.actions.ToolsAction"),
//            position = 1300),
    @ActionReference(
            path = "Loaders/text/isc-cls/Actions",
            id
            = @ActionID(category = "System", id = "org.openide.actions.PropertiesAction"),
            position = 1400)
})
public class clsDataObject extends MultiDataObject {

    private final FileObject fileObject;

    public clsDataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        this.fileObject = pf;
//        registerEditor("text/isc-cls", false);
        CookieSet cookies = getCookieSet();
//        observer = new GlslShaderFileObserver(this);

        final CloneableEditorSupport support = DataEditorSupport.create(this, getPrimaryEntry(), cookies);
        support.addPropertyChangeListener(
                new PropertyChangeListenerImpl(support));
        cookies.add((Node.Cookie) support);
    }

//    @Override
//    protected Node createNodeDelegate() {
//    }
    private class PropertyChangeListenerImpl implements PropertyChangeListener {

        private final CloneableEditorSupport support;

        public PropertyChangeListenerImpl(CloneableEditorSupport support) {
            this.support = support;
        }

        @Override
        public void propertyChange(PropertyChangeEvent event) {
            if ("document".equals(event.getPropertyName())) {
                if (event.getNewValue() != null) {
//                    support.getDocument().addDocumentListener(observer);
//                    observer.runCompileTask();
                } else if (event.getOldValue() != null) {
//                    ((Document) event.getOldValue()).removeDocumentListener(observer);
                }
            }
        }
    }

    @Override
    protected int associateLookup() {
        return 1;
    }
//    @MultiViewElement.Registration(
//            displayName = "#LBL_cls_EDITOR",
//            iconBase = "org/nbstudio/core/cls/class.png",
//            mimeType = "text/isc-cls",
//            persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED,
//            preferredID = "cls",
//            position = 1000)
//    @Messages("LBL_cls_EDITOR=Source")
//    public static MultiViewEditorElement createEditor(Lookup lkp) {
//        return new MultiViewEditorElement(lkp);
//    }
}
