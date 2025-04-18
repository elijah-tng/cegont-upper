package tripleo.vendor.antlr277;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.7/antlr/CommonASTWithHiddenTokens.java#2 $
 */

import tripleo.vendor.antlr277.collections.*;

/** A CommonAST whose initialization copies hidden token
 *  information from the Token used to create a node.
 */
public class CommonASTWithHiddenTokens extends CommonAST {
    protected CommonHiddenStreamToken hiddenBefore, hiddenAfter; // references to hidden tokens

    public CommonASTWithHiddenTokens() {
        super();
    }

    public CommonASTWithHiddenTokens(Token tok) {
        super(tok);
    }

    public void initialize(AST t) {
        hiddenBefore = ((CommonASTWithHiddenTokens) t).getHiddenBefore();
        hiddenAfter = ((CommonASTWithHiddenTokens) t).getHiddenAfter();
        super.initialize(t);
    }

    public CommonHiddenStreamToken getHiddenBefore() {
        return hiddenBefore;
    }

    public CommonHiddenStreamToken getHiddenAfter() {
        return hiddenAfter;
    }

    public void initialize(Token tok) {
        CommonHiddenStreamToken t = (CommonHiddenStreamToken) tok;
        super.initialize(t);
        hiddenBefore = t.getHiddenBefore();
        hiddenAfter = t.getHiddenAfter();
    }
}
