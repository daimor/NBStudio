lexer grammar clsLexer;

@header{
    package org.nbstudio.syntax.cls; 
    import java.util.HashMap;
    import java.util.Map;
}
tokens {
    Class, ClassMethod, Method, Property, Index, ForeignKey, Query, Parameter, XData, Trigger, Relationship
}


@lexer::members {
Map<String,Integer> keywords = new HashMap<String,Integer>(){{
    put("class", Class);
    put("classmethod", ClassMethod);
    put("method", Method);
    put("property", Property);
    put("index", Index);
    put("foreignkey", ForeignKey);
    put("query", Query);
    put("parameter", Parameter);
    put("xdata", XData);
    put("trigger", Trigger);
    put("relationship", Relationship);
}};

int lastKeyword = 0;
int prevToken = 0;
boolean isClassName = false;
boolean isPropertyName = false;
boolean isPropertiesList = false;

private boolean isExpr() {
    return ((prevToken==InitialExpression)||(prevToken==SqlComputeCode));
}

private boolean isMethod() {
    return ((lastKeyword==Method)||(lastKeyword==ClassMethod));
}
private boolean isClassName() {
    return ((prevToken==Class)||(prevToken==Extends)||(prevToken==As)||(prevToken==Of)||(prevToken==References)||isClassName);
}
private boolean isPropertyName() {
    return (
        (prevToken==Property)||
        (prevToken==Relationship)||
        (prevToken==On)||
        ((lastKeyword==Index)&&(prevToken==Data))||
        isPropertyName
        );
}
private boolean isMethodName() {
    return ((prevToken==Method)||(prevToken==ClassMethod));
}

private boolean isIncludeFile() {
    return ((prevToken==Include)||(prevToken==Import)||(prevToken==IncludeGenerator));
}

private void toggleList(){
   if(isClassName()){isClassName=!isClassName;}
   else if(isPropertyName()){isPropertyName=!isPropertyName;}
}

private void resetKeyword()
{
    lastKeyword = 0;
    isClassName = false;
    isPropertyName = false;
    //prevToken = 0;
}
public void emit(Token token) {
    super.emit(token);
    if((token.getType() != EQUAL)&&(token.getType() != LParen)) {
        prevToken = token.getType();
    }
}

boolean isKeyword(String str)
{
    boolean result = false;
    if(isPropertiesList) 
    {
         return false;
    }
    str = str.trim();
    if ( keywords.containsKey(str) )
    {
         setType(keywords.get(str));
         lastKeyword = keywords.get(str);
         result =  true;
    }
    return result;
}

                 
class lexerState extends Object 
{
    int charPositionInLine = -1;
    int line = -1;
    
    int lastKeyword = 0;
    int prevToken = 0;
    boolean isClassName = false;
    boolean isPropertyName = false;
    boolean isPropertiesList = false;
    
}
public lexerState getLexerState() 
{
    lexerState state = new lexerState();
    
    state.line = getLine();
    state.charPositionInLine = getCharPositionInLine();
    
    state.lastKeyword = lastKeyword;
    state.prevToken = prevToken;
    state.isClassName = isClassName;
    state.isPropertyName = isPropertyName;
    state.isPropertiesList = isPropertiesList;

    return state;
}

public void setLexerState(lexerState state) 
{ 
    if(state==null) return;
    setLine(state.line);
    setCharPositionInLine(state.charPositionInLine);
    
    lastKeyword = state.lastKeyword;
    prevToken = state.prevToken;
    isClassName = state.isClassName;
    isPropertyName = state.isPropertyName;
    isPropertiesList = state.isPropertiesList;
}

}

PropertyCollection: {(prevToken==As)}? ('array'|'list');
MethodLanguage: {(prevToken==Language)}? ('cache'|'basic'|'java'|'javascript'|'mvbasic'|'tsql');
MethodCodeMode: {(prevToken==CodeMode)}? ('call'|'code'|'expression'|'objectgenerator');

ClassName: {(isClassName())}? PERCENT? ID ( DOT ID )*;
MethodName  : {isMethodName()}? PERCENT? ID;
XDataName: {(prevToken==XData)}? PERCENT? ID;
QueryName: {(prevToken==Query)}? PERCENT? ID;
PropertyName: {(isPropertyName())}? PERCENT? ID (DOT ID)*;
ParameterName: {(prevToken==Parameter)}? PERCENT? ID;
ForeignKeyName: {(prevToken==ForeignKey)}? PERCENT? ID;
TriggerName: {(prevToken==Trigger)}? PERCENT? ID;
ProjectionName: {(prevToken==Projection)}? PERCENT? ID;
IndexName: {(prevToken==Index)}? PERCENT? ID;
IncludeFile: {isIncludeFile()}? PERCENT? ID;
SqlNameVal : {(prevToken==SqlName)}? ID? ( Underscore+ ID )+;
ClientNameVal : {(prevToken==ClientName)}? ID? ( Underscore+ ID )+;

ByRef:
      [Bb][Yy][Rr][Ee][Ff];

Output:
      [Oo][Uu][Tt][Pp][Uu][Tt];
Not: 
			[Nn][Oo][Tt];

Include: 
			[Ii][Nn][Cc][Ll][Uu][Dd][Ee];
Extends: 
			[Ee][Xx][Tt][Ee][Nn][Dd][Ss];
On:                     
      [Oo][Nn];
Projection: 
			[Pp][Rr][Oo][Jj][Ee][Cc][Tt][Ii][Oo][Nn];
As:
      [Aa][Ss];
Of:                     
      [Oo][Ff];
Abstract: 
			[Aa][Bb][Ss][Tt][Rr][Aa][Cc][Tt];
ClassType: 
			[Cc][Ll][Aa][Ss][Ss][Tt][Yy][Pp][Ee];
ClientDataType: 
			[Cc][Ll][Ii][Ee][Nn][Tt][Dd][Aa][Tt][Aa][Tt][Yy][Pp][Ee];
ClientName: 
			[Cc][Ll][Ii][Ee][Nn][Tt][Nn][Aa][Mm][Ee];
CompileAfter: 
			[Cc][Oo][Mm][Pp][Ii][Ll][Ee][Aa][Ff][Tt][Ee][Rr];
Cardinality:
      [Cc][Aa][Rr][Dd][Ii][Nn][Aa][Ll][Ii][Tt][Yy];
DdlAllowed: 
			[Dd][Dd][Ll][Aa][Ll][Ll][Oo][Ww][Ee][Dd];
DependsOn: 
			[Dd][Ee][Pp][Ee][Nn][Dd][Ss][Oo][Nn];
Final: 
			[Ff][Ii][Nn][Aa][Ll];
Hidden: 
			[Hh][Ii][Dd][Dd][Ee][Nn];
Import: 
			[Ii][Mm][Pp][Oo][Rr][Tt];
IncludeCode: 
			[Ii][Nn][Cc][Ll][Uu][Dd][Ee][Cc][Oo][Dd][Ee];
IncludeGenerator: 
			[Ii][Nn][Cc][Ll][Uu][Dd][Ee][Gg][Ee][Nn][Ee][Rr][Aa][Tt][Oo][Rr];
Language: 
			[Ll][Aa][Nn][Gg][Uu][Aa][Gg][Ee];
OdbcType: 
			[Oo][Dd][Bb][Cc][Tt][Yy][Pp][Ee];
Owner: 
			[Oo][Ww][Nn][Ee][Rr];
ProcedureBlock: 
			[Pp][Rr][Oo][Cc][Ee][Dd][Uu][Rr][Ee][Bb][Ll][Oo][Cc][Kk];
ServerOnly: 
			[Ss][Ee][Rr][Vv][Ee][Rr][Oo][Nn][Ll][Yy];
SoapBindingStyle: 
			[Ss][Oo][Aa][Pp][Bb][Ii][Nn][Dd][Ii][Nn][Gg][Ss][Tt][Yy][Ll][Ee];
SoapBodyUse: 
			[Ss][Oo][Aa][Pp][Bb][Oo][Dd][Yy][Uu][Ss][Ee];
SqlCategory: 
			[Ss][Qq][Ll][Cc][Aa][Tt][Ee][Gg][Oo][Rr][Yy];
SqlRowIdName: 
			[Ss][Qq][Ll][Rr][Oo][Ww][Ii][Dd][Nn][Aa][Mm][Ee];
SqlRowIdPrivate: 
			[Ss][Qq][Ll][Rr][Oo][Ww][Ii][Dd][Pp][Rr][Ii][Vv][Aa][Tt][Ee];
SqlTableName: 
			[Ss][Qq][Ll][Tt][Aa][Bb][Ll][Ee][Nn][Aa][Mm][Ee];
StorageStrategy: 
			[Ss][Tt][Oo][Rr][Aa][Gg][Ee][Ss][Tt][Rr][Aa][Tt][Ee][Gg][Yy];
ViewQuery: 
			[Vv][Ii][Ee][Ww][Qq][Uu][Ee][Rr][Yy];
Calculated: 
			[Cc][Aa][Ll][Cc][Uu][Ll][Aa][Tt][Ee][Dd];
Identity: 
			[Ii][Dd][Ee][Nn][Tt][Ii][Tt][Yy];
InitialExpression: 
			[Ii][Nn][Ii][Tt][Ii][Aa][Ll][Ee][Xx][Pp][Rr][Ee][Ss][Ss][Ii][Oo][Nn];
Internal: 
			[Ii][Nn][Tt][Ee][Rr][Nn][Aa][Ll];
Inverse: 
			[Ii][Nn][Vv][Ee][Rr][Ss][Ee];
Multidimensional: 
			[Mm][Uu][Ll][Tt][Ii][Dd][Ii][Mm][Ee][Nn][Ss][Ii][Oo][Nn][Aa][Ll];
Private: 
			[Pp][Rr][Ii][Vv][Aa][Tt][Ee];
ReadOnly: 
			[Rr][Ee][Aa][Dd][Oo][Nn][Ll][Yy];
Required: 
			[Rr][Ee][Qq][Uu][Ii][Rr][Ee][Dd];
SqlCollation: 
			[Ss][Qq][Ll][Cc][Oo][Ll][Ll][Aa][Tt][Ii][Oo][Nn];
SqlColumnNumber: 
			[Ss][Qq][Ll][Cc][Oo][Ll][Uu][Mm][Nn][Nn][Uu][Mm][Bb][Ee][Rr];
SqlComputeCode: 
			[Ss][Qq][Ll][Cc][Oo][Mm][Pp][Uu][Tt][Ee][Cc][Oo][Dd][Ee];
SqlComputed: 
			[Ss][Qq][Ll][Cc][Oo][Mm][Pp][Uu][Tt][Ee][Dd];
SqlComputeOnChange: 
			[Ss][Qq][Ll][Cc][Oo][Mm][Pp][Uu][Tt][Ee][Oo][Nn][Cc][Hh][Aa][Nn][Gg][Ee];
SqlFieldName: 
			[Ss][Qq][Ll][Ff][Ii][Ee][Ll][Dd][Nn][Aa][Mm][Ee];
SqlListDelimiter: 
			[Ss][Qq][Ll][Ll][Ii][Ss][Tt][Dd][Ee][Ll][Ii][Mm][Ii][Tt][Ee][Rr];
SqlListType: 
			[Ss][Qq][Ll][Ll][Ii][Ss][Tt][Tt][Yy][Pp][Ee];
Transient: 
			[Tt][Rr][Aa][Nn][Ss][Ii][Ee][Nn][Tt];
Data: 
			[Dd][Aa][Tt][Aa];
IdKey: 
			[Ii][Dd][Kk][Ee][Yy];
PrimaryKey: 
			[Pp][Rr][Ii][Mm][Aa][Rr][Yy][Kk][Ee][Yy];
SqlName: 
			[Ss][Qq][Ll][Nn][Aa][Mm][Ee];
Type: 
			[Tt][Yy][Pp][Ee];
Unique: 
			[Uu][Nn][Ii][Qq][Uu][Ee];
CodeMode: 
			[Cc][Oo][Dd][Ee][Mm][Oo][Dd][Ee];
ExternalProcName: 
			[Ee][Xx][Tt][Ee][Rr][Nn][Aa][Ll][Pp][Rr][Oo][Cc][Nn][Aa][Mm][Ee];
GenerateAfter: 
			[Gg][Ee][Nn][Ee][Rr][Aa][Tt][Ee][Aa][Ff][Tt][Ee][Rr];
NotForProperty: 
			[Nn][Oo][Tt][Ff][Oo][Rr][Pp][Rr][Oo][Pp][Ee][Rr][Tt][Yy];
PlaceAfter: 
			[Pp][Ll][Aa][Cc][Ee][Aa][Ff][Tt][Ee][Rr];
PublicList: 
			[Pp][Uu][Bb][Ll][Ii][Cc][Ll][Ii][Ss][Tt];
ReturnResultsets: 
			[Rr][Ee][Tt][Uu][Rr][Nn][Rr][Ee][Ss][Uu][Ll][Tt][Ss][Ee][Tt][Ss];
SoapAction: 
			[Ss][Oo][Aa][Pp][Aa][Cc][Tt][Ii][Oo][Nn];
SoapMessageName: 
			[Ss][Oo][Aa][Pp][Mm][Ee][Ss][Ss][Aa][Gg][Ee][Nn][Aa][Mm][Ee];
SoapNameSpace: 
			[Ss][Oo][Aa][Pp][Nn][Aa][Mm][Ee][Ss][Pp][Aa][Cc][Ee];
SoapTypeNameSpace: 
			[Ss][Oo][Aa][Pp][Tt][Yy][Pp][Ee][Nn][Aa][Mm][Ee][Ss][Pp][Aa][Cc][Ee];
SqlProc: 
			[Ss][Qq][Ll][Pp][Rr][Oo][Cc];
WebMethod: 
			[Ww][Ee][Bb][Mm][Ee][Tt][Hh][Oo][Dd];
ZenMethod: 
			[Zz][Ee][Nn][Mm][Ee][Tt][Hh][Oo][Dd];
SqlView: 
			[Ss][Qq][Ll][Vv][Ii][Ee][Ww];
SqlViewName: 
			[Ss][Qq][Ll][Vv][Ii][Ee][Ww][Nn][Aa][Mm][Ee];
Event: 
			[Ee][Vv][Ee][Nn][Tt];
Foreach: 
			[Ff][Oo][Rr][Ee][Aa][Cc][Hh];
NewTable: 
			[Nn][Ee][Ww][Tt][Aa][Bb][Ll][Ee];
OldTable: 
			[Oo][Ll][Dd][Tt][Aa][Bb][Ll][Ee];
Order: 
			[Oo][Rr][Dd][Ee][Rr];
Time: 
			[Tt][Ii][Mm][Ee];
UpdateColumnList: 
			[Uu][Pp][Dd][Aa][Tt][Ee][Cc][Oo][Ll][Uu][Mm][Nn][Ll][Ii][Ss][Tt];
References:
      [Rr][Ee][Ff][Ee][Rr][Ee][Nn][Cc][Ee][Ss];
OnDelete: 
			[Oo][Nn][Dd][Ee][Ll][Ee][Tt][Ee];
OnUpdate: 
			[Oo][Nn][Uu][Pp][Dd][Aa][Tt][Ee];
Flags:
      [Ff][Ll][Aa][Gg][Ss];
Constraint:
      [Cc][Oo][Nn][Ss][Tt][Rr][Aa][Ii][Nn][Tt];

Storage:
      [Ss][Tt][Oo][Rr][Aa][Gg][Ee];

SchemaSpec:
      [Ss][Cc][Hh][Re][Mm][Aa][Ss][Pp][Ee][Cc];
XMLNamespace:
      [Xx][Mm][Ll][Nn][Aa][Mm][Ee][Ss][Pp][Aa][Cc][Ee];


ID  :	[a-zA-Z] [a-zA-Z0-9]*
        {
         isKeyword(getText().toLowerCase());
        }
    ;


INT :	[0-9]+
    ;

FLOAT
    :   INT '.' INT? EXPONENT?
    |   '.' INT EXPONENT?
    |   INT+ EXPONENT
    ;

STRING
    : '"' (~[\r\n"] | '""')* '"'
    ;

fragment
EXPONENT : [eE] [+\-]? [0-9]+ ;


EOL : [\r\n] -> skip;


DOT         : '.';
COMMA       : ',';
PERCENT     : '%';
DOTCOMMA    : ';';
EQUAL       : '=';

WS       : [ \t]+ -> skip;

fragment Block: LBrace ( Block | ~[{}] )* ( RBrace | EOF );

MethodDeclaration: {isMethod()}? Block {resetKeyword();};
XDataDeclaration : {(lastKeyword==XData)}? Block {resetKeyword();};
QueryDeclaration : {(lastKeyword==Query)}? Block {resetKeyword();};
TriggerDeclaration : {(lastKeyword==Trigger)}? Block {resetKeyword();};

Expression : {isExpr()}? Block;

LBrace: '{';
RBrace: '}';
LParen: '(' { toggleList();};
RParen: ')' { toggleList();};
LBracket: '[' { isPropertiesList = true;};
RBracket: ']' { isPropertiesList = false;};
Underscore: '_';


//MLineComment: '/*' .*? ( '*/' | EOF );
Comment     : ('/*' .*? ( '*/' | EOF )) 
            | ('//' ~[\/\r\n] ~[\r\n]* '\r'? '\n');
Description : '///' ~[\r\n]* '\r'? '\n';

           