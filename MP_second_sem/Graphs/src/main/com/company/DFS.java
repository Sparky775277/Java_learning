package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class DFS {
    public void traverse(Vertex<T> startVertex) {
        Deque<Vertex<T>> stack = new LinkedList<>();
        stack.push(startVertex);
        while (!stack.isEmpty()) {
            Vertex<T> current = stack.pop();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current);
                current.getNeighbors().forEach(stack::push);
            }
        }
    }
}
