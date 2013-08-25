lexer grammar clsLexer;

@header{
    package org.nbstudio.syntax; 
}

@lexer::members {
class lexerState extends Object 
{
    int charPositionInLine = -1;
    int line = -1;
}
public lexerState getLexerState() 
{
    lexerState state = new lexerState();
    
    state.line = getLine();
    state.charPositionInLine = getCharPositionInLine();

    return state;
}

public void setLexerState(lexerState state) 
{ 
    if(state==null) return;
    setLine(state.line);
    setCharPositionInLine(state.charPositionInLine);
}

}

Include: 
			[Ii][Nn][Cc][Ll][Uu][Dd][Ee];
Class: 
			[Cc][Ll][Aa][Ss][Ss];
Extends: 
			[Ee][Xx][Tt][Ee][Nn][Dd][Ss];
ClassMethod: 
			[Cc][Ll][Aa][Ss][Ss][Mm][Ee][Tt][Hh][Oo][Dd];
ForeignKey: 
			[Ff][Oo][Rr][Ee][Ii][Gg][Nn][Kk][Ee][Yy];
Index: 
			[Ii][Nn][Dd][Ee][Xx];
On:                     
                        [Oo][Nn];
Method: 
			[Mm][Ee][Tt][Hh][Oo][Dd];
Parameter: 
			[Pp][Aa][Rr][Aa][Mm][Ee][Tt][Ee][Rr];
Projection: 
			[Pp][Rr][Oo][Jj][Ee][Cc][Tt][Ii][Oo][Nn];
Property: 
			[Pp][Rr][Oo][Pp][Ee][Rr][Tt][Yy];
Query: 
			[Qq][Uu][Ee][Rr][Yy];
Relationship: 
			[Rr][Ee][Ll][Aa][Tt][Ii][Oo][Nn][Ss][Hh][Ii][Pp];
Trigger: 
			[Tt][Rr][Ii][Gg][Gg][Ee][Rr];
XData: 
			[Xx][Dd][Aa][Tt][Aa];
As:
                        [Aa][Ss];
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
OnDelete: 
			[Oo][Nn][Dd][Ee][Ll][Ee][Tt][Ee];
OnUpdate: 
			[Oo][Nn][Uu][Pp][Dd][Aa][Tt][Ee];

Storage     : [Ss][Tt][Oo][Rr][Aa][Gg][Ee];

ID  :	[a-zA-Z] [a-zA-Z0-9]*;

INT :	[0-9]+
    ;

FLOAT
    :   INT '.' INT? EXPONENT?
    |   '.' INT EXPONENT?
    |   INT+ EXPONENT
    ;

STRING
    :  '"' ~["]* '"'
    ;

fragment
EXPONENT : [eE] [+\-]? [0-9]+ ;

EOL : [\r\n]+ -> skip
    ;

DOT         : '.';
COMMA       : ',';
PERCENT     : '%';
DOTCOMMA    : ';';
EQUAL       : '=';

WS       : [ \t]+ -> skip;

LBrace: '{';
RBrace: '}';
LParen: '(';
RParen: ')';

//Comment     : '//' .*? [\r\n]+;
Description : '///' .*? [\r\n]+;

