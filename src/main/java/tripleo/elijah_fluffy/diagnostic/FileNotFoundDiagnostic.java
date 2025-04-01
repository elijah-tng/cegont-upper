package tripleo.elijah_fluffy.diagnostic;

import org.jetbrains.annotations.*;

import java.io.*;
import java.util.*;

public class FileNotFoundDiagnostic implements ElDiagnostic {
	private final File f;

	public FileNotFoundDiagnostic(final File aLocal_prelude) {
		f = aLocal_prelude;
	}

	@Override
	public String code() {
		return "9004";
	}

	@Override
	public Severity severity() {
		return Severity.INFO;
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
		stream.println(code() + " File not found " + f.toString());
	}
}
