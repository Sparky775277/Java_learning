package com.company;

public class Main {

    public static void main(String[] args) {
	List list = new List();
    System.out.println("Список:");
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    /*list.add(50);
    list.add(60);
    list.add(70);
    list.add(80);
    list.add(90);*/
    list.print();

    //list.kolvo();

    System.out.println("Добавление в конец списка элемента(100) :");
    list.bdd(100);
    list.print();
    System.out.println("Добавление в конец списка элемента (200):");
    list.bdd(200);
    list.print();

   /* System.out.println("Удаление из списка конкретного элемента(10):");
    list.removeData(10);
    list.print();

    System.out.println("Удаление из списка начального элемента:");
    list.remove();
    list.print();*/

    System.out.println("Копирование в обратном порядке:");
    List k = new List(list);
    k.print();

    /*System.out.println("Удаление из списка всех элементов:");
    list.removeAll();
    list.print();*/
    }
}
