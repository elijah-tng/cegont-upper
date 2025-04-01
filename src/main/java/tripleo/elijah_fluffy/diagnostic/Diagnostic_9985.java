package tripleo.elijah_fluffy.diagnostic;

import org.jetbrains.annotations.*;

import java.io.*;
import java.util.*;

public class Diagnostic_9985 implements ElDiagnostic {
	private final ElLocatable locatable;
	private final File        file;

	public Diagnostic_9985(final ElLocatable aLocatable, final File aFile) {
		locatable = aLocatable;
		file      = aFile;
	}

	public Diagnostic_9985(final File aFile) {
		locatable = null;
		file      = aFile;
	}

	@Override
	public String code() {
		return "9995";
	}

	@Override
	public Severity severity() {
		return Severity.ERROR;
	}

	@Override
	public @NotNull ElLocatable primary() {
		return locatable;
	}

	@Override
	public @NotNull List<ElLocatable> secondary() {
		return List.of();
	}

	@Override
	public void report(final PrintStream stream) {
		final String path = file.getAbsolutePath();
		final String s = "9985 Not a directory " + path;
		stream.println(s);
	}
}
