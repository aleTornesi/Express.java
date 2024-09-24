package org.express.router.PathConverter.Tokens;

public final class Wildcard implements Token, Key {
    public final String value;

    public Wildcard(String value) {
        this.value = value;
    }

    public String getType() {
        return "wildcard";
    }
}
