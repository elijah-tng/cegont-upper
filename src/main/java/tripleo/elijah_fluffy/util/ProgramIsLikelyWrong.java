package tripleo.elijah_fluffy.util;

public class ProgramIsLikelyWrong extends RuntimeException {
	public ProgramIsLikelyWrong(final String message) {
		super(message);
	}

	public ProgramIsLikelyWrong(String message, Throwable cause) {
		super(message, cause);
	}

	public ProgramIsLikelyWrong(Throwable cause) {
		super(cause);
	}

	public ProgramIsLikelyWrong(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProgramIsLikelyWrong() {
		super();
	}
}
