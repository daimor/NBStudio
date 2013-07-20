/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.cls;

import com.intersys.classes.Dictionary.ClassDefinition;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import com.intersys.objects.Id;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Date;
import org.nbstudio.core.CacheFile;
import org.nbstudio.utils.Logger;
import org.openide.util.Exceptions;

/**
 *
 * @author daimor
 */
public class clsFile extends CacheFile {

    ClassDefinition cls;

    public clsFile(Database db, String name) throws CacheException {
        super(db, name);
        cls = (ClassDefinition) ClassDefinition._open(db, new Id(name));
    }

    @Override
    public Date getDate() {
        return null;
    }

    @Override
    public int getSize() {
        return -1;
    }

    @Override
    public InputStream open() {
        ObjectStream os = new ObjectStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        try {
            String includes = "";
            if (!includes.isEmpty()) {
                System.out.printf("Include %s\n\n", includes);
            }
            String extend = this.cls.getSuper();
            System.out.printf("Class %s", this.cls.getName());
            if (!extend.isEmpty()) {
                System.out.printf(" extends %s", extend);
            }
            System.out.printf("\n");
            System.out.println("{\n");


            System.out.println("\n}");

        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        return is;
    }

    class ObjectStream extends ByteArrayOutputStream {

        public ObjectStream() {
        }

        public void write(String string) throws IOException {
            write(string.getBytes());
        }
    }
}
