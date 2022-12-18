JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		Jgui.java

default: $(CLASSES:.java=.class)

.PHONY: clean

clean:
	$(RM) *.class
