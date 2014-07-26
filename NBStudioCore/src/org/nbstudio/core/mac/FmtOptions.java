/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.mac;

import java.util.HashMap;
import java.util.Map;
import org.netbeans.api.editor.settings.SimpleValueNames;

/**
 *
 * @author daimor
 */
public class FmtOptions {
    public static final String expandTabToSpaces = SimpleValueNames.EXPAND_TABS;
	public static final String tabSize = SimpleValueNames.TAB_SIZE;
	public static final String indentSize = SimpleValueNames.INDENT_SHIFT_WIDTH;
	//public static final String spacesPerTab = SimpleValueNames.SPACES_PER_TAB;
	public static final String rightMargin = SimpleValueNames.TEXT_LIMIT_WIDTH;

	private FmtOptions() {
	}

	public static int getDefaultAsInt(String key) {
		return Integer.parseInt(defaults.get(key));
	}

	public static boolean getDefaultAsBoolean(String key) {
		return Boolean.parseBoolean(defaults.get(key));
	}

	public static String getDefaultAsString(String key) {
		return defaults.get(key);
	}
	// Private section ---------------------------------------------------------
	private static final String TRUE = "true";      // NOI18N
	private static final String FALSE = "false";    // NOI18N
	private static Map<String, String> defaults;

	static {
		createDefaults();
	}

	private static void createDefaults() {
		String defaultValues[][] = {
			{expandTabToSpaces, FALSE}, //NOI18N
			{tabSize, "4"}, //NOI18N
			{indentSize, "4"}, //NOI18N
			{rightMargin, "80"}, //NOI18N
		};

		defaults = new HashMap<>();

		for (java.lang.String[] strings : defaultValues) {
			defaults.put(strings[0], strings[1]);
		}
	}
}
