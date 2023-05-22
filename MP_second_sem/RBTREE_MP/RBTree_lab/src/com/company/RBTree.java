package com.company;

import java.io.*;
import java.util.Iterator;
import java.util.Stack;

public class RBTree<K extends Comparable<K>, V> implements Iterable<RBTree.Node<K, V>> {
    private final static int RED = 0;
    private final static int BLACK = 1;

    static final class Node<K, V> {
        private K key;
        private V value;
        private int color = BLACK;
        Node<K, V> parent = nil;
        Node<K, V> left = nil;
        Node<K, V> right = nil;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key) {
            this.key = key;
            this.value = null;
        }

        public Node(Node<K, V> node) {
            this.key = node == null ? null : node.key;
            this.value = node == null ? null : node.value;
        }
    }

    public RBTree() {
    }

    public RBTree(RBTree<K, V> tree) {
        for (Node<K, V> node : tree)
            insert(new Node<K, V>(node));
    }

    private final static Node nil = new Node(null);
    private Node root = nil;

    public void insert(Node<K, V> node) {
        Node<K, V> tmp = root;
        if (root == nil)
            root = node;
        else {
            node.color = RED;
            while (true) {
                if (node.key.compareTo(tmp.key) > 0) {
                    if (tmp.right != nil)
                        tmp = tmp.right;
                    else {
                        node.parent = tmp;
                        tmp.right = node;
                        break;
                    }
                } else {
                    if (tmp.left != nil)
                        tmp = tmp.left;
                    else {
                        node.parent = tmp;
                        tmp.left = node;
                        break;
                    }
                }
            }
        }
        fixUp(node);
    }

    public void insert(K key) {
        Node<K, V> node = new Node(key);
        insert(node);
    }

    public void insert(K key, V value) {
        Node<K, V> node = new Node(key, value);
        insert(node);
    }

    public void print(Node<K, V> node) {
        if (node == nil)
            return;
        else if (node.value == null) {
            System.out.println((node.color == RED ? "Красный " : "Чёрный ") + node.key + "; Родитель: " + node.parent.key);
            print(node.left);
            print(node.right);
        } else {
            System.out.println((node.color == RED ? "Красный " : "Чёрный ") + " Ключ: " + node.key + " Значение: " + node.value + "; Родитель: " + node.parent.key);
            print(node.left);
            print(node.right);
        }
    }

    public void printOne(Node<K, V> node) {
        if (node == nil)
            return;
        else if (node.value == null) {
            System.out.println((node.color == RED ? "Красный " : "Чёрный ") + " Ключ: " + node.key + " Значение: " + node.value + "; Родитель: " + node.parent.key);
        } else {
            System.out.println((node.color == RED ? "Красный " : "Чёрный ") + " Ключ: " + node.key + " Значение: " + node.value + "; Родитель: " + node.parent.key);
        }
    }


    public Node find(Node<K, V> node, Node<K, V> findNode) {
        if (root == nil)
            return null;
        if (findNode.key.compareTo(node.key) > 0) {
            if (node.right != nil)
                return find(node.right, findNode);
        } else if (findNode.key.compareTo(node.key) < 0) {
            if (node.left != nil)
                return find(node.left, findNode);
        } else if (findNode.key == node.key)
            return node;
        return null;
    }

    public void find(K findNode) {
        Node<K, V> focus = new Node(findNode);
        printOne(find(root, focus));
    }

    public Node find(K findNode, int i) {
        Node<K, V> focus = new Node(findNode);
        return find(root, focus);
    }

    public void REdefine(K key, V value) {
        int i = 1;
        find(key, 1).value = value;
    }


    private void leftRotate(Node<K, V> node) {
        if (node.parent == nil) {
            Node<K, V> right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = nil;
            root = right;
        } else {
            if (node.parent.left == node)
                node.parent.left = node.right;
            else
                node.parent.right = node.right;
            node.right.parent = node.parent;
            node.parent = node.right;
            if (node.right.left != nil)
                node.right.left.parent = node;
            node.right = node.right.left;
            node.parent.left = node;
        }
    }

    private void rightRotate(Node<K, V> node) {
        if (node.parent == nil) {
            Node left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = nil;
            root = left;
        } else {
            if (node.parent.left == node)
                node.parent.left = node.left;
            else
                node.parent.right = node.left;
            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != nil)
                node.left.right.parent = node;
            node.left = node.left.right;
            node.parent.right = node;
        }
    }

    private void fixUp(Node<K, V> node) {
        while (node.parent.color == RED) {
            Node<K, V> uncle = nil;
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;
                if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.right) {
                    node = node.parent;
                    leftRotate(node);
                }
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                rightRotate(node.parent.parent);
            } else {
                uncle = node.parent.parent.left;
                if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.left) {
                    node = node.parent;
                    rightRotate(node);
                }
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                leftRotate(node.parent.parent);
            }
        }
        root.color = BLACK;
    }

    boolean delete(Node<K, V> z) {
        z = find(root, z);
        if (z == null)
            return false;
        Node<K, V> x;
        Node<K, V> y = z;
        int y_original_color = y.color;

        if (z.left == nil) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == nil) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = treeMinimum(z.right);
            y_original_color = y.color;
            x = y.right;
            if (y.parent == z)
                x.parent = y;
            else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (y_original_color == BLACK)
            deleteFixup(x);
        return true;
    }

    void delete(K key) {
        Node<K, V> node = new Node(key);
        delete(node);
    }

    void deleteAll() {
        root = null;
        System.gc();
    }

    void deleteFixup(Node<K, V> x) {
        while (x != root && x.color == BLACK) {
            if (x == x.parent.left) {
                Node<K, V> w = x.parent.right;
                if (w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }
                if (w.left.color == BLACK && w.right.color == BLACK) {
                    w.color = RED;
                    x = x.parent;
                    continue;
                } else if (w.right.color == BLACK) {
                    w.left.color = BLACK;
                    w.color = RED;
                    rightRotate(w);
                    w = x.parent.right;
                }
                if (w.right.color == RED) {
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.right.color = BLACK;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                Node<K, V> w = x.parent.left;
                if (w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }
                if (w.right.color == BLACK && w.left.color == BLACK) {
                    w.color = RED;
                    x = x.parent;
                    continue;
                } else if (w.left.color == BLACK) {
                    w.right.color = BLACK;
                    w.color = RED;
                    leftRotate(w);
                    w = x.parent.left;
                }
                if (w.left.color == RED) {
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.left.color = BLACK;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = BLACK;
    }

    void transplant(Node<K, V> target, Node<K, V> with) {
        if (target.parent == nil) {
            root = with;
        } else if (target == target.parent.left) {
            target.parent.left = with;
        } else
            target.parent.right = with;
        with.parent = target.parent;
    }

    Node treeMinimum(Node<K, V> subTreeRoot) {
        while (subTreeRoot.left != nil) {
            subTreeRoot = subTreeRoot.left;
        }
        return subTreeRoot;
    }

    Node treeMaximum(Node<K, V> subTreeRoot) {
        while (subTreeRoot.right != nil) {
            subTreeRoot = subTreeRoot.right;
        }
        return subTreeRoot;
    }

    public void isEmpty() {
        if (root == null)
            System.out.println("Tree is empty");
        else
            System.out.println("Tree isn't empty");
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new RedBlackTreeIterator(root);
    }        //итератор

    private class RedBlackTreeIterator implements Iterator<Node<K, V>> {
        Stack<Node<K, V>> stack;

        RedBlackTreeIterator(Node<K, V> root) {
            stack = new Stack<Node<K, V>>();
            explore(root);
        }

        private void explore(Node<K, V> node) {
            while (node != null) {
                if (node.key == null)
                    break;
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.empty();
        }

        @Override
        public Node<K, V> next() {
            Node<K, V> node = stack.pop();
            if (node.right != null) {
                explore(node.right);
            }
            return node;
        }
    }


    public static void main(String[] args) {
        RBTree<Integer, String> tree = new RBTree();
        tree.insert(15, "TTTT");
        tree.insert(16, "MMMM");
        tree.insert(14, "CCCC");
        tree.insert(13, "AAAA");
        System.out.println("Дерево:");
        tree.print(tree.root);
        System.out.println();

        tree.delete(13);
        System.out.println("Удален элемент под ключом 13:");
        tree.print(tree.root);
        System.out.println();

        System.out.println("Проверка на пустоту:");
        tree.isEmpty();
        System.out.println();

        System.out.println("Поиск по ключу(15):");
        tree.find(15);
        System.out.println();

        System.out.println("Изменение значения по ключу, первый параметр - ключ узла, второй параметр - новое значение. Здесь меняем узлу под ключом 15 значение на другой набор букв:");
        tree.REdefine(15, "KKKK");
        tree.find(15);
        System.out.println();

        System.out.println("Копирование:");
        RBTree<Integer, String> map = new RBTree<>(tree);
        for (Node<Integer, String> node : map) {
            System.out.println(node.key + " " + node.value);
        }
        System.out.println();

        System.out.println("Удаление и проверка на пустоту:");
        tree.deleteAll();
        tree.isEmpty();
        System.out.println();


        System.out.println("От себя добвалю, что не успел разобраться с junit в достаточной мере, для создания тестов... почему-то выполнение этой лабороторной работы заняло больше времени,чем ожидалось.");
    }
}