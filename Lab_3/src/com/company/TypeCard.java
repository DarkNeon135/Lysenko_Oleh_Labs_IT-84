package com.company;

public enum TypeCard
{
    EXPIRATION_CARD("Карта по истичению даты"),
    NUMBER_CARD("Карта с числом поездок"),
    CUMULATIVE_CARD("Накопительная карта");

    private String text;

    TypeCard(String text)
    {
        this.text = text;
    }
    public String getText(){ return text;}
}