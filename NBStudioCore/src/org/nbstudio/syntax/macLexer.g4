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
    
    @Override
    public String toString() {
       return "l:" + line + ", cp:" + (charPositionInLine+1) + ", cmd:" + isCommand + ", lt:" + lastTokenType;
    }
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
}

    int nesting = 0;
    boolean isCommand = false;
    boolean isClass = false;
    boolean isClassMethod = false;
    boolean doArg = false;
    boolean caret = false;
    boolean labelDef = false;
    int lastTokenType = 0;
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
Label       : {((getCharPositionInLine()==0)||(doArg&&(lastTokenType==CommandSPACE)))}? ID { labelDef = (getCharPositionInLine()==0);}; 
RoutineName : {doArg&&(lastTokenType==CARET)}? ID; 
GlobalName : {(lastTokenType==CARET)}? ID; 
SystemVariable: Dollar ID;
SpecialGlobal: CARET Dollar ID;


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

EOL : [\r\n]+ {isCommand=false;}
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
             if (nesting==0){
                if (isCommand){isCommand=false;setType(CommandSPACE);} 
                else {pushMode(COMMAND);}
             }
            }
            ;
LPClass     : {isClass}? '(' {nesting++;};
RPClass     : {isClass}? ').' {nesting--;isClassMethod=true;isClass=false;};
LPAREN      : '('WS* {nesting++;};
RPAREN      : WS*')'WS* {nesting--;};
LBRACK      : '{'WSNL* {nesting==0}? ->pushMode(COMMAND);
RBRACK      : WSNL*'}' {isCommand=false;};
FUNCTION    : '$'[a-zA-Z][a-zA-Z0-9]*;
COMMENT     : WS+ (';'|'/''/'+) .*? [\r\n]+;
MACROCOMMENT: WS* '#;' .*? [\r\n]+;
CARET       : '^' {caret=true;};
VertBar     : '|';
WS          : [ \t];
WSNL        : [ \t\r\n];
CondOper    : WS* ('&&'|'||'|'>='|'<='|'\'='|'>'|'<'|'\'<'|'\'>') WS*;
Negative    : '\'';
ObjectClass : '##class' {isClass=true;};
ObjectSuper : '##super';
ObjectThis  : '##this';

mode COMMAND;
CommandDO   : [dD][oO]? {doArg = true;isCMD();};
CommandGOTO : [gG]([oO][tT][oO])? {doArg = true;isCMD();};
CommandJOB  : [jJ]([oO][bB])? {doArg = true;isCMD();};

CMD  :	[a-zA-Z] [a-zA-Z0-9]* {doArg=false;isCMD();};
CommandSPACE : [ ] {popMode();isCommand=false;};
CommandCOLON : ':' -> popMode ;
CommandEOL : [\r\n]+ {popMode();isCommand=false;};
CommandLBRACK : '{'[ \r\n\t]*;
CommandRBRACK : [ \r\n\t]*'}' {popMode();isCommand=false;};
CommandCOMMA  : [ \t]*','[ \t]*;
