/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.core.cls;

import com.intersys.cache.CacheObject;
import com.intersys.classes.CacheRootObject;
import com.intersys.classes.Dictionary.ClassDefinition;
import com.intersys.classes.Dictionary.ParameterDefinition;
import com.intersys.classes.Dictionary.PropertyDefinition;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import com.intersys.objects.Id;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.nbstudio.syntax.cls.clsParser;

/**
 *
 * @author daimor
 */
public class CLSUtils {

    private static final ArrayList<String> propertiesExcludeList = new ArrayList<String>() {
        {
            add("Name");
            add("Description");
            add("SequenceNumber");
            add("Parameters");

            addList("%Dictionary.PropertyDefinition", new String[]{"Aliases", "Identity", "OnDelete", "Relationship", "Collection"});
            addList("%Dictionary.ParameterDefinition", new String[]{"Default", "Expression"});
            addList("%Dictionary.MethodDefinition", new String[]{"ClassMethod", "ClientMethod", "ReturnType", "FormalSpec", "Implementation", "Hash"});
            addList("%Dictionary.XDataDefinition", new String[]{"Data"});
            addList("%Dictionary.QueryDefinition", new String[]{"SqlQuery", "FormalSpec"});
            addList("%Dictionary.TriggerDefinition", new String[]{"Code"});
            addList("%Dictionary.IndexDefinition", new String[]{"Properties"});
            addList("%Dictionary.ForeignKeyDefinition", new String[]{"Properties", "ReferencedClass", "ReferencedKey"});
            addList("%Dictionary.ProjectionDefinition", new String[]{"Type"});
        }

        public void addList(String clsName, String[] excludeList) {
            for (String string : excludeList) {
                add(clsName + "||" + string);
            }
        }
    };

    private static CacheObject getmInternal(CacheRootObject obj) {
        CacheObject mInternal = null;
        try {
            Field privateStringField = CacheRootObject.class.getDeclaredField("mInternal");
            privateStringField.setAccessible(true);
            mInternal = (CacheObject) privateStringField.get(obj);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException ignoredException) {
        }
        return mInternal;
    }

    public static void setParameters(CacheRootObject obj, List<clsParser.ParameterContext> parametersList) {
        try {
            HashMap<String, String> params = CLSUtils.getParameters(obj);
            params.clear();
            if (parametersList == null) {
                return;
            }
            for (clsParser.ParameterContext parameterContext : parametersList) {
                String paramName = parameterContext.paramName.getText();
                String paramVal = parameterContext.paramVal.getText();
                paramVal = paramVal.replaceAll("\"\"", "\"");
                paramVal = Pattern.compile("^\"(.*)\"$").matcher(paramVal).replaceAll("$1");
                params.put(paramName, paramVal);
            }
        } catch (CacheException ignoredException) {
        }
    }

    public static HashMap<String, String> getParameters(CacheRootObject obj) throws com.intersys.objects.CacheException {
//        CacheObject mInternal = getmInternal(obj);
//        com.intersys.cache.Dataholder dh = mInternal.getProperty("Parameters", true);
//        com.intersys.cache.CacheObject cobj = dh.getCacheObject();
//        if (cobj == null) {
//            return null;
//        }
//        return  (HashMap<String, String>) (cobj.newJavaInstance());
        HashMap<String, String> result = new java.util.HashMap<>();
        try {
            Database db = obj.getDatabase();
            String className = obj._className(true);
            ClassDefinition objDef = (ClassDefinition) ClassDefinition.open(db, new Id(className), 0);

            List<ParameterDefinition> objParams = objDef.getParameters().asList();
            for (ParameterDefinition param : objParams) {
                String paramName = param.getName();
                String paramDef = param.getDefault();
                
                result.put(paramName, paramDef);
            }
        } catch (CacheException ex) {
        }
        return result;
    }

    public static void setProperty(CacheRootObject obj, String propName, boolean value) {
        try {
            CacheObject mInternal = getmInternal(obj);
            com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder(value);
            mInternal.setProperty(propName, dh);
        } catch (CacheException ignoredException) {
        }
    }

    public static void setProperty(CacheRootObject obj, String propName, String value) {
        try {
            CacheObject mInternal = getmInternal(obj);
            value = value.replaceAll("^\"(.*)\"$", "$1");
            value = ((value == null) || (value.isEmpty())) ? null : value;
            com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder(value);
            mInternal.setProperty(propName, dh);
        } catch (CacheException ignoredException) {
        }
    }

    public static String getProperty(CacheRootObject obj, String propName, String defaultValue) {
        try {
            CacheObject mInternal = getmInternal(obj);
            com.intersys.cache.Dataholder dh = mInternal.getProperty(propName, false);
            return dh.getString();
        } catch (CacheException ignoredException) {
            return defaultValue;
        }
    }

    public static Boolean getProperty(CacheRootObject obj, String propName, Boolean defaultValue) {
        try {
            CacheObject mInternal = getmInternal(obj);
            com.intersys.cache.Dataholder dh = mInternal.getProperty(propName, false);
            return dh.getBoolean();
        } catch (CacheException ignoredException) {
            return defaultValue;
        }
    }

    public static HashMap<String, Object> getProperties(CacheRootObject obj) {
        HashMap<String, Object> result = new java.util.HashMap<>();
        try {
            Database db = obj.getDatabase();
            String className = obj._className(true);
            ClassDefinition objDef = (ClassDefinition) ClassDefinition.open(db, new Id(className), 0);

            List<PropertyDefinition> objProps = objDef.getProperties().asList();
            for (PropertyDefinition prop : objProps) {
                String propName = prop.getName();
                String propType = prop.getType();
                String defaultValue = prop.getInitialExpression();

                if ((propName.startsWith("%"))
                        || propertiesExcludeList.contains(propName)
                        || propertiesExcludeList.contains(className + "||" + propName)
                        || (("InitialExpression".equals(propName)) && (obj instanceof PropertyDefinition) && (((PropertyDefinition) obj).getInitialExpression().equals("\"\"")))
                        || (!propType.matches("(%(Library.)?CacheString)|(%(Library.)?Boolean)"))) {
                    continue;
                }
                
                defaultValue = defaultValue.replaceAll("^\"(.*)\"$", "$1");
                defaultValue = defaultValue.replaceAll("\"\"", "\"");
                if (propType.matches("%(Library.)?CacheString")) {
                    result.put(propName, defaultValue);
                } else if (propType.matches("%(Library.)?Boolean")) {
                    result.put(propName, ("1".equals(defaultValue)));
                }
            }
        } catch (CacheException ex) {
        }
        return result;

    }
}
