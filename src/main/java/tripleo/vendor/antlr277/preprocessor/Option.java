package tripleo.vendor.antlr277.preprocessor;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.7/antlr/preprocessor/Option.java#2 $
 */

class Option {
    protected String name;
    protected String rhs;
    protected Grammar enclosingGrammar;

    public Option(String n, String rhs, Grammar gr) {
        name = n;
        this.rhs = rhs;
        setEnclosingGrammar(gr);
    }

    public Grammar getEnclosingGrammar() {
        return enclosingGrammar;
    }

    public void setEnclosingGrammar(Grammar g) {
        enclosingGrammar = g;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getRHS() {
        return rhs;
    }

    public void setRHS(String rhs) {
        this.rhs = rhs;
    }

    public String toString() {
        return "\t" + name + "=" + rhs;
    }
}
