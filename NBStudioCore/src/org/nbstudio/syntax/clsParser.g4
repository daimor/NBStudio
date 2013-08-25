parser grammar clsParser;

@header{
    package org.nbstudio.syntax; 
}

options { 
    tokenVocab=clsLexer;
}


prog: includeDefinition? Description? classDefintion;

includeDefinition
    :   Include includeFiles;

includeFile: PERCENT? ID;
includeFiles: includeFile
            | LParen includeFile ( COMMA includeFile)* RParen;

classDefintion: Class className 
                classExtends?
                LBrace 
                classContent*
                RBrace
              ;

className: PERCENT? ID (DOT ID)*;

classNames: className
          | LParen className (COMMA className)* RParen;

classExtends: Extends classNames;

classContent: Description
            | propertyDefinition
            | parameterDefinition
            | indexDefinition;

propertyDefinition: Property ID (As propertyType)? DOTCOMMA;

propertyType: PERCENT? ID (DOT ID)*;

parameterDefinition: Parameter ID (EQUAL STRING)? DOTCOMMA;

ids: ID
   | LParen ID ( COMMA ID )* RParen;

dotid: ID ( DOT ID)*;

dotids : dotid
       | LParen dotid ( COMMA dotid )* RParen;

indexDefinition: Index ID On dotids DOTCOMMA;
