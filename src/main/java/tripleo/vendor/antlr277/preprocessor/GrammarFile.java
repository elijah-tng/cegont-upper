package tripleo.vendor.antlr277.preprocessor;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.7/antlr/preprocessor/GrammarFile.java#2 $
 */

import tripleo.vendor.antlr277.collections.impl.*;
import tripleo.vendor.antlr277.collections.impl.*;

import java.io.*;
import java.util.*;

/** Stores header action, grammar preamble, file options, and
 *  list of grammars in the file
 */
public class GrammarFile {
    protected String fileName;
    protected String        headerAction = "";
    protected IndexedVector options;
    protected IndexedVector grammars;
    protected boolean expanded = false; // any grammars expanded within?
    protected tripleo.vendor.antlr277.Tool tool;

    public GrammarFile(tripleo.vendor.antlr277.Tool tool, String f) {
        fileName = f;
        grammars = new IndexedVector();
        this.tool = tool;
    }

    public void addGrammar(Grammar g) {
        grammars.appendElement(g.getName(), g);
    }

    public void generateExpandedFile() throws IOException {
        if (!expanded) {
            return; // don't generate if nothing got expanded
        }
        String expandedFileName = nameForExpandedGrammarFile(this.getName());

        // create the new grammar file with expanded grammars
        PrintWriter expF = tool.openOutputFile(expandedFileName);
        expF.println(toString());
        expF.close();
    }

    public String nameForExpandedGrammarFile(String f) {
        if (expanded) {
            // strip path to original input, make expanded file in current dir
            return "expanded" + tool.fileMinusPath(f);
        } else {
            return f;
        }
    }

    public String getName() {
        return fileName;
    }

    public String toString() {
        String h = headerAction == null ? "" : headerAction;
        String o = options == null ? "" : Hierarchy.optionsToString(options);

        StringBuffer s = new StringBuffer(10000);
        s.append(h);
        s.append(o);
        for (Enumeration e = grammars.elements(); e.hasMoreElements(); ) {
            Grammar g = (Grammar) e.nextElement();
            s.append(g.toString());
        }
        return s.toString();
    }

    public IndexedVector getGrammars() {
        return grammars;
    }

    public void setExpanded(boolean exp) {
        expanded = exp;
    }

    public void addHeaderAction(String a) {
        headerAction += a + System.getProperty("line.separator");
    }

    public void setOptions(IndexedVector o) {
        options = o;
    }
}
