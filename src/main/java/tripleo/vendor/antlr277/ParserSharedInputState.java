package tripleo.vendor.antlr277;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.7/antlr/ParserSharedInputState.java#2 $
 */

/** This object contains the data associated with an
 *  input stream of tokens.  Multiple parsers
 *  share a single ParserSharedInputState to parse
 *  the same stream of tokens.
 */
public class ParserSharedInputState {
    /** Are we guessing (guessing>0)? */
    public int guessing = 0;
    /** Where to get token objects */
    protected TokenBuffer input;
    /** What file (if known) caused the problem? */
    protected String filename;

    public void reset() {
        guessing = 0;
        filename = null;
        input.reset();
    }

    public String getFilename() {
        return filename;
    }

    public TokenBuffer getInput() {
        return input;
    }
}
