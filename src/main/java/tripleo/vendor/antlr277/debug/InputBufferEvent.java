package tripleo.vendor.antlr277.debug;

public class InputBufferEvent extends Event {
    public static final int CONSUME = 0;
    public static final int LA = 1;
    public static final int MARK = 2;
    public static final int REWIND = 3;
    char c;
    int lookaheadAmount; // amount of lookahead

    /**
     * CharBufferEvent constructor comment.
     * @param source java.lang.Object
     */
    public InputBufferEvent(Object source) {
        super(source);
    }
    /**
     * CharBufferEvent constructor comment.
     * @param source java.lang.Object
     */
    public InputBufferEvent(Object source, int type, char c, int lookaheadAmount) {
        super(source);
        setValues(type, c, lookaheadAmount);
    }

    /** This should NOT be called from anyone other than ParserEventSupport! */
    void setValues(int type, char c, int la) {
        super.setValues(type);
        setChar(c);
        setLookaheadAmount(la);
    }

    public String toString() {
        return "CharBufferEvent [" + (getType() == CONSUME ? "CONSUME, " : "LA, ")
                + getChar()
                + "," + getLookaheadAmount() + "]";
    }

    public char getChar() {
        return c;
    }

    public int getLookaheadAmount() {
        return lookaheadAmount;
    }

    void setLookaheadAmount(int la) {
        this.lookaheadAmount = la;
    }

    void setChar(char c) {
        this.c = c;
    }
}
