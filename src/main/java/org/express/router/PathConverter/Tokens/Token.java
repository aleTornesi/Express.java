package org.express.router.PathConverter.Tokens;



public sealed interface Token permits Text, Parameter, Wildcard, Group {
    public String getType();
}
