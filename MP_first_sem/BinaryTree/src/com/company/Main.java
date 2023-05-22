package com.company;

public class Main {

    public static void main(String[] args) {
        BinaryTree theTree = new BinaryTree();
        System.out.println("Создание дерева и добавление элементов");
        theTree.addNode(50,"root");
        theTree.addNode(45,"left");
        theTree.addNode(44,"Lleft");
        theTree.addNode(60,"Right");
        theTree.addNode(70,"Rright");
        theTree.addNode(85,"RRRight");
        theTree.addNode(1,"LLleft");


        theTree.preOrderTraverseTree(theTree.root);
        System.out.println();
        System.out.println("Поиск элемента");
        System.out.println(theTree.findNode(70));

        System.out.println();
        System.out.println("Копирование");
        BinaryTree<Integer> Second = new BinaryTree<>(theTree);
        theTree.preOrderTraverseTree(Second.root);

        System.out.println();
        System.out.println("Удаление");
        theTree.delete(theTree.root);
        theTree.preOrderTraverseTree(theTree.root);
    }
}
