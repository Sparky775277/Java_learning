package com.company;

import java.util.Arrays;
import java.util.LinkedList;

public class HashMap<K, V> {
    LinkedList<Node<K, V>>[] hashMap = new LinkedList[16]; //массив из списков
    int size = 0;
    final float PARAMETR_WORKLOAD = 2.0f;

    public HashMap() {

    }


    public void resize() {
        LinkedList<Node<K, V>>[] oldHashMap = hashMap;
        hashMap = new LinkedList[hashMap.length * 2 + 1];// увеличиваем размер по ТЗ
        size = 0;

        for (int i = 0; i < oldHashMap.length; i++) {
            if (oldHashMap[i] == null) continue;
            for (Node<K, V> entry : oldHashMap[i]) {
                put(entry.key, entry.value);
            }
        }
    }

    public int getIndex(K key) {
        return key.hashCode(); //Польльзуемся внутренней функцией жабы (ы)
    }

    public void deleteAll() {
        for (int i = 0; i < hashMap.length; i++) {
            hashMap[i] = null;
        }
        size = 0;
        System.gc();
    }

    public int size() {
        return size;
    }

    public void rehash() {
        if (size != 0 && (size / hashMap.length) >= PARAMETR_WORKLOAD) {
            resize();
        }
    }

    public void put(K key, V value) {
        rehash();

        int ix = getIndex(key) % hashMap.length; // вычисляем индекс для вставки

        if (hashMap[ix] == null) { // Два случая
            hashMap[ix] = new LinkedList<>();
            hashMap[ix].add(new Node(key, value));
            size++;
            return;
        } else {
            for (Node<K, V> entry : hashMap[ix]) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
            }

            hashMap[ix].add(new Node<>(key, value));
            size++;
            return;
        }
    }


    public V get(K key) {
        int ix = getIndex(key) % hashMap.length;

        if (hashMap[ix] == null)
            return null;

        for (Node<K, V> entry : hashMap[ix]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }


    public boolean containsKey(K key) { // этим я так и не воспользовался, хотя можно было бы)
        if (key == null) return false;

        int ix = getIndex(key) % hashMap.length;

        if (hashMap[ix] == null) {
            return false;
        }

        for (Node<K, V> entry : hashMap[ix]) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void remove(K key) {


        if (key == null) return;

        int ix = getIndex(key) % hashMap.length;

        if (hashMap[ix] == null) return;


        Node<K, V> toRemove = null;

        for (Node<K, V> entry : hashMap[ix]) {
            if (entry.key.equals(key)) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove == null)
            return;

        hashMap[ix].remove(toRemove);
        size--;
    }

    public boolean isEmpty() {
        if (size != 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return " " +
                "hashMap=" + Arrays.toString(hashMap) +
                ", size=" + size +
                ' ';
    }
}
