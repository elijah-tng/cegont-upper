package tripleo.elijah_fluffy.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Ok {
    @SuppressWarnings("InstantiationOfUtilityClass") //
    private static final Ok ok = new Ok();

    @NotNull
    @Contract(pure = true)
    public static Ok instance() {
        return ok;
    }

    private Ok() {
    }
}

//
//
//
