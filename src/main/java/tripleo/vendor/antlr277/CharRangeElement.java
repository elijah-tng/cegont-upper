package tripleo.vendor.antlr277;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.7/antlr/CharRangeElement.java#2 $
 */

class CharRangeElement extends AlternativeElement {
    protected char begin = 0;
    protected char end = 0;
    protected String beginText;
    protected String endText;
    String label;

    public CharRangeElement(LexerGrammar g, Token t1, Token t2, int autoGenType) {
        super(g);
        begin = (char) ANTLRLexer.tokenTypeForCharLiteral(t1.getText());
        beginText = t1.getText();
        end = (char) ANTLRLexer.tokenTypeForCharLiteral(t2.getText());
        endText = t2.getText();
        line = t1.getLine();
        // track which characters are referenced in the grammar
        for (int i = begin; i <= end; i++) {
            g.charVocabulary.add(i);
        }
        this.autoGenType = autoGenType;
    }

    public void generate() {
        grammar.generator.gen(this);
    }

    public Lookahead look(int k) {
        return grammar.theLLkAnalyzer.look(k, this);
    }

    public String toString() {
        if (label != null) return " " + label + ":" + beginText + ".." + endText;
        else return " " + beginText + ".." + endText;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label_) {
        label = label_;
    }
}
