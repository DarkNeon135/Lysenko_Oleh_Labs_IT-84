package com.company;

public enum Answer
{
    ALLOWED("ДОЗВОЛЕНО"),
    FORBIDDEN("ЗОБОРОНЕНО"),
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
