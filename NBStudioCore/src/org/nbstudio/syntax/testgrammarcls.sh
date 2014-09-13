#! /bin/sh

DIR="$(dirname "$(readlink -f "$0")")"
cd $DIR 

ANTLR=../../../../../release/modules/ext/antlr-4.4-complete.jar
CACHEDB=../../../../../../lib/cachedb.jar
CACHEJDBC=../../../../../../lib/cachejdbc.jar
LEXER=clsLexer.g4
PARSER=clsParser.g4
PACKAGE=org.nbstudio.syntax.cls
TEMPDIR=/tmp/antlrtestgrammar/
#-no-visitor -no-listener
ANTLROPT=" -o $TEMPDIR"
EXAMPLE=clsExample.cls

cd cls

if [ -e $TEMPDIR ] 
then
    echo $TEMPDIR already exist
else
    echo create tempdir $TEMPDIR
    mkdir $TEMPDIR
fi

echo clear temp dir
rm -f *.tokens
rm -rf $TEMPDIR/*

echo coping example
cp $EXAMPLE $TEMPDIR
cp ../../core/cls/CLSParserListerer4Save.java $TEMPDIR
cp ../../core/cls/CLSFile.java $TEMPDIR
cp ../../core/cls/CLSUtils.java $TEMPDIR
cp ../../core/CacheFile.java $TEMPDIR

echo generate java files
java -jar $ANTLR $ANTLROPT $LEXER
java -jar $ANTLR $ANTLROPT $PARSER

echo compile generated java files
javac -cp $ANTLR:$CACHEDB:$CACHEJDBC -s $TEMPDIR -d $TEMPDIR ${TEMPDIR}*.java

echo TestRig
java -cp $ANTLR:${TEMPDIR} org.antlr.v4.runtime.misc.TestRig ${PACKAGE}.cls prog $EXAMPLE -tokens $1

java -cp $ANTLR:$CACHEDB:$CACHEJDBC:${TEMPDIR} org.nbstudio.core.cls.CLSParserListerer4Save  < $EXAMPLE

