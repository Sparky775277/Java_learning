package com.company;

public class Main {

    public static void main(String[] args) {
	HashMap map = new HashMap();
    map.put(10,20);
    map.put(40,200);
    map.put(50,4382);
    map.put(100000,4382);
    map.put(2000000,4382);
    System.out.println(map.get(100000));
    System.out.println(map);
    //System.out.println(map.size());

        for(int i = 0; i <= 5; i++) {
            map.put(i, i);
        }
    System.out.println(map);

    map.deleteAll();
    System.out.println(map);
    }


    }

