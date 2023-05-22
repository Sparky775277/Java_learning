

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> theTree = new BinaryTree<Integer>();
        System.out.println("Создание дерева и добавление элементов");
        theTree.addNode(10,"root");
        theTree.addNode(8,"left");
        theTree.addNode(20,"left2");
        theTree.addNode(15,"Right");
        theTree.addNode(13,"Right2");
        theTree.addNode(17,"Right3");
        theTree.addNode(25,"3left");
        theTree.preOrderTraverseTree(theTree.root);

        System.out.println();

        theTree.SumAllelements(theTree.root);
        System.out.println("Cymma всех элементов");
        System.out.println(theTree.sum);

    }
}
