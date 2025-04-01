package tripleo.elijah_fluffy.util;

public class ProgramIsLikelyWrong extends RuntimeException {
	public ProgramIsLikelyWrong(final String message) {
		super(message);
	}
	public ProgramIsLikelyWrong() {
		super();
	}
}
