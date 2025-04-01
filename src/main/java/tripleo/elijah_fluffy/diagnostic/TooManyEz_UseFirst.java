package tripleo.elijah_fluffy.diagnostic;

import org.jetbrains.annotations.*;

import java.io.*;
import java.util.*;

class TooManyEz_UseFirst implements ElDiagnostic {
	final String message = "Too many .ez files, using first.";

	@Override
	public String code() {
		return "9998";
	}

	@Override
	public Severity severity() {
		return Severity.WARN;
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
