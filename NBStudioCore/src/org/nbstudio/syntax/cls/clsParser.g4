                    parser grammar clsParser;

@header{
    package org.nbstudio.syntax.cls; 
}

options { 
    tokenVocab=clsLexer;
}


prog:  classDefintion;

includeDefinition
    :   Include includeFiles;

includeFiles: IncludeFile
            | LParen IncludeFile ( COMMA IncludeFile)* RParen;

importDefinition
    :   Import includeFiles;

includegeneratorDefinition
    :   IncludeGenerator includeFiles;

classDefintion: includeDefinition?
                includegeneratorDefinition?
                importDefinition?
                Description* 
                Class ClassName 
                (Extends extendClassess=classNames)?
                (LBracket classProperties (COMMA classProperties)* RBracket)?
                LBrace 
                classContent*
                RBrace
              ;

classNames: ClassName
          | LParen ClassName (COMMA ClassName)* RParen;

classProperties: Not? propName=Abstract
               | propName=ClassType EQUAL propVal=ID
               | propName=ClientDataType EQUAL propVal=ID
               | propName=ClientName EQUAL propVal=ClientNameVal
               | propName=CompileAfter EQUAL propVal=ID
               | Not? propName=DdlAllowed
               | propName=DependsOn EQUAL propVal=ID
               | Not? propName=Final
               | Not? propName=Hidden
               | Not? propName=ProcedureBlock
               | Not? propName=SqlRowIdPrivate
               | propName=StorageStrategy EQUAL proVal=ID
               ;

classContent: comment
            | propertyDefinition
            | parameterDefinition
            | indexDefinition
            | methodDefintion
            | queryDefinition
            | xdataDefinition
            | triggerDefinition
            | foreignkeyDefinition
            | projectionDefinition
            ;

comment: Comment;

parametersList: LParen parameter ( COMMA parameter)* RParen;
parameter: paramName=ID EQUAL (paramVal=INT | paramVal=STRING);

propertyDefinition: Description* 
                    (Relationship|Property) PropertyName 
                    (As (PropertyCollection Of)? propertyType=ClassName)?
                    parametersList?
                    (LBracket propertyProperties (COMMA propertyProperties)* RBracket)?
                    DOTCOMMA;

propertyProperties: propName=Calculated
                  | propName=Cardinality EQUAL propVal=ID
                  | propName=ClientName EQUAL propVal=ClientNameVal
                  | propName=Final
                  | propName=Identity
                  | propName=InitialExpression EQUAL ( propVal=Expression | propVal=STRING | propVal=INT)
                  | propName=Internal
                  | propName=Inverse EQUAL propVal=ID
                  | propName=Multidimensional
                  | propName=Private
                  | propName=ReadOnly
                  | propName=Required
                  | propName=ServerOnly EQUAL propVal=(INT|ID)
                  | propName=SqlColumnNumber EQUAL propVal=INT
                  | propName=SqlComputed
                  | propName=SqlComputeCode EQUAL propVal=Expression
                  | propName=SqlComputeOnChange EQUAL propVal=ID
                  | propName=SqlFieldName EQUAL propVal=ID
                  | propName=SqlListDelimiter EQUAL propVal=STRING
                  | propName=SqlListType EQUAL propVal=ID
                  | propName=Transient
                  ;
                    

parameterDefinition: Description* 
                     Parameter ParameterName
                     (LBracket parameterProperties (COMMA parameterProperties)* RBracket)?
                     (EQUAL (parameterValue=STRING | parameterValue=INT))? 
                     DOTCOMMA;

parameterProperties: propName=Abstract
                   | propName=Constraint EQUAL propVal=STRING
                   | propName=Final
                   | propName=Flags EQUAL propVal=ID
                   | propName=Internal
                   ;

methodDefintion: Description* 
                 (Method|ClassMethod) MethodName LParen methodFormalSpec? RParen (As returnType=ClassName)? 
                 (LBracket methodProperties (COMMA methodProperties)* RBracket)?
                 MethodDeclaration;

methodFormalSpec: methodFormalSpecOne ( COMMA methodFormalSpecOne )*;
methodFormalSpecOne: (ByRef|Output)? varName=ID ( As varType=ClassName )? ( EQUAL methodFormalSpecExpr )?;
methodFormalSpecExpr : STRING
                     | INT;

methodProperties: propName=Abstract
                | propName=ClientName EQUAL propVal=ClientNameVal
                | propName=CodeMode EQUAL propVal=MethodCodeMode
                | propName=ExternalProcName EQUAL propVal=ID
                | propName=Final
                | propName=GenerateAfter EQUAL propVal=ID
                | propName=Internal
                | propName=Language EQUAL propVal=MethodLanguage
                | propName=NotForProperty
                | propName=PlaceAfter EQUAL propVal=ID
                | propName=Private
                | propName=ProcedureBlock
                | propName=PublicList EQUAL ids
                | propName=ReturnResultsets
                | propName=ServerOnly EQUAL propVal=(INT|ID)
                | propName=SoapAction EQUAL propVal=ID
                | propName=SoapBindingStyle EQUAL propVal=ID
                | propName=SoapBodyUse EQUAL propVal=ID
                | propName=SoapMessageName EQUAL propVal=ID
                | propName=SoapNameSpace EQUAL propVal=STRING
                | propName=SoapTypeNameSpace EQUAL propVal=STRING
                | propName=SqlName EQUAL propVal=SqlNameVal
                | propName=SqlProc
                | propName=WebMethod
                | propName=ZenMethod
                ;

indexDefinition: Description* 
                 Index IndexName On listProperties 
                 (LBracket indexProperties (COMMA indexProperties)* RBracket)?
                 DOTCOMMA;
indexProperties: propName=Data EQUAL listProperties
               | propName=Final
               | propName=IdKey
               | propName=PrimaryKey
               | propName=SqlName EQUAL propVal=SqlNameVal
               | propName=Type EQUAL propVal=ID
               | propName=Unique;

xdataDefinition: Description* 
                 XData XDataName 
                 (LBracket xdataProperties (COMMA xdataProperties)* RBracket)?
                 XDataDeclaration;

xdataProperties: propName=Internal
               | propName=SchemaSpec EQUAL (propVal=ID|propVal=STRING)
               | propName=XMLNamespace EQUAL propVal=STRING
               ;

queryDefinition: Description* 
                 Query QueryName 
                 LParen queryFormalSpec? RParen As returnType=ClassName
                 parametersList?
                 (LBracket queryProperties (COMMA queryProperties)* RBracket)?
                 QueryDeclaration;

queryFormalSpec: queryFormalSpecOne ( COMMA queryFormalSpecOne )*;
queryFormalSpecOne: varName=ID ( As varType=ClassName )? ( EQUAL queryFormalSpecExpr )?;
queryFormalSpecExpr : STRING
                     | INT;

queryProperties: propName=ClientName EQUAL propVal=ClientNameVal
               | propName=Final
               | propName=Internal
               | propName=Private
               | propName=SoapBindingStyle EQUAL propVal=ID
               | propName=SoapNameSpace EQUAL propVal=STRING
               | propName=SqlName EQUAL propVal=SqlNameVal
               | propName=SqlView
               | propName=SqlProc
               | propName=SqlViewName EQUAL propVal=ID
               | propName=WebMethod
               ;
ids: ID
   | LParen ID ( COMMA ID )* RParen;

listProperties : PropertyName
       | LParen PropertyName ( COMMA PropertyName )* RParen;

triggerDefinition:Description* 
                 Trigger TriggerName
                 (LBracket triggerProperties (COMMA triggerProperties)* RBracket)?
                 TriggerDeclaration;

triggerProperties: propName=Event EQUAL propVal=ID
               | propName=Final
               | propName=Foreach EQUAL propVal=ID
               | propName=Internal
               | propName=Language EQUAL propVal=ID
               | propName=NewTable EQUAL propVal=ID
               | propName=OldTable EQUAL propVal=ID
               | propName=Order EQUAL propVal=INT
               | propName=SqlName EQUAL propVal=SqlNameVal
               | propName=Time EQUAL propVal=ID
               | propName=UpdateColumnList EQUAL propVal=ID
               ;

foreignkeyDefinition:Description* 
                    ForeignKey ForeignKeyName 
                    LParen foreignkeyProps=ID RParen
                    References foreignkeyRefClass=ClassName 
                    LParen (foreignkeyRefKey=ID)? RParen
                    (LBracket foreignkeyProperties (COMMA foreignkeyProperties)* RBracket)?
                    DOTCOMMA
                    ;

foreignkeyProperties: propName=Internal
                    | propName=OnDelete EQUAL propVal=ID
                    | propName=OnUpdate EQUAL propVal=ID
                    | propName=SqlName EQUAL propVal=SqlNameVal
                    ;

projectionDefinition:Description* 
                    Projection ProjectionName As ClassName 
                    parametersList?
                    (LBracket projectionProperties (COMMA projectionProperties)* RBracket)?
                    DOTCOMMA
                    ;

projectionProperties: propName=Internal
                    ;