package tripleo.vendor.antlr277;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.7/antlr/TokenRangeElement.java#2 $
 */

class TokenRangeElement extends AlternativeElement {
    protected int begin = Token.INVALID_TYPE;
    protected int end = Token.INVALID_TYPE;
    protected String beginText;
    protected String endText;
    String label;

    public TokenRangeElement(Grammar g, Token t1, Token t2, int autoGenType) {
        super(g, t1, autoGenType);
        begin = grammar.tokenManager.getTokenSymbol(t1.getText()).getTokenType();
        beginText = t1.getText();
        end = grammar.tokenManager.getTokenSymbol(t2.getText()).getTokenType();
        endText = t2.getText();
        line = t1.getLine();
    }

    public void generate() {
        grammar.generator.gen(this);
    }

    public Lookahead look(int k) {
        return grammar.theLLkAnalyzer.look(k, this);
    }

    public String toString() {
        if (label != null) {
            return " " + label + ":" + beginText + ".." + endText;
        } else {
            return " " + beginText + ".." + endText;
        }
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label_) {
        label = label_;
    }
}
