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
import com.intersys.classes.GlobalCharacterStream;
import com.intersys.objects.CacheDatabase;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import com.intersys.objects.Id;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.nbstudio.syntax.cls.clsLexer;
import org.nbstudio.syntax.cls.clsParser;
import org.nbstudio.syntax.cls.clsParserBaseListener;

/**
 *
 * @author daimor
 */
public class CLSParserListerer4Save extends clsParserBaseListener {
    
    clsParser parser;
    ClassDefinition cls = null;
    private String className;
    private final Database db;
    int itemIndex = 0;
    CacheObject mInternal = null;
    HashMap<String, clsParser.ClassPropertiesContext> clsProps = new HashMap<>();
    HashMap<String, ParserRuleContext> curObjProps = new HashMap<>();
    CacheRootObject curObj = null;

    // only for testing
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length > 0) {
            inputFile = args[0];
        }
        InputStream is = System.in;
        if (inputFile != null) {
            is = new FileInputStream(inputFile);
        }
        ANTLRInputStream input = new ANTLRInputStream(is);
        
        clsLexer lexer = new clsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        clsParser parser = new clsParser(tokens);
        ParseTree tree = parser.prog(); // parse

        ParseTreeWalker walker = new ParseTreeWalker();
        String connString = "jdbc:Cache://localhost:1972/USER";
        Database db = CacheDatabase.getDatabase(connString);
        
        CLSParserListerer4Save extractor = new CLSParserListerer4Save(parser, db, null);
        
        System.out.println("start walk");
        walker.walk(extractor, tree);
        System.out.println("end walk");
        String className = extractor.GetClassName();
        System.out.println("ClassName: " + className);
        
        ClassFile clsFile = new ClassFile(db, className);
        InputStream clsText = clsFile.open();
        
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clsText))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        }
    }
    private final boolean noSave = false;
    
    String GetClassName() {
        return this.className;
    }
    
    CLSParserListerer4Save(clsParser clsParser, Database db, ClassDefinition clsDef) {
        
        this.parser = clsParser;
        this.cls = clsDef;
        this.db = db;
    }
    
    @Override
    public void enterClassDefintion(clsParser.ClassDefintionContext ctx) {
        try {
            this.className = ctx.ClassName().getText();
            String includeFiles = (ctx.includeDefinition() == null) ? "" : SepList(convertList(ctx.includeDefinition().includeFiles().IncludeFile()));
            String includegeneratorFiles = (ctx.includegeneratorDefinition() == null) ? "" : SepList(convertList(ctx.includegeneratorDefinition().includeFiles().IncludeFile()));
            String importFiles = (ctx.importDefinition() == null) ? "" : SepList(convertList(ctx.importDefinition().includeFiles().IncludeFile()));

            // Description
            String descr = getDescription(ctx.Description());

            // Extends
            String superClasses = (ctx.extendClassess == null) ? "" : SepList(convertList(ctx.extendClassess.ClassName()));
            
            this.itemIndex = 0;
            if (cls == null) {
                if (ClassDefinition.exists(db, new Id(this.className))) {
                    cls = (ClassDefinition) ClassDefinition._open(db, new Id(this.className));
                } else {
                    cls = new ClassDefinition(db, this.className);
                }
            }
            if (cls != null) {
                /// mInternal - I hope this protected property, will be all time
                if (mInternal == null) {
                    Field privateStringField = CacheRootObject.class.getDeclaredField("mInternal");
                    privateStringField.setAccessible(true);
                    mInternal = (CacheObject) privateStringField.get(cls);
                }
                if (includeFiles.isEmpty()) {
                    classPropReset("IncludeCode");
                } else {
                    cls.setIncludeCode(includeFiles);
                }
                if (includegeneratorFiles.isEmpty()) {
                    classPropReset("IncludeGenerator");
                } else {
                    cls.setIncludeGenerator(includegeneratorFiles);
                }
                if (importFiles.isEmpty()) {
                    classPropReset("Import");
                } else {
                    cls.setImport(importFiles);
                }
                if ((descr == null) || (descr.isEmpty())) {
                    classPropReset("Description");
                } else {
                    cls.setDescription(descr);
                }
                if (superClasses.isEmpty()) {
                    classPropReset("Super");
                } else {
                    cls.setSuper(superClasses);
                }
                
                clsProps.clear();
                
                cls.getProperties().clear();
                cls.getParameters().clear();
                cls.getMethods().clear();
                cls.getIndices().clear();
                cls.getUDLTexts().clear();
                cls.getProjections().clear();
                cls.getForeignKeys().clear();
                cls.getTriggers().clear();
                cls.getQueries().clear();
                cls.getXDatas().clear();
            }
        } catch (CacheException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
        }
    }
    
    void classPropReset(String propName) {
        try {
            com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
            com.intersys.cache.Dataholder res = mInternal.runInstanceMethod(propName + "Reset", args, com.intersys.objects.Database.RET_NONE);
        } catch (CacheException ex) {
        }
    }
    
    void classPropSet(String propName, boolean value) {
        try {
            com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
            args[0] = new com.intersys.cache.Dataholder(value);
            mInternal.runInstanceMethod(propName + "Set", args, com.intersys.objects.Database.RET_PRIM);
        } catch (CacheException ignoredException) {
        }
    }
    
    void classPropSet(String propName, String value) {
        try {
            com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
            args[0] = new com.intersys.cache.Dataholder(value);
            mInternal.runInstanceMethod(propName + "Set", args, com.intersys.objects.Database.RET_PRIM);
        } catch (CacheException ignoredException) {
        }
    }
    
    @Override
    public void enterClassProperties(clsParser.ClassPropertiesContext ctx) {
        if ((ctx.propName != null) && (!ctx.propName.getText().isEmpty())) {
            String propName = ctx.propName.getText().toLowerCase();
            clsProps.put(propName, ctx);
        }
    }
    
    @Override
    public void exitClassDefintion(clsParser.ClassDefintionContext ctx) {
        try {
            clsParser.ClassPropertiesContext tmpCtx;
            /// boolean's properties
            String[] boolProps = {"Abstract", "DdlAllowed", "Final", "Hidden", "ProcedureBlock", "SqlRowIdPrivate"};
            for (String propName : boolProps) {
                if ((tmpCtx = clsProps.get(propName.toLowerCase())) != null) {
                    classPropSet(propName, tmpCtx.Not() == null);
                } else {
                    classPropReset(propName);
                }
            }
            /// string's properties 
            String[] stringProps = {
                "ClassType", "ClientDataType", "ClientName", "CompileAfter", "DependsOn", "Inheritance",
                "Language", "OdbcType", "Owner", "ServerOnly", "SoapBindingStyle", "SoapBodyUse",
                "SQLCategory", "SqlRowIdName", "SqlTableName", "StorageStrategy", "ViewQuery"};
            for (String propName : stringProps) {
                try {
                    if ((tmpCtx = clsProps.get(propName.toLowerCase())) != null) {
                        classPropSet(propName, tmpCtx.propVal.getText());
                    } else {
                        classPropReset(propName);
                    }
                } catch (Exception ex) {
                }
            }
            
            if ((!noSave) && (cls != null)) {
                cls._save();
            }
        } catch (CacheException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void enterPropertyDefinition(clsParser.PropertyDefinitionContext ctx) {
        itemIndex++;
        String descr = getDescription(ctx.Description());
        String propertyName = ctx.PropertyName().getText();
        boolean relationship = ctx.Relationship() != null;
        String collection = (ctx.PropertyCollection() == null) ? null : ctx.PropertyCollection().getText();
        
        String propertyType = (ctx.propertyType == null) ? null : ctx.propertyType.getText();
        
        try {
            String fullPropertyName = this.className + "||" + propertyName;
            PropertyDefinition propertyDefinition;
            
            if (PropertyDefinition._existsId(db, new Id(fullPropertyName))) {
                propertyDefinition = (PropertyDefinition) PropertyDefinition._open(db, new Id(fullPropertyName));
            } else {
                propertyDefinition = new PropertyDefinition(db, this.className + ":" + propertyName);
            }
            
            propertyDefinition.setparent(this.cls);
            propertyDefinition.setSequenceNumber(itemIndex);
            propertyDefinition.setDescription(descr);
            propertyDefinition.setType(propertyType);
            propertyDefinition.setRelationship(relationship);
            propertyDefinition.setCollection(collection);
            
            List<clsParser.ParameterContext> parameters = (ctx.parametersList() == null) ? null : ctx.parametersList().parameter();
            CLSUtils.setParameters(propertyDefinition, parameters);
            
            curObjProps.clear();
            curObj = propertyDefinition;
        } catch (CacheException ex) {
        }
    }
    
    @Override
    public void enterPropertyProperties(clsParser.PropertyPropertiesContext ctx) {
        if ((ctx.propName != null) && (!ctx.propName.getText().isEmpty())) {
            String propName = ctx.propName.getText().toLowerCase();
            curObjProps.put(propName, ctx);
        }
    }
    
    @Override
    public void exitPropertyDefinition(clsParser.PropertyDefinitionContext ctx) {
        try {
            if (curObj == null) {
                return;
            }
            PropertyDefinition propertyDefinition = (PropertyDefinition) curObj;
            
            clsParser.PropertyPropertiesContext tmpCtx;
            
            Map<String, Object> objProps = CLSUtils.getProperties(propertyDefinition);
            for (Map.Entry<String, Object> entry : objProps.entrySet()) {
                String propName = entry.getKey();
                Object defaultVal = entry.getValue();
                
                tmpCtx = (clsParser.PropertyPropertiesContext) curObjProps.get(propName.toLowerCase());
                if (defaultVal instanceof Boolean) {
                    boolean propVal = (tmpCtx == null) ? (Boolean) defaultVal : true;
                    CLSUtils.setProperty(propertyDefinition, propName, propVal);
                } else if (defaultVal instanceof String) {
                    String propVal;
                    if (tmpCtx == null) {
                        propVal = (String) defaultVal;
                    } else if (("InitialExpression".equals(propName)) || ("SqlComputeCode".equals(propName))) {
                        propVal = tmpCtx.propVal.getText();
                        propVal = Pattern.compile("^\\{(.*)\\}$", Pattern.DOTALL).matcher(propVal).replaceAll("$1");
                    } else {
                        propVal = tmpCtx.propVal.getText();
                    }
                    CLSUtils.setProperty(propertyDefinition, propName, propVal);
                }
            }

//          save property definition
            if (!noSave) {
                propertyDefinition._save();
            }
        } catch (CacheException ex) {
        }
        curObj = null;
    }
    
    @Override
    public void enterMethodDefintion(clsParser.MethodDefintionContext ctx) {
        itemIndex++;
        String descr = getDescription(ctx.Description());
        String methodName = ctx.MethodName().getText();
        Boolean classMethod = (ctx.ClassMethod() != null);
        clsParser.MethodFormalSpecContext methodFormalSpec = ctx.methodFormalSpec();
        ArrayList<String> formalSpecList = new ArrayList<>();
        if (methodFormalSpec != null) {
            for (clsParser.MethodFormalSpecOneContext fc : methodFormalSpec.methodFormalSpecOne()) {
                String str = "";
                str += (fc.ByRef() == null) ? "" : "&";
                str += (fc.Output() == null) ? "" : "*";
                str += fc.varName.getText();
                str += (fc.As() == null) ? "" : ":" + fc.varType.getText();
                str += (fc.EQUAL() == null) ? "" : "=" + fc.methodFormalSpecExpr().getText();
//                str = str.replace("\"", "\"\"");
                formalSpecList.add(str);
            }
        }
        String formalSpec = SepList(formalSpecList);
        formalSpec = ((formalSpec == null) || (formalSpec.isEmpty())) ? null : formalSpec;
        String returnType = (ctx.returnType == null) ? null : ctx.returnType.getText();
        
        try {
            String fullMethodName = this.className + "||" + methodName;
            MethodDefinition methodDefinition;
            
            if (PropertyDefinition._existsId(db, new Id(fullMethodName))) {
                methodDefinition = (MethodDefinition) MethodDefinition._open(db, new Id(fullMethodName));
            } else {
                methodDefinition = new MethodDefinition(db, this.className + ":" + methodName);
            }
            
            methodDefinition.setparent(cls);
            methodDefinition.setSequenceNumber(itemIndex);
            methodDefinition.setDescription(descr);
            methodDefinition.setClassMethod(classMethod);
            methodDefinition.setFormalSpec(formalSpec);
            methodDefinition.setReturnType(returnType);
            
            GlobalCharacterStream code = new GlobalCharacterStream(db);
            String codeStr = ctx.MethodDeclaration().getText();
            codeStr = Pattern.compile("^\\{(\r?\n)?(.*)(\r?\n)?\\}$", Pattern.DOTALL).matcher(codeStr).replaceAll("$2");
            code.getWriter().write(codeStr);
            methodDefinition.setImplementation(code);
            
            curObjProps.clear();
            curObj = methodDefinition;
        } catch (CacheException | IOException ex) {
        }
    }
    
    @Override
    public void enterMethodProperties(clsParser.MethodPropertiesContext ctx) {
        if ((ctx.propName != null) && (!ctx.propName.getText().isEmpty())) {
            String propName = ctx.propName.getText().toLowerCase();
            curObjProps.put(propName, ctx);
        }
    }
    
    @Override
    public void exitMethodDefintion(clsParser.MethodDefintionContext ctx) {
        try {
            if (curObj == null) {
                return;
            }
            MethodDefinition methodDefinition = (MethodDefinition) curObj;
            clsParser.MethodPropertiesContext tmpCtx;
            
            Map<String, Object> objProps = CLSUtils.getProperties(methodDefinition);
            for (Map.Entry<String, Object> entry : objProps.entrySet()) {
                String propName = entry.getKey();
                Object defaultVal = entry.getValue();
                
                tmpCtx = (clsParser.MethodPropertiesContext) curObjProps.get(propName.toLowerCase());
                if (defaultVal instanceof Boolean) {
                    boolean propVal = (tmpCtx == null) ? (Boolean) defaultVal : true;
                    CLSUtils.setProperty(methodDefinition, propName, propVal);
                } else if (defaultVal instanceof String) {
                    String propVal;
                    if (tmpCtx == null) {
                        propVal = (String) defaultVal;
                    } else if ("PublicList".equals(propName)) {
                        propVal = SepListTN(tmpCtx.ids().ID());
                    } else {
                        propVal = tmpCtx.propVal.getText();
                    }
                    CLSUtils.setProperty(methodDefinition, propName, propVal);
                }
            }

//            save method definition
            if (!noSave) {
                methodDefinition._save();
            }
        } catch (CacheException ex) {
        }
        curObj = null;
    }
    
    @Override
    public void enterParameterDefinition(clsParser.ParameterDefinitionContext ctx) {
        itemIndex++;
        String descr = getDescription(ctx.Description());
        String parameterName = ctx.ParameterName().getText();
        
        try {
            String fullParameterName = this.className + "||" + parameterName;
            ParameterDefinition parameterDefinition;
            
            if (ParameterDefinition._existsId(db, new Id(fullParameterName))) {
                parameterDefinition = (ParameterDefinition) ParameterDefinition._open(db, new Id(fullParameterName));
            } else {
                parameterDefinition = new ParameterDefinition(db, this.className + ":" + parameterName);
            }
            
            parameterDefinition.setparent(cls);
            parameterDefinition.setSequenceNumber(itemIndex);
            parameterDefinition.setDescription(descr);
            
            String parameterValue = ctx.parameterValue.getText();
            if (parameterValue.startsWith("{")) {
//                parameterValue = Pattern.compile("^\\{(.*)\\}$").matcher(parameterValue).replaceAll("$1");
//                parameterDefinition.setExpression(parameterValue);
            } else {
                if (parameterValue.startsWith("\"")) {
                    parameterValue = Pattern.compile("^\"(.*)\"$").matcher(parameterValue).replaceAll("$1");
                }
                parameterDefinition.setDefault(parameterValue);
            }
            
            curObj = parameterDefinition;
            curObjProps.clear();
        } catch (CacheException ex) {
        }
        
    }
    
    @Override
    public void enterParameterProperties(clsParser.ParameterPropertiesContext ctx) {
        if ((ctx.propName != null) && (!ctx.propName.getText().isEmpty())) {
            String propName = ctx.propName.getText().toLowerCase();
            curObjProps.put(propName, ctx);
        }
    }
    
    @Override
    public void exitParameterDefinition(clsParser.ParameterDefinitionContext ctx) {
        try {
            if (curObj == null) {
                return;
            }
            ParameterDefinition parameterDefinition = (ParameterDefinition) curObj;
            
            clsParser.ParameterPropertiesContext tmpCtx;
            
            Map<String, Object> objProps = CLSUtils.getProperties(parameterDefinition);
            for (Map.Entry<String, Object> entry : objProps.entrySet()) {
                String propName = entry.getKey();
                Object defaultVal = entry.getValue();
                
                tmpCtx = (clsParser.ParameterPropertiesContext) curObjProps.get(propName.toLowerCase());
                if (defaultVal instanceof Boolean) {
                    boolean propVal = (tmpCtx == null) ? (Boolean) defaultVal : true;
                    CLSUtils.setProperty(parameterDefinition, propName, propVal);
                } else if (defaultVal instanceof String) {
                    String propVal;
                    if (tmpCtx == null) {
                        propVal = (String) defaultVal;
                    } else {
                        propVal = tmpCtx.propVal.getText();
                    }
                    CLSUtils.setProperty(parameterDefinition, propName, propVal);
                }
            }
            
            if (!noSave) {
                parameterDefinition._save();
            }
        } catch (CacheException ex) {
        }
        curObj = null;
    }
    
    @Override
    public void enterQueryDefinition(clsParser.QueryDefinitionContext ctx) {
        itemIndex++;
        String descr = getDescription(ctx.Description());
        String queryName = ctx.QueryName().getText();
        String returnType = ctx.returnType.getText();
        clsParser.QueryFormalSpecContext queryFormalSpec = ctx.queryFormalSpec();
        ArrayList<String> formalSpecList = new ArrayList<>();
        if (queryFormalSpec != null) {
            for (clsParser.QueryFormalSpecOneContext fc : queryFormalSpec.queryFormalSpecOne()) {
                String str = "";
                str += fc.varName.getText();
                str += (fc.As() == null) ? "" : ":" + fc.varType.getText();
                str += (fc.EQUAL() == null) ? "" : "=" + fc.queryFormalSpecExpr().getText();
//                str = str.replace("\"", "\"\"");
                formalSpecList.add(str);
            }
        }
        String formalSpec = SepList(formalSpecList);
        
        try {
            String fullQueryName = this.className + "||" + queryName;
            QueryDefinition queryDefinition;
            
            if (QueryDefinition._existsId(db, new Id(fullQueryName))) {
                queryDefinition = (QueryDefinition) QueryDefinition._open(db, new Id(fullQueryName));
            } else {
                queryDefinition = new QueryDefinition(db, this.className + ":" + queryName);
            }
            
            queryDefinition.setparent(cls);
            queryDefinition.setSequenceNumber(itemIndex);
            queryDefinition.setDescription(descr);
            
            String sqlQuery = (ctx.QueryDeclaration() == null) ? null : ctx.QueryDeclaration().getText();
            sqlQuery = Pattern.compile("^\\{(\r?\n)*(.*)(\r?\n)*\\}$", Pattern.DOTALL).matcher(sqlQuery).replaceAll("$2");
            queryDefinition.setSqlQuery(sqlQuery);
            queryDefinition.setFormalSpec(formalSpec);
            queryDefinition.setType(returnType);
            
            List<clsParser.ParameterContext> parameters = (ctx.parametersList() == null) ? null : ctx.parametersList().parameter();
            CLSUtils.setParameters(queryDefinition, parameters);
            
            curObjProps.clear();
            curObj = queryDefinition;
        } catch (CacheException ex) {
        }
    }
    
    @Override
    public void enterQueryProperties(clsParser.QueryPropertiesContext ctx) {
        if ((ctx.propName != null) && (!ctx.propName.getText().isEmpty())) {
            String propName = ctx.propName.getText().toLowerCase();
            curObjProps.put(propName, ctx);
        }
    }
    
    @Override
    public void exitQueryDefinition(clsParser.QueryDefinitionContext ctx) {
        try {
            if (curObj == null) {
                return;
            }
            QueryDefinition queryDefinition = (QueryDefinition) curObj;
            
            clsParser.QueryPropertiesContext tmpCtx;
            
            Map<String, Object> objProps = CLSUtils.getProperties(queryDefinition);
            for (Map.Entry<String, Object> entry : objProps.entrySet()) {
                String propName = entry.getKey();
                Object defaultVal = entry.getValue();
                
                tmpCtx = (clsParser.QueryPropertiesContext) curObjProps.get(propName.toLowerCase());
                if (defaultVal instanceof Boolean) {
                    boolean propVal = (tmpCtx == null) ? (Boolean) defaultVal : true;
                    CLSUtils.setProperty(queryDefinition, propName, propVal);
                } else if (defaultVal instanceof String) {
                    String propVal;
                    if (tmpCtx == null) {
                        propVal = (String) defaultVal;
                    } else {
                        propVal = tmpCtx.propVal.getText();
                    }
                    CLSUtils.setProperty(queryDefinition, propName, propVal);
                }
            }
            
            if (!noSave) {
                queryDefinition._save();
            }
        } catch (CacheException ex) {
        }
        curObj = null;
    }
    
    @Override
    public void enterXdataDefinition(clsParser.XdataDefinitionContext ctx) {
        itemIndex++;
        String descr = getDescription(ctx.Description());
        String xdataName = ctx.XDataName().getText();
        
        try {
            String fullXDataName = this.className + "||" + xdataName;
            XDataDefinition xdataDefinition;
            
            if (XDataDefinition._existsId(db, new Id(fullXDataName))) {
                xdataDefinition = (XDataDefinition) XDataDefinition._open(db, new Id(fullXDataName));
            } else {
                xdataDefinition = new XDataDefinition(db, this.className + ":" + xdataName);
            }
            
            xdataDefinition.setparent(cls);
            xdataDefinition.setSequenceNumber(itemIndex);
            xdataDefinition.setDescription(descr);
            
            GlobalCharacterStream code = new GlobalCharacterStream(db);
            String codeStr = ctx.XDataDeclaration().getText();
            codeStr = Pattern.compile("^\\{(\r?\n)?(.*)(\r?\n)?\\}$", Pattern.DOTALL).matcher(codeStr).replaceAll("$2");
            code.getWriter().write(codeStr);
            xdataDefinition.setData(code);
            
            curObj = xdataDefinition;
            curObjProps.clear();
        } catch (CacheException | IOException ex) {
        }
    }
    
    @Override
    public void enterXdataProperties(clsParser.XdataPropertiesContext ctx) {
        if ((ctx.propName != null) && (!ctx.propName.getText().isEmpty())) {
            String propName = ctx.propName.getText().toLowerCase();
            curObjProps.put(propName, ctx);
        }
    }
    
    @Override
    public void exitXdataDefinition(clsParser.XdataDefinitionContext ctx) {
        try {
            if (curObj == null) {
                return;
            }
            XDataDefinition xdataDefinition = (XDataDefinition) curObj;
            
            clsParser.XdataPropertiesContext tmpCtx;
            
            Map<String, Object> objProps = CLSUtils.getProperties(xdataDefinition);
            for (Map.Entry<String, Object> entry : objProps.entrySet()) {
                String propName = entry.getKey();
                Object defaultVal = entry.getValue();
                
                tmpCtx = (clsParser.XdataPropertiesContext) curObjProps.get(propName.toLowerCase());
                if (defaultVal instanceof Boolean) {
                    boolean propVal = (tmpCtx == null) ? (Boolean) defaultVal : true;
                    CLSUtils.setProperty(xdataDefinition, propName, propVal);
                } else if (defaultVal instanceof String) {
                    String propVal;
                    if (tmpCtx == null) {
                        propVal = (String) defaultVal;
                    } else {
                        propVal = tmpCtx.propVal.getText();
                    }
                    CLSUtils.setProperty(xdataDefinition, propName, propVal);
                }
            }
            
            if (!noSave) {
                xdataDefinition._save();
            }
        } catch (CacheException ex) {
        }
        curObj = null;
    }
    
    @Override
    public void enterIndexDefinition(clsParser.IndexDefinitionContext ctx) {
        itemIndex++;
        String descr = getDescription(ctx.Description());
        String indexName = ctx.IndexName().getText();
        
        try {
            String fullIndexName = this.className + "||" + indexName;
            IndexDefinition indexDefinition;
            
            if (IndexDefinition._existsId(db, new Id(fullIndexName))) {
                indexDefinition = (IndexDefinition) IndexDefinition._open(db, new Id(fullIndexName));
            } else {
                indexDefinition = new IndexDefinition(db, this.className + ":" + indexName);
            }
            
            List<String> listProps = new ArrayList<>();
            List<TerminalNode> ctxListProps = ctx.listProperties().PropertyName();
            for (TerminalNode terminalNode : ctxListProps) {
                listProps.add(terminalNode.getText());
            }
            
            indexDefinition.setparent(cls);
            indexDefinition.setSequenceNumber(itemIndex);
            indexDefinition.setDescription(descr);
            indexDefinition.setProperties(SepList(listProps));
            
            curObj = indexDefinition;
            curObjProps.clear();
        } catch (CacheException ex) {
        }
    }
    
    @Override
    public void enterIndexProperties(clsParser.IndexPropertiesContext ctx) {
        if ((ctx.propName != null) && (!ctx.propName.getText().isEmpty())) {
            String propName = ctx.propName.getText().toLowerCase();
            curObjProps.put(propName, ctx);
        }
    }
    
    @Override
    public void exitIndexDefinition(clsParser.IndexDefinitionContext ctx) {
        try {
            if (curObj == null) {
                return;
            }
            IndexDefinition indexDefinition = (IndexDefinition) curObj;
            
            clsParser.IndexPropertiesContext tmpCtx;
            
            Map<String, Object> objProps = CLSUtils.getProperties(indexDefinition);
            for (Map.Entry<String, Object> entry : objProps.entrySet()) {
                String propName = entry.getKey();
                Object defaultVal = entry.getValue();
                
                tmpCtx = (clsParser.IndexPropertiesContext) curObjProps.get(propName.toLowerCase());
                if (defaultVal instanceof Boolean) {
                    boolean propVal = (tmpCtx == null) ? (Boolean) defaultVal : true;
                    CLSUtils.setProperty(indexDefinition, propName, propVal);
                } else if (defaultVal instanceof String) {
                    String propVal;
                    if (tmpCtx == null) {
                        propVal = (String) defaultVal;
                    } else if ("Data".equals(propName)) {
                        propVal = SepListTN(tmpCtx.listProperties().PropertyName());
                    } else {
                        propVal = tmpCtx.propVal.getText();
                    }
                    CLSUtils.setProperty(indexDefinition, propName, propVal);
                }
            }
            
            if (!noSave) {
                indexDefinition._save();
            }
        } catch (CacheException ex) {
        }
        curObj = null;
        
    }
    
    @Override
    public void enterForeignkeyDefinition(clsParser.ForeignkeyDefinitionContext ctx) {
        itemIndex++;
        String descr = getDescription(ctx.Description());
        String foreignkeyName = ctx.ForeignKeyName().getText();
        String props = ctx.foreignkeyProps.getText();
        String refClass = ctx.foreignkeyRefClass.getText();
        String refKey = (ctx.foreignkeyRefKey == null) ? null : ctx.foreignkeyRefKey.getText();
        
        try {
            String fullForeignKeyName = this.className + "||" + foreignkeyName;
            ForeignKeyDefinition foreignkeyDefinition;
            
            if (IndexDefinition._existsId(db, new Id(fullForeignKeyName))) {
                foreignkeyDefinition = (ForeignKeyDefinition) IndexDefinition._open(db, new Id(fullForeignKeyName));
            } else {
                foreignkeyDefinition = new ForeignKeyDefinition(db, this.className + ":" + foreignkeyName);
            }
            
            foreignkeyDefinition.setparent(cls);
            foreignkeyDefinition.setSequenceNumber(itemIndex);
            foreignkeyDefinition.setDescription(descr);
            foreignkeyDefinition.setProperties(props);
            foreignkeyDefinition.setReferencedClass(refClass);
            foreignkeyDefinition.setReferencedKey(refKey);
            
            curObj = foreignkeyDefinition;
            curObjProps.clear();
        } catch (CacheException ex) {
        }
    }
    
    @Override
    public void enterForeignkeyProperties(clsParser.ForeignkeyPropertiesContext ctx) {
        if ((ctx.propName != null) && (!ctx.propName.getText().isEmpty())) {
            String propName = ctx.propName.getText().toLowerCase();
            curObjProps.put(propName, ctx);
        }
    }
    
    @Override
    public void exitForeignkeyDefinition(clsParser.ForeignkeyDefinitionContext ctx) {
        try {
            if (curObj == null) {
                return;
            }
            ForeignKeyDefinition foreignkeyDefinition = (ForeignKeyDefinition) curObj;
            
            clsParser.ForeignkeyPropertiesContext tmpCtx;
            
            Map<String, Object> objProps = CLSUtils.getProperties(foreignkeyDefinition);
            for (Map.Entry<String, Object> entry : objProps.entrySet()) {
                String propName = entry.getKey();
                Object defaultVal = entry.getValue();
                
                tmpCtx = (clsParser.ForeignkeyPropertiesContext) curObjProps.get(propName.toLowerCase());
                if (defaultVal instanceof Boolean) {
                    boolean propVal = (tmpCtx == null) ? (Boolean) defaultVal : true;
                    CLSUtils.setProperty(foreignkeyDefinition, propName, propVal);
                } else if (defaultVal instanceof String) {
                    String propVal;
                    if (tmpCtx == null) {
                        propVal = (String) defaultVal;
                    } else {
                        propVal = tmpCtx.propVal.getText();
                    }
                    CLSUtils.setProperty(foreignkeyDefinition, propName, propVal);
                }
            }
            
            if (!noSave) {
                foreignkeyDefinition._save();
            }
        } catch (CacheException ex) {
        }
        curObj = null;
    }
    
    @Override
    public void enterProjectionDefinition(clsParser.ProjectionDefinitionContext ctx) {
        itemIndex++;
        String descr = getDescription(ctx.Description());
        String projectionName = ctx.ProjectionName().getText();
        String type = ctx.ClassName().getText();
        
        try {
            String fullProjectionName = this.className + "||" + projectionName;
            ProjectionDefinition projectionDefinition;
            
            if (IndexDefinition._existsId(db, new Id(fullProjectionName))) {
                projectionDefinition = (ProjectionDefinition) IndexDefinition._open(db, new Id(fullProjectionName));
            } else {
                projectionDefinition = new ProjectionDefinition(db, this.className + ":" + projectionName);
            }
            
            projectionDefinition.setparent(cls);
            projectionDefinition.setSequenceNumber(itemIndex);
            projectionDefinition.setDescription(descr);
            projectionDefinition.setType(type);
            
            List<clsParser.ParameterContext> parameters = (ctx.parametersList() == null) ? null : ctx.parametersList().parameter();
            CLSUtils.setParameters(projectionDefinition, parameters);
            
            curObj = projectionDefinition;
            curObjProps.clear();
        } catch (CacheException ex) {
        }
    }
    
    @Override
    public void enterProjectionProperties(clsParser.ProjectionPropertiesContext ctx) {
        if ((ctx.propName != null) && (!ctx.propName.getText().isEmpty())) {
            String propName = ctx.propName.getText().toLowerCase();
            curObjProps.put(propName, ctx);
        }
    }
    
    @Override
    public void exitProjectionDefinition(clsParser.ProjectionDefinitionContext ctx) {
        try {
            if (curObj == null) {
                return;
            }
            ProjectionDefinition projectionDefinition = (ProjectionDefinition) curObj;
            
            clsParser.ProjectionPropertiesContext tmpCtx;
            
            Map<String, Object> objProps = CLSUtils.getProperties(projectionDefinition);
            for (Map.Entry<String, Object> entry : objProps.entrySet()) {
                String propName = entry.getKey();
                Object defaultVal = entry.getValue();
                
                tmpCtx = (clsParser.ProjectionPropertiesContext) curObjProps.get(propName.toLowerCase());
                if (defaultVal instanceof Boolean) {
                    boolean propVal = (tmpCtx == null) ? (Boolean) defaultVal : true;
                    CLSUtils.setProperty(projectionDefinition, propName, propVal);
//                } else if (defaultVal instanceof String) {
//                    String propVal;
//                    if (tmpCtx == null) {
//                        propVal = (String) defaultVal;
//                    } else {
//                        propVal = tmpCtx.propVal.getText();
//                    }
//                    CLSUtils.setProperty(projectionDefinition, propName, propVal);
                }
            }
            
            if (!noSave) {
                projectionDefinition._save();
            }
        } catch (CacheException ex) {
        }
        curObj = null;
    }
    
    @Override
    public void enterTriggerDefinition(clsParser.TriggerDefinitionContext ctx) {
        itemIndex++;
        String descr = getDescription(ctx.Description());
        String triggerName = ctx.TriggerName().getText();
        
        try {
            String fullTriggerName = this.className + "||" + triggerName;
            TriggerDefinition triggerDefinition;
            
            if (IndexDefinition._existsId(db, new Id(fullTriggerName))) {
                triggerDefinition = (TriggerDefinition) IndexDefinition._open(db, new Id(fullTriggerName));
            } else {
                triggerDefinition = new TriggerDefinition(db, this.className + ":" + triggerName);
            }
            
            triggerDefinition.setparent(cls);
            triggerDefinition.setSequenceNumber(itemIndex);
            triggerDefinition.setDescription(descr);
            
            String code = ctx.TriggerDeclaration().getText();
            code = Pattern.compile("^\\{(\r?\n)*(.*)(\r?\n)*\\}$", Pattern.DOTALL).matcher(code).replaceAll("$2");
            triggerDefinition.setCode(code);
            
            curObj = triggerDefinition;
            curObjProps.clear();
        } catch (CacheException ex) {
        }
    }
    
    @Override
    public void enterTriggerProperties(clsParser.TriggerPropertiesContext ctx) {
        if ((ctx.propName != null) && (!ctx.propName.getText().isEmpty())) {
            String propName = ctx.propName.getText().toLowerCase();
            curObjProps.put(propName, ctx);
        }
    }
    
    @Override
    public void exitTriggerDefinition(clsParser.TriggerDefinitionContext ctx) {
        try {
            if (curObj == null) {
                return;
            }
            TriggerDefinition triggerDefinition = (TriggerDefinition) curObj;
            
            clsParser.TriggerPropertiesContext tmpCtx;
            
            Map<String, Object> objProps = CLSUtils.getProperties(triggerDefinition);
            for (Map.Entry<String, Object> entry : objProps.entrySet()) {
                String propName = entry.getKey();
                Object defaultVal = entry.getValue();
                
                tmpCtx = (clsParser.TriggerPropertiesContext) curObjProps.get(propName.toLowerCase());
                if (defaultVal instanceof Boolean) {
                    boolean propVal = (tmpCtx == null) ? (Boolean) defaultVal : true;
                    CLSUtils.setProperty(triggerDefinition, propName, propVal);
                } else if (defaultVal instanceof String) {
                    String propVal;
                    if (tmpCtx == null) {
                        propVal = (String) defaultVal;
                    } else {
                        propVal = tmpCtx.propVal.getText();
                    }
                    CLSUtils.setProperty(triggerDefinition, propName, propVal);
                }
            }
            
            if (!noSave) {
                triggerDefinition._save();
            }
        } catch (CacheException ex) {
        }
        curObj = null;
    }
    
    @Override
    public void enterComment(clsParser.CommentContext ctx) {
        itemIndex++;
        String udltextName = "T" + itemIndex;
        
        try {
            String fullUDLTextName = this.className + "||" + udltextName;
            UDLTextDefinition udltextDefinition;
            
            if (UDLTextDefinition._existsId(db, new Id(fullUDLTextName))) {
                udltextDefinition = (UDLTextDefinition) UDLTextDefinition._open(db, new Id(fullUDLTextName));
            } else {
                udltextDefinition = new UDLTextDefinition(db, this.className + ":" + udltextName);
            }
            
            udltextDefinition.setparent(cls);
            udltextDefinition.setSequenceNumber(itemIndex);
            GlobalCharacterStream udltextContent = new GlobalCharacterStream(db);
            udltextContent._write(ctx.getText());
            udltextDefinition.setContent(udltextContent);
            
            if (!noSave) {
                udltextDefinition._save();
            }
        } catch (CacheException ex) {
        }
    }
    
    String getDescription(List<TerminalNode> descrList) {
        String descr = SepList(convertList(descrList, new cnvString() {
            @Override
            public String convert(String data) {
                return data.replaceAll("^/// ?(.*)\r?\n$", "$1");
            }
        }), "\r\n");
        return descr.isEmpty() ? null : descr;
    }
    
    List<String> convertList(List<TerminalNode> tnList) {
        return convertList(tnList, new cnvString() {
            @Override
            public String convert(String data) {
                return data;
            }
        });
    }
    
    List<String> convertList(List<TerminalNode> tnList, cnvString func) {
        ArrayList<String> list = new ArrayList<>();
        for (TerminalNode terminalNode : tnList) {
            String str = terminalNode.getText();
            str = func.convert(str);
            list.add(str);
        }
        return list;
    }
    
    interface cnvString {
        
        String convert(String data);
    }
    
    static String stringToHex(String string) {
        StringBuilder buf = new StringBuilder(200);
        for (char ch : string.toCharArray()) {
            if (buf.length() > 0) {
                buf.append(' ');
            }
            buf.append(String.format("%04x", (int) ch));
        }
        return buf.toString();
    }
    
    String SepListTN(List<TerminalNode> tnList) {
        List<String> list = new ArrayList<>();
        
        for (TerminalNode terminalNode : tnList) {
            list.add(terminalNode.getText());
        }
        
        return SepList(list, ",");
    }
    
    String SepList(List<String> list) {
        return SepList(list, ",");
    }
    
    String SepList(List<String> list, String separator) {
        if ((list == null) || (list.isEmpty())) {
            return "";
        }
        StringBuilder sepValueBuilder = new StringBuilder();
        //Looping through the itemsList
        for (int i = 0; i < list.size() - 1; i++) {
            //append the value into the builder
            sepValueBuilder.append(list.get(i));
            sepValueBuilder.append(separator);
        }
        sepValueBuilder.append(list.get(list.size() - 1));
        return sepValueBuilder.toString();
    }
}
