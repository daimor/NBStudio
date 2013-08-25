lexer grammar macLexer;

@header{
    package org.nbstudio.syntax; 
}

@lexer::members {
class lexerState extends Object 
{
    int charPositionInLine = -1;
    int line = -1;
    
    int nesting = 0;
    boolean isCommand = false;
    boolean isClass = false;
    boolean isClassMethod = false;
    boolean doArg = false;
    boolean caret = false;
    boolean labelDef = false;
    int lastTokenType = 0;
    int mode = DEFAULT_MODE;
    IntegerStack modeStack;
    boolean macroline = false;
    
}
public lexerState getLexerState() 
{
    lexerState state = new lexerState();
    
    state.line = getLine();
    state.charPositionInLine = getCharPositionInLine();

    state.nesting = nesting;
    state.isCommand = isCommand;
    state.isClass = isClass;
    state.isClassMethod = isClassMethod;
    state.doArg = doArg;
    state.caret = caret;
    state.labelDef = labelDef;
    state.lastTokenType = lastTokenType;
    state.mode = _mode;
    state.modeStack = new IntegerStack();
    state.macroline = macroline;
    for (int i = 0; i < _modeStack.size(); i++) {
        state.modeStack.push(_modeStack.get(i));
    }
    return state;
}

public void setLexerState(lexerState state) 
{ 
    if(state==null) return;
    setLine(state.line);
    setCharPositionInLine(state.charPositionInLine);
    
    nesting = state.nesting;
    isCommand = state.isCommand;
    isClass = state.isClass = isClass;
    isClassMethod = state.isClassMethod;
    doArg = state.doArg;
    caret = state.caret;
    labelDef = state.labelDef;
    lastTokenType = state.lastTokenType;
    _modeStack.clear();
    for (int i = 0; i < state.modeStack.size(); i++) {
        pushMode(state.modeStack.get(i));
    }
    mode(state.mode);
    macroline = state.macroline;
}

    int nesting = 0;
    boolean isCommand = false;
    boolean isClass = false;
    boolean isClassMethod = false;
    boolean doArg = false;
    boolean caret = false;
    boolean labelDef = false;
    int lastTokenType = 0;
    boolean macroline = false;
    
    void isCMD() {
        isCommand=true;
        setType(CMD);
    }
public void emit(Token token) {
    super.emit(token);
    lastTokenType = token.getType();
}
}


ObjectMethod: {isClassMethod}? ID {isClass=false;isClassMethod=false;};
ObjectName  : {nesting>0&&isClass}? '%'? ID ('.' ID )*;
Label       : {((getCharPositionInLine()==0)||(doArg&&(lastTokenType==CommandSPACE)))}? ID { labelDef = (!doArg);}; 
RoutineName : {doArg&&(lastTokenType==CARET)}? ID; 
GlobalName : {(lastTokenType==CARET)}? ID; 
SystemVariable: Dollar ID;
SpecialGlobal: CARET Dollar ID;
MACMethodPrivate: {labelDef}? [Pp][Rr][Ii][Vv][Aa][Tt][Ee];
MACMethodPublic: {labelDef}? [Pp][Uu][Bb][Ll][Ii][Cc];

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

EOL : [\r\n]+ {isCommand=false;macroline=false;}
    ;
   
EQUAL       : WS*'='WS*;
COMMA       : WS*','WS*;
Dollar      : '$';
Colon       : ':';
DOT         : '.';
PLUS        : '+';
MINUS       : '-';
PERCENT     : '%';
AT          : '@';
SHARP       : '#';
EXCLAMATION : '!';
QUESTON     : '?';
ASTERISK    : '*';
UNDERSCORE  : '_';
SLASH       : '/';
BACKSLASH   : '\\';
Spaces      : WS+ 
            {
             if (nesting==0&&!macroline){
                if (isCommand){isCommand=false;setType(CommandSPACE);} 
                else {pushMode(COMMAND);}
             }
            }
            ;
LPClass     : {isClass}? '(' {nesting++;};
RPClass     : {isClass}? ').' {nesting--;isClassMethod=true;isClass=false;};
LPAREN      : '('WS* {nesting++;};
RPAREN      : WS*')'WS* {nesting--;};
LBRACE      : '{'WS* {nesting==0&&!macroline}? ->pushMode(COMMAND);
RBRACE      : WSNL*'}' {isCommand=false;};
LBRACK      : WSNL*'[';
RBRACK      : ']'WSNL* {isCommand=false;};
FUNCTION    : '$'[a-zA-Z][a-zA-Z0-9]*;
COMMENT     : WS+ (';'|'/''/'+) .*? [\r\n]+;
MACROCOMMENT: {(getCharPositionInLine()==0)}? WS* '#;' .*? [\r\n]+;
//MLINECOMMENT: WS* '/*' (.*?|[\r\n])* '*/';
CARET       : '^' {caret=true;};
VertBar     : '|';
WS          : [ \t];
WSNL        : [ \t\r\n];
CondOper    : WS* ('&&'|'||'|'>='|'<='|'\'='|'>'|'<'|'\'<'|'\'>') WS*;
Negative    : '\'';
//MACRO       : Spaces? '#' {macroline = true;System.out.println("MACRO");};
ObjectClass : '##'[Cc][Ll][Aa][Ss][Ss] {isClass=true;};
ObjectSuper : '##'[Ss][Uu][Pp][Ee][Rr];
ObjectThis  : '##'[Tt][Hh][Ii][Ss];
Define      : {(getCharPositionInLine()==0)}? WS*'#'[Dd][Ee][Ff][Ii][Nn][Ee] {macroline = true;};
DefineExpression: Define .*? [\r\n]+;
Include     : {(getCharPositionInLine()==0)}? WS*'#'[Ii][Nn][Cc][Ll][Uu][Dd][Ee] {macroline = true;};

mode COMMAND;
CommandDO   : [dD][oO]? {doArg = true;isCMD();};
CommandGOTO : [gG]([oO][tT][oO])? {doArg = true;isCMD();};
CommandJOB  : [jJ]([oO][bB])? {doArg = true;isCMD();};

CMD  :	[a-zA-Z] [a-zA-Z0-9]* {doArg=false;isCMD();labelDef=false;};
CommandSPACE : [ ] {popMode();isCommand=false;};
CommandCOLON : ':' -> popMode ;
CommandEOL : [\r\n]+ {popMode();isCommand=false;};
CommandLBRACE : '{'[ \t]*;
CommandRBRACE : [ \r\n\t]*'}' {popMode();isCommand=false;};
CommandCOMMA  : [ \t]*','[ \t]*;
