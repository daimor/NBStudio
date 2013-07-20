/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.mac;

import java.util.prefs.Preferences;
import javax.swing.text.Document;
import org.netbeans.modules.editor.indent.spi.CodeStylePreferences;
import static org.nbstudio.core.mac.FmtOptions.*;
/**
 *
 * @author daimor
 */
public class CodeStyle {

    private final Preferences preferences;

    public static CodeStyle getCodeStyle(Document document) {
        CodeStyle cs = new CodeStyle(CodeStylePreferences.get(document).getPreferences());
        return cs;
    }

    private CodeStyle(Preferences preferences) {
        this.preferences = preferences;
    }

    public int getIndentSize() {
        return preferences.getInt(indentSize, getDefaultAsInt(indentSize));
    }

    public int getTabSize() {
        return preferences.getInt(tabSize, getDefaultAsInt(tabSize));
    }

    public boolean getExpandTabToSpaces() {
        return preferences.getBoolean(expandTabToSpaces, getDefaultAsBoolean(expandTabToSpaces));
    }

    public int getRightMargin() {
        return preferences.getInt(rightMargin, getDefaultAsInt(rightMargin));
    }
}
