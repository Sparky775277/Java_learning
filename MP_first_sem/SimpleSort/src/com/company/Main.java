package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Создадим массив(ы) и применим к ним различные сортировки с различными свойствами");
        Integer[] numbers = {7,3,1,4,6,2,3,1,0,-1};
        System.out.println(Arrays.toString(numbers));
        System.out.println();
        var sorter = new SimpleSort();
        sorter.bubbleSort(numbers);
        System.out.println("сортировка массива целых чисел заданного размера");
        System.out.println(Arrays.toString(numbers));
        System.out.println();

        Integer[] numbers2 = {7,3,1,4,6,2,3,1,0,-1};
        var sorter2 = new SimpleSort();
        System.out.println("сортировка любой подпоследовательности массива");
        sorter.insertionSort(numbers2, 2, 6);
        System.out.println(Arrays.toString(numbers2));

        System.out.println();
        String[] numbers3 = {"Hello", "Goodbye","String2", "String"};
        var sorter3 = new SimpleSort();
        System.out.println("сортировка массивов с любыми типами данных");
        sorter.selectionSort(numbers3);
        System.out.println(Arrays.toString(numbers3));

    }
}
