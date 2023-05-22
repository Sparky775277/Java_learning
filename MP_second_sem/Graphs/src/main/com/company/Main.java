package com.company;

public class Main {

        public static void main(String[] args) {
            Graph g = new Graph(5);
            g.addEdge(0, 1);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(3, 3);
            g.addEdge(4, 2);
            g.printAdjacencyList();
        }
    }

