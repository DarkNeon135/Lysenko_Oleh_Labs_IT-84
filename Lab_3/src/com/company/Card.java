package com.company;

abstract class Card {
    final int id;
    TypeCard type;
    boolean active;
    int numberAllowed;
    int numberBanned;

    Card(int id) {
        this.id = id;
        this.active = true;

        numberAllowed = 0;
        numberBanned = 0;
    }

    abstract Answer checkCard(int cardID, int trip, float fare);
}
