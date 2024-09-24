package org.express.router.PathConverter.Tokens;

public final class Text implements Token {
    public final String value;

    public Text(String value) {
        this.value = value;
    }

    public String getType() {
        return "text";
    }
}
