/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.cls;

import com.intersys.classes.Dictionary.ClassDefinition;
import com.intersys.classes.Dictionary.ForeignKeyDefinition;
import com.intersys.classes.Dictionary.IndexDefinition;
import com.intersys.classes.Dictionary.MethodDefinition;
import com.intersys.classes.Dictionary.ParameterDefinition;
import com.intersys.classes.Dictionary.PropertyDefinition;
import com.intersys.classes.Dictionary.QueryDefinition;
import com.intersys.classes.Dictionary.TriggerDefinition;
import com.intersys.classes.Dictionary.UDLTextDefinition;
import com.intersys.classes.Dictionary.XDataDefinition;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import com.intersys.objects.Id;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.nbstudio.core.CacheFile;
import org.openide.util.Exceptions;

/**
 *
 * @author daimor
 */
public class clsFile extends CacheFile {

    ClassDefinition cls;

    public clsFile(Database db, String name) throws CacheException {
        super(db, name);
        try {
            if (ClassDefinition._existsId(db, new Id(name))) {
                cls = (ClassDefinition) ClassDefinition._open(db, new Id(name));
            }
        } catch (Exception ex) {
        }
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
        ClassText os;
        ByteArrayInputStream is = null;
        try {
            os = new ClassText();
            is = new ByteArrayInputStream(os.toByteArray());
        } catch (CacheException ex) {
            Exceptions.printStackTrace(ex);
        }

        return is;
    }

    final class ClassText extends ByteArrayOutputStream {

        public ClassText() throws CacheException {
            if (cls == null) {
                return;
            }
            cls._reload();
            writeParensValue("Include %s\n\n", cls.getIncludeCode());
            writeDescription(cls.getDescription());
            printf("Class %s", cls.getName());
            writeParensValue(" Extends %s", cls.getSuper());
            writeln();
            println("{");
            
            List<Object> list = new ArrayList();
            list.addAll(cls.getProperties().asList());
            list.addAll(cls.getMethods().asList());
            list.addAll(cls.getParameters().asList());
            list.addAll(cls.getIndices().asList());
            list.addAll(cls.getForeignKeys().asList());
            list.addAll(cls.getXDatas().asList());
            list.addAll(cls.getProjections().asList());
            list.addAll(cls.getQueries().asList());
            list.addAll(cls.getTriggers().asList());
            list.addAll(cls.getUDLTexts().asList());
            Collections.sort(list, new Comparator<Object>() {
                @Override
                public int compare(Object o1, Object o2) {
                    int seqNum1 = 0, seqNum2 = 0;
                    try {
                        seqNum1 = getSeqNumber(o1);
                        seqNum2 = getSeqNumber(o2);
                    } catch (CacheException ex) {
                    }
                    if (seqNum1 > seqNum2) {
                        return 1;
                    } else if (seqNum1 < seqNum2) {
                        return -1;
                    } else {
                        return 0;
                    }
                }

                int getSeqNumber(Object obj) throws CacheException {
                    if (obj instanceof PropertyDefinition) {
                        return ((PropertyDefinition) obj).getSequenceNumber();
                    } else if (obj instanceof ParameterDefinition) {
                        return ((ParameterDefinition) obj).getSequenceNumber();
                    } else if (obj instanceof MethodDefinition) {
                        return ((MethodDefinition) obj).getSequenceNumber();
                    } else if (obj instanceof XDataDefinition) {
                        return ((XDataDefinition) obj).getSequenceNumber();
                    } else if (obj instanceof QueryDefinition) {
                        return ((QueryDefinition) obj).getSequenceNumber();
                    } else if (obj instanceof TriggerDefinition) {
                        return ((TriggerDefinition) obj).getSequenceNumber();
                    } else if (obj instanceof UDLTextDefinition) {
                        return ((UDLTextDefinition) obj).getSequenceNumber();
                    } else if (obj instanceof IndexDefinition) {
                        return ((IndexDefinition) obj).getSequenceNumber();
                    } else if (obj instanceof ForeignKeyDefinition) {
                        return ((ForeignKeyDefinition) obj).getSequenceNumber();
                    }

                    return 0;
                }
            });

            int pos = 0;
            for (Iterator<Object> it = list.iterator(); it.hasNext();) {
                Object obj = it.next();
                writeln();
                if (obj instanceof PropertyDefinition) {
                    showElement((PropertyDefinition) obj);
                } else if (obj instanceof UDLTextDefinition) {
                    showElement((UDLTextDefinition) obj);
                } else if (obj instanceof MethodDefinition) {
                    showElement((MethodDefinition) obj);
                } else if (obj instanceof ParameterDefinition) {
                    showElement((ParameterDefinition) obj);
                } else if (obj instanceof XDataDefinition) {
                    showElement((XDataDefinition) obj);
                } else if (obj instanceof QueryDefinition) {
                    showElement((QueryDefinition) obj);
                } else if (obj instanceof TriggerDefinition) {
                    showElement((TriggerDefinition) obj);
                } else if (obj instanceof IndexDefinition) {
                    showElement((IndexDefinition) obj);
                } else if (obj instanceof ForeignKeyDefinition) {
                    showElement((ForeignKeyDefinition) obj);
                }
            }
            println("\n}");

        }

//        void showElement(Object obj) {
//        }
        void showElement(PropertyDefinition obj) throws CacheException {
            writeDescription(obj.getDescription());
            printf("Property %s", obj.getName());
            writeParensValue(" As %s", obj.getType());
            writeln(";");
        }

        void showElement(ParameterDefinition obj) throws CacheException {
            writeDescription(obj.getDescription());
            printf("Parameter %s", obj.getName());
            if ((obj.getDefault() != null) && (!obj.getDefault().isEmpty())) {
                printf(" = \"%s\"", obj.getDefault());
            }
            writeln(";");
        }

        void showElement(MethodDefinition obj) throws CacheException {
            writeDescription(obj.getDescription());
            if (obj.getClassMethod()) {
                printf("ClassMethod %s", obj.getName());
            } else {
                printf("Method %s", obj.getName());
            }
            printf("()");
//            writeParensValue(" As %s", obj.getReturnType());
            writeln();
            writeln("{");
            writeReader(obj.getImplementationIn());
            writeln("}");
        }

        void showElement(XDataDefinition obj) throws CacheException {
            writeDescription(obj.getDescription());
            printf("XData %s", obj.getName());
            write("()");
            writeln();
            writeln("{");
            writeReader(obj.getDataIn());
            writeln("}");
        }

        void showElement(QueryDefinition obj) throws CacheException {
            writeDescription(obj.getDescription());
            printf("Query %s", obj.getName());
            write("()");
            writeln();
            writeln("{");
            write(obj.getSqlQuery());
            writeln("}");
        }

        void showElement(TriggerDefinition obj) throws CacheException {
            writeDescription(obj.getDescription());
            printf("Trigger %s", obj.getName());
            write("()");
            writeln();
            writeln("{");
            write(obj.getCode());
            writeln("}");
        }

        void showElement(UDLTextDefinition obj) throws CacheException {
            writeReader(obj.getContentIn());
        }

        void showElement(IndexDefinition obj) throws CacheException {
            writeDescription(obj.getDescription());
            printf("Index %s", obj.getName());
            writeParensValue(" On %s ", obj.getProperties());
            writeln(";");
        }

        void showElement(ForeignKeyDefinition obj) throws CacheException {
            writeDescription(obj.getDescription());
            printf("ForeignKey %s", obj.getName());
            writeParensValue(" On %s ", obj.getProperties());
            writeln(";");
        }

        void writeDescription(String str) {
            if ((str == null) || (str.isEmpty())) {
                return;
            }
            write("/// ");
            str = str.replace("\n", "\n/// ");
            write(str);
            if (!str.isEmpty()) {
                writeln();
            }
        }

        void writeParensValue(String fmt, String str) {
            if ((str == null) || (str.isEmpty())) {
                return;
            }
            if (str.contains(",")) {
                str = str.replace(",", ", ");
                str = "(" + str + ")";
            }
            printf(fmt, str);
        }

        public void printf(String string, Object... args) {
            write(String.format(string, args));
        }

        public void println(String string, Object... args) {
            writeln(String.format(string, args));
        }

        public void writeln() {
            write('\n');
        }

        public void writeln(String string) {
            write(string + '\n');
        }

        public void write(String string) {
            try {
//                write(string.getBytes("UTF-8"));
                write(string.getBytes());
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }

        public void writeReader(Reader isr) {
            try {
                BufferedReader buff;
                isr.reset();
                buff = new BufferedReader(isr);
                String str;
                while ((str = buff.readLine()) != null) {
                    if (str.isEmpty()) {
                        continue;
                    }
                    writeln(str);
                }
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    class ObjectStream extends ByteArrayOutputStream {

        public ObjectStream() {
        }

        public void write(String string) throws IOException {
            write(string.getBytes());
        }
    }
}
