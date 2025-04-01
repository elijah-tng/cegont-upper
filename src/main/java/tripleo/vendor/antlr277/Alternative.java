package tripleo.vendor.antlr277;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.7/antlr/Alternative.java#2 $
 */

/** Intermediate data class holds information about an alternative */
class Alternative {
    // Syntactic predicate block if non-null
    protected SynPredBlock synPred;
    // Semantic predicate action if non-null
    protected String semPred;
    // Exception specification if non-null
    protected ExceptionSpec exceptionSpec;
    // Init action if non-null;
    protected Lookahead[] cache; // lookahead for alt.  Filled in by
    // deterministic() only!!!!!!!  Used for
    // code gen after calls to deterministic()
    // and used by deterministic for (...)*, (..)+,
    // and (..)? blocks.  1..k
    protected int lookaheadDepth; // each alt has different look depth possibly.
    // depth can be NONDETERMINISTIC too.
    // 0..n-1
    // If non-null, Tree specification ala -> A B C (not implemented)
    protected Token treeSpecifier = null;
    // Tracking alternative linked list
    AlternativeElement head; // head of alt element list
    AlternativeElement tail; // last element added
    // True of AST generation is on for this alt
    private boolean doAutoGen;

    public Alternative() {}

    public Alternative(AlternativeElement firstElement) {
        addElement(firstElement);
    }

    public void addElement(AlternativeElement e) {
        // Link the element into the list
        if (head == null) {
            head = tail = e;
        } else {
            tail.next = e;
            tail = e;
        }
    }

    public boolean atStart() {
        return head == null;
    }

    public boolean getAutoGen() {
        // Don't build an AST if there is a tree-rewrite-specifier
        return doAutoGen && treeSpecifier == null;
    }

    public void setAutoGen(boolean doAutoGen_) {
        doAutoGen = doAutoGen_;
    }

    public Token getTreeSpecifier() {
        return treeSpecifier;
    }
}
