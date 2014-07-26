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

public class newfileWizardPanelName implements WizardDescriptor.ValidatingPanel<WizardDescriptor> {

    /**
     * The visual component that displays this panel. If you need to access the
     * component from this class, just use getComponent().
     */
    private newfileVisualPanelName component;
    private final ChangeSupport changeSupport = new ChangeSupport(this);
    private WizardDescriptor wizard;

    // Get the visual component for the panel. In this template, the component
    // is kept separate. This can be more efficient: if the wizard is created
    // but never displayed, or not all panels are displayed, it is better to
    // create only those which really need to be visible.
    @Override
    public newfileVisualPanelName getComponent() {
        if (component == null) {
            component = new newfileVisualPanelName(this);
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
        component.read(wiz);
    }

    @Override
    public void storeSettings(WizardDescriptor wiz) {
        // use wiz.putProperty to remember current panel state
        boolean cancelled = wiz.getValue() != WizardDescriptor.FINISH_OPTION;
        if (!cancelled) {
            wiz.putProperty("className", component.getClassPackage() + "." + component.getClassName());
            wiz.putProperty("classDesc", component.getClassDesc());
        }
    }

    @Override
    public void validate() throws WizardValidationException {
        String clsName = component.getClassPackage() + "." + component.getName();
        if (component.getClassPackage().isEmpty()) {
            throw new WizardValidationException(null, "Invalid Package Name", null);
        }
        if (component.getClassName().isEmpty()) {
            throw new WizardValidationException(null, "Invalid Class Name", null);
        }
    }
}
