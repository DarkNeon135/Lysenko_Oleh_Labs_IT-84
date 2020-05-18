package com.company;

public class TurnstileTest
{
//    @Test
//    public void scanCard()
//    {
//        Register register = new Register(5, new File("files\\").getAbsolutePath() + "\\");
//        Turnstile turnstile = new Turnstile(register);
//
//        Card eCard = register.createCard(TypeCard.EXPIRATION_CARD, ExpirationType.DAY,false);
//        Card nCard = register.createCard(TypeCard.NUMBER_CARD, NumberTripType._4, false);
//        Card cCard = register.createCard(TypeCard.CUMULATIVE_CARD, 5);
//
//        assertEquals(turnstile.scanCard(eCard.id), Answer.ALLOWED);
//        assertEquals(turnstile.scanCard(nCard.id), Answer.ALLOWED);
//        assertEquals(turnstile.scanCard(cCard.id), Answer.ALLOWED);
//
//        register.blockCard(eCard.id);
//
//        assertEquals(turnstile.scanCard(eCard.id), Answer.FORBIDDEN);
//
//        assertEquals(turnstile.scanCard(nCard.id), Answer.ALLOWED);
//        assertEquals(turnstile.scanCard(nCard.id), Answer.ALLOWED);
//        assertEquals(turnstile.scanCard(nCard.id), Answer.ALLOWED);
//        assertEquals(turnstile.scanCard(nCard.id), Answer.FORBIDDEN);
//
//        assertEquals(turnstile.scanCard(cCard.id), Answer.FORBIDDEN);
//    }

    private void assertEquals(Answer scanCard, Answer allowed) {
    }
}