/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.cls;

import junit.framework.TestCase;
import org.nbstudio.syntax.cls.clsParser;

/**
 *
 * @author daimor
 */
public class clsParserListerer4SaveTest extends TestCase {
    
    public clsParserListerer4SaveTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of enterClassDefintion method, of class CLSParserListerer4Save.
     */
    public void testEnterClassDefintion() {
        System.out.println("enterClassDefintion");
        clsParser.ClassDefintionContext ctx = null;
        CLSParserListerer4Save instance = null;
        instance.enterClassDefintion(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterMethodDefintion method, of class CLSParserListerer4Save.
     */
    public void testEnterMethodDefintion() {
        System.out.println("enterMethodDefintion");
        clsParser.MethodDefintionContext ctx = null;
        CLSParserListerer4Save instance = null;
        instance.enterMethodDefintion(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
