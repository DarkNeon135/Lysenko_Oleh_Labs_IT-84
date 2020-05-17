package com.company;

import java.util.Date;

class ExpirationCard extends Card
{
    int numberDay;
    Date dateCreation;
    Date dateLocking;
    boolean privilege;

    ExpirationCard(int id, ExpirationType expirationType, boolean privilege)
    {
        super(id);
        this.type = TypeCard.EXPIRATION_CARD;
        this.numberDay = expirationType.getValue();

        dateCreation = new Date();
        dateLocking = new Date(dateCreation.getYear(), dateCreation.getMonth(), dateCreation.getDate() + numberDay);

        this.privilege = privilege;
    }

    @Override
    Answer checkCard(int cardID, int trip, float fare)
    {
        Answer answer = Answer.FORBIDDEN;
        Date dateNow = new Date();

        if(dateNow.before(this.dateLocking))
        {
            answer = Answer.ALLOWED;
        }
        else
        {
            answer = Answer.FORBIDDEN;
        }
        return answer;
    }
}

enum ExpirationType
{
    DAY(1),
    WEEK(7),
    MONTH(30);

    private int value;

    ExpirationType(int value)
    {
        this.value = value;
    }

    public int getValue(){ return value;}
}

