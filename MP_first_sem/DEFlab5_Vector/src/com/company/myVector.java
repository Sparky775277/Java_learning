package com.company;

public class myVector<T extends Comparable<T>> extends SimpleSort {
    int element;
    int volume;
    Comparable[] array;


    public myVector() {
        volume = 0;
        array = new Comparable[0];
        element = 0;
    }

    public myVector(myVector<T> newarray) {
        array = new Comparable[volume];
        array = newarray.array;
        element = newarray.element;
        volume = newarray.volume;
    }

    public myVector(int quantity) {
        volume = quantity * 2 + 10;
        array = new Comparable[volume];
        element = 0;
    }

    public void Add(T data) {
        if (volume > element) {
            array[element] = data;
            element++;
        } else {
            Comparable[] temp = new Comparable[volume + 1];
            for (int i = 0; i < element; i++) {
                temp[i] = array[i];
            }
            array = temp;
            array[element] = data;
            element++;
        }
    }

    public void AddPosition(T data, int position) {
        if (volume > element) {
            for (int i = element; i > position - 1; i--) {
                array[i + 1] = array[i];
            }
            array[position] = data;
            element++;
        } else {
            Comparable[] temp = new Comparable[volume];
            for (int i = 0; i < element; i++) {
                temp[i] = array[i];
            }
            array = temp;
            for (int i = element; i > position - 1; i--) {
                array[i + 1] = array[i];
            }
            array[position] = data;
            element++;
        }
    }

    public void removePosition(int index) {
        if (volume > element) {
            array[index] = null;
            for (int i = index; i < element; i++) {
                array[i] = array[i + 1];
            }
            element--;
        }
    }

    public void removeEnd() {
        if (volume > element) {
            array[element] = null;
            element--;
        }
    }

    public void removeAll() {
        for (int i = 0; i < volume; i++) {
            array[i] = null;
        }
    }

    public void increaseVolume(myVector<T> newarray, int newvolume) {
        volume = volume + newvolume;
        Comparable[] temp = new Comparable[volume];
        for (int i = 0; i < element; i++) {
            temp[i] = array[i];
        }
        array = temp;

    }

    public int OutputElements() {
        return element;
    }

    public int OutputVolume() {
        return volume;
    }

    public void print() {
        for (int i = 0; i < element; i++) {
            if (array[i] != null) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }
}