package org.express.router.PathConverter.Tokens;

import java.util.Collections;
import java.util.List;

public final class Group implements Token {
    public final List<Token> tokens;

    public Group(List<Token> tokens) {
        this.tokens = Collections.unmodifiableList(tokens);
    }

    public String getType() {
        return "group";
    }
}
