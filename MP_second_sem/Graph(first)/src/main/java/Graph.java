import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Graph <T extends Comparable<T>>{
    List<Node<T>> vertexList;
    int numVertex = 0;
    int numEdge = 0;

    public Graph(){
        vertexList = new ArrayList<>();
    }

    public void addVertex(T nameVertex){
        vertexList.add(new Node<>(nameVertex));
        numVertex++;
    }

    public void addEdge(T from, T to){
        addEdge(from, to, 1);
    }

    public void addEdge(T from, T to, int weight) {
        int indexFrom = 0;
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).nameVertex.compareTo(from) == 0) {
                indexFrom = i;
                break;
            }
        }

        vertexList.get(indexFrom).edges.add(new Edge<>(from, to, weight));
        numEdge++;
    }

    public void addEdgeOriented(T from, T to){
        addEdgeOriented(from, to, 1);
    }

    public void addEdgeOriented(T from, T to, int weight){
        int indexFrom = 0;
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).nameVertex.compareTo(from) == 0) {
                indexFrom = i;
                break;
            }
        }

        vertexList.get(indexFrom).edges.add(new Edge<>(from, to, weight));
        numEdge++;
        vertexList.get(indexFrom).edges.add(new Edge<>(to, from, weight));
        numEdge++;
    }

    public boolean isContain(T vertex){
        for (Node<T> tNode : vertexList) {
            if (tNode.nameVertex.compareTo(vertex) == 0) {
                return true;
            }
        }
        return false;
    }

    public List<T> getOutEdges(T vertex){
        ArrayList<T> result = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < vertexList.size(); i++){
            if (vertexList.get(i).nameVertex.compareTo(vertex) == 0){
                index = i;
                break;
            }
        }
        for (int i = 0; i < vertexList.get(index).edges.size(); i++){
            result.add(vertexList.get(index).edges.get(i).nameVertexTo);
        }

        return result;
    }

    public List<Edge<T>> getAllEdges(){
        ArrayList<Edge<T>> result = new ArrayList<>();

        for (Node<T> tNode : vertexList) {
            result.addAll(tNode.edges);
        }

        return result;
    }

    public List<T> getVertexNames(){
        ArrayList<T> result = new ArrayList<>();

        for (Node<T> node : vertexList){
            result.add(node.nameVertex);
        }

        return result;
    }

    public int getWeight(T from, T to){
        int indexFrom = indexOf(from);

        for (int i = 0; i < vertexList.size(); i++){
            if (vertexList.get(indexFrom).edges.get(i).nameVertexTo.compareTo(to) == 0){
                return vertexList.get(indexFrom).edges.get(i).weight;
            }
        }

        return 0;
    }

    public int indexOf(T data){
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).nameVertex.compareTo(data) == 0) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph<?> graph = (Graph<?>) o;

        var setVertexA = new HashSet<>(graph.vertexList);
        var setVertexB = new HashSet<>(this.vertexList);

        var setEdgeA = new HashSet<>(graph.getAllEdges());
        var setEdgeB = new HashSet<>(graph.getAllEdges());

        if (!setVertexA.equals(setVertexB)) return false;
        return setEdgeA.equals(setEdgeB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexList, numVertex, numEdge);
    }
}