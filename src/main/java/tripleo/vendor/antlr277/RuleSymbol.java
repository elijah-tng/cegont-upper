package tripleo.vendor.antlr277;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.7/antlr/RuleSymbol.java#2 $
 */

import tripleo.vendor.antlr277.collections.impl.*;

class RuleSymbol extends GrammarSymbol {
    RuleBlock block; // list of alternatives
    boolean   defined; // has the rule been defined yet?
    Vector    references; // list of all nodes referencing this rule
    // not strictly needed by generic symbol table
    // but we will almost always analyze/gen code
    String    access; // access specifier for this rule
    String    comment; // A javadoc comment if any.

    public RuleSymbol(String r) {
        super(r);
        references = new Vector();
    }

    public void addReference(RuleRefElement e) {
        references.appendElement(e);
    }

    public RuleBlock getBlock() {
        return block;
    }

    public void setBlock(RuleBlock rb) {
        block = rb;
    }

    public RuleRefElement getReference(int i) {
        return (RuleRefElement) references.elementAt(i);
    }

    public boolean isDefined() {
        return defined;
    }

    public int numReferences() {
        return references.size();
    }

    public void setDefined() {
        defined = true;
    }
}
