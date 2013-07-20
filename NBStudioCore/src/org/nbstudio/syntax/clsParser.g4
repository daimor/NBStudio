parser grammar clsParser;

@header{
    package org.nbstudio.syntax; 
}

options { 
    tokenVocab=clsLexer;
}


prog: include?;

include: Include;