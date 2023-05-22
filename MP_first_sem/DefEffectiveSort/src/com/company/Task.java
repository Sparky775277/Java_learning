package com.company;

public class Task extends effectiveSort {
    public Integer method(Integer[] array){
        this.quickSort(array);
        int k = array.length;
        Integer[] arr = new Integer[k];
        for (int i = 0; i < arr.length; i++)
            arr[i] = 0;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++){
                if (array[i] == array[j])
                    arr[i] ++;
            }
        int c = 0;
        int max = -Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++){
            if ( arr[i] > max){
                max = array[i];
                c = i;
            }
        }
        if ( c != 0)
            return max;
        else return -1;
    }
}
