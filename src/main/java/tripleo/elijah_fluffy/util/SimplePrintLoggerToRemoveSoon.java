package tripleo.elijah_fluffy.util;


public class SimplePrintLoggerToRemoveSoon {

	private static final boolean DEBUG_ON = false;

	public static void println_err(final String aS) {
		if (DEBUG_ON) System.err.println(aS);
	}

	public static void println_out(final String aS) {
		if (DEBUG_ON) System.out.println(aS);
	}

	public static void println2(final String aS) {
		if (DEBUG_ON) System.out.println("" + aS);
	}

	public static void println_err2(final String aS) {
		if (DEBUG_ON) System.err.println("" + aS);
	}

	public static void println_out_2(final String aS) {
		if (DEBUG_ON) System.out.println("" + aS);
	}

	/*
	 * Make a note of workarounds
	 */
	public static void ilf(final String aS) {
		System.out.println("[ilf] " + aS);
	}
}
