package com.company;

class CumulativeCard extends Card
{
    float sumOfMoney;

    CumulativeCard(int id, float sumOfMoney)
    {
        super(id);
        this.type = TypeCard.CUMULATIVE_CARD;
        this.sumOfMoney = sumOfMoney;
    }

    @Override
    Answer checkCard(int cardID, int trip, float fare)
    {
        Answer answer = Answer.FORBIDDEN;

        if(this.sumOfMoney >= fare)
        {
            this.sumOfMoney -= fare;
            answer = Answer.ALLOWED;
        }
        else
        {
            answer = Answer.FORBIDDEN;
        }

        return answer;
    }
}