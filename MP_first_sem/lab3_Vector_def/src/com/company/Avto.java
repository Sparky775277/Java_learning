package com.company;

public class Avto{
    private String Number1;
    public Avto(String Number){
        this.Number1 = Number;
    }

    @Override
    public String toString() {
        return "Avto{" +
                "Number1='" + Number1 + '\'' +
                '}';
    }
}

