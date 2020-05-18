package com.company;

public enum Answer
{
    ALLOWED("Allowed"),
    FORBIDDEN("Forbidden"),
    CHECK("");

    private String str;

    Answer(String name)
    {
        this.str = name;
    }

    String getString()
    {
        return str;
    }
}
