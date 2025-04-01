package tripleo.vendor.antlr277.debug;

public class NewLineEvent extends Event {
    private int line;

    public NewLineEvent(Object source) {
        super(source);
    }

    public NewLineEvent(Object source, int line) {
        super(source);
        setValues(line);
    }

    /** This should NOT be called from anyone other than ParserEventSupport! */
    void setValues(int line) {
        setLine(line);
    }

    public int getLine() {
        return line;
    }

    void setLine(int line) {
        this.line = line;
    }

    public String toString() {
        return "NewLineEvent [" + line + "]";
    }
}
