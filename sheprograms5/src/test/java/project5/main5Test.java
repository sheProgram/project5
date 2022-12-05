package project5;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ADTPackage.*;

/**
 * Unit test for simple pgraph.
 */
public class main5Test 
{
    @Test
    public void getBreadthFirstTraversal() {
        Graph <String> graph1 = new Graph<>();
        //creating the vertexes
        graph1.addVertex("A");
        graph1.addVertex("B");
        graph1.addVertex("C");
        graph1.addVertex("D");
        graph1.addVertex("E");
        graph1.addVertex("F");
        graph1.addVertex("G");
        graph1.addVertex("H");
        graph1.addVertex("I");
                
        //creating the edges between them in order
        graph1.addEdge("A", "B");
        graph1.addEdge("A", "D");
        graph1.addEdge("A", "E");
        graph1.addEdge("B", "E");
        graph1.addEdge("D", "G");
        graph1.addEdge("E", "F");
        graph1.addEdge("E", "H");
        graph1.addEdge("G", "H");
        graph1.addEdge("F", "C");
        graph1.addEdge("F", "H");
        graph1.addEdge("H", "I");
        graph1.addEdge("C", "B");
        graph1.addEdge("I", "F");

        QueueInterface<String> breadthFirstTraversal = graph1.getBreadthFirstTraversal("A");
        System.out.println("BFT: \n-------------------------------------------------------");
        while(!breadthFirstTraversal.isEmpty())
        {
            System.out.print(breadthFirstTraversal.dequeue() + "-> ");
        }

    }
}