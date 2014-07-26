/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.cls;

import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;
import org.openide.util.ChangeSupport;
import org.openide.util.HelpCtx;

public class newfileWizardPanelType implements WizardDescriptor.ValidatingPanel<WizardDescriptor> {

    /**
     * The visual component that displays this panel. If you need to access the
     * component from this class, just use getComponent().
     */
    private newfileVisualPanelType component;
    private final ChangeSupport changeSupport = new ChangeSupport(this);
    private WizardDescriptor wizard;

    // Get the visual component for the panel. In this template, the component
    // is kept separate. This can be more efficient: if the wizard is created
    // but never displayed, or not all panels are displayed, it is better to
    // create only those which really need to be visible.
    @Override
    public newfileVisualPanelType getComponent() {
        if (component == null) {
            component = new newfileVisualPanelType(this);
            isValid();
        }
        return component;
    }

    @Override
    public HelpCtx getHelp() {
        // Show no Help button for this panel:
        return HelpCtx.DEFAULT_HELP;
        // If you have context help:
        // return new HelpCtx("help.key.here");
    }

    @Override
    public boolean isValid() {
        if (wizard == null) {
            return true;
        }
        try {
            wizard.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, null);
            validate();
            return true;
        } catch (WizardValidationException ex) {
            wizard.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, ex.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public void addChangeListener(ChangeListener l) {
        changeSupport.addChangeListener(l);
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
        changeSupport.removeChangeListener(l);
    }

    protected final void fireChangeEvent() {
        changeSupport.fireChange();
    }

    @Override
    public void readSettings(WizardDescriptor wiz) {
        this.wizard = wiz;
    }

    @Override
    public void storeSettings(WizardDescriptor wiz) {
        // use wiz.putProperty to remember current panel state
        int typeOfClass = component.getTypeOfClass();
        String superClass = component.getSuperClass();
        wiz.putProperty("typeOfClass", typeOfClass);
        wiz.putProperty("superClass", superClass);
    }

    @Override
    public void validate() throws WizardValidationException {
        int typeOfClass = component.getTypeOfClass();
        if (typeOfClass < 0) {
            throw new WizardValidationException(null, "Invalid type of class", null);
        }
        String superClass = component.getSuperClass();
        if ((typeOfClass == newfileVisualPanelType.TYPE_CUSTOM) && (superClass.isEmpty())) {
            throw new WizardValidationException(null, "Invalid extends class", null);
        }
        wizard.putProperty("typeOfClass", typeOfClass);
    }
}
