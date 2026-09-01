package tripleo.elijah_fluffy.anno;

public class NeverReached extends RuntimeException {
	public NeverReached() {
	}

	public NeverReached(String message) {
		super(message);
	}

	public NeverReached(String message, Throwable cause) {
		super(message, cause);
	}

	public NeverReached(Throwable cause) {
		super(cause);
	}

	public NeverReached(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
