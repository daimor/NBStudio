/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.syntax.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openide.util.Exceptions;

/**
 *
 * @author James Reid
 */
public class ANTLRTokenReader {

    private final HashMap<String, String> tokenTypes = new HashMap<>();
    private final ArrayList<ANTLRTokenId> tokens = new ArrayList<>();

    public ANTLRTokenReader() {
        init();
    }

    /**
     * Initializes the map to include any keywords in the Hop Programming
     * language.
     */
    private void init() {
    }

    /**
     * Reads the token file from the ANTLR parser and generates appropriate
     * tokens.
     *
     * @return
     */
    public List<ANTLRTokenId> readTokenFile(String resourceName, HashMap<String, String> tokenTypes) {
        this.tokenTypes.clear();
        this.tokenTypes.putAll(tokenTypes);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inp = classLoader.getResourceAsStream(resourceName);
        BufferedReader input = new BufferedReader(new InputStreamReader(inp));
        readTokenFile(input);
        return tokens;
    }

    /**
     * Reads in the token file.
     *
     * @param buff
     */
    private void readTokenFile(BufferedReader buff) {
        try {
            String line;
            ArrayList<Integer> uniq = new ArrayList<>();
            while ((line = buff.readLine()) != null) {
                String[] splLine = line.split("=");
                String name = splLine[0];
                int tok = Integer.parseInt(splLine[splLine.length - 1].trim());
                if (uniq.contains(tok)) {
                    continue;
                }
                uniq.add(tok);
                ANTLRTokenId id;
                String tokenCategory;
                String tmpName = name;
                if (name.indexOf('_') > 0) {
                    tmpName = name.substring(0, name.indexOf('_'));
                    if (tmpName.equals("T")) {
                        tmpName = name;
                    }
                }
                tokenCategory = tokenTypes.get(tmpName);
                if (tokenCategory != null) {
                    //if the value exists, put it in the correct category
                    id = new ANTLRTokenId(name, tokenCategory, tok);
                } else {
                    //if we don't recognize the token, consider it to a separator
                    id = new ANTLRTokenId(name, "separator", tok);
                }
                //add it into the vector of tokens
                tokens.add(id);
            }
            uniq.clear();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
