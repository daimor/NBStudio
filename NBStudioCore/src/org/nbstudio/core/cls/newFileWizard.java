/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.cls;

import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.event.ChangeListener;
import org.netbeans.api.templates.TemplateRegistration;
import org.openide.WizardDescriptor;

/**
 *
 * @author daimor
 */
@TemplateRegistration(folder = "Cache", content = "clsTemplate.cls", displayName = "Cache Class")
public class newFileWizard implements WizardDescriptor.InstantiatingIterator<WizardDescriptor> {

    private int index;
    private WizardDescriptor wizard;
    private List<WizardDescriptor.Panel<WizardDescriptor>> panels;
    private List<WizardDescriptor.Panel<WizardDescriptor>> firstPanels;
    private String[] beforeSteps;
    private int currentTypeClass = 0;

    private List<WizardDescriptor.Panel<WizardDescriptor>> getPanels() {
        if (firstPanels == null) {
            firstPanels = new ArrayList<>();
            firstPanels.add(new newfileWizardPanelName());
            firstPanels.add(new newfileWizardPanelType());
        }
        
        if (panels == null) {
            panels = new ArrayList<>();
            panels.addAll(firstPanels);

            if (currentTypeClass == 0) {
                panels.add(null);
            } else {
                switch (currentTypeClass) {
                    case newfileVisualPanelType.TYPE_PERSISTENT:
                        panels.add(new newfileWizardPanelTypePersistent());
                        break;
                    case newfileVisualPanelType.TYPE_CSP:
                        panels.add(new newfileWizardPanelTypeCSP());
                        break;
                }
                panels.add(new newfileWizardPanelTypeSummary());
            }

//            panels.add(new newfileWizardPanelTypePersistent());
//            panels.add(new newfileWizardPanelTypeCSP());
            String[] steps = createSteps();
            for (int i = 0; i < panels.size(); i++) {
                if (panels.get(i) != null) {
                    Component c = panels.get(i).getComponent();
                    if (c instanceof JComponent) { // assume Swing components
                        JComponent jc = (JComponent) c;
                        jc.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, i);
                        jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DATA, steps);
                        jc.putClientProperty(WizardDescriptor.PROP_AUTO_WIZARD_STYLE, true);
                        jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DISPLAYED, true);
                        jc.putClientProperty(WizardDescriptor.PROP_CONTENT_NUMBERED, true);
                    }
                }
            }
        }
        return panels;
    }

    private String[] createSteps() {
        assert beforeSteps != null : "This wizard may only be used embedded in the template wizard";
        String[] res = new String[(beforeSteps.length - 1) + panels.size()];
        for (int i = 0; i < res.length; i++) {
            if (i < (beforeSteps.length - 1)) {
                res[i] = beforeSteps[i];
            } else if (panels.get(i - beforeSteps.length + 1) == null) {
                res[i] = "...";
            } else {
                res[i] = panels.get(i - beforeSteps.length + 1).getComponent().getName();
            }
        }
        return res;
    }

    @Override
    public Set instantiate() throws IOException {
        return Collections.emptySet();
    }

    @Override
    public void initialize(WizardDescriptor wizard) {
        this.wizard = wizard;
        beforeSteps = (String[]) wizard.getProperty("WizardPanel_contentData");
        wizard.putProperty("typeOfClass", newfileVisualPanelType.TYPE_CSP);
    }

    @Override
    public void uninitialize(WizardDescriptor wizard) {
        panels = null;
    }

    @Override
    public WizardDescriptor.Panel<WizardDescriptor> current() {
        return getPanels().get(index);
    }

    @Override
    public String name() {
        return index + 1 + ". from " + getPanels().size();
    }

    @Override
    public boolean hasNext() {
        return index < getPanels().size() - 1;
    }

    @Override
    public boolean hasPrevious() {
        return index > 0;
    }

    @Override
    public void nextPanel() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (index == 1) {
            panels.clear();
            panels = null;
            currentTypeClass = wizard.getProperty("typeOfClass") == null ? 0 : (int) wizard.getProperty("typeOfClass");
        }
        index++;
    }

    @Override
    public void previousPanel() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        if (index - 1 == 1) {
            panels.clear();
            panels = null;
            currentTypeClass = 0;
        }
        index--;
    }

    // If nothing unusual changes in the middle of the wizard, simply:
    @Override
    public void addChangeListener(ChangeListener l) {
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
    }
}
