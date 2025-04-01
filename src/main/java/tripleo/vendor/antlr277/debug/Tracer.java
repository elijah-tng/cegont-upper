package tripleo.vendor.antlr277.debug;

public class Tracer extends TraceAdapter implements TraceListener {
    String indent = ""; // TBD: should be StringBuffer

    public void enterRule(TraceEvent e) {
        System.out.println(indent + e);
        indent();
    }

    public void exitRule(TraceEvent e) {
        dedent();
        System.out.println(indent + e);
    }

    protected void dedent() {
        if (indent.length() < 2) indent = "";
        else indent = indent.substring(2);
    }

    protected void indent() {
        indent += "  ";
    }
}
