package org.express.router.PathConverter;

import java.util.Objects;

public class LexToken {
    public final String type;
    public final int index;
    public final String value;

    public LexToken(String type, int index, String value) {
        if (!isValidType(Objects.requireNonNull(type))) {
            throw new IllegalArgumentException("Invalid token type: " + type);
        }
        this.type = type;
        if(index < 0) {
            throw new IllegalArgumentException("Invalid token index: " + index);
        }
        this.index = index;
        this.value = value;
    }

    private boolean isValidType(String type) {
        return value.equals("{") || value.equals("}") || value.equals("WILDCARD") || value.equals("PARAM") 
        || value.equals("CHAR") || value.equals("ESCAPED") || value.equals("END") || value.equals("(") 
        || value.equals(")") || value.equals("[") || value.equals("]") || value.equals("+") || value.equals("?") 
        || value.equals("!");
    }
}

package org.express.router.PathConverter;

import java.util.Objects;

class LexToken {
    private final String type;
    private final int index;
    private final String value;

    public LexToken(String type, int index, String value) {
        if (!isValidType(Objects.requireNonNull(type))) {
            throw new IllegalArgumentException("Invalid token type: " + type);
        }
        this.type = type;
        if(index < 0) {
            throw new IllegalArgumentException("Invalid token index: " + index);
        }
        this.index = index;
        this.value = value;
    }

    private boolean isValidType(String type) {
        return value.equals("{") || value.equals("}") || value.equals("WILDCARD") || value.equals("PARAM") 
        || value.equals("CHAR") || value.equals("ESCAPED") || value.equals("END") || value.equals("(") 
        || value.equals(")") || value.equals("[") || value.equals("]") || value.equals("+") || value.equals("?") 
        || value.equals("!");
    }
}
