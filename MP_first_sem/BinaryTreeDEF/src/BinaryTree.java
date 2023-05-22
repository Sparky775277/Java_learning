import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {

    Node<T> root;
    int len;

    public BinaryTree() {
        this.root = root;
    }

    public void addNode( T key, String name){
        Node<T> newNode = new Node<T>(key, name);
        if (root == null){
            root = newNode;

        } else {
            Node<T> focusNode = root;

            Node<T> parent;

            while (true){
                parent = focusNode;
                if (key.compareTo(focusNode.key) == 0 )
                    break;
                if (key.compareTo(focusNode.key) < 0 ){
                    focusNode = focusNode.leftChild;

                    if (focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }

                }else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null ) {
                        parent.rightChild = newNode;
                        return;
                    }
                }


            }
        }
    }

    public  void preOrderTraverseTree(Node<? extends Number> focusNode){
        if (focusNode != null){
            System.out.println((focusNode));
            preOrderTraverseTree(focusNode.leftChild);
            preOrderTraverseTree(focusNode.rightChild);
        }
    }

    Double sum = 0.0;
    public Double SumAllelements(Node<? extends Number> focusNode) throws StackOverflowError{
        if (focusNode != null){
            sum = sum(focusNode.key, sum);
            SumAllelements(focusNode.leftChild);
            SumAllelements(focusNode.rightChild);
        }
        return sum;
    }

    public Double sum(Number current, Number node){
        double res = node.doubleValue() + current.doubleValue();
        return res;
    }

    void delete(Node<T> root)
    {
        if (root!=null){
            delete(root.leftChild);
            root.leftChild = null;
            delete(root.rightChild);
            root.rightChild = null;
        }
        this.root = null;
    }


    Node<T> findNode(T key) {
        Node<T> focusNode = root;
        while (focusNode.key != key) {
            if (key.compareTo(focusNode.key) < 0 ) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null)
                return null;
        }
        return focusNode;
    }
    public BinaryTree(BinaryTree<T> tree) {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> head = tree.root;
        while(head != null){
            this.addNode(head.key, "new");
            if(head.rightChild != null){
                stack.add(head.rightChild);
            }
            if(head.leftChild != null){
                head = head.leftChild;
            }
            else if (stack.isEmpty()){
                break;
            }
            else{
                head = stack.pop();
            }
        }
    }



}



class Node <T extends Comparable<T>> {
    T key;
    String name;

    Node<T> leftChild;
    Node<T> rightChild;

    Node(T key, String name){
        this.key = key;

        this.name = name;

    }

    public String toString(){
        return name + " Has a key " + key;
    }
}