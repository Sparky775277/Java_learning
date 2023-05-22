package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

         System.out.println("Работа (быстрой) сортировки с массивом чисел");
        Integer[] array = new Integer[]{64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        System.out.println("Сам массив:");
        System.out.println(Arrays.toString(array));
        var sorter = new effectiveSort();
        sorter.quickSort(array);
        System.out.println("Результат:");
        System.out.println(Arrays.toString(array));
        System.out.println();

        System.out.println("Работа сортировки (слияния) с подпоследовательностью массива чисел (со 2-го до 10-го)");
        Integer[] array2 = new Integer[]{64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        var sorter2 = new effectiveSort();
        sorter2.mergeSort(array2,2,10);
        System.out.println(Arrays.toString(array2));
        System.out.println();


        System.out.println("Работа сортировки (пирамидальная сортировка) с различными типами данных:");
        String[] array3 = {"Hello", "Goodbye","Teddybear", "String2", "String"};
        var sorter3 = new effectiveSort();
        sorter3.heapSort(array3);
        System.out.println(Arrays.toString(array3));

    }
}
