package org.express.router.PathConverter;

import java.util.Iterator;
import java.util.regex.Pattern;


public class Lexer implements Iterator<LexToken> {
    private static final Pattern START = Pattern.compile("/^[$_\\p{ID_Start}]$/u");
    private static final Pattern CONTINUE = Pattern.compile("/^[$\\u200c\\u200d\\p{ID_Continue}]$/u");
    private static final char[] SIMPLE_TOKENS = { '{', '}', '(', ')', '[', ']', '+', '?', '!' };

    private int index;
    private char[] chars;

    public Lexer(String path) {
        this.chars = path.toCharArray();
        this.index = 0;
    }

    private String getName(char[] chars) {
        var value = "";

        if(START.matcher(String.valueOf(chars[++index])).find()) {
            value += chars[index];
            while(CONTINUE.matcher(String.valueOf(chars[++index])).find()) {
                value += chars[index];
            }
        } else if (chars[index] == '"') {
            var pos = index;

            while (index < chars.length) {
                if (chars[++index] == '"') {
                    index++;
                    pos = 0;
                    break;
                }

                if (chars[index] == '\\') {
                    value += chars[++index];
                } else {
                    value += chars[index];
                }
            }

            if (pos != 0) {
                throw new IllegalArgumentException("Unclosed quote");
            }
        }
        
        if(value.isEmpty()) {
            throw new IllegalArgumentException("Unexpected token");
        }

        return value;
    }

    @Override
    public boolean hasNext() {
        return this.index <= this.chars.length;
    }

    @Override
    public LexToken next() {
        if(this.index == this.chars.length) {
            return new LexToken("END", this.index++, "");
        }
        var c = this.chars[this.index];
        boolean isSimpleToken = false;
        for(var token : SIMPLE_TOKENS) {
            if(token == c) {
                isSimpleToken = true;
                break;
            }
        }
        if (isSimpleToken) {
            return new LexToken(String.valueOf(c), this.index++, String.valueOf(c));
        }
        if (c == '\\') {
            return new LexToken("ESCAPED", this.index++, String.valueOf(c));
        }
        if (c == ':') {
            return new LexToken("PARAM", this.index++, getName(this.chars));
        }
        if (c == '*') {
            return new LexToken("WILDCARD", this.index++, getName(this.chars));
        }
        if (c == '}') {
            return new LexToken("END", this.index++, "}");
        }

        return new LexToken("CHAR", this.index++, String.valueOf(c));
    }
}
