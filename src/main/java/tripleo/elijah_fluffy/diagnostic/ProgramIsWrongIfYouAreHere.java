package tripleo.elijah_fluffy.diagnostic;

public class ProgramIsWrongIfYouAreHere extends RuntimeException {
	public ProgramIsWrongIfYouAreHere() {
	}

	public ProgramIsWrongIfYouAreHere(String message) {
		super(message);
	}

	public ProgramIsWrongIfYouAreHere(String message, Throwable cause) {
		super(message, cause);
	}

	public ProgramIsWrongIfYouAreHere(Throwable cause) {
		super(cause);
	}

	public ProgramIsWrongIfYouAreHere(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
