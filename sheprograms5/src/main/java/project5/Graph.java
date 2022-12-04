package project5;

import java.util.Iterator;
import ADTPackage.*;

public final class Graph<T> implements GraphInterface<T> {

    private DictionaryInterface<T, VertexInterface<T>> vertices;
    private int edgeCount;

    public Graph()
    {
        vertices = new UnsortedLinkedDictionary<>();
        edgeCount = 0;
    }

    public boolean addVertex(T vertexLabel){
        VertexInterface<T> addResult = vertices.add(vertexLabel, new Vertex<>(vertexLabel));
        return addResult == null;
    }

    public QueueInterface<T> getBreadthFirstTraversal(T origin) {
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>();

        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin); // Enqueue vertex label
        vertexQueue.enqueue(originVertex); // Enqueue vertex

        while (!vertexQueue.isEmpty()) {
            VertexInterface<T> frontVertex = vertexQueue.dequeue();
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();

            while (neighbors.hasNext()) {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (!nextNeighbor.isVisited()) {
                    nextNeighbor.visit();
                    traversalOrder.enqueue(nextNeighbor.getLabel());
                    vertexQueue.enqueue(nextNeighbor);
                } // end if
            } // end while
        } // end while
        return traversalOrder;
    } // end getBreadthFirstTraversal

    @Override
    public boolean addEdge(T begin, T end, double edgeWeight) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addEdge(T begin, T end) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasEdge(T begin, T end) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        return vertices.isEmpty();
    } // end isEmpty
    
    @Override
    public void clear() {
        vertices.clear();
        edgeCount = 0;
    } // end clear
    
    @Override
    public int getNumberOfVertices() {
        return vertices.getSize();
    } // end getNumberOfVertices
    
    @Override
    public int getNumberOfEdges() {
        return edgeCount;
    } // end getNumberOfEdges

    @Override
    public QueueInterface<T> getDepthFirstTraversal(T origin) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public StackInterface<T> getTopologicalOrder() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getShortestPath(T begin, T end, StackInterface<T> path) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getCheapestPath(T begin, T end, StackInterface<T> path) {
        // TODO Auto-generated method stub
        return 0;
    }
} // end Graph
