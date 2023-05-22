package com.company;

import java.util.Arrays;

public class effectiveSort {

    public <T extends Comparable<T>> void quickSort(T[] arr, int from, int to) {

        if (from < to) {

            Integer divideIndex = partition(arr, from, to);

            quickSort(arr, from, divideIndex - 1);

            quickSort(arr, divideIndex, to);

        }
    }

    public <T extends Comparable<T>> void quickSort(T[] arr) {
        this.quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        T pivot = arr[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {

            while (arr[leftIndex].compareTo(pivot) < 0) {
                leftIndex++;
            }

            while (arr[rightIndex].compareTo(pivot) > 0) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static <T extends Comparable<T>> void swap(T[] array, int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }


}




