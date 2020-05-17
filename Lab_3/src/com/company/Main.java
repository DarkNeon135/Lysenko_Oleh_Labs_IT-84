package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args)
    {
        Register register = new Register(5, new File("files\\").getAbsolutePath() + "\\");
        Turnstile turnstile = new Turnstile(register);

        System.out.println(turnstile.scanCard(1).getString());


        System.out.println(register.getCardData(1));

        System.out.println(register.getStatistics());
    }
}
