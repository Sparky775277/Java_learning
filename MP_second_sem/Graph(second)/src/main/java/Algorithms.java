import java.util.*;


public class Algorithms {
    public Algorithms(){
    }

    public static <T extends Comparable<T>> List<T> tarjan(final Graph<T> graph) throws Exception {
        Objects.requireNonNull(graph);
        Set<T> grayVertex = new HashSet<>();
        List<T> blackVertex = new ArrayList<>();

        for (T vertex : graph.getVertexNames()) {
            helperTarjan(vertex, graph, blackVertex, grayVertex);
        }

        Collections.reverse(blackVertex);
        return blackVertex;
    }

    private static <T extends Comparable<T>> void helperTarjan(T vertex, Graph<T> graph, List<T> blackVertex, Set<T> grayVertex) throws Exception {
        if (blackVertex.contains(vertex)) {
            return;
        }
        if (grayVertex.contains(vertex)) {
            throw new Exception("Detected loop. Algorithm cannot be used for this graph.");
        }

        grayVertex.add(vertex);
        List<T> neighbors = graph.getOutEdges(vertex);
        for (T neighbor : neighbors) {
            helperTarjan(neighbor, graph, blackVertex, grayVertex);
        }
        grayVertex.remove(vertex);
        blackVertex.add(vertex);
    }

    public static <T extends Comparable<T>> List<Edge<T>> fleury(final Graph<T> graph) throws Exception {
        Objects.requireNonNull(graph);
        Graph<T> graphOther = new Graph<>(graph);

        T startVertex = checkGraphForEuler(graph, false);

        List<Edge<T>> result = new ArrayList<>();
        helperFleury(startVertex, startVertex, graphOther, result);
        return result;
    }

    private static <T extends Comparable<T>> void helperFleury(T vertex, T startVertex, Graph<T> graph, List<Edge<T>> result) throws Exception {
        for (T neighbor : graph.getVertexNames()) {
            if (graph.getEdge(vertex, neighbor) == null) {
                continue;
            }
            if (neighbor.equals(startVertex) && (graph.getOutEdges(vertex).size() > 1)) {
                continue;
            }

            if (canBeRemoved(vertex, neighbor, graph)) {
                result.add(graph.getEdge(vertex, neighbor));
                graph.removeEdge(vertex, neighbor);
                helperFleury(neighbor, startVertex, graph, result);
                break;
            }
        }
    }

    private static <T extends Comparable<T>> boolean canBeRemoved(T src, T dest, final Graph<T> graph) throws Exception {

        if (graph.getOutEdges(src).size() == 1) {
            return true;
        }

        int allEdgesCount = graph.getAllEdges().size();
        int newEdgesCount = 0;

        Deque<Edge<T>> stack = new ArrayDeque<>();
        Set<Edge<T>> visited = new HashSet<>();
        Edge<T> tempEdge = graph.getEdge(src, dest);
        graph.removeEdge(src, dest);
        stack.add(tempEdge);


        while (!stack.isEmpty()) {
            Edge<T> edge = stack.pop();
            visited.add(edge);
            for (Edge<T> e : graph.getEdges(edge.nameVertexTo)) {
                if (!visited.contains(e) && !stack.contains(e)) {
                    stack.add(e);
                }
            }
            newEdgesCount++;
        }
        graph.addEdge(tempEdge.nameVertexFrom, tempEdge.nameVertexTo, tempEdge.weight);

        return allEdgesCount == newEdgesCount;
    }

    public static <T extends Comparable<T>> List<Edge<T>> findEulerCycle(final Graph<T> graph) throws Exception {
        Objects.requireNonNull(graph);
        Graph<T> graphOther = new Graph<>(graph);

        T startVertex = checkGraphForEuler(graphOther, true);

        List<T> result = new ArrayList<>();
        Deque<T> stack = new ArrayDeque<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            T v = stack.peek();
            if (graphOther.getOutEdges(v).isEmpty()) {
                result.add(v);
                stack.pop();
            } else {
                Edge<T> edge = graphOther.getEdges(v).get(0);
                graphOther.removeEdge(edge.nameVertexFrom, edge.nameVertexTo);
                stack.push(edge.nameVertexTo);
            }
        }

        Collections.reverse(result);

        List<Edge<T>> edgeResult = new ArrayList<>();
        for (int i = 0; i < result.size() - 1; i++) {
            edgeResult.add(
                    graph.getEdge(result.get(i), result.get(i + 1))
            );
        }


        return edgeResult;
    }

    private static <T extends Comparable<T>> T checkGraphForEuler(final Graph<T> graph, boolean isCycle) throws Exception {
        int degreeP1 = 0; // inDegree = outDegree + 1
        int degreeM1 = 0; // inDegree = outDegree - 1
        T startVertex = null;
        for (T vertex : graph.getVertexNames()) {
            if (graph.getInEdges(vertex).size() == graph.getOutEdges(vertex).size()) {
                continue;
            }
            if (degreeM1 == 0 && graph.getInEdges(vertex).size() == graph.getOutEdges(vertex).size() - 1) {
                degreeM1++;
                startVertex = vertex;
                continue;
            }
            if (degreeP1 == 0 && graph.getInEdges(vertex).size() == graph.getOutEdges(vertex).size() + 1) {
                degreeP1++;
                continue;
            }
            throw new Exception("Euler path does not exist. Algorithm cannot be used for this graph.");
        }
        if (degreeM1 != degreeP1) {
            throw new Exception("Euler path does not exist. Algorithm cannot be used for this graph.");
        }

        if (isCycle && degreeM1 == 1) {
            throw new Exception("Euler circuit does not exist. Algorithm cannot be used for this graph.");
        }

        if (degreeM1 == 0) {
            for (T vertex : graph.getVertexNames()) {
                Map<T, Integer> shortestMap = dijkstrasAlgorithm(graph, vertex);
                long existedPathCount = shortestMap.values().stream().filter(x -> x != -1).count();
                if (existedPathCount != graph.getVertexNames().size()) {
                    throw new Exception("Euler circuit does not exist. Algorithm cannot be used for this graph.");
                }
            }
        }
        if (startVertex == null) {
            startVertex = graph.getVertexNames().get(0);
        }

        return startVertex;
    }

    public static <T extends Comparable<T>> List<List<T>> kosaraju(final Graph<T> graph) throws Exception {
        Objects.requireNonNull(graph);
        List<List<T>> result = new ArrayList<>();

        // Non-recursive algorithm
        Stack<T> dfsStack = new Stack<>();
        Stack<T> resultStack = new Stack<>();
        Deque<T> unvisited = new ArrayDeque<>(graph.getVertexNames());
        dfsStack.add(graph.getVertexNames().get(0));
        while (!dfsStack.isEmpty() || !unvisited.isEmpty()) {
            T vertex;
            if (dfsStack.isEmpty()) {
                vertex = unvisited.peek();
                dfsStack.add(vertex);
            } else {
                vertex = dfsStack.peek();
            }
            unvisited.remove(vertex);

            boolean existUnvisitedNeighbor = false;
            for (T neighbor : graph.getOutEdges(vertex)) {
                if (unvisited.contains(neighbor)) {
                    dfsStack.add(neighbor);
                    existUnvisitedNeighbor = true;
                    break;
                }
            }
            if (existUnvisitedNeighbor) {
                continue;
            }

            dfsStack.pop();
            resultStack.add(vertex);
        }

        Graph<T> transposedGraph = graph.getTransposedGraph();
        Set<T> visited = new HashSet<>();
        while (!resultStack.isEmpty()) {
            T vertex = resultStack.pop();
            if (!visited.contains(vertex)) {
                List<T> componentList = dfs(transposedGraph, vertex);
                componentList.removeAll(visited);
                visited.addAll(componentList);
                result.add(componentList);
            }
        }

        result.sort((x, y) -> Integer.compare(y.size(), x.size()));
        return result;
    }

    private static <T extends Comparable<T>> void dfsExtended(T vertex, Graph<T> graph, Set<T> visited, Deque<T> stack) throws Exception {
        if (!visited.contains(vertex)) {
            visited.add(vertex);
            for (T neighbor : graph.getOutEdges(vertex)) {
                dfsExtended(neighbor, graph, visited, stack);
            }
            stack.add(vertex);
        }
    }

    public static <T extends Comparable<T>> Map<T, Integer> dijkstrasAlgorithm(Graph<T> graph, T from){
        int indexFrom = graph.getIndex(from);
        Map<T, Integer> shortestWeight = new HashMap<>(); // Minimal weight of path from src to vertex
        for (int i = 0; i < graph.vertexList.size(); i++) {
            if (graph.vertexList.get(i).nameVertex.equals(from)) {
                shortestWeight.put(graph.vertexList.get(i).nameVertex, 0);
            } else {
                shortestWeight.put(graph.vertexList.get(i).nameVertex, Integer.MAX_VALUE); // MAX_VALUE instead of positive infinity
            }
        }

        Queue<T> unvisited = new LinkedList<>();
        Set<T> visited = new HashSet<>();
        unvisited.add(from);
        while (!unvisited.isEmpty()){
            T cur = unvisited.poll();
            visited.add(cur);

            int weightCur = shortestWeight.get(cur);
            List<T> neighbors = graph.getOutEdges(cur);
            for (T vertexNeighbor : neighbors){
                if (vertexNeighbor.equals(cur)){
                    continue;
                }

                int oldWeight = shortestWeight.get(vertexNeighbor);
                int newWeight = graph.getWeight(cur, vertexNeighbor);
                if ((oldWeight == Integer.MAX_VALUE) || (oldWeight > newWeight + shortestWeight.get(cur))){
                    shortestWeight.replace(vertexNeighbor, newWeight + weightCur);
                }

                if (!visited.contains(vertexNeighbor) && !unvisited.contains(vertexNeighbor)){
                    unvisited.add(vertexNeighbor);
                }
            }

        }
        return shortestWeight;
    }

    public static <T extends Comparable<T>> List<T> dfs(Graph<T> graph, T srcVertex) throws Exception {
        if (!graph.isContain(srcVertex)) {
            throw new Exception("Vertex '" + srcVertex + "' does not exist");
        }

        Stack<T> stack = new Stack<>();
        List<T> visited = new ArrayList<>();
        stack.push(srcVertex);
        while (!stack.isEmpty()) {
            T cur = stack.pop();
            if (!visited.contains(cur)) {
                visited.add(cur);

                List<T> neighbors = graph.getOutEdges(cur);
                for (T neighborVertex : neighbors) {
                    if (!visited.contains(neighborVertex)) {
                        stack.add(neighborVertex);
                    }
                }
            }
        }

        return visited;
    }
}
