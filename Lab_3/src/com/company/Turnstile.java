package com.company;

class Turnstile
{
    private Register register;

    Turnstile(Register register)
    {
        this.register = register;
    }

    Answer scanCard(int cardID)
    {
        Answer answer = register.checkCard(cardID);

        if(answer == Answer.CHECK)
        {
            answer = this.warn(cardID);
        }

        register.writeStatistics(cardID, answer);

        return answer;
    }

    private Answer warn(int cardID)
    {
        Answer answer = Answer.ALLOWED;

        if(false) // Перевірка контролера
        {
            register.returnResource(cardID);
            answer = Answer.FORBIDDEN;
        }

        return Answer.ALLOWED;
    }
}
