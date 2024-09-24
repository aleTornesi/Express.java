package org.express.router.PathConverter;

import org.express.router.PathConverter.Tokens.Text;
import org.express.router.PathConverter.Tokens.Parameter;
import org.express.router.PathConverter.Tokens.Token;
import org.express.router.PathConverter.Tokens.Wildcard;
import org.express.router.PathConverter.Tokens.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Parser {

    public static List<Token> parse(String str) {
        var consumer = new Consumer(str);
        return Collections.unmodifiableList(consume(consumer, "END"));
    }

    private static List<Token> consume(Consumer consumer, String endTokenType) {
        var tokens = new ArrayList<Token>();
        while (true) {
            var path = consumer.text();
            if (!path.isEmpty()) {
                tokens.add(new Text(path));
            }

            var paramName = consumer.tryConsume("PARAM");
            if (paramName != null) {
                tokens.add(new Parameter(paramName));
                continue;
            }

            var wildcard = consumer.tryConsume("WILDCARD");
            if (wildcard != null) {
                tokens.add(new Wildcard(wildcard));
                continue;
            }

            if(consumer.tryConsume("{") != null) {
                tokens.add(new Group(consume(consumer, "}")));
                continue;
            }

            consumer.consume(endTokenType);
            return tokens;
        }
    }
    
}
