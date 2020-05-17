package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Data
{
    String aboutCard(Card card, String path)
    {
        String data = "---------- ДАНІ ПРО КАРТКУ ----------\n";

        data += "ID: " + card.id + ";\n";
        data += "Тип: " + card.type.getText() + ";\n";
        data += "Активність: " + card.active + ";\n";

        switch (card.type)
        {
            case EXPIRATION_CARD:
                data += "Термін дії (дні): " + ((ExpirationCard)card).numberDay + ";\n";
                data += "Cтворена: " + ((ExpirationCard)card).dateCreation + ";\n";
                data += "Діє до: " + ((ExpirationCard)card).dateLocking + ";\n";
                data += "Пільга: " + ((ExpirationCard)card).privilege + ";\n";
                break;
            case NUMBER_CARD:
                data += "Кількість поїздок: " + ((NumberCard)card).numberTrip + ";\n";
                data += "Пільга: " + ((NumberCard)card).privilege + ";\n";
                break;
            case CUMULATIVE_CARD:
                data += "Сума на рахунку: " + ((CumulativeCard)card).sumOfMoney + " у.о.\n";
                break;
        }

        data += "-------------------------------------\n";

        try(FileWriter writer = new FileWriter(path, false))
        {
            writer.write(data);
            writer.flush();
        }
        catch(IOException ex){ }

        return data;
    }

    String statistics (ArrayList<Card> cards, String path)
    {
        String data = "------------------------------------- СТАТИСТИКА -------------------------------------\n";

        for(Card card: cards)
        {
            data += "ID: " + card.id + "\tкількість дозволених проходів: " + card.numberAllowed + "\tкількість заборонених проходів: " + card.numberBanned + ";\n";
        }

        data += "--------------------------------------------------------------------------------------\n";

        try(FileWriter writer = new FileWriter(path, false))
        {
            writer.write(data);
            writer.flush();
        }
        catch(IOException ex){ }

        return data;
    }
}