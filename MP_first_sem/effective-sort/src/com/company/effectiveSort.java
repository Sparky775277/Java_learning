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

    private static<T extends Comparable<T>> int partition(T[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        T pivot = arr[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {

            while (arr[leftIndex].compareTo(pivot)<0) {
                leftIndex++;
            }

            while (arr[rightIndex].compareTo(pivot)>0) {
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


    public static <T extends Comparable<T>> Comparable[] mergeSort(Comparable[] array) {
        Comparable[] tmp;
        Comparable[] currentSrc = array;
        Comparable[] currentDest = new Comparable[array.length];

        int size = 1;
        while (size < 2*array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;
        }
        return currentSrc;
    }
    public <T extends Comparable<T>> void mergeSort(Comparable[] array, int start, int end) {

        Comparable[] k = Arrays.copyOfRange(array, start, end);
        this.mergeSort(k);
        int j = 0;
        for (int i = start; i < end; i++ ){
            array[i]=k[j];
            j++;
        }


    }
    private static <T extends Comparable<T>> void merge(T[] src1, int src1Start, T[] src2, int src2Start, T[] dest, int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
//            if (src2[index2] == null || src1[index1] == null ){
//                return;
//            }
            if (index1 < src1End && (index2 >= src2End || src1[index1].compareTo(src2[index2]) < 0)) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    public <T extends Comparable<T>> void heapSort(T[] array)
    {
        this.heapSort(array, 0, array.length);
    }

    public static <T extends Comparable<T>> void heapSort(Comparable[] array, int index1, int index2) {
        Comparable tempArray[] = new Comparable[index2 - index1];
        int j = 0;
        for (int i = index1; i < index2; i++) {
            tempArray[j] = array[i];
            j++;
        }
        j = 0;
        int n = tempArray.length;


        for (int i = n / 2 - 1; i >= 0; i--)
            heapAuxiliary(tempArray, n, i);


        for (int i = n - 1; i >= 0; i--) {

            T temp = (T) tempArray[0];
            tempArray[0] = tempArray[i];
            tempArray[i] = temp;


            heapAuxiliary(tempArray, i, 0);
        }

        for (int i = index1; i < index2; i++) {
            array[i] = (T) tempArray[j];
            j++;
        }
    }


    public static <T extends Comparable<T>> void heapAuxiliary(T array[], int n, int i) {
        int biggest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l].compareTo(array[biggest]) > 0)
            biggest = l;

        if (r < n && array[r].compareTo(array[biggest]) > 0)
            biggest = r;

        if (biggest != i) {
            T swap = array[i];
            array[i] = array[biggest];
            array[biggest] = swap;

            heapAuxiliary(array, n, biggest);
        }
    }
}
