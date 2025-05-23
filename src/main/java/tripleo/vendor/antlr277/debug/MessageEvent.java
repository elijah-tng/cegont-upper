package tripleo.vendor.antlr277.debug;

public class MessageEvent extends Event {
    public static int WARNING = 0;
    public static int ERROR = 1;
    private String text;

    public MessageEvent(Object source) {
        super(source);
    }

    public MessageEvent(Object source, int type, String text) {
        super(source);
        setValues(type, text);
    }

    /** This should NOT be called from anyone other than ParserEventSupport! */
    void setValues(int type, String text) {
        super.setValues(type);
        setText(text);
    }

    public String toString() {
        return "ParserMessageEvent [" + (getType() == WARNING ? "warning," : "error,") + getText() + "]";
    }

    public String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }
}
