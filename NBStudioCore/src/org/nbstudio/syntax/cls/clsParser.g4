parser grammar clsParser;

@header{
    package org.nbstudio.syntax.cls; 
}

options { 
    tokenVocab=clsLexer;
}


prog: includeDefinition? Description* classDefintion;

includeDefinition
    :   Include includeFiles;

includeFile: PERCENT? ID;
includeFiles: includeFile
            | LParen includeFile ( COMMA includeFile)* RParen;

classDefintion: Class classNames 
                classExtends?
                LBrace 
                classContent*
                RBrace
              ;

classNames: ClassName
          | LParen ClassName (COMMA ClassName)* RParen;

classExtends: Extends classNames;

classContent: Description
            | Comment
            | propertyDefinition
            | parameterDefinition
            | indexDefinition
            | methodDefintion
            | queryDefinition
            | xdataDefinition;

propertyDefinition: Property PropertyName (As propertyType)? DOTCOMMA;

propertyType: ClassName;

parameterDefinition: Parameter ParameterName (EQUAL STRING)? DOTCOMMA;

methodDefintion: (Method|ClassMethod) MethodName LParen RParen MethodDeclaration;

xdataDefinition: XData XDataName (LParen RParen)? XDataDeclaration;

queryDefinition: Query QueryName (LParen RParen)? QueryDeclaration;

ids: ID
   | LParen ID ( COMMA ID )* RParen;

listProperties : PropertyName
       | LParen PropertyName ( COMMA PropertyName )* RParen;

indexDefinition: Index IndexName On listProperties DOTCOMMA;
