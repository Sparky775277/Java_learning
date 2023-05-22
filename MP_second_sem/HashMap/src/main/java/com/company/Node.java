package com.company;

public class Node<K, V> {

    public K key;
    public V value;

    public Node(K k, V v){
        key = k;
        value = v;
    }
    // понадобится для вывода
    public String toString(){
        return key + " = " + value;
    }

}
