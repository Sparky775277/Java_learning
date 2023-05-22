package com.company;

public class Main {
    public static void main(String[] args) {
        Complex qui1 = new Complex(10.0d, 20.0d);
        Complex qui2 = new Complex(40.0d, 30.0d);
        Complex.Sum(qui1, qui2);
        Complex.Sub(qui1, qui2);
        Complex.Abs(qui1);
        Complex.Arg(qui1);
    }
}
