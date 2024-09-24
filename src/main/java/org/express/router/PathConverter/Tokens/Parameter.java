package org.express.router.PathConverter.Tokens;

public final class Parameter implements Token, Key {
    public final String value;

    public Parameter(String value) {
        this.value = value;
    }

    public String getType() {
        return "param";
    }
}
