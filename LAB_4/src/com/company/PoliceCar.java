package com.company;

public class PoliceCar<T extends Policeman> extends Car<T> {
    PoliceCar(int seats)
    {
        super(seats);
    }

    @Override
    public boolean addPassenger(T person)
    {
        return super.addPassenger(person);
    }
}
