package tripleo.vendor.antlr277;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 */

/** This token knows what index 0..n-1 it is from beginning of stream.
 *  Designed to work with TokenStreamRewriteEngine.java
 */
public class TokenWithIndex extends CommonToken {
    /** Index into token array indicating position in input stream */
    int index;

    public TokenWithIndex() {
        super();
    }

    public TokenWithIndex(int i, String t) {
        super(i, t);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int i) {
        index = i;
    }

    public String toString() {
        return "[" + index + ":\"" + getText() + "\",<" + getType() + ">,line=" + line + ",col=" + col + "]\n";
    }
}
