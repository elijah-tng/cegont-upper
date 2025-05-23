package tripleo.vendor.antlr277.debug;

public class ParserMatchEvent extends GuessingEvent {
    // NOTE: for a mismatch on type STRING, the "text" is used as the lookahead
    //       value.  Normally "value" is this
    public static int TOKEN = 0;
    public static int BITSET = 1;
    public static int CHAR = 2;
    public static int CHAR_BITSET = 3;
    public static int STRING = 4;
    public static int CHAR_RANGE = 5;
    private boolean inverse;
    private boolean matched;
    private Object target;
    private int value;
    private String text;

    public ParserMatchEvent(Object source) {
        super(source);
    }

    public ParserMatchEvent(
            Object source,
            int type,
            int value,
            Object target,
            String text,
            int guessing,
            boolean inverse,
            boolean matched) {
        super(source);
        setValues(type, value, target, text, guessing, inverse, matched);
    }

    /** This should NOT be called from anyone other than ParserEventSupport! */
    void setValues(int type, int value, Object target, String text, int guessing, boolean inverse, boolean matched) {
        super.setValues(type, guessing);
        setValue(value);
        setTarget(target);
        setInverse(inverse);
        setMatched(matched);
        setText(text);
    }

    public String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }

    public String toString() {
        return "ParserMatchEvent [" + (isMatched() ? "ok," : "bad,")
                + (isInverse() ? "NOT " : "")
                + (getType() == TOKEN ? "token," : "bitset,")
                + getValue()
                + "," + getTarget() + "," + getGuessing() + "]";
    }

    public boolean isMatched() {
        return matched;
    }

    public boolean isInverse() {
        return inverse;
    }

    public int getValue() {
        return value;
    }

    public Object getTarget() {
        return target;
    }

    void setTarget(Object target) {
        this.target = target;
    }

    void setValue(int value) {
        this.value = value;
    }

    void setInverse(boolean inverse) {
        this.inverse = inverse;
    }

    void setMatched(boolean matched) {
        this.matched = matched;
    }
}
