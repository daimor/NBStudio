
ANTLR=../../../../../release/modules/ext/antlr-4.4-complete.jar
LEXER=macLexer.g4
PARSER=macParser.g4
PACKAGE=org.nbstudio.syntax.mac
TEMPDIR=/tmp/antlrtestgrammar/
ANTLROPT="-no-visitor -no-listener -o $TEMPDIR"
EXAMPLE=macExample.mac

cd mac

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

echo generate java files
java -jar $ANTLR $ANTLROPT $LEXER
java -jar $ANTLR $ANTLROPT $PARSER

echo compile generated java files
javac -cp $ANTLR -s $TEMPDIR -d $TEMPDIR ${TEMPDIR}*.java

echo TestRig
java -cp $ANTLR:${TEMPDIR} org.antlr.v4.runtime.misc.TestRig ${PACKAGE}.mac prog $EXAMPLE -tokens $1
