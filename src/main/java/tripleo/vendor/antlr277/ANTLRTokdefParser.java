// $ANTLR : "tokdef.g" -> "ANTLRTokdefParser.java"$
package tripleo.vendor.antlr277;

import tripleo.vendor.antlr277.collections.impl.*;

/** Simple lexer/parser for reading token definition files
 * in support of the import/export vocab option for grammars.
 */
public class ANTLRTokdefParser extends LLkParser implements ANTLRTokdefParserTokenTypes {

    // This chunk of error reporting code provided by Brian Smith

    public static final String[] _tokenNames = {
        "<0>",
        "EOF",
        "<2>",
        "NULL_TREE_LOOKAHEAD",
        "ID",
        "STRING",
        "ASSIGN",
        "LPAREN",
        "RPAREN",
        "INT",
        "WS",
        "SL_COMMENT",
        "ML_COMMENT",
        "ESC",
        "DIGIT",
        "XDIGIT"
    };
    public static final BitSet   _tokenSet_0 = new BitSet(mk_tokenSet_0());
    public static final BitSet   _tokenSet_1 = new BitSet(mk_tokenSet_1());
    private Tool antlrTool;

    public ANTLRTokdefParser(TokenBuffer tokenBuf) {
        this(tokenBuf, 3);
    }

    protected ANTLRTokdefParser(TokenBuffer tokenBuf, int k) {
        super(tokenBuf, k);
        tokenNames = _tokenNames;
    }

    public ANTLRTokdefParser(TokenStream lexer) {
        this(lexer, 3);
    }

    protected ANTLRTokdefParser(TokenStream lexer, int k) {
        super(lexer, k);
        tokenNames = _tokenNames;
    }

    public ANTLRTokdefParser(ParserSharedInputState state) {
        super(state, 3);
        tokenNames = _tokenNames;
    }

    private static final long[] mk_tokenSet_0() {
        long[] data = {2L, 0L};
        return data;
    }

    private static final long[] mk_tokenSet_1() {
        long[] data = {50L, 0L};
        return data;
    }

    /** Delegates the error message to the tool if any was registered via
     *  {@link #initTool(tripleo.vendor.antlr277.Tool)}
     *  @since 2.7.2
     */
    public void reportError(RecognitionException e) {
        if (getTool() != null) {
            getTool().error(e.getErrorMessage(), e.getFilename(), e.getLine(), e.getColumn());
        } else {
            super.reportError(e);
        }
    }

    /** Delegates the error message to the tool if any was registered via
     *  {@link #initTool(tripleo.vendor.antlr277.Tool)}
     *  @since 2.7.2
     */
    public void reportError(String s) {
        if (getTool() != null) {
            getTool().error(s, getFilename(), -1, -1);
        } else {
            super.reportError(s);
        }
    }

    /** @since 2.7.2 */
    protected tripleo.vendor.antlr277.Tool getTool() {
        return antlrTool;
    }

    /** In order to make it so existing subclasses don't break, we won't require
     * that the tripleo.vendor.antlr277.Tool instance be passed as a constructor element. Instead,
     * the tripleo.vendor.antlr277.Tool instance should register itself via {@link #initTool(tripleo.vendor.antlr277.Tool)}
     * @throws IllegalStateException if a tool has already been registered
     * @since 2.7.2
     */
    public void setTool(tripleo.vendor.antlr277.Tool tool) {
        if (antlrTool == null) {
            antlrTool = tool;
        } else {
            throw new IllegalStateException("tripleo.vendor.antlr277.Tool already registered");
        }
    }

    /** Delegates the warning message to the tool if any was registered via
     *  {@link #initTool(tripleo.vendor.antlr277.Tool)}
     *  @since 2.7.2
     */
    public void reportWarning(String s) {
        if (getTool() != null) {
            getTool().warning(s, getFilename(), -1, -1);
        } else {
            super.reportWarning(s);
        }
    }

    public final void file(ImportVocabTokenManager tm) throws RecognitionException, TokenStreamException {

        Token name = null;

        try { // for error handling
            name = LT(1);
            match(ID);
            {
                _loop225:
                do {
                    if ((LA(1) == ID || LA(1) == STRING)) {
                        line(tm);
                    } else {
                        break _loop225;
                    }

                } while (true);
            }
        } catch (RecognitionException ex) {
            reportError(ex);
            consume();
            consumeUntil(_tokenSet_0);
        }
    }

    public final void line(ImportVocabTokenManager tm) throws RecognitionException, TokenStreamException {

        Token s1 = null;
        Token lab = null;
        Token s2 = null;
        Token id = null;
        Token para = null;
        Token id2 = null;
        Token i = null;
        Token t = null;
        Token s = null;

        try { // for error handling
            {
                if ((LA(1) == STRING)) {
                    s1 = LT(1);
                    match(STRING);
                    s = s1;
                } else if ((LA(1) == ID) && (LA(2) == ASSIGN) && (LA(3) == STRING)) {
                    lab = LT(1);
                    match(ID);
                    t = lab;
                    match(ASSIGN);
                    s2 = LT(1);
                    match(STRING);
                    s = s2;
                } else if ((LA(1) == ID) && (LA(2) == LPAREN)) {
                    id = LT(1);
                    match(ID);
                    t = id;
                    match(LPAREN);
                    para = LT(1);
                    match(STRING);
                    match(RPAREN);
                } else if ((LA(1) == ID) && (LA(2) == ASSIGN) && (LA(3) == INT)) {
                    id2 = LT(1);
                    match(ID);
                    t = id2;
                } else {
                    throw new NoViableAltException(LT(1), getFilename());
                }
            }
            match(ASSIGN);
            i = LT(1);
            match(INT);

            Integer value = Integer.valueOf(i.getText());
            // if literal found, define as a string literal
            if (s != null) {
                tm.define(s.getText(), value.intValue());
                // if label, then label the string and map label to token symbol also
                if (t != null) {
                    StringLiteralSymbol sl = (StringLiteralSymbol) tm.getTokenSymbol(s.getText());
                    sl.setLabel(t.getText());
                    tm.mapToTokenSymbol(t.getText(), sl);
                }
            }
            // define token (not a literal)
            else if (t != null) {
                tm.define(t.getText(), value.intValue());
                if (para != null) {
                    TokenSymbol ts = tm.getTokenSymbol(t.getText());
                    ts.setParaphrase(para.getText());
                }
            }

        } catch (RecognitionException ex) {
            reportError(ex);
            consume();
            consumeUntil(_tokenSet_1);
        }
    }
}
