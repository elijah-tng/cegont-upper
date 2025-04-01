package tripleo.elijah_fluffy.util;

import org.jetbrains.annotations.*;

import java.util.*;

public class ReadySupplier_1<T> implements ReadySupplier<T> {
	private final T t;

	public ReadySupplier_1(final @NotNull T aT) {
		// README why supply a NULL??
		t = Objects.requireNonNull(aT);
	}

	@Override
	public T get() {
		if (!ready()) {
			throw new IllegalStateException("not ready"); // FIXME move this
		}
		return t;
	}

	@Override
	public boolean ready() {
		return t != null;
	}
}
