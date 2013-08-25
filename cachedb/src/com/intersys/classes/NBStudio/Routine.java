package com.intersys.classes.NBStudio;


/**
 * Cache' Java Class Generated for class %NBStudio.Routine on version Cache for UNIX (SUSE Linux Enterprise Server for x86-64) 2013.1 (Build 416U) Mon Feb 4 2013 19:21:06 EST.<br>
 *
 * @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine</A>
**/

public class Routine extends com.intersys.classes.RegisteredObject implements java.io.Serializable {
    private static final long serialVersionUID = 1146;
    private static String CACHE_CLASS_NAME = "%NBStudio.Routine";
    /**
           <p>NB: DO NOT USE IN APPLICATION(!!!).
           <br>Use <code>com.intersys.classes.NBStudio.Routine.open</code> instead!</br></p>
           <p>
           Used to construct a Java object, corresponding to existing object
           in Cache database.
           </p>
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
    */
    public Routine (com.intersys.cache.CacheObject ref) throws com.intersys.objects.CacheException {
        super (ref);
    }
    public Routine (com.intersys.objects.Database db, String initstr) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME,initstr));
    }
    /**
       Creates a new instance of object "%NBStudio.Routine" in Cache
       database and corresponding object of class
       <code>com.intersys.classes.NBStudio.Routine</code>.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @throws com.intersys.objects.CacheException in case of error.

              @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
              @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
     */
    public Routine (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME));
    }
    /**
       Returns class name of the class com.intersys.classes.NBStudio.Routine as it is in
      Cache Database. Note, that this is a static method, so no
      object specific information can be returned. Use
      <code>getCacheClass().getName()</code> to get the class name
      for specific object.
       @return Cache class name as a <code>String</code>
      @see #getCacheClass()
      @see com.intersys.objects.reflect.CacheClass#getName()
     */
    public static String getCacheClassName( ) {
        return CACHE_CLASS_NAME;
    }

   /**
           Allows access metadata information about type of this object
           in Cache database. Also can be used for dynamic binding (accessing
           properties and calling methods without particular class known).

           @return <code>CacheClass</code> object for this object type.
   */
    public com.intersys.objects.reflect.CacheClass getCacheClass( ) throws com.intersys.objects.CacheException {
        return mInternal.getCacheClass();
    }

    public static void checkAllFieldsValid(com.intersys.objects.Database db ) throws com.intersys.objects.CacheException {
    }

    /**
       Verifies that all fields from Cache class are exposed with
       accessor methods in Java class and that values for indexes in
       zObjVal are the same as in Cache. It does not return anything
       but it throws an exception in case of inconsistency.

       <p>But if there is any inconsistency in zObjVal indexes this is fatal and class can not work correctly and must be regenerated

       @param db Database used for connection. Note that if you are
       using multiple databases the class can be consistent with one
       and inconsistent with another.
       @throws com.intersys.objects.InvalidClassException if any inconsistency is found.
       @throws com.intersys.objects.CacheException if any error occurred during
       verification, e.g. communication error with Database.
       @see com.intersys.objects.InvalidPropertyException

     */
    public static void checkAllMethods(com.intersys.objects.Database db ) throws com.intersys.objects.CacheException {
        checkAllMethods(db, CACHE_CLASS_NAME, Routine.class);
    }
    public static void checkManagerValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
    }
    /**
       Returns value of property <code>Manager</code>.
       <Description>
       @return current value of <code>Manager</code> represented as
       <code>com.intersys.classes.RoutineMgr</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#Manager"> Manager</A>
    */
    public com.intersys.classes.RoutineMgr getManager()  throws com.intersys.objects.CacheException {
       com.intersys.cache.Dataholder dh = mInternal.getProperty("Manager",true);
        com.intersys.cache.CacheObject cobj = dh.getCacheObject();
        if (cobj == null)
            return null;
        return (com.intersys.classes.RoutineMgr)(cobj.newJavaInstance());
    }

    /**
       Sets new value for <code>Manager</code>.
       <Description>
       @param value new value to be set represented as
       <code>com.intersys.classes.RoutineMgr</code>.
       @throws com.intersys.objects.CacheException if any error occurred during value setting.
       @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#Manager"> Manager</A>
    */
    public void setManager(com.intersys.classes.RoutineMgr value)  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder (value);
        mInternal.setProperty("Manager", dh);
        return;
    }

    public static void checkNameValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
    }
    /**
       Returns value of property <code>Name</code>.
       <Description>
       @return current value of <code>Name</code> represented as
       <code>java.lang.String</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#Name"> Name</A>
    */
    public java.lang.String getName()  throws com.intersys.objects.CacheException {
       com.intersys.cache.Dataholder dh = mInternal.getProperty("Name",false);
       return dh.getString();
    }

    /**
       Sets new value for <code>Name</code>.
       <Description>
       @param value new value to be set represented as
       <code>java.lang.String</code>.
       @throws com.intersys.objects.CacheException if any error occurred during value setting.
       @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#Name"> Name</A>
    */
    public void setName(java.lang.String value)  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder (value);
        mInternal.setProperty("Name", dh);
        return;
    }

    public static void checkReadOnlyValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
    }
    /**
       Returns value of property <code>ReadOnly</code>.
       <Description>
       @return current value of <code>ReadOnly</code> represented as
       <code>java.lang.Boolean</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#ReadOnly"> ReadOnly</A>
    */
    public java.lang.Boolean getReadOnly()  throws com.intersys.objects.CacheException {
       com.intersys.cache.Dataholder dh = mInternal.getProperty("ReadOnly",false);
       return dh.getBoolean();
    }

    /**
       Sets new value for <code>ReadOnly</code>.
       <Description>
       @param value new value to be set represented as
       <code>java.lang.Boolean</code>.
       @throws com.intersys.objects.CacheException if any error occurred during value setting.
       @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#ReadOnly"> ReadOnly</A>
    */
    public void setReadOnly(java.lang.Boolean value)  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder (value);
        mInternal.setProperty("ReadOnly", dh);
        return;
    }

    /**
     <p>Runs method %ClassName in Cache.</p>
     <p>Description: Returns the object's class name. The <var>fullname</var> determines how the
class name is represented. If it is 1 then it returns the full class name
including any package qualifier. If it is 0 (the default) then it returns the
name of the class without the package, this is mainly for backward compatibility
with the pre-package behaviour of %ClassName.</p>
     @param db represented as com.intersys.objects.Database
     @param fullname represented as java.lang.Boolean
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#%ClassName"> Method %ClassName</A>
    */
    public static java.lang.String sys_ClassName (com.intersys.objects.Database db, java.lang.Boolean fullname) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(fullname);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%ClassName",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method %IsA in Cache.</p>
     <p>Description: Returns true (1) if instances of this class are also instances of the isclass parameter.
That is 'isclass' is a primary superclass of this object.</p>
     @param db represented as com.intersys.objects.Database
     @param isclass represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#%IsA"> Method %IsA</A>
    */
    public static java.lang.Integer sys_IsA (com.intersys.objects.Database db, java.lang.String isclass) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(isclass);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%IsA",args,com.intersys.objects.Database.RET_PRIM);
        return res.getInteger();
    }
    /**
     <p>Runs method GetDate in Cache.</p>
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#GetDate"> Method GetDate</A>
    */
    public java.sql.Timestamp GetDate () throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("GetDate",args,com.intersys.objects.Database.RET_PRIM);
        return res.getTimestamp();
    }
    /**
     <p>Runs method GetSize in Cache.</p>
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#GetSize"> Method GetSize</A>
    */
    public java.lang.Integer GetSize () throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("GetSize",args,com.intersys.objects.Database.RET_PRIM);
        return res.getInteger();
    }
    /**
     <p>Runs method ManagerIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param value represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#ManagerIsValid"> Method ManagerIsValid</A>
    */
    public static void ManagerIsValid (com.intersys.objects.Database db, java.lang.String value) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(value);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ManagerIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method NameDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#NameDisplayToLogical"> Method NameDisplayToLogical</A>
    */
    public static java.lang.String NameDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"NameDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method NameIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#NameIsValid"> Method NameIsValid</A>
    */
    public static void NameIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"NameIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method NameLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#NameLogicalToDisplay"> Method NameLogicalToDisplay</A>
    */
    public static java.lang.String NameLogicalToDisplay (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"NameLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ReadOnlyDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#ReadOnlyDisplayToLogical"> Method ReadOnlyDisplayToLogical</A>
    */
    public static java.lang.Boolean ReadOnlyDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ReadOnlyDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getBoolean();
    }
    /**
     <p>Runs method ReadOnlyIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     default argument _val set to ""
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #ReadOnlyIsValid(com.intersys.objects.Database,java.lang.String)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#ReadOnlyIsValid"> Method ReadOnlyIsValid</A>
    */
    public static void ReadOnlyIsValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ReadOnlyIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method ReadOnlyIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#ReadOnlyIsValid"> Method ReadOnlyIsValid</A>
    */
    public static void ReadOnlyIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ReadOnlyIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method ReadOnlyLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.Boolean
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#ReadOnlyLogicalToDisplay"> Method ReadOnlyLogicalToDisplay</A>
    */
    public static java.lang.String ReadOnlyLogicalToDisplay (com.intersys.objects.Database db, java.lang.Boolean _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ReadOnlyLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method compile in Cache.</p>
     <p>Description: Compiles this routine.</p>
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#compile"> Method compile</A>
    */
    public com.intersys.objects.SList compile () throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("compile",args,com.intersys.objects.Database.RET_PRIM);
        return res.getSList();
    }
    /**
     <p>Runs method getContents in Cache.</p>
     <p>Description: Retrieves routine contents.</p>
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#getContents"> Method getContents</A>
    */
    public com.intersys.classes.BinaryStream getContents () throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("getContents",args,com.intersys.objects.Database.RET_OBJECT);
        com.intersys.cache.CacheObject cobj = res.getCacheObject();
        if (cobj == null)
            return null;
        return (com.intersys.classes.BinaryStream)(cobj.newJavaInstance());
    }
    /**
     <p>Runs method setContents in Cache.</p>
     <p>Description: Sets routine contents to those of
specified character stream.</p>
     @param contents represented as com.intersys.classes.CharacterStream
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=SAMPLES&CLASSNAME=%25NBStudio.Routine#setContents"> Method setContents</A>
    */
    public void setContents (com.intersys.classes.CharacterStream contents) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(contents);
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("setContents",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
}
