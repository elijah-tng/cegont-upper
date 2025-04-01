package tripleo.vendor.antlr277;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.7/antlr/LexerSharedInputState.java#2 $
 */

import java.io.*;

/** This object contains the data associated with an
 *  input stream of characters.  Multiple lexers
 *  share a single LexerSharedInputState to lex
 *  the same input stream.
 */
public class LexerSharedInputState {
    public int guessing = 0;
    protected int column = 1;
    protected int line = 1;
    protected int tokenStartColumn = 1;
    protected int tokenStartLine = 1;
    protected InputBuffer input;
    /** What file (if known) caused the problem? */
    protected String filename;

    public LexerSharedInputState(InputStream in) {
        this(new ByteBuffer(in));
    }

    public LexerSharedInputState(InputBuffer inbuf) {
        input = inbuf;
    }

    public LexerSharedInputState(Reader in) {
        this(new CharBuffer(in));
    }

    public String getFilename() {
        return filename;
    }

    public InputBuffer getInput() {
        return input;
    }

    public int getLine() {
        return line;
    }

    public int getTokenStartColumn() {
        return tokenStartColumn;
    }

    public int getTokenStartLine() {
        return tokenStartLine;
    }

    public int getColumn() {
        return column;
    }

    public void reset() {
        column = 1;
        line = 1;
        tokenStartColumn = 1;
        tokenStartLine = 1;
        guessing = 0;
        filename = null;
        input.reset();
    }
}
