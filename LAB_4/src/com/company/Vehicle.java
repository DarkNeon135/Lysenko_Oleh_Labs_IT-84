package com.company;

import java.util.ArrayList;

public abstract class Vehicle<T>
{
    int id;
    private static int idCountner;
    private int seats;
    protected ArrayList<T> passengers = new ArrayList<>();

    Vehicle(int seats)
    {
        this.id = idCountner;
        idCountner++;
        this.seats = seats;
    }

    public int getSeats()
    {
        return seats;
    }

    boolean addPassenger(T person)
    {
        boolean flag = false;

        if(passengers.size() == getSeats())
        {
            throw new PassengerException("All seats are busy");
        }
        else if(((Person)person).inCar)
        {
            throw new PassengerException("Passenger (ID = " + ((Person)person).getID() + ") already in the car");
        }
        else
        {
            ((Person)person).inCar = true;
            passengers.add((T)person);
            flag = true;
        }

        return flag;
    }

    boolean disembarkPassenger(int personID)
    {
        boolean flag = false;

        Person person = findPersonByID(personID);

        if(person != null)
        {
            person.inCar = false;
            passengers.remove(person);
            flag = true;
        }
        else
            throw new PassengerException("No passengers with  (ID = " + personID + ")");

        return flag;
    }

    Person findPersonByID(int personID)
    {
        for (Person person: (ArrayList<Person>)passengers)
        {
            if(person.getID() == personID)
                return person;
        }

        return null;

    }

    public int getBusy()
    {
        return this.passengers.size();
    }
}
