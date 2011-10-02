#!/bin/sh
# run fitnesse extracting the correct classpath from the POM

mvn dependency:build-classpath -Dmdep.outputFile=.fitnesse.classpath

export CLASSPATH=`cat .fitnesse.classpath`:target/classes:target/test-classes

exec java -cp $CLASSPATH fitnesseMain.FitNesseMain -p 9090 -d src/test/fitnesse