package org.express.router.PathConverter;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.function.Function;

import org.express.router.PathConverter.Tokens.Token;
import org.express.router.PathConverter.Tokens.Key;

import java.util.ArrayList;

public class PathConverter {

    private static final String DEFAULT_DELIMITER = "/";

    public static String match(String path) {
        var decode = options.decode() == null ? DEFAULT_DECODE : options.decode();
        var delimiter = options.delimiter() == null ? "/" : options.delimiter();
    }

    public static String match(Token[] path) {
    }
    
    private static Object pathToRegex(Token[] paths, String delimiter, boolean end, boolean sensitive, boolean trailing) {
        var keys = new ArrayList<Key>();
        var sources = new ArrayList<String>();

        return null;
    }

}
