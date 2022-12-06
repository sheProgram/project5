package project5;
import ADTPackage.*;

/**
 * Driver class for running the graph traversal code.
 */
public class main5 {
    public static void main (String[] args){
        GraphInterface<String> pgraph = new Graph<>();
        pgraph.addVertex("A");
        pgraph.addVertex("B");
        pgraph.addVertex("C");
        pgraph.addVertex("D");
        pgraph.addVertex("E");
        pgraph.addVertex("F");
        pgraph.addVertex("G");
        pgraph.addVertex("H");
        pgraph.addVertex("I");
        
        pgraph.addEdge("A", "B");
        pgraph.addEdge("A", "D");
        pgraph.addEdge("A", "E");
        pgraph.addEdge("B", "E");
        pgraph.addEdge("D", "G");
        pgraph.addEdge("E", "F");
        pgraph.addEdge("E", "H");
        pgraph.addEdge("G", "H");
        pgraph.addEdge("F", "C");
        pgraph.addEdge("F", "H");
        pgraph.addEdge("H", "I");
        pgraph.addEdge("C", "B");
        pgraph.addEdge("I", "F");

        QueueInterface<String> breadthFirstTraversal = pgraph.getBreadthFirstTraversal("A");
        System.out.println("BFT: \n-------------------------------------------------------");
        while(!breadthFirstTraversal.isEmpty())
        {
            System.out.print(breadthFirstTraversal.dequeue());
            System.out.print("->" );
        
        }

        System.out.println("");

        QueueInterface<String> depthFirstTraversal = pgraph.getDepthFirstTraversal("A");
        System.out.println("DFT:  \n-------------------------------------------------------");
        while(!depthFirstTraversal.isEmpty())
        {
            System.out.print(depthFirstTraversal.dequeue());
            System.out.print("->" );
        }
    }
}
