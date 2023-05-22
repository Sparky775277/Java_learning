package com.company;

public class SimpleSort {
    public <T extends Comparable> void bubbleSort(T[] array) {
        this.bubbleSort(array, 0, array.length);
    }

    public <T extends Comparable> void bubbleSort(T[] array, int indexFirst, int indexSecond) {
        boolean isSorted;
        for (var i = indexFirst; i < indexSecond; i++) {
            isSorted = true;
            for (var j = indexFirst + 1; j < indexSecond; j++)
                if (array[j].compareTo(array[j - 1]) < 0) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            if (isSorted)
                return;
        }
    }


    private <T extends Comparable> void swap(T[] array, int indexfirst, int indexsecond) {
        T temp = array[indexfirst];
        array[indexfirst] = array[indexsecond];
        array[indexsecond] = temp;
    }

    public <T extends Comparable> void insertionSort(T[] array) {
        this.insertionSort(array, 0, array.length);
    }


    public <T extends Comparable> void insertionSort(T[] array, int indexFirst, int indexSecond) {
        for (var i = indexFirst + 1; i < indexSecond; i++) {
            var current = array[i];
            var j = i - 1;
            while (j >= indexFirst && array[j].compareTo(current) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    public <T extends Comparable> void selectionSort(T[] array) {
        this.selectionSort(array, 0, array.length);
    }


    public <T extends Comparable> void selectionSort(T[] array, int indexFirst, int indexSecond) {

        for (int i = indexFirst; i < indexSecond - 1; i++) {
            int min = i;
            for (int j = i + 1; j < indexSecond; j++) {
                if (array[min].compareTo(array[j]) > 0) {
                    min = j;
                }
            }

            T temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}

