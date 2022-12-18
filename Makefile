JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		Jgui.java

ENTRY = Jgui

default: $(CLASSES:.java=.class)

.PHONY: clean run

clean:
	$(RM) *.class

run:
	java $(ENTRY)
