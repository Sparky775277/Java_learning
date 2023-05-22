package com.company;

public class Main {

    public static void main(String[] args) {
        myVector array = new myVector(10);
        System.out.println("Добавим несколько элементов. Каждый из них добавляется в конец");
        array.Add(5);
        array.Add(4);
        array.Add(3);
        array.Add(2);
        array.Add(1);
        array.Add("New symbol");
        array.print();

        System.out.println("Копирование с указанного индекса:");
        myVector k = new myVector(array,2);
        k.print();

        array.removeAll();
        k.removeAll();

        System.out.println("Работа массива с классом Avto:");
        myVector<Avto> gold = new myVector<>(3);
        gold.Add(new Avto("C510PT"));
        gold.Add(new Avto("K482YT"));
        gold.Add(new Avto("A741YM"));

        gold.print();


    }
}

