package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var sorter = new SimpleSort();
        System.out.println("Работа с простым массивом");
        Integer[] numbers2 = {7, 3, 1, 4, 6, 2, 3, 1, 0, -1};
        System.out.println(Arrays.toString(numbers2));
        var sorter2 = new SimpleSort();
        sorter.insertionSort(numbers2, false);// флаг отвечает за порядок: true- возрастание,false - убывание.
        System.out.println("Итог:");
        System.out.println(Arrays.toString(numbers2));// Пример работы без учета третьей лабы.
        System.out.println();

        myVector<Integer> vec = new myVector<>(10);
        System.out.println("Пример работы с учетом третьей лабы. Добавим несколько элементов. Каждый из них добавляется в конец.");
        vec.Add(5);
        vec.Add(4);
        vec.Add(3);
        vec.Add(2);
        vec.Add(1);
        vec.print();
        vec.insertionSort(vec.array, true);
        System.out.println("Отсортированный масив созданный с помощью класса из третьей лабораторной работы:");
        vec.print();


    }
}
