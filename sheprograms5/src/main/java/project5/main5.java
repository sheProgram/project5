package project5;

import ADTPackage.*;

public class main5 {
    public static void main (String[] args){

        // int graphSize = 9;
        // int counter = 1;
        // Graph<String> graph = new Graph<>(graphSize);

        // // create a graph given in the project prompt.
        // graph.setLabel(0, "A");
        // graph.addEdge(0,1);
        // graph.addEdge(0,3);
        // graph.addEdge(0,4);
        // graph.setLabel(1, "B");
        // graph.addEdge(1,4);
        // graph.setLabel(2, "C");
        // graph.addEdge(2,1);
        // graph.setLabel(3, "D");
        // graph.addEdge(3,6);
        // graph.setLabel(4, "E");
        // graph.addEdge(4,5);
        // graph.addEdge(4,7);
        // graph.setLabel(5, "F");
        // graph.addEdge(5,2);
        // graph.addEdge(5,7);
        // graph.setLabel(6, "G");
        // graph.addEdge(6,7);
        // graph.setLabel(7, "H");
        // graph.addEdge(7,8);
        // graph.setLabel(8, "I");
        // graph.addEdge(8,5);

        // // perform a breadth-first traversal on the
        // // graph starting at vertex A.
        // QueueInterface<String> breadthFirst = graph.getBreadthFirstTraversal("A");

        // // display the vertices in order in which they were visited.
        // System.out.print("Displaying the vertices in breadth-first traversal order: ");
        // while (!breadthFirst.isEmpty())
        // {
        //     String label = breadthFirst.dequeue();

        //     System.out.print(label);
        //     if (counter < graphSize)
        //     {
        //         System.out.print(" -> ");
        //         ++counter;
        //     }
        // }
        // System.out.println();
        // // restart the counter that's used for the number of arrows used.
        // counter = 1;

        // // perform a depth-first traversal on the
        // // graph starting at vertex A.
        // QueueInterface<String> depthFirst = graph.getDepthFirstTraversal("A");

        // // display the vertices in order in which they were visited.
        // System.out.print("Displaying the vertices in depth-first traversal order: ");
        // while (!depthFirst.isEmpty())
        // {
        //     String label = depthFirst.dequeue();

        //     System.out.print(label);
        //     if (counter < graphSize)
        //     {
        //         System.out.print(" -> ");
        //         ++counter;
        //     }
        // }
        // System.out.println();

        // GraphInterface<String> pgraph = new Graph<>();

//         //Add vertices to the graph
//         pgraph.addVertex("A");
//         pgraph.addVertex("B");
//         pgraph.addVertex("C");
//         pgraph.addVertex("D");
//         pgraph.addVertex("E");
//         pgraph.addVertex("F");
//         pgraph.addVertex("G");
//         pgraph.addVertex("H");
//         pgraph.addVertex("I");

//         //Connect the vertices
//         pgraph.addEdge("A", "B");
//         pgraph.addEdge("A", "E");
//         pgraph.addEdge("A", "D");
//         pgraph.addEdge("B", "E");
//         pgraph.addEdge("D", "G");
//         pgraph.addEdge("E", "F");
//         pgraph.addEdge("E", "H");
//         pgraph.addEdge("G", "H");
//         pgraph.addEdge("H", "I");
//         pgraph.addEdge("F", "H");
//         pgraph.addEdge("F", "C");
//         pgraph.addEdge("C", "B");


// System.out.println("Breadth First Traversal: ");
// System.out.println(pgraph.getBreadthFirstTraversal("A"));
// System.out.println("\nDepth first Traversal: ");
// System.out.println(pgraph.getDepthFirstTraversal("A"));
    
    }
}
