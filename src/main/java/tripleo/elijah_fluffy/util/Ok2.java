package tripleo.elijah_fluffy.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/// todo: we did something "interesting" with this somewhere,
///  see if we can integrate it; hint: LocatableKind, mostly for static checking
public class Ok2 {
    private static final Ok2 INSTANCE = new Ok2(null);

    public final String locationMarker;

    private Ok2(final String aLocationMarker) {
        locationMarker = aLocationMarker;
    }

    public static Ok2 instance() {
        return INSTANCE;
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull Ok2 not(String locationMarker) {
        return new Ok2(locationMarker);
    }

    public boolean isOk() {
        return locationMarker != null;
    }
}
