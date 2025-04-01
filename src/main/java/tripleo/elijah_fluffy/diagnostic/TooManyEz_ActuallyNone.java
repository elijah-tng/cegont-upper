package tripleo.elijah_fluffy.diagnostic;

import org.jetbrains.annotations.*;

import java.io.*;
import java.util.*;

public class TooManyEz_ActuallyNone implements ElDiagnostic {
	final String message = "No .ez files found.";

	@Override
	public String code() {
		return "9999";
	}

	@Override
	public Severity severity() {
		return Severity.ERROR;
	}

	@Override
	public @NotNull ElLocatable primary() {
		return null;
	}

	@Override
	public @NotNull List<ElLocatable> secondary() {
		return null;
	}

	@Override
	public void report(final PrintStream stream) {
		stream.printf("%s %s%n", code(), message);
	}
}
