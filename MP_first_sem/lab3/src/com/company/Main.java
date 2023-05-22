package com.company;

public class Main {

    public static void main(String[] args) {
        myVector array = new myVector(10);
        System.out.println("Добавим несколько элементов");
        array.Add(5);
        array.Add(4);
        array.Add(3);
        array.Add(2);
        array.Add(1);
        array.Add("New symbol");
        array.print();
        System.out.println("Добавим элемент по индексу(1)");
        array.AddPosition(10, 1);
        array.print();
        System.out.println("Удалим элемент по индексу(3)");
        array.removePosition(3);
        array.print();
        System.out.println("Удалим элемент с конца");
        array.removeEnd();
        array.print();
        System.out.println("Увеличим массив на 10");
        array.increaseVolume(array, 10);
        System.out.println("Размер массива при этом составит:");
        System.out.println(array.OutputVolume());

        System.out.println();
        System.out.println("Вывод элемента:");
        System.out.println(array.OutputElements());
        System.out.println("Вывод размера:");
        System.out.println(array.OutputVolume());


        System.out.println("Копирование:");
        myVector k = new myVector(array);
        array.print();

        System.out.println("Доброго времени суток, вроде бы выполнил все условия ТЗ, возможно что-то не запускал в классе Main(test), надеюсь на понимание (◍•ᴗ•◍)❤  ");
    }
}

