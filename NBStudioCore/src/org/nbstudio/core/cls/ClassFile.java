/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.cls;

import com.intersys.cache.CacheObject;
import com.intersys.classes.CacheRootObject;
import com.intersys.classes.Dictionary.ClassDefinition;
import com.intersys.classes.Dictionary.ForeignKeyDefinition;
import com.intersys.classes.Dictionary.IndexDefinition;
import com.intersys.classes.Dictionary.MethodDefinition;
import com.intersys.classes.Dictionary.ParameterDefinition;
import com.intersys.classes.Dictionary.ProjectionDefinition;
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
import java.nio.charset.Charset;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.nbstudio.core.CacheFile;
import org.nbstudio.syntax.cls.clsLexer;
import org.nbstudio.syntax.cls.clsParser;

/**
 *
 * @author daimor
 */
public class ClassFile extends CacheFile {

    ClassDefinition cls;
    Charset charset = Charset.forName("UTF-8");
    protected CacheObject mInternal;
    private ClassDefinition methodDef;
    private ClassDefinition propertyDef;
    private ClassDefinition triggerDef;
    private ClassDefinition foreignkeyDef;
    private ClassDefinition projectionDef;
    private ClassDefinition indexDef;
    private ClassDefinition queryDef;
    private ClassDefinition parameterDef;
    private ClassDefinition xdataDef;

    public ClassFile(Database db, String name) throws CacheException {
        super(db, name);
        try {
            if (ClassDefinition._existsId(db, new Id(name))) {
                cls = (ClassDefinition) ClassDefinition._open(db, new Id(name));
            } else {
                cls = new ClassDefinition(db, name);
            }
            Field privateStringField = CacheRootObject.class.getDeclaredField("mInternal");
            privateStringField.setAccessible(true);
            mInternal = (CacheObject) privateStringField.get(cls);

            methodDef = (ClassDefinition) ClassDefinition.open(db, new Id("%Dictionary.MethodDefinition"), 0);
            propertyDef = (ClassDefinition) ClassDefinition.open(db, new Id("%Dictionary.PropertyDefinition"), 0);
            foreignkeyDef = (ClassDefinition) ClassDefinition.open(db, new Id("%Dictionary.ForeignKeyDefinition"), 0);
            indexDef = (ClassDefinition) ClassDefinition.open(db, new Id("%Dictionary.IndexDefinition"), 0);
            queryDef = (ClassDefinition) ClassDefinition.open(db, new Id("%Dictionary.QueryDefinition"), 0);
            parameterDef = (ClassDefinition) ClassDefinition.open(db, new Id("%Dictionary.ParameterDefinition"), 0);
            triggerDef = (ClassDefinition) ClassDefinition.open(db, new Id("%Dictionary.TriggerDefinition"), 0);
            projectionDef = (ClassDefinition) ClassDefinition.open(db, new Id("%Dictionary.ProjectionDefinition"), 0);
            xdataDef = (ClassDefinition) ClassDefinition.open(db, new Id("%Dictionary.XDataDefinition"), 0);
            projectionDef = (ClassDefinition) ClassDefinition.open(db, new Id("%Dictionary.ProjectionDefinition"), 0);

        } catch (CacheException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException ex) {
            ex.printStackTrace();
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
            os = new ClassText(cls);
            is = new ByteArrayInputStream(os.toByteArray());
        } catch (CacheException ex) {
            ex.printStackTrace();
        }

        return is;
    }

    @Override
    public void save(byte[] data) {
        ANTLRInputStream input = new ANTLRInputStream(new String(data, charset));
        Lexer lexer = new clsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        clsParser clsParser = new clsParser(tokens);
        try {
            clsParser.ProgContext prog = clsParser.prog();
            ParseTreeWalker walker = new ParseTreeWalker();
            CLSParserListerer4Save listener = new CLSParserListerer4Save(clsParser, db, cls);
            walker.walk(listener, prog);
            cls._save();
            db.utilities().compileCacheClass(getName(), "cdfk-u");
        } catch (CacheException | RecognitionException ex) {
            System.out.println("SaveException: " + ex.getLocalizedMessage());
//            ex.printStackTrace();
        }
    }

    final class ClassText extends ByteArrayOutputStream {

        ClassDefinition cls;

        public ClassText(ClassDefinition cls) throws CacheException {
            if (cls == null) {
                return;
            }
            this.cls = cls;

//            cls._reload();
            writeParensValue("Include %s\n\n", cls.getIncludeCode());
            writeParensValue("Import %s\n\n", cls.getImport());
            writeParensValue("IncludeGenerator %s\n\n", cls.getIncludeGenerator());
            writeDescription(cls.getDescription());
            printf("Class %s", cls.getName());
            writeParensValue(" Extends %s", cls.getSuper());

            // Class properties
            List<String> clsProperties = new ArrayList<>();
            /// boolean's properties
            com.intersys.cache.Dataholder tmpRes;
            String[] boolProps = {"Abstract", "DdlAllowed", "Final", "Hidden", "ProcedureBlock", "SqlRowIdPrivate"};
            for (String propName : boolProps) {
                if (propIsDefined(propName) && ((tmpRes = propGet(propName)) != null)) {
                    clsProperties.add((tmpRes.getBoolean() ? "" : "Not ") + propName);
                }
            }
            /// string's properties 
            String[] stringProps = {
                "ClassType", "ClientDataType", "ClientName", "CompileAfter", "DependsOn", "Language",
                "OdbcType", "Owner", "ServerOnly", "SoapBindingStyle", "SoapBodyUse", "SQLCategory",
                "SqlRowIdName", "SqlTableName", "StorageStrategy", "ViewQuery"};
            for (String propName : stringProps) {
                if (propIsDefined(propName) && ((tmpRes = propGet(propName)) != null)) {
                    clsProperties.add(propName + " = " + tmpRes.getString());
                }
            }

            writeBrackets(clsProperties);
            writeln();
            println("{");

            List<Object> list = new ArrayList<>();
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
                    } else if (obj instanceof ProjectionDefinition) {
                        return ((ProjectionDefinition) obj).getSequenceNumber();
                    }

                    return 0;
                }
            });

            int pos = 0;
            for (Object obj : list) {
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
                } else if (obj instanceof ProjectionDefinition) {
                    showElement((ProjectionDefinition) obj);
                }
            }
            println("\n}");

        }

        boolean propIsDefined(String propName) {
            boolean result = false;
            try {
                com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
                com.intersys.cache.Dataholder res = mInternal.runInstanceMethod(propName + "IsDefined", args, Database.RET_PRIM);
                result = res.getBoolean();
            } catch (CacheException ex) {
            }
            return result;
        }

        com.intersys.cache.Dataholder propGet(String propName) {
            try {
                com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
                com.intersys.cache.Dataholder res = mInternal.runInstanceMethod(propName + "Get", args, Database.RET_PRIM);
                return res;
            } catch (CacheException ex) {
            }
            return null;
        }

        void propsAdd(List<String> props, CacheRootObject obj, String propName, Object defaultValue) {
            try {
                if (defaultValue instanceof Boolean) {
                    boolean boolRes = CLSUtils.getProperty(obj, propName, (Boolean) defaultValue);
                    if (boolRes) {
                        props.add(propName);
                    }
                } else if (defaultValue instanceof String) {
                    String stringRes = (String) CLSUtils.getProperty(obj, propName, (String) defaultValue);
                    if ((!stringRes.isEmpty())
                            && (!defaultValue.equals("\"" + stringRes + "\""))
                            && (!defaultValue.equals(stringRes))) {
                        if ((obj instanceof PropertyDefinition) && ("SqlComputeCode".equals(propName))) {
                            stringRes = "{" + stringRes + "}";
                        } else if ((obj instanceof XDataDefinition)
                                && (("SchemaSpec".equals(propName)) || ("SchemaSpec".equals(propName)))) {
                            if (stringRes.contains(":")) {
                                stringRes = "\"" + stringRes + "\"";
                            }
                        } else if ((obj instanceof PropertyDefinition) && ("InitialExpression".equals(propName))) {
                            if ((!stringRes.matches("^\"(.*)\"$")) && ((!stringRes.matches("^\\d*$")))) {
                                stringRes = "{" + stringRes + "}";
                            }
                        } else if (("PublicList".equals(propName)) && (obj instanceof MethodDefinition)) {
                            if (stringRes.contains(",")) {
                                stringRes = stringRes.replace(",", ", ");
                                stringRes = "(" + stringRes + ")";
                            }
                        } else if (("Data".equals(propName)) && (obj instanceof IndexDefinition)) {
                            if (stringRes.contains(",")) {
                                stringRes = stringRes.replace(",", ", ");
                                stringRes = "(" + stringRes + ")";
                            }
                        }
                        props.add(propName + " = " + stringRes);
                    }
                }
            } catch (Exception ex) {
//                System.out.println("propsAdd: " + ex.getMessage());
//                ex.printStackTrace();
            }
        }

        void writeProps(ClassDefinition objDef, CacheRootObject obj, List<String> excludeList) {
            try {
                if (objDef == null) {
                    return;
                }
                List<String> props = new ArrayList<>();

                Map<String, Object> objProps = CLSUtils.getProperties(obj);
                for (Map.Entry<String, Object> entry : objProps.entrySet()) {
                    String propName = entry.getKey();
                    Object defaultValue = entry.getValue();

                    propsAdd(props, obj, propName, defaultValue);
                }
                writeBrackets(props);
            } catch (Exception ex) {
            }

        }

//        void showElement(Object obj) {
//        }
        void showElement(PropertyDefinition obj) throws CacheException {
            writeDescription(obj.getDescription());
            String propType = obj.getRelationship() ? "Relationship" : "Property";
            printf(propType + " %s", obj.getName());
            String collection = obj.getCollection() == null ? "" : obj.getCollection();
            writeParensValue(" As " + (collection.isEmpty() ? "" : collection + " of ") + "%s", obj.getType());
            writeParameters(CLSUtils.getParameters(obj));

            String[] excludeList = {"Aliases", "Identity", "OnDelete", "Relationship", "Collection"};
            writeProps(propertyDef, obj, Arrays.asList(excludeList));

            writeln(";");
        }

        void showElement(ParameterDefinition obj) throws CacheException {
            writeDescription(obj.getDescription());
            printf("Parameter %s", obj.getName());

            String[] excludeList = {"Default", "Expression"};
            writeProps(parameterDef, obj, Arrays.asList(excludeList));

            if ((obj.getDefault() != null) && (!obj.getDefault().isEmpty())) {
                String parameterValue = obj.getDefault();
                if (!parameterValue.matches("^\\d*$")) {
                    parameterValue = "\"" + parameterValue + "\"";
                }
                printf(" = %s", parameterValue);
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
            writeFormalSpec(obj.getFormalSpec());
            writeParensValue(" As %s", obj.getReturnType());

            String[] excludeList = {"ClassMethod", "ClientMethod", "ReturnType", "FormalSpec", "Implementation", "Hash"};
            writeProps(methodDef, obj, Arrays.asList(excludeList));

            writeln();
            writeln("{");
            writeReader(obj.getImplementationIn());
            writeln("}");
        }

        void showElement(XDataDefinition obj) throws CacheException {
            writeDescription(obj.getDescription());
            printf("XData %s", obj.getName());

            String[] excludeList = {"Data"};
            writeProps(xdataDef, obj, Arrays.asList(excludeList));

            writeln();
            writeln("{");
            writeReader(obj.getDataIn());
            writeln("}");
        }

        void showElement(QueryDefinition obj) throws CacheException {
            writeDescription(obj.getDescription());
            printf("Query %s", obj.getName());
            writeFormalSpec(obj.getFormalSpec());
            printf(" As %s", obj.getType());
            writeParameters(CLSUtils.getParameters(obj));

            String[] excludeList = {"SqlQuery", "FormalSpec"};
            writeProps(queryDef, obj, Arrays.asList(excludeList));

            writeln();
            writeln("{");
            String sqlQuery = (obj.getSqlQuery() == null) ? "" : obj.getSqlQuery();
            sqlQuery = Pattern.compile("^(\r?\n)?(.*)(\r?\n)?$", Pattern.DOTALL).matcher(sqlQuery).replaceAll("$2");
            write(sqlQuery);
            writeln("\n}");
        }

        void showElement(TriggerDefinition obj) throws CacheException {
            writeDescription(obj.getDescription());
            printf("Trigger %s", obj.getName());

            String[] excludeList = {"Code"};
            writeProps(triggerDef, obj, Arrays.asList(excludeList));

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
            writeParensValue(" On %s", obj.getProperties());

            String[] excludeList = {"Properties"};
            writeProps(indexDef, obj, Arrays.asList(excludeList));

            writeln(";");
        }

        void showElement(ForeignKeyDefinition obj) throws CacheException {
            writeDescription(obj.getDescription());
            String props = (obj.getProperties() == null) ? "" : obj.getProperties();
            String refClass = (obj.getReferencedClass() == null) ? "" : obj.getReferencedClass();
            String refKey = (obj.getReferencedKey() == null) ? "" : obj.getReferencedKey();
            printf("ForeignKey %s(%s)", obj.getName(), props);
            printf(" References %s(%s)", refClass, refKey);

            String[] excludeList = {"Properties", "ReferencedClass", "ReferencedKey"};
            writeProps(foreignkeyDef, obj, Arrays.asList(excludeList));

            writeln(";");
        }

        void showElement(ProjectionDefinition obj) throws CacheException {
            writeDescription(obj.getDescription());
            printf("Projection %s", obj.getName());
            printf(" As %s", obj.getType());
            writeParameters(CLSUtils.getParameters(obj));

            String[] excludeList = {"Type"};
            writeProps(projectionDef, obj, Arrays.asList(excludeList));

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

        void writeFormalSpec(String str) {
            if ((str != null) && (!str.isEmpty())) {
                str = str.replace(",", ", ");
                str = str.replace(":", " As ");
                str = str.replace("&", "ByRef ");
                str = str.replace("*", "Output ");
                str = str.replace("=", " = ");
            } else {
                str = "";
            }
            printf("(%s)", str);
        }

        void writeParameters(HashMap<String, String> list) {

            if ((list == null) || (list.isEmpty())) {
                return;
            }
            StringBuilder sepValueBuilder = new StringBuilder();
            for (Map.Entry<String, String> entry : list.entrySet()) {
                if (sepValueBuilder.length() > 0) {
                    sepValueBuilder.append(", ");
                }
                String paramName = entry.getKey();
                String paramVal = entry.getValue();
                if (paramVal != null) {
                    if (!paramVal.matches("^\\d*$")) {
                        paramVal = paramVal.replaceAll("\"", "\"\"");
                        paramVal = "\"" + paramVal + "\"";
                    }
                    sepValueBuilder.append(paramName);
                    sepValueBuilder.append(" = ");
                    sepValueBuilder.append(paramVal);
                } else {
                    sepValueBuilder.append(paramName);
                }
            }
            if (sepValueBuilder.length() > 0) {
                printf("(%s)", sepValueBuilder.toString());
            }
        }

        void writeBrackets(List<String> list) {
            if ((list == null) || (list.isEmpty())) {
                return;
            }
            StringBuilder sepValueBuilder = new StringBuilder();
            //Looping through the itemsList
            for (int i = 0; i < list.size() - 1; i++) {
                String value = list.get(i);
                //append the value into the builder
                sepValueBuilder.append(value);
                sepValueBuilder.append(", ");
            }
            sepValueBuilder.append(list.get(list.size() - 1));
            if (sepValueBuilder.length() > 0) {
                printf(" [ %s ]", sepValueBuilder.toString());
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
                write(string.getBytes(charset));
//                write(string.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
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
                ex.printStackTrace();
            }
        }
    }

    static class ObjectStream extends ByteArrayOutputStream {

        public ObjectStream() {
        }

        public void write(String string) throws IOException {
            write(string.getBytes());
        }
    }
}
