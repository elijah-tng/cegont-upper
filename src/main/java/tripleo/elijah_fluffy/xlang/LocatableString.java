package tripleo.elijah_fluffy.xlang;

import tripleo.elijah_fluffy.diagnostic.ElLocatable;
import tripleo.vendor.antlr277.Token;

import java.io.File;
import java.util.Objects;

public interface LocatableString {
    static LocatableString of(Token aToken) {
        return new LocatableString() {
            @Override
            public String asLocatableString() {
                return aToken.getText();
            }

            @Override
            public ElLocatable getLocatable() {
                return new ElLocatable() {
                    @Override
                    public int getLine() {
                        return aToken.getLine();
                    }

                    @Override
                    public int getColumn() {
                        return aToken.getColumn();
                    }

                    @Override
                    public int getLineEnd() {
                        return aToken.getLine();
                    }

                    @Override
                    public int getColumnEnd() {
                        return aToken.getColumn() + asLocatableString().length(); // ?!
                    }

                    @Override
                    public File getFile() {
                        return new File(aToken.getFilename());
                    }

                    @Override
                    public LocatableKind getLocatableKind() {
                        return LocatableKind.TextSpan;
                    }
                };
            }

            @Override
            public boolean hasLocation() {
                return true;
            }
        };
    }

    static LocatableString of(String aAbsolutePath) {
        return new LocatableString() {
            @Override
            public String asLocatableString() {
                return aAbsolutePath;
            }

            @Override
            public ElLocatable getLocatable() {
                return null;
            }

            @Override
            public boolean hasLocation() {
                return false;
            }
        };
    }

    String asLocatableString();

    // Token asLocatableToken();
    // boolean isToken();
    ElLocatable getLocatable();

    boolean hasLocation();

    default boolean sameString(String aName) {
        return Objects.equals(aName, asLocatableString());
    }
}
