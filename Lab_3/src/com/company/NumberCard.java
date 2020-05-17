package com.company;

class NumberCard extends Card
{
    int numberTrip;
    boolean privilege;

    NumberCard(int id, NumberTripType numberTripType, boolean privilege)
    {
        super(id);
        this.type = TypeCard.NUMBER_CARD;
        this.numberTrip = numberTripType.getValue();
        this.privilege = privilege;
    }

    @Override
    Answer checkCard(int cardID, int trip, float fare)
    {
        Answer answer = Answer.FORBIDDEN;

        if(this.numberTrip >= trip)
        {
            this.numberTrip -= trip;
            answer = Answer.ALLOWED;
        }
        else
        {
            answer = Answer.FORBIDDEN;
        }

        return answer;
    }
}

enum NumberTripType
{
    _4(4),
    _10(10),
    _20(20);

    private int value;

    NumberTripType(int value)
    {
        this.value = value;
    }

    public int getValue(){ return value;}
}