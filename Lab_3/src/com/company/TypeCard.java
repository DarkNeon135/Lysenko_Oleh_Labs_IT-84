package com.company;

public enum TypeCard
{
    EXPIRATION_CARD("Картка з терміном дії"),
    NUMBER_CARD("Картка із кількістю поїздок"),
    CUMULATIVE_CARD("Накопичувальна картка");

    private String text;

    TypeCard(String text)
    {
        this.text = text;
    }
    public String getText(){ return text;}
}