package com.company;

public class Main {

    static String randString(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] answ = new char[(int)(Math.random() * 25)];

        for(int i = 0;i < answ.length;i++)
            answ[i] = alphabet.charAt((int)(Math.random() * (alphabet.length() - 1)));

        return new String(answ);
    }

    public static void main(String[] args) {
        String[] hi = new String[100];

        for(int i = 0;i < hi.length;i++)
            hi[i] = randString();


        map<Integer,String> main_map = new map<>();
        for(int i = 1;i <= 50;i++)
            main_map.add_couple(i,hi[i-1]);

//        main_map.showtree(main_map.root);
//        System.out.println();
        for(int i = 1;i <= 50;i++)
            System.out.println("элемента с ключем " + i +":" + main_map.get_value(i) + " - Этот элемент в массиве - " + hi[i-1]);

//        System.out.println("Другое дерево: ");
        map<Integer,String> othermap = new map<>(main_map);

//        othermap.showtree(othermap.root);
//        System.out.println();
        othermap.delete();

        System.out.println("Главное дерево:");
        main_map.showtree(main_map.root);
        System.out.println();
        System.out.println(main_map.isRBtree() + "- количество черных узлов (в случае ошибки - -1)");


        System.out.println("Побочное дерево:");
        othermap.showtree(othermap.root);

    }
}