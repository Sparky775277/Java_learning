package com.company;


import java.math.*;

public class Complex {

    double imagine;
    double real;

    public Complex (){}
    public Complex (double real, double imagine){
        this.real = real;
        this.imagine = imagine;
    }

    public static void Sum (Complex qui1, Complex qui2){
        double a = qui1.real + qui2.real;
        double b =  qui1.imagine + qui2.imagine;
        System.out.println("Sum: "+a +" "+"+" +" "+"i*"+"("+b+")");
    }
    public static void Sub (Complex qui1, Complex qui2){
        double a = qui1.real - qui2.real;
        double b =  qui1.imagine - qui2.imagine;
        System.out.println("Sub: " + a +" "+"+" +" "+"i*"+"("+b+")");
    }

    public static void Abs (Complex qui1 ){
       double a = Math.sqrt(qui1.real*qui1.real+qui1.imagine*qui1.imagine);
        System.out.println("Abs: " + a);

    }
    public static void Arg(Complex qui1){
        double a = Math.atan(qui1.imagine/qui1.real );
        System.out.println("Arg: " + a);
    }


}



