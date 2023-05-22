package com.company;

public class SimpleSort {


    public <T extends Comparable<T>> void insertionSort(T[] array) {
        this.insertionSort(array, 0, array.length, true);
    }


    public <T extends Comparable<T>> void insertionSort(T[] array, int indexFirst, int indexSecond) {
        this.insertionSort(array, indexFirst, indexSecond, true);
    }

    public <T extends Comparable<T>> void insertionSort(T[] array, int indexFirst, int indexSecond, boolean flag) {
        for (var i = indexFirst + 1; i < indexSecond; i++) {
            if (array[i] == null) {
                break;
            }
            T current = array[i];
            var j = i - 1;
            if (flag) {
                while (j >= indexFirst && array[j].compareTo(current) > 0) {
                    array[j + 1] = array[j];
                    j--;
                }
            } else {
                while (j >= 0 && array[j].compareTo(current) < 0) {
                    array[j + 1] = array[j];
                    j--;
                }
            }
            array[j + 1] = current;

        }

    }

    public <T extends Comparable<T>> void insertionSort(T[] array, boolean flag) {
        this.insertionSort(array, 0, array.length, flag);
    }

}



