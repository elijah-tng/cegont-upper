package tripleo.elijah_fluffy.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Ok {
    private static final Ok INSTANCE   = new Ok(null);

	public final String locationMarker;

    private Ok(final String aLocationMarker) {
        locationMarker = aLocationMarker;
    }

    public static Ok instance() {
        return INSTANCE;
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull Ok not(String locationMarker) {
        return new Ok(locationMarker);
    }

	public boolean isOk() {
		return locationMarker != null;
	}
}
