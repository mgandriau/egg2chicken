MDIR=../../../../../../workspace-egg-2015/mg.egg.eggc-cmd-mig/
# les jars associes
MJAR=$(MDIR)eggcx.jar

EDIR=../../../../../../egg-new-syntax/src/
EGGJAR=$(EDIR)eggc.jar
ODIR=./
OUTJAR=$(ODIR)eggc-5.4.0.jar
JDIR=/usr/bin
JOPTS=-O -source 1.6 -target 1.6 -Xlint:unchecked -encoding UTF-8
JAVAC=$(JDIR)/javac $(JOPTS)
JAVA=$(JDIR)/java
JAR=$(JDIR)/jar
JAVADOC=$(JDIR)/javadoc

# langages
XLANG=EGG
OLANG=OPTION
LLANG=LACTION
ELANG=EXPREG

#################

all : ljava chk package legg class comp jar

ljava: 
	$(JAVAC) -classpath . mg/egg/eggc/runtime/libjava/*.java
	$(JAVAC) -classpath . mg/egg/eggc/runtime/libjava/lex/*.java
	$(JAVAC) -classpath . mg/egg/eggc/runtime/libjava/problem/*.java
	$(JAVAC) -classpath . mg/egg/eggc/runtime/libjava/messages/*.java

legg: 
	$(JAVAC) -classpath . \
	mg/egg/eggc/internal/dst/*.java \
	mg/egg/eggc/compiler/libegg/base/*.java \
	mg/egg/eggc/compiler/libegg/java/*.java \
	mg/egg/eggc/compiler/libegg/jlex/*.java \
	mg/egg/eggc/compiler/libegg/type/*.java \
	mg/egg/eggc/compiler/libegg/egg/*.java \
	mg/egg/eggc/compiler/libegg/latex/*.java

chk :
	cd mg/egg/eggc/compiler/mig && \
	$(JAVA) -cp ../$(MJAR) mg.egg.eggc.compiler.EGGC $(XLANG).egg && \
        cp egg/$(XLANG).egg ../egg && \
	$(JAVA) -cp ../$(MJAR) mg.egg.eggc.compiler.EGGC $(OLANG).egg && \
        cp egg/$(OLANG).egg ../egg && \
	$(JAVA) -cp ../$(MJAR) mg.egg.eggc.compiler.EGGC $(LLANG).egg && \
        cp egg/$(LLANG).egg ../egg && \
	$(JAVA) -cp ../$(MJAR) mg.egg.eggc.compiler.EGGC $(ELANG).egg && \
        cp egg/$(ELANG).egg ../egg 


package:
	cd mg/egg/eggc/compiler/egg && \
	$(JAVA) -jar ../$(EGGJAR) $(XLANG).egg && \
	$(JAVA) -jar ../$(EGGJAR) $(OLANG).egg && \
	$(JAVA) -jar ../$(EGGJAR) $(LLANG).egg && \
	$(JAVA) -jar ../$(EGGJAR) $(ELANG).egg 

class: mg/egg/eggc/compiler/egg/java
	$(JAVAC) -classpath . mg/egg/eggc/compiler/egg/java/*.java

comp:
	$(JAVAC) -classpath . mg/egg/eggc/compiler/*.java 

jar: mg/egg/eggc/compiler/egg/java
	$(JAR) cmf MANIFEST.MF $(OUTJAR) \
	mg/egg/eggc/compiler/*.class \
	mg/egg/eggc/compiler/egg.dtd \
	mg/egg/eggc/internal/dst/*.class \
	mg/egg/eggc/compiler/egg/*.properties \
	mg/egg/eggc/compiler/egg/java/*.class \
	mg/egg/eggc/compiler/libegg/base/*.class \
	mg/egg/eggc/compiler/libegg/java/*.class  \
	mg/egg/eggc/compiler/libegg/jlex/*.class \
	mg/egg/eggc/compiler/libegg/type/*.class \
	mg/egg/eggc/compiler/libegg/egg/*.class \
	mg/egg/eggc/compiler/libegg/latex/*.class \
	mg/egg/eggc/runtime/libjava/*.class \
	mg/egg/eggc/runtime/libjava/lex/*.class \
	mg/egg/eggc/runtime/libjava/problem/*.class \
	mg/egg/eggc/runtime/libjava/messages/*.class \
	mg/egg/eggc/runtime/libjava/messages/*.properties

clean:
	rm -rf \
	$(OUTJAR) \
	mg/egg/eggc/compiler/egg/java \
	mg/egg/eggc/internal/dst/*.class \
	mg/egg/eggc/compiler/*.class \
	mg/egg/eggc/compiler/libegg/base/*.class \
	mg/egg/eggc/compiler/libegg/java/*.class  \
	mg/egg/eggc/compiler/libegg/jlex/*.class \
	mg/egg/eggc/compiler/libegg/type/*.class \
	mg/egg/eggc/compiler/libegg/egg/*.class \
	mg/egg/eggc/compiler/libegg/latex/*.class \
	mg/egg/eggc/runtime/libjava/*.class \
	mg/egg/eggc/runtime/libjava/lex/*.class \
	mg/egg/eggc/runtime/libjava/problem/*.class \
	mg/egg/eggc/runtime/libjava/messages/*.class
