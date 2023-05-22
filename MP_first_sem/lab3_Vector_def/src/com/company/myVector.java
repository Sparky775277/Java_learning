package com.company;

public class myVector<T> {
    int element;
    int volume;
    Object[] array;


    public myVector() {
        volume = 0;
        array = new Object[0];
        element = 0;
    }

    public myVector(myVector newarray) {
        array = new Object[volume];
        array = newarray.array;
        element = newarray.element;
        volume = newarray.volume;
    }
    public myVector(myVector newarray, int index) {
        //this.increaseVolume(newarray, index);
        array = new Object[volume];

        array = newarray.array;
        element = newarray.element;
        volume = newarray.volume;
        for (int i = 0; i < element; i++) {
            if ( i < index)
            array[i] = null;
        }

    }

    public myVector(int quantity) {
        volume = quantity * 2 + 10;
        array = new Object[volume];
        element = 0;
    }

    public void Add(T data) {
        if (volume > element) {
            array[element] = data;
            element++;
        } else {
            Object[] temp = new Object[volume + 1];
            for (int i = 0; i < element; i++) {
                temp[i] = array[i];
            }
            array = temp;
            array[element] = data;
            element++;
        }
    }


    public void removeAll() {
        for (int i = 0; i < volume; i++) {
            array[i] = null;
        }
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


