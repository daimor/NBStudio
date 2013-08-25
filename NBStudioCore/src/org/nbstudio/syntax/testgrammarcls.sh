
ANTLR=../../../../release/modules/ext/antlr-4.1-complete.jar
LEXER=clsLexer.g4
PARSER=clsParser.g4
PACKAGE=org.nbstudio.syntax
TEMPDIR=/tmp/antlrtestgrammar/
#-no-visitor -no-listener
ANTLROPT=" -o $TEMPDIR"
EXAMPLE=clsExample.cls

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
cp clsMyParserListener.java $TEMPDIR

echo generate java files
java -jar $ANTLR $ANTLROPT $LEXER
java -jar $ANTLR $ANTLROPT $PARSER

echo compile generated java files
javac -cp $ANTLR -s $TEMPDIR -d $TEMPDIR ${TEMPDIR}*.java

echo TestRig
java -cp $ANTLR:${TEMPDIR} org.antlr.v4.runtime.misc.TestRig ${PACKAGE}.cls prog $EXAMPLE -tokens $1
