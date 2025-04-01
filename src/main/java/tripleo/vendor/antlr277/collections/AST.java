package tripleo.vendor.antlr277.collections;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.7/antlr/collections/AST.java#2 $
 */

import tripleo.vendor.antlr277.Token;

/** Minimal AST node interface used by ANTLR AST generation
 * and tree-walker.
 */
public interface AST {
    /** Add a (rightmost) child to this node */
    public void addChild(AST c);

    public boolean equals(AST t);

    public boolean equalsList(AST t);

    public boolean equalsListPartial(AST t);

    public boolean equalsTree(AST t);

    public boolean equalsTreePartial(AST t);

    public ASTEnumeration findAll(AST tree);

    public ASTEnumeration findAllPartial(AST subtree);

    /** Get the first child of this node; null if no children */
    public AST getFirstChild();

    /** Set the first child of a node. */
    public void setFirstChild(AST c);

    /** Get	the next sibling in line after this one */
    public AST getNextSibling();

    /** Set the next sibling after this one. */
    public void setNextSibling(AST n);

    /** Get the token text for this node */
    public String getText();

    /** Set the token text for this node */
    public void setText(String text);

    /** Get the token type for this node */
    public int getType();

    /** Set the token type for this node */
    public void setType(int ttype);

    /** @since 2.7.3 Need for error handling */
    public int getLine();

    /** @since 2.7.3 Need for error handling */
    public int getColumn();

    /** Get number of children of this node; if leaf, returns 0 */
    public int getNumberOfChildren();

    public void initialize(int t, String txt);

    public void initialize(AST t);

    public void initialize(Token t);

    public String toString();

    public String toStringList();

    public String toStringTree();
}
