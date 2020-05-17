package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args)
    {
        Register register = new Register(5, new File("files\\").getAbsolutePath() + "\\"); // Створення реєстру
        Turnstile turnstile = new Turnstile(register); // Створення турнікету і присвоєння йому реєстру

//        Card eCard = register.createCard(TypeCard.EXPIRATION_CARD, ExpirationType.DAY,true); // Створення картуи через реєстр
//
        //Card newCard = new Card(1); // Створення дублікату карти по вказаному ID
//
        System.out.println(turnstile.scanCard(1).getString()); // Сканування карти і пошук її у реєстрі по ID
//
//        System.out.println(register.getCardData(newCard.id)); // Видача інформації про картку по ID

        System.out.println(register.getCardData(1));

        System.out.println(register.getStatistics()); // Статистика проходів і відмов по усім карткам
    }
}
