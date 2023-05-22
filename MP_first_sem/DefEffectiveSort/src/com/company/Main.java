package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Работа (быстрой) сортировки с заданным условием защиты");
        Task task = new Task();
        Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9,9,9};
        System.out.println("Сам массив:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Вариант, когда есть число, повторяющееся несколько раз ( по ТЗ нужно вывести само число)");
        System.out.println("Результат:");
        System.out.println(task.method(arr));

        System.out.println();


        System.out.println("Вариант, когда нет повторяющихся несколько раз чисел ( по ТЗ нужно вывести -1)");
        System.out.println("Сам массив:");
        Integer[] arr2 = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8,9};
        System.out.println(Arrays.toString(arr2));
        System.out.println("Результат:");
        System.out.println(task.method(arr2));

    }
}
