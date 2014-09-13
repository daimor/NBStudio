/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.project;

import java.util.HashSet;
import java.util.Set;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;

public class CacheProjectWizardPanel1 implements WizardDescriptor.Panel, WizardDescriptor.ValidatingPanel {

    private CacheProjectVisualPanel1 component;
    private WizardDescriptor wizardDescriptor;

    // Get the visual component for the panel. In this template, the component
    // is kept separate. This can be more efficient: if the wizard is created
    // but never displayed, or not all panels are displayed, it is better to
    // create only those which really need to be visible.
    @Override
    public CacheProjectVisualPanel1 getComponent() {
        if (component == null) {
            component = new CacheProjectVisualPanel1(this);
            component.setName(NbBundle.getMessage(CacheProjectWizardPanel1.class, "LBL_CreateProjectStep1"));
        }
        return component;
    }

    @Override
    public HelpCtx getHelp() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    public boolean isValid() {
        getComponent();
        return component.valid(wizardDescriptor);
    }

    private final Set<ChangeListener> listeners = new HashSet<>(1); // or can use ChangeSupport in NB 6.0

    @Override
    public void addChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.add(l);
        }
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.remove(l);
        }
    }

    protected final void fireChangeEvent() {
        Set<ChangeListener> ls;
        synchronized (listeners) {
            ls = new HashSet<>(listeners);
        }
        ChangeEvent ev = new ChangeEvent(this);
        for (ChangeListener l : ls) {
            l.stateChanged(ev);
        }
    }

    public void readSettings(WizardDescriptor wiz) {
        wizardDescriptor = (WizardDescriptor) wiz;
        component.read(wizardDescriptor);
    }

    public void storeSettings(WizardDescriptor wiz) {
        WizardDescriptor d = (WizardDescriptor) wiz;
        component.store(d);
    }

    @Override
    public void validate() throws WizardValidationException {
        getComponent();
        component.validate(wizardDescriptor);
    }

    @Override
    public void readSettings(Object settings) {
        readSettings((WizardDescriptor) settings);
    }

    @Override
    public void storeSettings(Object settings) {
        storeSettings((WizardDescriptor) settings);
    }

}
