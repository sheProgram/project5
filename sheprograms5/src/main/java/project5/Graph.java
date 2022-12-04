// package project5;

// import java.util.Iterator;
// import ADTPackage.*;
// import project5.GraphInterface;

// public final class Graph<T> implements GraphInterface<T> {

//     private DictionaryInterface<T, VertexInterface<T>> vertices;
//     private int edgeCount;

//     public Graph()
//     {
//         vertices = new UnsortedLinkedDictionary<>();
//         edgeCount = 0;
//     }

//     public boolean addVertex(T vertexLabel){
//         VertexInterface<T> addResult = vertices.add(vertexLabel, new Vertex<>(vertexLabel));
//         return addResult == null;
//     }

//     public QueueInterface<T> getBreadthFirstTraversal(T origin) {
//         QueueInterface<T> traversalOrder = new LinkedQueue<>();
//         QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>();

//         VertexInterface<T> originVertex = vertices.getValue(origin);
//         originVertex.visit();
//         traversalOrder.enqueue(origin); // Enqueue vertex label
//         vertexQueue.enqueue(originVertex); // Enqueue vertex

//         while (!vertexQueue.isEmpty()) {
//             VertexInterface<T> frontVertex = vertexQueue.dequeue();
//             Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();

//             while (neighbors.hasNext()) {
//                 VertexInterface<T> nextNeighbor = neighbors.next();
//                 if (!nextNeighbor.isVisited()) {
//                     nextNeighbor.visit();
//                     traversalOrder.enqueue(nextNeighbor.getLabel());
//                     vertexQueue.enqueue(nextNeighbor);
//                 } // end if
//             } // end while
//         } // end while
//         return traversalOrder;
//     } // end getBreadthFirstTraversal
// } // end Graph
