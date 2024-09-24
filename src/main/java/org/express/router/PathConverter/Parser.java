package org.express.router.PathConverter;

public class Parser {

    public static List<Token> parse(String str) {
        var consumer = new Consumer(str);
    }

    private static List<Token> consume(Consumer consumer, String endTokenType) {
        var tokens = new ArrayList<Token>();
        while (true) {
            var path = consumer.text();
            if (!path.isEmpty()) {
                tokens.add(new Token("TEXT", path));
            }
            if (token.type.equals(endTokenType)) {
                break;
            }
            tokens.add(token);
            consumer.consume();
        }
    }
    
}
