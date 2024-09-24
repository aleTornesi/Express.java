package org.express.router.PathConverter;

public class Consumer {
    private LexToken peeked;
    private final Lexer lexer;

    public Consumer(String str) {
        this.lexer = new Lexer(str);
    }
    
    public LexToken peek() {
        if (this.peeked == null) {
            this.peeked = this.lexer.next();
        }
        return this.peeked;
    }
    
    public String tryConsume(String type) {
        if (!this.peek().type.equals(type)) {
            return null;
        }
        var token = this.peek();
        this.peeked = null;
        return token.value;
    }

    public String consume(String type) {
        var token = this.tryConsume(type);
        if (token != null) {
            return token;
        }
        throw new IllegalArgumentException("Unexpected token: " + this.peek().type + " at index " + this.peek().index);
    }

    public String text() {
        var sb = new StringBuilder();
        String value;
        while ((value = this.tryConsume("CHAR")) != null || this.tryConsume("ESCAPED") != null) {
            sb.append(value);
        }
        return sb.toString();
    }
}
