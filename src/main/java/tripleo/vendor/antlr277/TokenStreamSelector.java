package tripleo.vendor.antlr277;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.cs.usfca.edu
 * Software rights: http://www.tripleo.vendor.antlr277.org/license.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.7/antlr/TokenStreamSelector.java#2 $
 */

import tripleo.vendor.antlr277.ASdebug.*;
import tripleo.vendor.antlr277.collections.Stack;
import tripleo.vendor.antlr277.collections.impl.*;

import java.util.*;

/** A token stream MUX (multiplexor) knows about n token streams
 *  and can multiplex them onto the same channel for use by token
 *  stream consumer like a parser.  This is a way to have multiple
 *  lexers break up the same input stream for a single parser.
 *	Or, you can have multiple instances of the same lexer handle
 *  multiple input streams; this works great for includes.
 */
public class TokenStreamSelector implements TokenStream, IASDebugStream {
    /** The set of inputs to the MUX */
    protected Hashtable inputStreamNames;

    /** The currently-selected token stream input */
    protected TokenStream input;

    /** Used to track stack of input streams */
    protected Stack streamStack = new LList();

    public TokenStreamSelector() {
        super();
        inputStreamNames = new Hashtable();
    }

    public void addInputStream(TokenStream stream, String key) {
        inputStreamNames.put(key, stream);
    }

    /** Return the stream from tokens are being pulled at
     *  the moment.
     */
    public TokenStream getCurrentStream() {
        return input;
    }

    public Token nextToken() throws TokenStreamException {
        // return input.nextToken();
        // keep looking for a token until you don't
        // get a retry exception.
        for (; ; ) {
            try {
                return input.nextToken();
            } catch (TokenStreamRetryException r) {
                // just retry "forever"
            }
        }
    }

    public TokenStream pop() {
        TokenStream stream = (TokenStream) streamStack.pop();
        select(stream);
        return stream;
    }

    /** Set the stream without pushing old stream */
    public void select(TokenStream stream) {
        input = stream;
    }

    public void push(TokenStream stream) {
        streamStack.push(input); // save current stream
        select(stream);
    }

    public void push(String sname) {
        streamStack.push(input);
        select(sname);
    }

    public void select(String sname) throws IllegalArgumentException {
        input = getStream(sname);
    }

    public TokenStream getStream(String sname) {
        TokenStream stream = (TokenStream) inputStreamNames.get(sname);
        if (stream == null) {
            throw new IllegalArgumentException("TokenStream " + sname + " not found");
        }
        return stream;
    }

    /** Abort recognition of current Token and try again.
     *  A stream can push a new stream (for include files
     *  for example, and then retry(), which will cause
     *  the current stream to abort back to this.nextToken().
     *  this.nextToken() then asks for a token from the
     *  current stream, which is the new "substream."
     */
    public void retry() throws TokenStreamRetryException {
        throw new TokenStreamRetryException();
    }

    public String getEntireText() {
        return ASDebugStream.getEntireText(this.input);
    }

    public TokenOffsetInfo getOffsetInfo(Token token) {
        return ASDebugStream.getOffsetInfo(this.input, token);
    }
}
