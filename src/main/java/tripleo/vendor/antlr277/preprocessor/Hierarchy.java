package tripleo.vendor.antlr277.preprocessor;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.7/antlr/preprocessor/Hierarchy.java#2 $
 */

import tripleo.vendor.antlr277.ANTLRException;
import tripleo.vendor.antlr277.TokenStreamException;
import tripleo.vendor.antlr277.collections.impl.IndexedVector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Hashtable;

public class Hierarchy {
    protected Grammar LexerRoot = null;
    protected Grammar ParserRoot = null;
    protected Grammar TreeParserRoot = null;
    protected Hashtable symbols; // table of grammars
    protected Hashtable files; // table of grammar files read in
    protected tripleo.vendor.antlr277.Tool antlrTool;

    public Hierarchy(tripleo.vendor.antlr277.Tool tool) {
        this.antlrTool = tool;
        LexerRoot = new Grammar(tool, "Lexer", null, null);
        ParserRoot = new Grammar(tool, "Parser", null, null);
        TreeParserRoot = new Grammar(tool, "TreeParser", null, null);
        symbols = new Hashtable(10);
        files = new Hashtable(10);

        LexerRoot.setPredefined(true);
        ParserRoot.setPredefined(true);
        TreeParserRoot.setPredefined(true);

        symbols.put(LexerRoot.getName(), LexerRoot);
        symbols.put(ParserRoot.getName(), ParserRoot);
        symbols.put(TreeParserRoot.getName(), TreeParserRoot);
    }

    public static String optionsToString(IndexedVector options) {
        String s = "options {" + System.getProperty("line.separator");
        for (Enumeration e = options.elements(); e.hasMoreElements(); ) {
            s += (Option) e.nextElement() + System.getProperty("line.separator");
        }
        s += "}" + System.getProperty("line.separator") + System.getProperty("line.separator");
        return s;
    }

    public void addGrammar(Grammar gr) {
        gr.setHierarchy(this);
        // add grammar to hierarchy
        symbols.put(gr.getName(), gr);
        // add grammar to file.
        GrammarFile f = getFile(gr.getFileName());
        f.addGrammar(gr);
    }

    public GrammarFile getFile(String fileName) {
        return (GrammarFile) files.get(fileName);
    }

    public void expandGrammarsInFile(String fileName) {
        GrammarFile f = getFile(fileName);
        for (Enumeration e = f.getGrammars().elements(); e.hasMoreElements(); ) {
            Grammar g = (Grammar) e.nextElement();
            g.expandInPlace();
        }
    }

    public Grammar findRoot(Grammar g) {
        if (g.getSuperGrammarName() == null) { // at root
            return g;
        }
        // return root of super.
        Grammar sg = g.getSuperGrammar();
        if (sg == null) return g; // return this grammar if super missing
        return findRoot(sg);
    }

    public Grammar getGrammar(String gr) {
        return (Grammar) symbols.get(gr);
    }

    public void readGrammarFile(String file) throws FileNotFoundException {
        Reader grStream = new BufferedReader(new FileReader(file));
        addGrammarFile(new GrammarFile(antlrTool, file));

        // Create the simplified grammar lexer/parser
        PreprocessorLexer ppLexer = new PreprocessorLexer(grStream);
        ppLexer.setFilename(file);
        Preprocessor pp = new Preprocessor(ppLexer);
        pp.setTool(antlrTool);
        pp.setFilename(file);

        // populate the hierarchy with class(es) read in
        try {
            pp.grammarFile(this, file);
        } catch (TokenStreamException io) {
            antlrTool.toolError("Token stream error reading grammar(s):\n" + io);
        } catch (ANTLRException se) {
            antlrTool.toolError("error reading grammar(s):\n" + se);
        }
    }

    public void addGrammarFile(GrammarFile gf) {
        files.put(gf.getName(), gf);
    }

    /** Return true if hierarchy is complete, false if not */
    public boolean verifyThatHierarchyIsComplete() {
        boolean complete = true;
        // Make a pass to ensure all grammars are defined
        for (Enumeration e = symbols.elements(); e.hasMoreElements(); ) {
            Grammar c = (Grammar) e.nextElement();
            if (c.getSuperGrammarName() == null) {
                continue; // at root: ignore predefined roots
            }
            Grammar superG = c.getSuperGrammar();
            if (superG == null) {
                antlrTool.toolError("grammar " + c.getSuperGrammarName() + " not defined");
                complete = false;
                symbols.remove(c.getName()); // super not defined, kill sub
            }
        }

        if (!complete) return false;

        // Make another pass to set the 'type' field of each grammar
        // This makes it easy later to ask a grammar what its type
        // is w/o having to search hierarchy.
        for (Enumeration e = symbols.elements(); e.hasMoreElements(); ) {
            Grammar c = (Grammar) e.nextElement();
            if (c.getSuperGrammarName() == null) {
                continue; // ignore predefined roots
            }
            c.setType(findRoot(c).getName());
        }

        return true;
    }

    public tripleo.vendor.antlr277.Tool getTool() {
        return antlrTool;
    }

    public void setTool(tripleo.vendor.antlr277.Tool antlrTool) {
        this.antlrTool = antlrTool;
    }
}
