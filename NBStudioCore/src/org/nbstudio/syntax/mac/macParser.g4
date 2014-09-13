parser grammar macParser;

@header{
    package org.nbstudio.syntax.mac; 
}

options { 
    tokenVocab=macLexer;
}
@parser::members{
int loopLevel = 0;
boolean ifBlock = false;
boolean elseBlock = false;
int argsLevel = 0;
boolean tryBlock = false;
boolean catchBlock = false;
boolean doBlock = false;
boolean whileBlock = false;

boolean cmp(String cmds){
    String val = _input.LT(1).getText();
    String[] vars = cmds.split(",");
    for (String cmd : vars) {
        if(val.equalsIgnoreCase(cmd)){
            return true;
        }
    }
    return false;
}
}

prog 	
    :	statement*
	;

statement
	:	Spaces? simpleStatement
        |       Include Spaces includeStatement Spaces? (EOL|EOF)
        |       define
        |       comments
        |       (Spaces|EOL|CommandEOL)
        |       Label labelDef?
	;
blockStatement[boolean quitWithoutArgs]
@init{
if(quitWithoutArgs) {loopLevel++;}
}
@after{
if(quitWithoutArgs) {loopLevel--;}
}
        :       (LBRACE|CommandLBRACE) statement* (RBRACE|CommandRBRACE)
        ;

comments:       COMMENT
        ;
simpleStatement
@init {
    // reset blocks
    catchBlock = tryBlock;
    tryBlock = false;
    elseBlock = ifBlock;
    ifBlock = false;
    whileBlock = doBlock;
    doBlock = false;
}    
        :   breakCommand pc? breakStatement
        |   catchCommand catchStatement
        |   closeCommand pc? closeStatement
        |   continueCommand pc?
        |   doCommand pc? doStatement?
        |   elseCommand1 elseStatement
        |   elseCommand2 CommandSPACE?
        |   forCommand forStatement
        |   gotoCommand pc? gotoStatement
        |   haltCommand pc? CommandSPACE?
        |   hangCommand pc? hangStatement
        |   ifCommand ifStatement
        |   jobCommand pc? jobStatement
        |   killCommand pc? killStatement
        |   lockCommand pc? lockStatement
        |   mergeCommand pc? mergeStatement
        |   newCommand pc? newStatement
        |   openCommand pc? openStatement
        |   quitCommand pc? quitStatement
        |   readCommand pc? readStatement
        |   setCommand pc? setStatement
        |   tcommitCommand pc?
        |   throwCommand pc? expression?
        |   trollbackCommand pc? expression?
        |   tryCommand tryStatement
        |   tstartCommand pc?
        |   useCommand pc? useStatement
        |   viewCommand pc? viewStatement
        |   whileCommand whileStatement
        |   writeCommand pc? writeStatement?
        |   xecuteCommand pc? xecuteStatement
        |   zkillCommand pc? zkillStatement
        |   znspaceCommand pc? expression
        |   ztrapCommand pc? expression
        |   zwriteCommand pc? zwriteStatement
        |   zzdumpCommand pc? zzdumpStatement
        |   printCommand pc? printStatement
        |   zbreakCommand pc? zbreakStatement
        |   zinsertCommand
        |   zloadCommand
        |   zprintCommand
        |   zremoveCommand
        |   zsaveCommand
        |   SQLBlock
        |   JSBlock
        |   HTMLBlock
        |   macrosAsCommand
	;
macrosAsCommand: CMDMacros
               ;
includeStatement 
        :   includeRtn 
        |   LPAREN Spaces? ID ( Spaces? COMMA includeRtn )* Spaces? RPAREN
        ;

includeRtn:	PERCENT? ID
	;

define  :
            DefineExpression
        ;

breakCommand            :{cmp("b,break")}? CMD;
breakStatement
        :               CommandSPACE? expression?
        ;

catchCommand            : {catchBlock&&cmp("catch")}? CMD;
catchStatement
        :              CommandSPACE? Spaces? ID? Spaces? blockStatement[true]
        ;
closeCommand            :{cmp("c,close")}? CMD;
closeStatement:     CommandSPACE expression (COMMA expression)*
              ;
continueCommand         :{cmp("continue")}? CMD;
doCommand               :{cmp("d,do")}? CMD;
doStatement
        :   CommandSPACE ( doArgument pc? ( COMMA doArgument pc? )* )
        |   CommandSPACE  (CommandSPACE|Spaces|CommandEOL|EOL)* blockStatement[true] {doBlock = true;}
        |   CommandSPACE
        ;
elseCommand1             : {elseBlock&&cmp("else")}? CMD;
elseCommand2             : {!elseBlock&&cmp("else")}? CMD;
elseStatement:      CommandSPACE? Spaces? blockStatement[false]
             ;

elseifCommand           :{cmp("elseif")}? CMD;

forCommand              :{cmp("f,for")}? CMD;
forStatement
        :       CommandSPACE ( variable (EQUAL forExpression)? )? (CommandSPACE|Spaces|CommandEOL|EOL)* blockStatement[true]?
        ;
forExpression 
        :       expression ((Colon expression (Colon expression)? )? | (COMMA expression)*)
        ;
gotoCommand             :{cmp("g,goto")}? CMD;
gotoStatement
        :
        ;
haltCommand             :{cmp("h,halt")}? CMD;
hangCommand             :{cmp("h,hang")}? CMD;
hangStatement:      CommandSPACE expression (COMMA expression)*
             ;

ifCommand               :{cmp("i,if")}? CMD;
ifStatement:    CommandSPACE condition (COMMA condition)* Spaces? blockStatement[false] {ifBlock=true;}
           |    CommandSPACE condition (COMMA condition)*
           ;
jobCommand              :{cmp("j,job")}? CMD;
jobStatement:   CommandSPACE jobArgument ( COMMA jobArgument)*
            ;
jobArgument: doArgument ( Colon jobProcessParams? (Colon expression)? )?
           ;
jobProcessParams: LPAREN (expression|Colon)* RPAREN
                ;
killCommand             :{cmp("k,kill")}? CMD;
killStatement
	:	CommandSPACE? (killArgument (COMMA killArgument)* )?
        ;
killArgument:       variable
            |       LPAREN variable RPAREN
            ;
lockCommand             :{cmp("l,lock")}? CMD;
lockStatement:  CommandSPACE? (lockArgument (COMMA lockArgument)? )?
             ;
lockArgument: (PLUS|MINUS)? lockArgument2 (Colon expression)?
            | (PLUS|MINUS)? LPAREN lockArgument2 (COMMA lockArgument2)* RPAREN (Colon expression)?
            ;
lockArgument2: variable (SHARP expression)?
             ;
mergeCommand            :{cmp("m,merge")}? CMD;
mergeStatement:     CommandSPACE mergeArgument ( COMMA mergeArgument)*
              ;
mergeArgument:      variable EQUAL expression
             ;
newCommand              :{cmp("n,new")}? CMD;
newStatement
	:	(CommandSPACE (localVariable (COMMA localVariable)* )? )?
	;
openCommand             :{cmp("o,open")}? CMD;
openStatement:      CommandSPACE expression (Colon colonExpression? (Colon expression? (Colon expression? )? )? )?
             ;
quitCommand             :{cmp("q,quit")}? CMD;
quitStatement
	:   {loopLevel>0}? CommandSPACE?
        |   {loopLevel==0}? CommandSPACE? expression?
        ;
readCommand             :{cmp("r,read")}? CMD;
readStatement:      CommandSPACE readArgument (COMMA readArgument)*
             ;
readArgument:       writeArgument
            |       variable (SHARP expression)? Colon expression
            ;
setCommand              :{cmp("s,set")}? CMD;
setStatement
	:	CommandSPACE setArgument ( COMMA setArgument)*
        ;
setArgument:       variable EQUAL expression;
tcommitCommand          :{cmp("tc,tcommit")}? CMD;
throwCommand            :{cmp("throw")}? CMD;
trollbackCommand        :{cmp("tr,trollback")}? CMD;
tryCommand              :{cmp("try")}? CMD;
tryStatement:       CommandSPACE? Spaces? blockStatement[true] {tryBlock = true;}
            ;
tstartCommand           :{cmp("ts,tstart")}? CMD;
useCommand              :{cmp("u,use")}? CMD;
useStatement:       CommandSPACE expression (Colon colonExpression (Colon expression)? )?
            ;
viewCommand             :{cmp("v,view")}? CMD;
viewStatement:      CommandSPACE expression (Colon expression (Colon expression (Colon expression)? )? )?
             ;
whileCommand            :{cmp("while")}? CMD;
whileStatement:     {whileBlock}? CommandSPACE condition (COMMA condition)* 
              |     {!whileBlock}? CommandSPACE condition (COMMA condition)* Spaces? blockStatement[true]
              ;
writeCommand            :{cmp("w,write")}? CMD;
writeStatement:     CommandSPACE (writeArgument (COMMA writeArgument)* )
              |     CommandSPACE
              ;
writeArgument:      expression
             |      (SHARP|EXCLAMATION)*
             |      QUESTON expression
             |      ASTERISK variable
             |      SLASH ID
             ;
xecuteCommand           :{cmp("x,xecute")}? CMD;
xecuteStatement:    CommandSPACE xeceuteArgument pc? (COMMA xeceuteArgument pc?)*
               ;
xeceuteArgument:    expression
               |    LPAREN expression {argsLevel++;} (COMMA expression)* {argsLevel--;} RPAREN
               ;
zkillCommand            :{cmp("zk,zkill")}? CMD;
zkillStatement:     CommandSPACE variable (COMMA variable)*
              ;
znspaceCommand          :{cmp("zn,znspace")}? CMD;
ztrapCommand            :{cmp("ztrap")}? CMD;
zwriteCommand           :{cmp("zw,zwrite")}? CMD;
zwriteStatement:        CommandSPACE? (variable (COMMA variable)* )?
               ;
zzdumpCommand           :{cmp("zzdump")}? CMD;
zzdumpStatement:        CommandSPACE expression (COMMA expression)*
               ;
printCommand            :{cmp("p,print")}? CMD;
printStatement:         CommandSPACE
              ;
zbreakCommand           :{cmp("zb,zbreak")}? CMD;
zbreakStatement:        CommandSPACE? 
               ;
zinsertCommand          :{cmp("zi,zinsert")}? CMD;
zloadCommand            :{cmp("zl,zload")}? CMD;
zprintCommand           :{cmp("zp,zprint")}? CMD;
zremoveCommand          :{cmp("zr,zremove")}? CMD;
zsaveCommand            :{cmp("zs,zsave")}? CMD;

systemFunction:       func=SystemVariable LPAREN RPAREN 
              ;

variable:       localVariable
        |       globalVariable
        |       LPAREN variable RPAREN
        |       AT variable (AT LPAREN expression ( COMMA expression )* RPAREN)?
        |       Property
        ;
            
localVariable:	PERCENT? ID
	;
globalVariable
        :       CARET (VertBar expression? VertBar)? PERCENT? GlobalName
	;
localVariableList
	:	(LPAREN ID Spaces ( COMMA ID)* RPAREN)
	;

colonExpression: LPAREN (expression|Colon)* RPAREN
               | expression
               ;
expression
        :       simpleExpression
        |       expression Spaces? ((EOL* UNDERSCORE)|PLUS|MINUS|ASTERISK|SHARP|SLASH|BACKSLASH) Spaces? expression
        |       LPAREN expression RPAREN
        |       condition
        ;
simpleExpression
	:	INT
	|	FLOAT
        |       variable
        |       STRING
        |       doClass
        |       {argsLevel>0}? DOT localVariable
        |       SystemVariable
        |       SpecialGlobal
        |       systemFunction
        |       Macros
	;
condition
        :   LPAREN condition RPAREN
        |   condition (CondOper|EQUAL) condition
        |   Negative condition
        |   simpleExpression
        ;

pc      : CommandCOLON condition;

arguments
        : {argsLevel++;} LPAREN (COMMA|expression)* RPAREN {argsLevel--;}
        ;

doClass : ObjectClass LPClass ObjectName RPClass ObjectMethod arguments
        ;
doRoutine : Label? (PLUS expression)? (CARET RoutineName)? arguments?
        ;
doArgument
        : doClass
        | doRoutine
        ;

labelDef
        :   LPAREN ( labelParameter ( COMMA labelParameter)* )? RPAREN
            (methodPublicVariables? Spaces? (MACMethodPrivate|MACMethodPublic)? Spaces? CommandEOL? comments* Spaces? methodContent  )?
        ;
methodPublicVariables: LBRACK ID (COMMA ID)* RBRACK
                     ;
methodContent:   CommandLBRACE statement CommandRBRACE
             |   CommandLBRACE CommandRBRACE
             |   LBRACE statement RBRACE
             |   CommandLBRACE CommandEOL? statement? RBRACE
             ;
labelParameter
        :   ID
        |   ID EQUAL (STRING|INT)
        ;