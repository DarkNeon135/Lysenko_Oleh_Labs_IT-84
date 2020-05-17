package com.company;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

class Register
{
    float fare;
    int trip = 1;
    private static int idCard;
    ArrayList<Card> cards = new ArrayList<>();
    String path;

    Register(float fare, String path)
    {
        this.fare = fare;
        this.path = path;

        this.cards = this.FromJson("e.json", "n.json", "c.json");
        this.IDfromJson("id.json");
    }

    ExpirationCard createCard(TypeCard type, ExpirationType expirationType, boolean privilege)
    {
        ExpirationCard card = new ExpirationCard(idCard, expirationType, privilege);
        this.addToCards(card);
        idCard++;
        this.IDtoJson("id.json");

        return card;
    }

    NumberCard createCard(TypeCard type, NumberTripType numberTripType, boolean privilege)
    {
        NumberCard card = new NumberCard(idCard, numberTripType, privilege);
        this.addToCards(card);
        idCard++;
        this.IDtoJson("id.json");

        return card;
    }

    CumulativeCard createCard(TypeCard type, float sumOfMoney)
    {
        CumulativeCard card = new CumulativeCard(idCard, sumOfMoney);
        this.addToCards(card);
        idCard++;
        this.IDtoJson("id.json");

        return card;
    }

    private void updateCard(Card card)
    {
        this.cards.remove(card);
        this.addToCards(card);
    }

    void blockCard(int cardID)
    {
        Card card = this.findCardById(cardID);
        card.active = false;

        this.updateCard(card);
    }

    private void addToCards(Card card)
    {
        this.cards.add(card);
        this.ToJson("e.json", "n.json", "c.json");
    }

    String getCardData(int cardID)
    {
        Card card = this.findCardById(cardID);
        Data data = new Data();

        if(card != null)
            return data.aboutCard(card, path + "data.txt");
        else
            return "No card with (ID: " + cardID + ")  :(\n";
    }

    Answer checkCard(int cardID)
    {
        Answer answer = Answer.FORBIDDEN;

        Card card = this.findCardById(cardID);

        if(card != null && card.active)
        {
            answer = card.checkCard(cardID, trip, fare);
            updateCard(card);
        }

        if(answer == Answer.FORBIDDEN)
            blockCard(cardID);

        return answer;
    }

    void returnResource(int cardID)
    {
        Card card = findCardById(cardID);

        switch (card.type)
        {
            case EXPIRATION_CARD:
                this.updateCard(card);
                break;

            case NUMBER_CARD:
                ((NumberCard) card).numberTrip += trip;
                this.updateCard(card);
                break;
        }
    }


    private Card findCardById(int cardID)
    {
        Card card = null;

        for(Card el: this.cards)
        {
            if(el.id == cardID) {
                card = el;
                break;
            }
        }

        return card;
    }

    void writeStatistics(int cardID, Answer answer)
    {
        Card card = this.findCardById(cardID);

        if(card != null)
        {
            switch (answer)
            {
                case ALLOWED:
                    card.numberAllowed++;
                    this.updateCard(card);
                    break;
                case FORBIDDEN:
                    card.numberBanned++;
                    this.updateCard(card);
                    break;
            }
        }
    }

    String getStatistics()
    {
        Data data = new Data();

        return data.statistics(this.cards, path + "statistics.txt");
    }

    String getStatistics(TypeCard typeCard)
    {
        Data data = new Data();

        ArrayList<Card> list = new ArrayList<>();

        for (Card el: this.cards)
        {
            if(el.type == typeCard)
                list.add(el);
        }

        if(!list.isEmpty())
            return data.statistics(list, path + "statistics.txt");
        else
            return "No cards with (TYPE: " + typeCard + ")  :(\n";
    }

    String getStatistics(int cardID) {
        Data data = new Data();
        Card card = this.findCardById(cardID);

        if (card != null)
        {
            ArrayList<Card> list = new ArrayList<>();
            list.add(card);

            return data.statistics(list, path + "statistics.txt");
        }
        else
            return " No card with (ID: " + cardID + ") (\n";
    }

    private void IDtoJson(String pathName)
    {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(path + pathName))
        {
            gson.toJson(idCard, writer);
        }
        catch (IOException e) { }
    }

    private void IDfromJson(String pathName)
    {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(path + pathName))
        {
            idCard = gson.fromJson(reader, int.class);
        } catch (IOException e) { }
    }

    private void ToJson(String pathE, String pathN, String pathC)
    {
        Gson gson = new Gson();

        ArrayList<ExpirationCard> listE = new ArrayList<>();
        ArrayList<NumberCard> listN = new ArrayList<>();
        ArrayList<CumulativeCard> listC = new ArrayList<>();

        for (Card card: cards)
        {
            if(card.type == TypeCard.EXPIRATION_CARD)
                listE.add((ExpirationCard)card);
        }

        for (Card card: cards)
        {
            if(card.type == TypeCard.NUMBER_CARD)
                listN.add((NumberCard)card);
        }

        for (Card card: cards)
        {
            if(card.type == TypeCard.CUMULATIVE_CARD)
                listC.add((CumulativeCard)card);
        }

        try (FileWriter writer = new FileWriter(path + pathE))
        {
            gson.toJson(listE, writer);
        }
        catch (IOException e) { }

        try (FileWriter writer = new FileWriter(path + pathN))
        {
            gson.toJson(listN, writer);
        }
        catch (IOException e) { }

        try (FileWriter writer = new FileWriter(path + pathC))
        {
            gson.toJson(listC, writer);
        }
        catch (IOException e) { }
    }

    private ArrayList<Card> FromJson(String pathE, String pathN, String pathC)
    {
        Gson gson = new Gson();
        ArrayList<Card> list = new ArrayList<>();
        ArrayList<ExpirationCard> listE = new ArrayList<>();
        ArrayList<NumberCard> listN = new ArrayList<>();
        ArrayList<CumulativeCard> listC = new ArrayList<>();

        Type typeE = new TypeToken<ArrayList<ExpirationCard>>() {}.getType();
        try (Reader reader = new FileReader(path + pathE))
        {
            listE = gson.fromJson(reader, typeE);
        } catch (IOException e) { }

        Type typeN = new TypeToken<ArrayList<NumberCard>>() {}.getType();
        try (Reader reader = new FileReader(path + pathN))
        {
            listN = gson.fromJson(reader, typeN);
        } catch (IOException e) { }

        Type typeC = new TypeToken<ArrayList<CumulativeCard>>() {}.getType();
        try (Reader reader = new FileReader(path + pathC))
        {
            listC = gson.fromJson(reader, typeC);
        } catch (IOException e) { }

        for (Card card: listE)
            list.add(card);

        for (Card card: listN)
            list.add(card);

        for (Card card: listC)
            list.add(card);

        return list;
    }
}