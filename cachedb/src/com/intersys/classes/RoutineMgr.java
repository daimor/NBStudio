package com.intersys.classes;


/**
 * Cache' Java Class Generated for class %Library.RoutineMgr on version Cache for UNIX (SUSE Linux Enterprise Server for x86-64) 2014.1 (Build 608U) Tue Mar 25 2014 17:13:20 EDT.<br>
 * Description: This class is used internally by Cach&eacute;. You should not make direct use of it within your applications. There is no guarantee made about either the behavior or future operation of this class.<p>
This is a wrapper class used by Studio to manipulate routines.
 *
 * @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr</A>
**/

public class RoutineMgr extends com.intersys.classes.RegisteredObject implements java.io.Serializable {
    private static final long serialVersionUID = 7094;
    private static String CACHE_CLASS_NAME = "%Library.RoutineMgr";
    /**
           <p>NB: DO NOT USE IN APPLICATION(!!!).
           <br>Use <code>com.intersys.classes.RoutineMgr.open</code> instead!</br></p>
           <p>
           Used to construct a Java object, corresponding to existing object
           in Cache database.
           </p>
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
    */
    public RoutineMgr (com.intersys.cache.CacheObject ref) throws com.intersys.objects.CacheException {
        super (ref);
    }
    public RoutineMgr (com.intersys.objects.Database db, String initstr) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME,initstr));
    }
    /**
       Creates a new instance of object "%Library.RoutineMgr" in Cache
       database and corresponding object of class
       <code>com.intersys.classes.RoutineMgr</code>.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @throws com.intersys.objects.CacheException in case of error.

              @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
              @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
     */
    public RoutineMgr (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        super (((com.intersys.cache.SysDatabase)db).newCacheObject (CACHE_CLASS_NAME));
    }
    /**
       Runs method <code> %OpenId </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>com.intersys.classes.RoutineMgr</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>com.intersys.classes.RoutineMgr</code> or of
      any of its subclasses. Cast to <code>com.intersys.classes.RoutineMgr</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
      <code>Id</code>.

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #RoutineMgr
     */
    public static com.intersys.classes.RegisteredObject _open (com.intersys.objects.Database db, com.intersys.objects.Id id) throws com.intersys.objects.CacheException {
        return open(db, id);
    }
    /**
       Runs method <code> %OpenId </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>com.intersys.classes.RoutineMgr</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>com.intersys.classes.RoutineMgr</code> or of
      any of its subclasses. Cast to <code>com.intersys.classes.RoutineMgr</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
      <code>Id</code>.

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #RoutineMgr
     */
    public static com.intersys.classes.RegisteredObject open (com.intersys.objects.Database db, com.intersys.objects.Id id) throws com.intersys.objects.CacheException {
        com.intersys.cache.CacheObject cobj = (((com.intersys.cache.SysDatabase)db).openCacheObject(CACHE_CLASS_NAME, id.toString()));
        return (com.intersys.classes.RegisteredObject)(cobj.newJavaInstance());
    }
    /**
       Runs method <code> %OpenId </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>com.intersys.classes.RoutineMgr</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>com.intersys.classes.RoutineMgr</code> or of
      any of its subclasses. Cast to <code>com.intersys.classes.RoutineMgr</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
      <code>Id</code>.
      @param concurrency Concurrency level.  represented as
      <code>Concurrency</code>.

      Here are concurrency values, see Object Concurrency Options in your on-line Cache' documentation for more information.
      @see <a href = "http://daimor-pc:57772/csp/documatic/DocBook.UI.Page.cls?KEY=GOBJ_concurrency"> Object Concurrency Options.</A>

      <TABLE border="1"
      summary="Object Concurrency Options.">
      <CAPTION><EM>Object Concurrency Options</EM></CAPTION>
      <TR><TD>-1 </TD><TD>Default concurrency</TD></TR>
      <TR><TD>0 </TD><TD>No locking, no locks are used</TD></TR>
      <TR><TD>1 </TD><TD>Atomic</TD></TR>
      <TR><TD>2 </TD><TD>Shared</TD></TR>
      <TR><TD>3 </TD><TD>Shared/Retained</TD></TR>
      <TR><TD>4 </TD><TD>Exclusive</TD></TR>
      </TABLE>

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #RoutineMgr
     */
    public static com.intersys.classes.RegisteredObject _open (com.intersys.objects.Database db, com.intersys.objects.Id id, int concurrency) throws com.intersys.objects.CacheException {
        return open(db, id, concurrency);
    }
    /**
       Runs method <code> %OpenId </code> in Cache to open an object
       from Cache database and creates corresponding object of class
       <code>com.intersys.classes.RoutineMgr</code>.

       @return <code> RegisteredObject </code>, corresponding to opened
       object. This object may be of <code>com.intersys.classes.RoutineMgr</code> or of
      any of its subclasses. Cast to <code>com.intersys.classes.RoutineMgr</code> is
      guaranteed to pass without <code>ClassCastException</code> exception.

       @param db <code>Database</code> object used for connection with
       Cache database.

       @param id ID as specified in Cache represented as
      <code>Id</code>.
      @param concurrency Concurrency level.  represented as
      <code>Concurrency</code>.

      Here are concurrency values, see Object Concurrency Options in your on-line Cache' documentation for more information.
      @see <a href = "http://daimor-pc:57772/csp/documatic/DocBook.UI.Page.cls?KEY=GOBJ_concurrency"> Object Concurrency Options.</A>

      <TABLE border="1"
      summary="Object Concurrency Options.">
      <CAPTION><EM>Object Concurrency Options</EM></CAPTION>
      <TR><TD>-1 </TD><TD>Default concurrency</TD></TR>
      <TR><TD>0 </TD><TD>No locking, no locks are used</TD></TR>
      <TR><TD>1 </TD><TD>Atomic</TD></TR>
      <TR><TD>2 </TD><TD>Shared</TD></TR>
      <TR><TD>3 </TD><TD>Shared/Retained</TD></TR>
      <TR><TD>4 </TD><TD>Exclusive</TD></TR>
      </TABLE>

       @throws com.intersys.objects.CacheException in case of error.
      @see java.lang.ClassCastException
           @see #_open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #open(com.intersys.objects.Database, com.intersys.objects.Oid)
           @see #RoutineMgr
     */
    public static com.intersys.classes.RegisteredObject open (com.intersys.objects.Database db, com.intersys.objects.Id id, int concurrency) throws com.intersys.objects.CacheException {
        com.intersys.cache.CacheObject cobj = (((com.intersys.cache.SysDatabase)db).openCacheObject(CACHE_CLASS_NAME, id.toString(), concurrency));
        return (com.intersys.classes.RegisteredObject)(cobj.newJavaInstance());
    }
    /**
       Returns class name of the class com.intersys.classes.RoutineMgr as it is in
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
        checkAllMethods(db, CACHE_CLASS_NAME, RoutineMgr.class);
    }
    public static void checkCodeValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
    }
    public com.intersys.objects.CacheReader getCodeIn()  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = mInternal.getProperty("Code",true);
        com.intersys.cache.CacheObject cobj = dh.getCacheObject();
        com.intersys.cache.SysDatabase db = mInternal.getDatabase();
        return (db.getReader (cobj));
    }
    public com.intersys.objects.CacheWriter getCodeOut() throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = mInternal.getProperty("Code",true);
        com.intersys.cache.CacheObject cobj = dh.getCacheObject();
        com.intersys.cache.SysDatabase db = mInternal.getDatabase();
        return (db.getWriter (cobj));
    }
    public static void checkGeneratedValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
    }
    /**
       Returns value of property <code>Generated</code>.
       <Description>
       @return current value of <code>Generated</code> represented as
       <code>java.lang.Boolean</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#Generated"> Generated</A>
    */
    public java.lang.Boolean getGenerated()  throws com.intersys.objects.CacheException {
       com.intersys.cache.Dataholder dh = mInternal.getProperty("Generated",false);
       return dh.getBoolean();
    }

    public static void checkIsCSPValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
    }
    /**
       Returns value of property <code>IsCSP</code>.
       <p>Description: True is this is a CSP/CSR file, else false.</p>
       @return current value of <code>IsCSP</code> represented as
       <code>java.lang.Boolean</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#IsCSP"> IsCSP</A>
    */
    public java.lang.Boolean getIsCSP()  throws com.intersys.objects.CacheException {
       com.intersys.cache.Dataholder dh = mInternal.getProperty("IsCSP",false);
       return dh.getBoolean();
    }

    public static void checkNameValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
    }
    /**
       Returns value of property <code>Name</code>.
       <p>Description: The name of the routine associated with this object.</p>
       @return current value of <code>Name</code> represented as
       <code>java.lang.String</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#Name"> Name</A>
    */
    public java.lang.String getName()  throws com.intersys.objects.CacheException {
       com.intersys.cache.Dataholder dh = mInternal.getProperty("Name",false);
       return dh.getString();
    }

    /**
       Sets new value for <code>Name</code>.
       <p>Description: The name of the routine associated with this object.</p>
       @param value new value to be set represented as
       <code>java.lang.String</code>.
       @throws com.intersys.objects.CacheException if any error occurred during value setting.
       @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#Name"> Name</A>
    */
    public void setName(java.lang.String value)  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder (value);
        mInternal.setProperty("Name", dh);
        return;
    }

    public static void checkNamespaceValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
    }
    /**
       Returns value of property <code>Namespace</code>.
       <p>Description: Return the namespace this routine/csp file exists in. Mainly used for CSP file for the Studio.</p>
       @return current value of <code>Namespace</code> represented as
       <code>java.lang.String</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#Namespace"> Namespace</A>
    */
    public java.lang.String getNamespace()  throws com.intersys.objects.CacheException {
       com.intersys.cache.Dataholder dh = mInternal.getProperty("Namespace",false);
       return dh.getString();
    }

    public static void checkProtectedValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
    }
    /**
       Returns value of property <code>Protected</code>.
       <p>Description: Deprecated</p>
       @return current value of <code>Protected</code> represented as
       <code>java.lang.Boolean</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#Protected"> Protected</A>
    */
    public java.lang.Boolean getProtected()  throws com.intersys.objects.CacheException {
       com.intersys.cache.Dataholder dh = mInternal.getProperty("Protected",false);
       return dh.getBoolean();
    }

    /**
       Sets new value for <code>Protected</code>.
       <p>Description: Deprecated</p>
       @param value new value to be set represented as
       <code>java.lang.Boolean</code>.
       @throws com.intersys.objects.CacheException if any error occurred during value setting.
       @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#Protected"> Protected</A>
    */
    public void setProtected(java.lang.Boolean value)  throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder dh = new com.intersys.cache.Dataholder (value);
        mInternal.setProperty("Protected", dh);
        return;
    }

    public static void checkTimeStampValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
    }
    /**
       Returns value of property <code>TimeStamp</code>.
       <p>Description: The timestamp of the routine associated with this object.</p>
       @return current value of <code>TimeStamp</code> represented as
       <code>java.sql.Timestamp</code>

       @throws com.intersys.objects.CacheException if any error occurred during value retrieval.
       @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#TimeStamp"> TimeStamp</A>
    */
    public java.sql.Timestamp getTimeStamp()  throws com.intersys.objects.CacheException {
       com.intersys.cache.Dataholder dh = mInternal.getProperty("TimeStamp",false);
       return dh.getTimestamp();
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
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#%ClassName"> Method %ClassName</A>
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
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#%IsA"> Method %IsA</A>
    */
    public static java.lang.Integer sys_IsA (com.intersys.objects.Database db, java.lang.String isclass) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(isclass);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"%IsA",args,com.intersys.objects.Database.RET_PRIM);
        return res.getInteger();
    }
    /**
     <p>Runs method %Save in Cache.</p>
     <p>Description: Save the routine associated with this object.
Return <var>Refresh</var>=1 if the save has changed
the document so it should be refreshed in the client</p>
     @param Refresh represented as com.intersys.objects.BooleanHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#%Save"> Method %Save</A>
    */
    public void sys_Save (com.intersys.objects.BooleanHolder Refresh) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        int[] _refs = new int[1];
        args[0] = com.intersys.cache.Dataholder.create (Refresh.value);
        _refs[0] = 1;
        com.intersys.cache.Dataholder[] res=mInternal.runInstanceMethod("%Save",_refs,args,com.intersys.objects.Database.RET_PRIM);
        Refresh.set(res[1].getBoolean());
        getDatabase().parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method AutoComplete in Cache.</p>
     <p>Description: Used to provide autocomplete in the open dialog, you pass in the <var>name</var> the user
has entered and the <var>mask</mask> which is the current pattern mask and it will return
null if it can not find a match or the next name that does match.</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @param mask represented as java.lang.String
     @param complete represented as com.intersys.objects.StringHolder
     default argument generated set to 1
     default argument directory set to ""
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #AutoComplete(com.intersys.objects.Database,java.lang.String,java.lang.String,com.intersys.objects.StringHolder,java.lang.Boolean,java.lang.String)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#AutoComplete"> Method AutoComplete</A>
    */
    public static void AutoComplete (com.intersys.objects.Database db, java.lang.String name, java.lang.String mask, com.intersys.objects.StringHolder complete) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        int[] _refs = new int[1];
        args[0] = new com.intersys.cache.Dataholder(name);
        args[1] = new com.intersys.cache.Dataholder(mask);
        args[2] = com.intersys.cache.Dataholder.create (complete.value);
        _refs[0] = 3;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"AutoComplete",_refs,args,com.intersys.objects.Database.RET_PRIM);
        complete.set(res[1].getString());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method AutoComplete in Cache.</p>
     <p>Description: Used to provide autocomplete in the open dialog, you pass in the <var>name</var> the user
has entered and the <var>mask</mask> which is the current pattern mask and it will return
null if it can not find a match or the next name that does match.</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @param mask represented as java.lang.String
     @param complete represented as com.intersys.objects.StringHolder
     @param generated represented as java.lang.Boolean
     default argument directory set to ""
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #AutoComplete(com.intersys.objects.Database,java.lang.String,java.lang.String,com.intersys.objects.StringHolder,java.lang.Boolean,java.lang.String)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#AutoComplete"> Method AutoComplete</A>
    */
    public static void AutoComplete (com.intersys.objects.Database db, java.lang.String name, java.lang.String mask, com.intersys.objects.StringHolder complete, java.lang.Boolean generated) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        int[] _refs = new int[1];
        args[0] = new com.intersys.cache.Dataholder(name);
        args[1] = new com.intersys.cache.Dataholder(mask);
        args[2] = com.intersys.cache.Dataholder.create (complete.value);
        _refs[0] = 3;
        args[3] = new com.intersys.cache.Dataholder(generated);
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"AutoComplete",_refs,args,com.intersys.objects.Database.RET_PRIM);
        complete.set(res[1].getString());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method AutoComplete in Cache.</p>
     <p>Description: Used to provide autocomplete in the open dialog, you pass in the <var>name</var> the user
has entered and the <var>mask</mask> which is the current pattern mask and it will return
null if it can not find a match or the next name that does match.</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @param mask represented as java.lang.String
     @param complete represented as com.intersys.objects.StringHolder
     @param generated represented as java.lang.Boolean
     @param directory represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#AutoComplete"> Method AutoComplete</A>
    */
    public static void AutoComplete (com.intersys.objects.Database db, java.lang.String name, java.lang.String mask, com.intersys.objects.StringHolder complete, java.lang.Boolean generated, java.lang.String directory) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[5];
        int[] _refs = new int[1];
        args[0] = new com.intersys.cache.Dataholder(name);
        args[1] = new com.intersys.cache.Dataholder(mask);
        args[2] = com.intersys.cache.Dataholder.create (complete.value);
        _refs[0] = 3;
        args[3] = new com.intersys.cache.Dataholder(generated);
        args[4] = new com.intersys.cache.Dataholder(directory);
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"AutoComplete",_refs,args,com.intersys.objects.Database.RET_PRIM);
        complete.set(res[1].getString());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method BestRoutineMatch in Cache.</p>
     <p>Description: Given a routine name return the name including extension that is most suitable for
Studio to open</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#BestRoutineMatch"> Method BestRoutineMatch</A>
    */
    public static java.lang.String BestRoutineMatch (com.intersys.objects.Database db, java.lang.String name) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(name);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"BestRoutineMatch",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method CheckDeveloperRole in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#CheckDeveloperRole"> Method CheckDeveloperRole</A>
    */
    public static void CheckDeveloperRole (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"CheckDeveloperRole",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method CheckSQLIdentifier in Cache.</p>
     <p>Description: Used by Studio to avoid calling %SQL.</p>
     @param db represented as com.intersys.objects.Database
     @param ident represented as com.intersys.objects.StringHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#CheckSQLIdentifier"> Method CheckSQLIdentifier</A>
    */
    public static void CheckSQLIdentifier (com.intersys.objects.Database db, com.intersys.objects.StringHolder ident) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        int[] _refs = new int[1];
        args[0] = com.intersys.cache.Dataholder.create (ident.value);
        _refs[0] = 1;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"CheckSQLIdentifier",_refs,args,com.intersys.objects.Database.RET_PRIM);
        ident.set(res[1].getString());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method CodeGetObjectId in Cache.</p>
     default argument force set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #CodeGetObjectId(java.lang.Integer)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#CodeGetObjectId"> Method CodeGetObjectId</A>
    */
    public java.lang.String CodeGetObjectId () throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("CodeGetObjectId",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method CodeGetObjectId in Cache.</p>
     @param force represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#CodeGetObjectId"> Method CodeGetObjectId</A>
    */
    public java.lang.String CodeGetObjectId (java.lang.Integer force) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(force);
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("CodeGetObjectId",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method CodeIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param value represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#CodeIsValid"> Method CodeIsValid</A>
    */
    public static void CodeIsValid (com.intersys.objects.Database db, java.lang.String value) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(value);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"CodeIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method CodeSetObject in Cache.</p>
     @param newvalue represented as com.intersys.objects.Oid
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#CodeSetObject"> Method CodeSetObject</A>
    */
    public void CodeSetObject (com.intersys.objects.Oid newvalue) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(newvalue);
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("CodeSetObject",args,com.intersys.objects.Database.RET_PRIM);
        getDatabase().parseStatus(res);
        return;
    }
    /**
     <p>Runs method CodeSetObjectId in Cache.</p>
     @param newid represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#CodeSetObjectId"> Method CodeSetObjectId</A>
    */
    public void CodeSetObjectId (java.lang.String newid) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(newid);
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("CodeSetObjectId",args,com.intersys.objects.Database.RET_PRIM);
        getDatabase().parseStatus(res);
        return;
    }
    /**
     <p>Runs method Compile in Cache.</p>
     <p>Description: Compile the routine associated with this object.</p>
     default argument qspec set to ""
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #Compile(java.lang.String)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#Compile"> Method Compile</A>
    */
    public void Compile () throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("Compile",args,com.intersys.objects.Database.RET_PRIM);
        getDatabase().parseStatus(res);
        return;
    }
    /**
     <p>Runs method Compile in Cache.</p>
     <p>Description: Compile the routine associated with this object.</p>
     @param qspec represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#Compile"> Method Compile</A>
    */
    public void Compile (java.lang.String qspec) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(qspec);
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("Compile",args,com.intersys.objects.Database.RET_PRIM);
        getDatabase().parseStatus(res);
        return;
    }
    /**
     <p>Runs method CompileClass in Cache.</p>
     <p>Description: For internal use only</p>
     @param db represented as com.intersys.objects.Database
     @param _class represented as java.lang.String
     @param qspec represented as java.lang.String
     @param Reload represented as com.intersys.objects.BooleanHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#CompileClass"> Method CompileClass</A>
    */
    public static void CompileClass (com.intersys.objects.Database db, java.lang.String _class, java.lang.String qspec, com.intersys.objects.BooleanHolder Reload) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        int[] _refs = new int[1];
        args[0] = new com.intersys.cache.Dataholder(_class);
        args[1] = new com.intersys.cache.Dataholder(qspec);
        args[2] = com.intersys.cache.Dataholder.create (Reload.value);
        _refs[0] = 3;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"CompileClass",_refs,args,com.intersys.objects.Database.RET_PRIM);
        Reload.set(res[1].getBoolean());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method ConstructCSPSession in Cache.</p>
     <p>Description: Internal method to construct a CSP session with current security permissions and return the session id</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#ConstructCSPSession"> Method ConstructCSPSession</A>
    */
    public static java.lang.String ConstructCSPSession (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ConstructCSPSession",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ConstructEditError in Cache.</p>
     <p>Description: Internal method to construct the correct error code if the item is not editable because
of source control hooks</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @param isinsourcecontrol represented as java.lang.Boolean
     @param ischeckedout represented as java.lang.Boolean
     @param user represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#ConstructEditError"> Method ConstructEditError</A>
    */
    public static void ConstructEditError (com.intersys.objects.Database db, java.lang.String name, java.lang.Boolean isinsourcecontrol, java.lang.Boolean ischeckedout, java.lang.String user) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(name);
        args[1] = new com.intersys.cache.Dataholder(isinsourcecontrol);
        args[2] = new com.intersys.cache.Dataholder(ischeckedout);
        args[3] = new com.intersys.cache.Dataholder(user);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ConstructEditError",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method ConvertVersion in Cache.</p>
     <p>Description: Internal function to return absolute version number</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @param type represented as java.lang.String
     @param version represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#ConvertVersion"> Method ConvertVersion</A>
    */
    public static java.lang.String ConvertVersion (com.intersys.objects.Database db, java.lang.String name, java.lang.String type, java.lang.String version) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(name);
        args[1] = new com.intersys.cache.Dataholder(type);
        args[2] = new com.intersys.cache.Dataholder(version);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ConvertVersion",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method CreateCSPDirectory in Cache.</p>
     <p>Description: Given a CSP path create the associated directory.</p>
     @param db represented as com.intersys.objects.Database
     @param directory represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#CreateCSPDirectory"> Method CreateCSPDirectory</A>
    */
    public static void CreateCSPDirectory (com.intersys.objects.Database db, java.lang.String directory) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(directory);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"CreateCSPDirectory",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method Delete in Cache.</p>
     <p>Description: Delete the routine <var>name</var>.</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#Delete"> Method Delete</A>
    */
    public static void Delete (com.intersys.objects.Database db, java.lang.String name) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(name);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Delete",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method DeletePackage in Cache.</p>
     <p>Description: Used to delete the files associated with a directory from the open dialog</p>
     @param db represented as com.intersys.objects.Database
     @param _package represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#DeletePackage"> Method DeletePackage</A>
    */
    public static void DeletePackage (com.intersys.objects.Database db, java.lang.String _package) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_package);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"DeletePackage",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method DocumentTypesClose in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#DocumentTypesClose"> Method DocumentTypesClose</A>
    */
    public static void DocumentTypesClose (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        int[] _refs = new int[1];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"DocumentTypesClose",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method DocumentTypesExecute in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#DocumentTypesExecute"> Method DocumentTypesExecute</A>
    */
    public static void DocumentTypesExecute (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        int[] _refs = new int[1];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"DocumentTypesExecute",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method DocumentTypesFetch in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @param Row represented as com.intersys.objects.SysListHolder
     default argument AtEnd set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #DocumentTypesFetch(com.intersys.objects.Database,com.intersys.objects.ByteArrayHolder,com.intersys.objects.SysListHolder,com.intersys.objects.IntegerHolder)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#DocumentTypesFetch"> Method DocumentTypesFetch</A>
    */
    public static void DocumentTypesFetch (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle, com.intersys.objects.SysListHolder Row) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        int[] _refs = new int[2];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        args[1] = com.intersys.cache.Dataholder.create (Row.value);
        _refs[1] = 2;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"DocumentTypesFetch",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        Row.set(res[2].getSList());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method DocumentTypesFetch in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @param Row represented as com.intersys.objects.SysListHolder
     @param AtEnd represented as com.intersys.objects.IntegerHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#DocumentTypesFetch"> Method DocumentTypesFetch</A>
    */
    public static void DocumentTypesFetch (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle, com.intersys.objects.SysListHolder Row, com.intersys.objects.IntegerHolder AtEnd) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        int[] _refs = new int[3];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        args[1] = com.intersys.cache.Dataholder.create (Row.value);
        _refs[1] = 2;
        args[2] = com.intersys.cache.Dataholder.create (AtEnd.value);
        _refs[2] = 3;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"DocumentTypesFetch",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        Row.set(res[2].getSList());
        AtEnd.set(res[3].getInteger());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method Exists in Cache.</p>
     <p>Description: Return true if the routine/csp/class/project/global/object code exists and false otherwise.</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#Exists"> Method Exists</A>
    */
    public static java.lang.Boolean Exists (com.intersys.objects.Database db, java.lang.String name) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(name);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"Exists",args,com.intersys.objects.Database.RET_PRIM);
        return res.getBoolean();
    }
    /**
     <p>Runs method FeatureBits in Cache.</p>
     <p>Description: Method implemented for Studio</p>
     @param db represented as com.intersys.objects.Database
     default argument bit set to ""
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #FeatureBits(com.intersys.objects.Database,java.lang.Integer)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#FeatureBits"> Method FeatureBits</A>
    */
    public static byte[] FeatureBits (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"FeatureBits",args,com.intersys.objects.Database.RET_PRIM);
        return res.getBytes();
    }
    /**
     <p>Runs method FeatureBits in Cache.</p>
     <p>Description: Method implemented for Studio</p>
     @param db represented as com.intersys.objects.Database
     @param bit represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#FeatureBits"> Method FeatureBits</A>
    */
    public static byte[] FeatureBits (com.intersys.objects.Database db, java.lang.Integer bit) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(bit);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"FeatureBits",args,com.intersys.objects.Database.RET_PRIM);
        return res.getBytes();
    }
    /**
     <p>Runs method GeneratedDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#GeneratedDisplayToLogical"> Method GeneratedDisplayToLogical</A>
    */
    public static java.lang.Boolean GeneratedDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GeneratedDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getBoolean();
    }
    /**
     <p>Runs method GeneratedIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     default argument _val set to ""
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #GeneratedIsValid(com.intersys.objects.Database,java.lang.String)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#GeneratedIsValid"> Method GeneratedIsValid</A>
    */
    public static void GeneratedIsValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GeneratedIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method GeneratedIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#GeneratedIsValid"> Method GeneratedIsValid</A>
    */
    public static void GeneratedIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GeneratedIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method GeneratedLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.Boolean
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#GeneratedLogicalToDisplay"> Method GeneratedLogicalToDisplay</A>
    */
    public static java.lang.String GeneratedLogicalToDisplay (com.intersys.objects.Database db, java.lang.Boolean _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GeneratedLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetCurrentTimeStamp in Cache.</p>
     <p>Description: Get the on-disk timestamp for the routine associated with this object.</p>
     @param compiletime represented as com.intersys.objects.TimestampHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#GetCurrentTimeStamp"> Method GetCurrentTimeStamp</A>
    */
    public java.sql.Timestamp GetCurrentTimeStamp (com.intersys.objects.TimestampHolder compiletime) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        int[] _refs = new int[1];
        args[0] = com.intersys.cache.Dataholder.create (compiletime.value);
        _refs[0] = 1;
        com.intersys.cache.Dataholder[] res=mInternal.runInstanceMethod("GetCurrentTimeStamp",_refs,args,com.intersys.objects.Database.RET_PRIM);
        compiletime.set(res[1].getTimestamp());
        return res[0].getTimestamp();
    }
    /**
     <p>Runs method GetDate in Cache.</p>
     <p>Description: Return the timestamp of this routine/csp/class/project/global/object code if it exists
or -1 if it does not exist</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#GetDate"> Method GetDate</A>
    */
    public static java.sql.Timestamp GetDate (com.intersys.objects.Database db, java.lang.String name) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(name);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetDate",args,com.intersys.objects.Database.RET_PRIM);
        return res.getTimestamp();
    }
    /**
     <p>Runs method GetOther in Cache.</p>
     <p>Description: For a given source item, this function returns the source item(s) generated
from it or from which it was generated (depending on the 'direction' flag).
<ul>
<li><b>name</b> - string containing name of source item. For example: "Test" or
"Sample.Person" There is NO ".MAC" etc in this name.</li>
<li><b>type</b> -  string containing type of source item: This can be one of:
"INT","MAC","BAS","MVB","MVI","CLS","CSP","CSR"</li>
<li><b>direction</b> - direction flag: +1 will go in the direction that files are
compiled in, for example MAC to INT or CLS to MAC, -1 will go in the opposite
direction, INT to MAC, MAC to CLS etc.</li>
</ul>
Returns comma-delimited list of source names (including type string appended to the
end) or "" if there is no corresponding other. Example:
<ul>
<li>("Test","INT",-1)  --> "Test.MAC"</li>
<li>("Test","MAC",1)  --> "Test.INT"</li>
<li>("Sample.Person","CLS",1)  -->  "Sample.Person.1.MAC,Sample.Person.2.MAC"</li>
<li>("/csp/samples/menu","CSP",1)  -->  "csp.menu.CLS"</li>
<li>("Sample.Person.1","MAC",-1)  -->  "Sample.Person.CLS"</li>
</ul><p>
Note that for classes the routines shown do not include the method generator routines.<p>
The <var>label</var> is of the form 'label+offset', if included then this will return the
routine name followed by a ':' and then the offset corresponding to this position</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @param type represented as java.lang.String
     @param direction represented as java.lang.Integer
     @param label represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#GetOther"> Method GetOther</A>
    */
    public static java.lang.String GetOther (com.intersys.objects.Database db, java.lang.String name, java.lang.String type, java.lang.Integer direction, java.lang.String label) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(name);
        args[1] = new com.intersys.cache.Dataholder(type);
        args[2] = new com.intersys.cache.Dataholder(direction);
        args[3] = new com.intersys.cache.Dataholder(label);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"GetOther",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method GetWebServerPort in Cache.</p>
     <p>Description: Return the port the Cache web server is running on or 0 if the
web server is not active. Also returns the server name which is useful if the web server
is running on a different machine (needed for VMS configurations for example). It can also
return a <var>urlprefix</var> which is added to the url to goto at the start and is required
if one web server is serving multiple Cache installations to differential between these versions
which again is needed by VMS installs. It also returns <var>url</var> which is the constructed
url as a string, you just need to append the page you are going to request to this.</p>
     @param db represented as com.intersys.objects.Database
     @param port represented as com.intersys.objects.IntegerHolder
     @param server represented as com.intersys.objects.StringHolder
     @param urlprefix represented as com.intersys.objects.StringHolder
     @param url represented as com.intersys.objects.StringHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#GetWebServerPort"> Method GetWebServerPort</A>
    */
    public static void GetWebServerPort (com.intersys.objects.Database db, com.intersys.objects.IntegerHolder port, com.intersys.objects.StringHolder server, com.intersys.objects.StringHolder urlprefix, com.intersys.objects.StringHolder url) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        int[] _refs = new int[4];
        args[0] = com.intersys.cache.Dataholder.create (port.value);
        _refs[0] = 1;
        args[1] = com.intersys.cache.Dataholder.create (server.value);
        _refs[1] = 2;
        args[2] = com.intersys.cache.Dataholder.create (urlprefix.value);
        _refs[2] = 3;
        args[3] = com.intersys.cache.Dataholder.create (url.value);
        _refs[3] = 4;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"GetWebServerPort",_refs,args,com.intersys.objects.Database.RET_PRIM);
        port.set(res[1].getInteger());
        server.set(res[2].getString());
        urlprefix.set(res[3].getString());
        url.set(res[4].getString());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method ImportItemListClose in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as byte[]
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#ImportItemListClose"> Method ImportItemListClose</A>
    */
    public static void ImportItemListClose (com.intersys.objects.Database db, byte[] QHandle) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(QHandle);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ImportItemListClose",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method ImportItemListExecute in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @param filename represented as java.lang.String
     @param charset represented as java.lang.String
     @param description represented as com.intersys.objects.StringHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#ImportItemListExecute"> Method ImportItemListExecute</A>
    */
    public static void ImportItemListExecute (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle, java.lang.String filename, java.lang.String charset, com.intersys.objects.StringHolder description) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        int[] _refs = new int[2];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        args[1] = new com.intersys.cache.Dataholder(filename);
        args[2] = new com.intersys.cache.Dataholder(charset);
        args[3] = com.intersys.cache.Dataholder.create (description.value);
        _refs[1] = 4;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"ImportItemListExecute",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        description.set(res[2].getString());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method ImportItemListFetch in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @param Row represented as com.intersys.objects.SysListHolder
     @param AtEnd represented as com.intersys.objects.IntegerHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#ImportItemListFetch"> Method ImportItemListFetch</A>
    */
    public static void ImportItemListFetch (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle, com.intersys.objects.SysListHolder Row, com.intersys.objects.IntegerHolder AtEnd) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        int[] _refs = new int[3];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        args[1] = com.intersys.cache.Dataholder.create (Row.value);
        _refs[1] = 2;
        args[2] = com.intersys.cache.Dataholder.create (AtEnd.value);
        _refs[2] = 3;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"ImportItemListFetch",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        Row.set(res[2].getSList());
        AtEnd.set(res[3].getInteger());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method ImportItemListFetchRows in Cache.</p>
     <p>Description: Returns the next <var>FetchCount</var> rows in the query.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @param FetchCount represented as java.lang.Integer
     @param RowSet represented as com.intersys.objects.SysListHolder
     @param ReturnCount represented as com.intersys.objects.IntegerHolder
     @param AtEnd represented as com.intersys.objects.IntegerHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#ImportItemListFetchRows"> Method ImportItemListFetchRows</A>
    */
    public static void ImportItemListFetchRows (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle, java.lang.Integer FetchCount, com.intersys.objects.SysListHolder RowSet, com.intersys.objects.IntegerHolder ReturnCount, com.intersys.objects.IntegerHolder AtEnd) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[5];
        int[] _refs = new int[4];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        args[1] = new com.intersys.cache.Dataholder(FetchCount);
        args[2] = com.intersys.cache.Dataholder.create (RowSet.value);
        _refs[1] = 3;
        args[3] = com.intersys.cache.Dataholder.create (ReturnCount.value);
        _refs[2] = 4;
        args[4] = com.intersys.cache.Dataholder.create (AtEnd.value);
        _refs[3] = 5;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"ImportItemListFetchRows",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        RowSet.set(res[2].getSList());
        ReturnCount.set(res[3].getInteger());
        AtEnd.set(res[4].getInteger());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method IsCSPDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#IsCSPDisplayToLogical"> Method IsCSPDisplayToLogical</A>
    */
    public static java.lang.Boolean IsCSPDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"IsCSPDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getBoolean();
    }
    /**
     <p>Runs method IsCSPIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     default argument _val set to ""
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #IsCSPIsValid(com.intersys.objects.Database,java.lang.String)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#IsCSPIsValid"> Method IsCSPIsValid</A>
    */
    public static void IsCSPIsValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"IsCSPIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method IsCSPIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#IsCSPIsValid"> Method IsCSPIsValid</A>
    */
    public static void IsCSPIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"IsCSPIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method IsCSPLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.Boolean
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#IsCSPLogicalToDisplay"> Method IsCSPLogicalToDisplay</A>
    */
    public static java.lang.String IsCSPLogicalToDisplay (com.intersys.objects.Database db, java.lang.Boolean _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"IsCSPLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method IsCSPName in Cache.</p>
     <p>Description: Return true if this is item is a file under a CSP application</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#IsCSPName"> Method IsCSPName</A>
    */
    public static java.lang.Boolean IsCSPName (com.intersys.objects.Database db, java.lang.String name) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(name);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"IsCSPName",args,com.intersys.objects.Database.RET_PRIM);
        return res.getBoolean();
    }
    /**
     <p>Runs method IsClassGenerated in Cache.</p>
     <p>Description: Return true if this classname is a generated class, and false otherwise</p>
     @param db represented as com.intersys.objects.Database
     @param classname represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#IsClassGenerated"> Method IsClassGenerated</A>
    */
    public static java.lang.Boolean IsClassGenerated (com.intersys.objects.Database db, java.lang.String classname) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(classname);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"IsClassGenerated",args,com.intersys.objects.Database.RET_PRIM);
        return res.getBoolean();
    }
    /**
     <p>Runs method IsGenerated in Cache.</p>
     <p>Description: Return true if this document is generated and false otherwise</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#IsGenerated"> Method IsGenerated</A>
    */
    public static java.lang.Boolean IsGenerated (com.intersys.objects.Database db, java.lang.String name) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(name);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"IsGenerated",args,com.intersys.objects.Database.RET_PRIM);
        return res.getBoolean();
    }
    /**
     <p>Runs method IsMapped in Cache.</p>
     <p>Description: Return true if this item is mapped from a database other than the default routine database.
Also return the source database in <var>sourcedb</var>.</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @param sourcedb represented as com.intersys.objects.StringHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#IsMapped"> Method IsMapped</A>
    */
    public static java.lang.Boolean IsMapped (com.intersys.objects.Database db, java.lang.String name, com.intersys.objects.StringHolder sourcedb) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        int[] _refs = new int[1];
        args[0] = new com.intersys.cache.Dataholder(name);
        args[1] = com.intersys.cache.Dataholder.create (sourcedb.value);
        _refs[0] = 2;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"IsMapped",_refs,args,com.intersys.objects.Database.RET_PRIM);
        sourcedb.set(res[1].getString());
        return res[0].getBoolean();
    }
    /**
     <p>Runs method IsServerOnly in Cache.</p>
     <p>Description: Returns true if this item is server only</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#IsServerOnly"> Method IsServerOnly</A>
    */
    public static java.lang.Boolean IsServerOnly (com.intersys.objects.Database db, java.lang.String name) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(name);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"IsServerOnly",args,com.intersys.objects.Database.RET_PRIM);
        return res.getBoolean();
    }
    /**
     <p>Runs method KillProcess in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param pid represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#KillProcess"> Method KillProcess</A>
    */
    public static void KillProcess (com.intersys.objects.Database db, java.lang.String pid) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(pid);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"KillProcess",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method LanguageModeGet in Cache.</p>
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#LanguageModeGet"> Method LanguageModeGet</A>
    */
    public java.lang.Integer LanguageModeGet () throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("LanguageModeGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getInteger();
    }
    /**
     <p>Runs method LanguageModeSet in Cache.</p>
     @param languagemode represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#LanguageModeSet"> Method LanguageModeSet</A>
    */
    public void LanguageModeSet (java.lang.Integer languagemode) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(languagemode);
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("LanguageModeSet",args,com.intersys.objects.Database.RET_PRIM);
        getDatabase().parseStatus(res);
        return;
    }
    /**
     <p>Runs method Lock in Cache.</p>
     <p>Description: Lock this routine, return true if it worked and false if it did not.</p>
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#Lock"> Method Lock</A>
    */
    public void Lock () throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("Lock",args,com.intersys.objects.Database.RET_PRIM);
        getDatabase().parseStatus(res);
        return;
    }
    /**
     <p>Runs method LockItem in Cache.</p>
     <p>Description: Get or release a lock on a document.
 If <parameter>lock</parameter> is true (the default) then it will be locked else it will be unlocked.</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     default argument lock set to 1
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #LockItem(com.intersys.objects.Database,java.lang.String,java.lang.Boolean)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#LockItem"> Method LockItem</A>
    */
    public static void LockItem (com.intersys.objects.Database db, java.lang.String name) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(name);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"LockItem",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method LockItem in Cache.</p>
     <p>Description: Get or release a lock on a document.
 If <parameter>lock</parameter> is true (the default) then it will be locked else it will be unlocked.</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @param lock represented as java.lang.Boolean
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#LockItem"> Method LockItem</A>
    */
    public static void LockItem (com.intersys.objects.Database db, java.lang.String name, java.lang.Boolean lock) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(name);
        args[1] = new com.intersys.cache.Dataholder(lock);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"LockItem",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method NameDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#NameDisplayToLogical"> Method NameDisplayToLogical</A>
    */
    public static java.lang.String NameDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"NameDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method NameGet in Cache.</p>
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#NameGet"> Method NameGet</A>
    */
    public java.lang.String NameGet () throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("NameGet",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method NameIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#NameIsValid"> Method NameIsValid</A>
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
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#NameLogicalToDisplay"> Method NameLogicalToDisplay</A>
    */
    public static java.lang.String NameLogicalToDisplay (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"NameLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method NameSet in Cache.</p>
     @param name represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#NameSet"> Method NameSet</A>
    */
    public void NameSet (java.lang.String name) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(name);
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("NameSet",args,com.intersys.objects.Database.RET_PRIM);
        getDatabase().parseStatus(res);
        return;
    }
    /**
     <p>Runs method NamespaceDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#NamespaceDisplayToLogical"> Method NamespaceDisplayToLogical</A>
    */
    public static java.lang.String NamespaceDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"NamespaceDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method NamespaceIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#NamespaceIsValid"> Method NamespaceIsValid</A>
    */
    public static void NamespaceIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"NamespaceIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method NamespaceListClose in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as byte[]
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#NamespaceListClose"> Method NamespaceListClose</A>
    */
    public static void NamespaceListClose (com.intersys.objects.Database db, byte[] QHandle) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(QHandle);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"NamespaceListClose",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method NamespaceListExecute in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#NamespaceListExecute"> Method NamespaceListExecute</A>
    */
    public static void NamespaceListExecute (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        int[] _refs = new int[1];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"NamespaceListExecute",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method NamespaceListFetch in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @param Row represented as com.intersys.objects.SysListHolder
     default argument AtEnd set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #NamespaceListFetch(com.intersys.objects.Database,com.intersys.objects.ByteArrayHolder,com.intersys.objects.SysListHolder,com.intersys.objects.IntegerHolder)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#NamespaceListFetch"> Method NamespaceListFetch</A>
    */
    public static void NamespaceListFetch (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle, com.intersys.objects.SysListHolder Row) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        int[] _refs = new int[2];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        args[1] = com.intersys.cache.Dataholder.create (Row.value);
        _refs[1] = 2;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"NamespaceListFetch",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        Row.set(res[2].getSList());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method NamespaceListFetch in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @param Row represented as com.intersys.objects.SysListHolder
     @param AtEnd represented as com.intersys.objects.IntegerHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#NamespaceListFetch"> Method NamespaceListFetch</A>
    */
    public static void NamespaceListFetch (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle, com.intersys.objects.SysListHolder Row, com.intersys.objects.IntegerHolder AtEnd) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        int[] _refs = new int[3];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        args[1] = com.intersys.cache.Dataholder.create (Row.value);
        _refs[1] = 2;
        args[2] = com.intersys.cache.Dataholder.create (AtEnd.value);
        _refs[2] = 3;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"NamespaceListFetch",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        Row.set(res[2].getSList());
        AtEnd.set(res[3].getInteger());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method NamespaceLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#NamespaceLogicalToDisplay"> Method NamespaceLogicalToDisplay</A>
    */
    public static java.lang.String NamespaceLogicalToDisplay (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"NamespaceLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method NormalizeName in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#NormalizeName"> Method NormalizeName</A>
    */
    public static java.lang.String NormalizeName (com.intersys.objects.Database db, java.lang.String name) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(name);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"NormalizeName",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method OnPageCode in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param language represented as java.lang.String
     default argument xml set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #OnPageCode(com.intersys.objects.Database,java.lang.String,java.lang.Boolean)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#OnPageCode"> Method OnPageCode</A>
    */
    public static java.lang.String OnPageCode (com.intersys.objects.Database db, java.lang.String language) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(language);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OnPageCode",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method OnPageCode in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param language represented as java.lang.String
     @param xml represented as java.lang.Boolean
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#OnPageCode"> Method OnPageCode</A>
    */
    public static java.lang.String OnPageCode (com.intersys.objects.Database db, java.lang.String language, java.lang.Boolean xml) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(language);
        args[1] = new com.intersys.cache.Dataholder(xml);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"OnPageCode",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ProtectedDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#ProtectedDisplayToLogical"> Method ProtectedDisplayToLogical</A>
    */
    public static java.lang.Boolean ProtectedDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProtectedDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getBoolean();
    }
    /**
     <p>Runs method ProtectedIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     default argument _val set to ""
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #ProtectedIsValid(com.intersys.objects.Database,java.lang.String)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#ProtectedIsValid"> Method ProtectedIsValid</A>
    */
    public static void ProtectedIsValid (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProtectedIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method ProtectedIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#ProtectedIsValid"> Method ProtectedIsValid</A>
    */
    public static void ProtectedIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProtectedIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method ProtectedLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.Boolean
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#ProtectedLogicalToDisplay"> Method ProtectedLogicalToDisplay</A>
    */
    public static java.lang.String ProtectedLogicalToDisplay (com.intersys.objects.Database db, java.lang.Boolean _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ProtectedLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method ReturnCSPSessionId in Cache.</p>
     <p>Description: Deprecated internal method to return the CSP session id of the session constructed with <method>ConstructCSPSession</method>.
This is no longer needed as <method>ConstructCSPSession</method> returns the CSP sessionId directly now.</p>
     @param db represented as com.intersys.objects.Database
     @param id represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#ReturnCSPSessionId"> Method ReturnCSPSessionId</A>
    */
    public static java.lang.String ReturnCSPSessionId (com.intersys.objects.Database db, java.lang.String id) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(id);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"ReturnCSPSessionId",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method StudioOpenDialogClose in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as byte[]
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#StudioOpenDialogClose"> Method StudioOpenDialogClose</A>
    */
    public static void StudioOpenDialogClose (com.intersys.objects.Database db, byte[] QHandle) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(QHandle);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"StudioOpenDialogClose",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method StudioOpenDialogExecute in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @param Spec represented as java.lang.String
     @param Dir represented as java.lang.Integer
     @param OrderBy represented as java.lang.Integer
     @param SystemFiles represented as java.lang.Boolean
     @param Flat represented as java.lang.Boolean
     @param NotStudio represented as java.lang.Boolean
     @param ShowGenerated represented as java.lang.Boolean
     @param Filter represented as java.lang.String
     default argument RoundTime set to 0
     default argument Mapped set to 1
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #StudioOpenDialogExecute(com.intersys.objects.Database,com.intersys.objects.ByteArrayHolder,java.lang.String,java.lang.Integer,java.lang.Integer,java.lang.Boolean,java.lang.Boolean,java.lang.Boolean,java.lang.Boolean,java.lang.String,java.lang.Boolean,java.lang.Boolean)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#StudioOpenDialogExecute"> Method StudioOpenDialogExecute</A>
    */
    public static void StudioOpenDialogExecute (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle, java.lang.String Spec, java.lang.Integer Dir, java.lang.Integer OrderBy, java.lang.Boolean SystemFiles, java.lang.Boolean Flat, java.lang.Boolean NotStudio, java.lang.Boolean ShowGenerated, java.lang.String Filter) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[9];
        int[] _refs = new int[1];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        args[1] = new com.intersys.cache.Dataholder(Spec);
        args[2] = new com.intersys.cache.Dataholder(Dir);
        args[3] = new com.intersys.cache.Dataholder(OrderBy);
        args[4] = new com.intersys.cache.Dataholder(SystemFiles);
        args[5] = new com.intersys.cache.Dataholder(Flat);
        args[6] = new com.intersys.cache.Dataholder(NotStudio);
        args[7] = new com.intersys.cache.Dataholder(ShowGenerated);
        args[8] = new com.intersys.cache.Dataholder(Filter);
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"StudioOpenDialogExecute",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method StudioOpenDialogExecute in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @param Spec represented as java.lang.String
     @param Dir represented as java.lang.Integer
     @param OrderBy represented as java.lang.Integer
     @param SystemFiles represented as java.lang.Boolean
     @param Flat represented as java.lang.Boolean
     @param NotStudio represented as java.lang.Boolean
     @param ShowGenerated represented as java.lang.Boolean
     @param Filter represented as java.lang.String
     @param RoundTime represented as java.lang.Boolean
     default argument Mapped set to 1
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #StudioOpenDialogExecute(com.intersys.objects.Database,com.intersys.objects.ByteArrayHolder,java.lang.String,java.lang.Integer,java.lang.Integer,java.lang.Boolean,java.lang.Boolean,java.lang.Boolean,java.lang.Boolean,java.lang.String,java.lang.Boolean,java.lang.Boolean)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#StudioOpenDialogExecute"> Method StudioOpenDialogExecute</A>
    */
    public static void StudioOpenDialogExecute (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle, java.lang.String Spec, java.lang.Integer Dir, java.lang.Integer OrderBy, java.lang.Boolean SystemFiles, java.lang.Boolean Flat, java.lang.Boolean NotStudio, java.lang.Boolean ShowGenerated, java.lang.String Filter, java.lang.Boolean RoundTime) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[10];
        int[] _refs = new int[1];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        args[1] = new com.intersys.cache.Dataholder(Spec);
        args[2] = new com.intersys.cache.Dataholder(Dir);
        args[3] = new com.intersys.cache.Dataholder(OrderBy);
        args[4] = new com.intersys.cache.Dataholder(SystemFiles);
        args[5] = new com.intersys.cache.Dataholder(Flat);
        args[6] = new com.intersys.cache.Dataholder(NotStudio);
        args[7] = new com.intersys.cache.Dataholder(ShowGenerated);
        args[8] = new com.intersys.cache.Dataholder(Filter);
        args[9] = new com.intersys.cache.Dataholder(RoundTime);
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"StudioOpenDialogExecute",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method StudioOpenDialogExecute in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @param Spec represented as java.lang.String
     @param Dir represented as java.lang.Integer
     @param OrderBy represented as java.lang.Integer
     @param SystemFiles represented as java.lang.Boolean
     @param Flat represented as java.lang.Boolean
     @param NotStudio represented as java.lang.Boolean
     @param ShowGenerated represented as java.lang.Boolean
     @param Filter represented as java.lang.String
     @param RoundTime represented as java.lang.Boolean
     @param Mapped represented as java.lang.Boolean
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#StudioOpenDialogExecute"> Method StudioOpenDialogExecute</A>
    */
    public static void StudioOpenDialogExecute (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle, java.lang.String Spec, java.lang.Integer Dir, java.lang.Integer OrderBy, java.lang.Boolean SystemFiles, java.lang.Boolean Flat, java.lang.Boolean NotStudio, java.lang.Boolean ShowGenerated, java.lang.String Filter, java.lang.Boolean RoundTime, java.lang.Boolean Mapped) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[11];
        int[] _refs = new int[1];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        args[1] = new com.intersys.cache.Dataholder(Spec);
        args[2] = new com.intersys.cache.Dataholder(Dir);
        args[3] = new com.intersys.cache.Dataholder(OrderBy);
        args[4] = new com.intersys.cache.Dataholder(SystemFiles);
        args[5] = new com.intersys.cache.Dataholder(Flat);
        args[6] = new com.intersys.cache.Dataholder(NotStudio);
        args[7] = new com.intersys.cache.Dataholder(ShowGenerated);
        args[8] = new com.intersys.cache.Dataholder(Filter);
        args[9] = new com.intersys.cache.Dataholder(RoundTime);
        args[10] = new com.intersys.cache.Dataholder(Mapped);
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"StudioOpenDialogExecute",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method StudioOpenDialogFetch in Cache.</p>
     <p>Description: <b>Fetch</b> returns the next row in the query.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @param Row represented as com.intersys.objects.SysListHolder
     default argument AtEnd set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #StudioOpenDialogFetch(com.intersys.objects.Database,com.intersys.objects.ByteArrayHolder,com.intersys.objects.SysListHolder,com.intersys.objects.IntegerHolder)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#StudioOpenDialogFetch"> Method StudioOpenDialogFetch</A>
    */
    public static void StudioOpenDialogFetch (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle, com.intersys.objects.SysListHolder Row) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        int[] _refs = new int[2];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        args[1] = com.intersys.cache.Dataholder.create (Row.value);
        _refs[1] = 2;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"StudioOpenDialogFetch",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        Row.set(res[2].getSList());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method StudioOpenDialogFetch in Cache.</p>
     <p>Description: <b>Fetch</b> returns the next row in the query.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @param Row represented as com.intersys.objects.SysListHolder
     @param AtEnd represented as com.intersys.objects.IntegerHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#StudioOpenDialogFetch"> Method StudioOpenDialogFetch</A>
    */
    public static void StudioOpenDialogFetch (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle, com.intersys.objects.SysListHolder Row, com.intersys.objects.IntegerHolder AtEnd) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        int[] _refs = new int[3];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        args[1] = com.intersys.cache.Dataholder.create (Row.value);
        _refs[1] = 2;
        args[2] = com.intersys.cache.Dataholder.create (AtEnd.value);
        _refs[2] = 3;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"StudioOpenDialogFetch",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        Row.set(res[2].getSList());
        AtEnd.set(res[3].getInteger());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method StudioOpenDialogFetchRows in Cache.</p>
     <p>Description: <b>StudioOpenDialogFetchRows</b> returns the next <var>FetchCount</var> rows in the query.</p>
     @param db represented as com.intersys.objects.Database
     @param QHandle represented as com.intersys.objects.ByteArrayHolder
     @param FetchCount represented as java.lang.Integer
     @param RowSet represented as com.intersys.objects.SysListHolder
     @param ReturnCount represented as com.intersys.objects.IntegerHolder
     @param AtEnd represented as com.intersys.objects.IntegerHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#StudioOpenDialogFetchRows"> Method StudioOpenDialogFetchRows</A>
    */
    public static void StudioOpenDialogFetchRows (com.intersys.objects.Database db, com.intersys.objects.ByteArrayHolder QHandle, java.lang.Integer FetchCount, com.intersys.objects.SysListHolder RowSet, com.intersys.objects.IntegerHolder ReturnCount, com.intersys.objects.IntegerHolder AtEnd) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[5];
        int[] _refs = new int[4];
        args[0] = com.intersys.cache.Dataholder.create (QHandle.value);
        _refs[0] = 1;
        args[1] = new com.intersys.cache.Dataholder(FetchCount);
        args[2] = com.intersys.cache.Dataholder.create (RowSet.value);
        _refs[1] = 3;
        args[3] = com.intersys.cache.Dataholder.create (ReturnCount.value);
        _refs[2] = 4;
        args[4] = com.intersys.cache.Dataholder.create (AtEnd.value);
        _refs[3] = 5;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"StudioOpenDialogFetchRows",_refs,args,com.intersys.objects.Database.RET_PRIM);
        QHandle.set(res[1].getBytes());
        RowSet.set(res[2].getSList());
        ReturnCount.set(res[3].getInteger());
        AtEnd.set(res[4].getInteger());
        db.parseStatus(res[0]);
        return;
    }
    /**
     <p>Runs method TS in Cache.</p>
     <p>Description: Return the timestamp for this item.</p>
     @param db represented as com.intersys.objects.Database
     @param name represented as java.lang.String
     @param compiletime represented as com.intersys.objects.TimestampHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#TS"> Method TS</A>
    */
    public static java.sql.Timestamp TS (com.intersys.objects.Database db, java.lang.String name, com.intersys.objects.TimestampHolder compiletime) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        int[] _refs = new int[1];
        args[0] = new com.intersys.cache.Dataholder(name);
        args[1] = com.intersys.cache.Dataholder.create (compiletime.value);
        _refs[0] = 2;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"TS",_refs,args,com.intersys.objects.Database.RET_PRIM);
        compiletime.set(res[1].getTimestamp());
        return res[0].getTimestamp();
    }
    /**
     <p>Runs method TimeStampDisplayToLogical in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#TimeStampDisplayToLogical"> Method TimeStampDisplayToLogical</A>
    */
    public static java.sql.Timestamp TimeStampDisplayToLogical (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"TimeStampDisplayToLogical",args,com.intersys.objects.Database.RET_PRIM);
        return res.getTimestamp();
    }
    /**
     <p>Runs method TimeStampIsValid in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#TimeStampIsValid"> Method TimeStampIsValid</A>
    */
    public static void TimeStampIsValid (com.intersys.objects.Database db, java.lang.String _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"TimeStampIsValid",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method TimeStampLogicalToDisplay in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _val represented as java.sql.Timestamp
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#TimeStampLogicalToDisplay"> Method TimeStampLogicalToDisplay</A>
    */
    public static java.lang.String TimeStampLogicalToDisplay (com.intersys.objects.Database db, java.sql.Timestamp _val) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_val);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"TimeStampLogicalToDisplay",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method Unlock in Cache.</p>
     <p>Description: Unlock this routine, return a status code.</p>
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#Unlock"> Method Unlock</A>
    */
    public void Unlock () throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[0];
        com.intersys.cache.Dataholder res=mInternal.runInstanceMethod("Unlock",args,com.intersys.objects.Database.RET_PRIM);
        getDatabase().parseStatus(res);
        return;
    }
    /**
     <p>Runs method UpdateTemplates in Cache.</p>
     <p>Description: Used by Studio because it is hard to call %Studio.TemplateMgr directly</p>
     @param db represented as com.intersys.objects.Database
     @param qspec represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#UpdateTemplates"> Method UpdateTemplates</A>
    */
    public static void UpdateTemplates (com.intersys.objects.Database db, java.lang.String qspec) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(qspec);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"UpdateTemplates",args,com.intersys.objects.Database.RET_PRIM);
        db.parseStatus(res);
        return;
    }
    /**
     <p>Runs method UserType in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param Name represented as java.lang.String
     @param Class represented as com.intersys.objects.StringHolder
     @param StudioType represented as com.intersys.objects.StringHolder
     @param Schema represented as com.intersys.objects.StringHolder
     @param StudioIcon represented as com.intersys.objects.IntegerHolder
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#UserType"> Method UserType</A>
    */
    public static java.lang.Boolean UserType (com.intersys.objects.Database db, java.lang.String Name, com.intersys.objects.StringHolder Class, com.intersys.objects.StringHolder StudioType, com.intersys.objects.StringHolder Schema, com.intersys.objects.IntegerHolder StudioIcon) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[5];
        int[] _refs = new int[4];
        args[0] = new com.intersys.cache.Dataholder(Name);
        args[1] = com.intersys.cache.Dataholder.create (Class.value);
        _refs[0] = 2;
        args[2] = com.intersys.cache.Dataholder.create (StudioType.value);
        _refs[1] = 3;
        args[3] = com.intersys.cache.Dataholder.create (Schema.value);
        _refs[2] = 4;
        args[4] = com.intersys.cache.Dataholder.create (StudioIcon.value);
        _refs[3] = 5;
        com.intersys.cache.Dataholder[] res=db.runClassMethod(CACHE_CLASS_NAME,"UserType",_refs,args,com.intersys.objects.Database.RET_PRIM);
        Class.set(res[1].getString());
        StudioType.set(res[2].getString());
        Schema.set(res[3].getString());
        StudioIcon.set(res[4].getInteger());
        return res[0].getBoolean();
    }
    /**
     <p>Runs method getPackageList in Cache.</p>
     <p>Description: Fill up the list of packages for this directory.</p>
     @param db represented as com.intersys.objects.Database
     @param idx represented as java.lang.Integer
     @param directory represented as java.lang.String
     @param SystemFiles represented as java.lang.Boolean
     default argument namespace set to $namespace
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #getPackageList(com.intersys.objects.Database,java.lang.Integer,java.lang.String,java.lang.Boolean,java.lang.String)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#getPackageList"> Method getPackageList</A>
    */
    public static void getPackageList (com.intersys.objects.Database db, java.lang.Integer idx, java.lang.String directory, java.lang.Boolean SystemFiles) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[3];
        args[0] = new com.intersys.cache.Dataholder(idx);
        args[1] = new com.intersys.cache.Dataholder(directory);
        args[2] = new com.intersys.cache.Dataholder(SystemFiles);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"getPackageList",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method getPackageList in Cache.</p>
     <p>Description: Fill up the list of packages for this directory.</p>
     @param db represented as com.intersys.objects.Database
     @param idx represented as java.lang.Integer
     @param directory represented as java.lang.String
     @param SystemFiles represented as java.lang.Boolean
     @param namespace represented as java.lang.String
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#getPackageList"> Method getPackageList</A>
    */
    public static void getPackageList (com.intersys.objects.Database db, java.lang.Integer idx, java.lang.String directory, java.lang.Boolean SystemFiles, java.lang.String namespace) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[4];
        args[0] = new com.intersys.cache.Dataholder(idx);
        args[1] = new com.intersys.cache.Dataholder(directory);
        args[2] = new com.intersys.cache.Dataholder(SystemFiles);
        args[3] = new com.intersys.cache.Dataholder(namespace);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"getPackageList",args,com.intersys.objects.Database.RET_NONE);
        return;
    }
    /**
     <p>Runs method getRoutinesFromClass in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _class represented as java.lang.String
     default argument type set to 0
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see #getRoutinesFromClass(com.intersys.objects.Database,java.lang.String,java.lang.Integer)
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#getRoutinesFromClass"> Method getRoutinesFromClass</A>
    */
    public static java.lang.String getRoutinesFromClass (com.intersys.objects.Database db, java.lang.String _class) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[1];
        args[0] = new com.intersys.cache.Dataholder(_class);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"getRoutinesFromClass",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Runs method getRoutinesFromClass in Cache.</p>
     @param db represented as com.intersys.objects.Database
     @param _class represented as java.lang.String
     @param type represented as java.lang.Integer
     @throws com.intersys.objects.CacheException if any error occured while running the method.
     @see <a href = "http://daimor-pc:57772/csp/documatic/%25CSP.Documatic.cls?APP=1&PAGE=CLASS&LIBRARY=USER&CLASSNAME=%25Library.RoutineMgr#getRoutinesFromClass"> Method getRoutinesFromClass</A>
    */
    public static java.lang.String getRoutinesFromClass (com.intersys.objects.Database db, java.lang.String _class, java.lang.Integer type) throws com.intersys.objects.CacheException {
        com.intersys.cache.Dataholder[] args = new com.intersys.cache.Dataholder[2];
        args[0] = new com.intersys.cache.Dataholder(_class);
        args[1] = new com.intersys.cache.Dataholder(type);
        com.intersys.cache.Dataholder res=db.runClassMethod(CACHE_CLASS_NAME,"getRoutinesFromClass",args,com.intersys.objects.Database.RET_PRIM);
        return res.getString();
    }
    /**
     <p>Returns a CallableStatement for query DocumentTypes.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
    */
    public static com.intersys.objects.CacheQuery query_DocumentTypes (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        return new com.intersys.objects.CacheQuery(db, "%Library.RoutineMgr_DocumentTypes", 0, 0);
    }

    /**
     <p>Returns a CallableStatement for query ImportItemList.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
    */
    public static com.intersys.objects.CacheQuery query_ImportItemList (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        return new com.intersys.objects.CacheQuery(db, "%Library.RoutineMgr_ImportItemList", 2, 1);
    }

    /**
     <p>Returns a CallableStatement for query NamespaceList.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
    */
    public static com.intersys.objects.CacheQuery query_NamespaceList (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        return new com.intersys.objects.CacheQuery(db, "%Library.RoutineMgr_NamespaceList", 0, 0);
    }

    /**
     <p>Returns a CallableStatement for query StudioOpenDialog.</p>
     @param db represented as com.intersys.objects.Database
     @throws com.intersys.objects.CacheException if any error occured while running the method.
    */
    public static com.intersys.objects.CacheQuery query_StudioOpenDialog (com.intersys.objects.Database db) throws com.intersys.objects.CacheException {
        return new com.intersys.objects.CacheQuery(db, "%Library.RoutineMgr_StudioOpenDialog", 10, 1);
    }

}
