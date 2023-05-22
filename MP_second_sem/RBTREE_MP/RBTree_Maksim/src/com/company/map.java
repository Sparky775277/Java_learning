package com.company;


public class map<T extends Comparable<T>,V> {
    Node<T,V> root;

    map(){}

    map(Node<T,V> node){
        root = node;
    }

    map(map<T,V> othermap){
        root = reccurent_constr(othermap.root,null);

    }

    boolean isEmpty(){
        return (root != null);
    }

    int isRBtree(){
        int answ = check_RBtree(root,1);
        return answ;
    }

    void delete(){ root = null; }

    void add_couple(T startkey,V startvalue){
        if(root == null){
            root = new Node<>(startkey,startvalue);
            root.color = !root.color;
            return ;
        }
        Node<T,V> add_node = new Node(startkey,startvalue);
        Node<T,V> help = root;

        while(true){
            if(add_node.key.compareTo(help.key) < 0){
                if(help.left != null) {
                    help = help.left;
                    continue;
                }
                else {
                    help.left = add_node;
                    add_node.parent = help;
                    break;
                }
            }

            if(add_node.key.compareTo(help.key) >= 0) {
                if (help.right != null) {
                    help = help.right;
                    continue;
                } else {
                    help.right = add_node;
                    add_node.parent = help;
                    break;
                }
            }
        }

        if(root.left == add_node || root.right == add_node){
            return ;
        }

        checkNode(add_node);

    }

    V get_value(T startkey){
        Node<T,V> help = root;
        int deep = 1;
        while(true) {
            if (startkey.compareTo(help.key) < 0) {
                if (help.left != null) {
                    help = help.left;
                    deep++;
                } else {
                    System.out.println("Элемент не найден");
                    return null;
                }
            } else if (startkey.compareTo(help.key) > 0) {
                if (help.right != null) {
                    help = help.right;
                    deep++;
                } else {
                    System.out.println("Элемент не найден");
                    return null;
                }
            } else {
                System.out.print(deep + " глубина ");
                return help.value;
            }

        }
    }

    void checkNode(Node<T,V> X) {
        if(X == root){
            root.color = true;
            return ;
        }

        Node<T, V> father = X.parent;

        if(father.parent == null)
            return ;
        Node<T, V> grand = father.parent;
        Node<T, V> uncle = (grand.left == father) ? grand.right : grand.left;

        if (uncle != null && !uncle.color) {
//            System.out.println("Делаю первое условие");
            father.color = !father.color;
            uncle.color = !uncle.color;
            grand.color = !grand.color;
            checkNode(grand);
            return;
        }
        else if (((grand.left == father && father.right == X) || (grand.right == father && father.left == X)) && (uncle == null || uncle.color)) {
            System.out.println("Делаю второе условие");
            if(grand.left == father){
                grand.left = X;
                X.parent = grand;
                X.left = father;
                father.parent = X;
                father.right = null;
            }

            if(grand.right == father){
                grand.right = X;
                X.parent = grand;
                X.right = father;
                father.parent = X;
                father.left = null;
            }

            Node<T,V> help = father;
            father = X;
            X = help;
        }

        if (((grand.left == father && father.left == X) || grand.right == father && father.right == X) && (uncle == null || uncle.color)) {
//            System.out.println("Делаю третье условие");
            if(grand.parent != null) {
                if (grand.parent.left == grand) {
                    grand.parent.left = father;
                    father.parent = grand.parent;
                } else if (grand.parent.right == grand) {
                    grand.parent.right = father;
                    father.parent = grand.parent;
                }
            }else {
                root = father;
                father.parent = null;
            }


            father.color = !father.color;
            grand.color = !grand.color;

            if(grand.left == father){
                if(father.right != null) {
                    grand.left = father.right;
                    grand.left.parent = grand;
                }else
                    grand.left = null;

                father.right = grand;
                grand.parent = father;
                return ;
            }else if(grand.right == father){
                if(father.left != null){
                    grand.right = father.left;
                    grand.right.parent = grand;
                }else
                    grand.right = null;

                father.left = grand;
                grand.parent = father;
                return ;
            }else
                System.out.println("Дурь какая-тоЭ");


        }
    }

    void showtree(Node<T,V> node){
        if(node == null){
            System.out.println("Элементов нет");
            return ;
        }

        System.out.print(node.key + " ");
        System.out.print((node.color)?"Черный":"Красный");
        if(node.left != null) {
            System.out.println(" Влево");
            showtree(node.left);
        }
        if(node.right != null) {
            System.out.println(" Вправо");
            showtree(node.right);
        }
    }

    Node<T,V> reccurent_constr(Node<T,V> child,Node<T,V> papa){
        Node<T,V> help = new Node<T,V>(child);
        help.parent = papa;
        if(help.left != null){
            help.left = reccurent_constr(help.left,help);
        }
        if(help.right != null){
            help.right = reccurent_constr(help.right,help);
        }

        return help;
    }

    int check_RBtree(Node<T,V> node,int num){
        if(node.color)
            num++;

        int result1 = num;
        int result2 = num;

        if(node.left != null)
            result1 = check_RBtree(node.left,num);
        if(node.right != null)
            result2 = check_RBtree(node.right,num);

        if(result1 != result2)
            return -1;

        return result1;
    }
}

class Node<T extends  Comparable<T>,V>{
    Node<T,V> parent;
    Node<T,V> right;
    Node<T,V> left;

    boolean color; // true - черный false - красный
    T key;
    V value;

    Node(T key,V value){
        color = false;
        this.key = key;
        this.value = value;
    }
    Node(Node<T,V> node){
        value = node.value;
        key = node.key;
        color = node.color;
        left = node.left;
        right = node.right;

    }

}
