package project5;
import java.util.Iterator;
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

    @Test
    public void getDepthFirstTraversal() {
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

        QueueInterface<String> depthFirstTraversal = graph1.getDepthFirstTraversal("A");
        System.out.println("DFT:  \n-------------------------------------------------------");
        while(!depthFirstTraversal.isEmpty())
        {
            System.out.println(depthFirstTraversal.dequeue() + "-> ");
        }

    }

    @Test
    public void getBFTdupe() {
        Graph <String> graph1 = new Graph<>();
        //creating the vertexes
        graph1.addVertex("A");
        graph1.addVertex("A");
        graph1.addVertex("C");
        graph1.addVertex("D");
        graph1.addVertex("F");
        graph1.addVertex("F");
        graph1.addVertex("G");
        graph1.addVertex("H");
        graph1.addVertex("I");
                
        //creating the edges between them in order
        graph1.addEdge("A", "B");
        graph1.addEdge("A", "D");
        graph1.addEdge("A", "E");
        graph1.addEdge("B", "E");
        graph1.addEdge("G", "G");
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

    @Test
    public void getDFTdupe() {
        Graph <String> graph1 = new Graph<>();
        //creating the vertexes
        graph1.addVertex("A");
        graph1.addVertex("A");
        graph1.addVertex("A");
        graph1.addVertex("");
        graph1.addVertex("E");
        graph1.addVertex("F");
        graph1.addVertex("G");
        graph1.addVertex("H");
        graph1.addVertex("I");
                
        //creating the edges between them in order
        graph1.addEdge("A", "B");
        graph1.addEdge("A", "A");
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

        QueueInterface<String> depthFirstTraversal = graph1.getDepthFirstTraversal("A");
        System.out.println("DFT:  \n-------------------------------------------------------");
        while(!depthFirstTraversal.isEmpty())
        {
            System.out.println(depthFirstTraversal.dequeue() + "-> ");
        }

    }
    @Test
    public void getDFTempty() {
        Graph <String> graph1 = new Graph<>();
        //creating the vertexes
        graph1.addVertex("A");
        graph1.addVertex("B");
        graph1.addVertex("");
        graph1.addVertex("");
        graph1.addVertex("E");
        graph1.addVertex("");
        graph1.addVertex("G");
        graph1.addVertex("H");
        graph1.addVertex("");
                
        //creating the edges between them in order
        graph1.addEdge("A", "B");
        graph1.addEdge("", "");
        graph1.addEdge("A", "");
        graph1.addEdge("B", "E");
        graph1.addEdge("D", "G");
        graph1.addEdge("E", "F");
        graph1.addEdge("E", "H");
        graph1.addEdge("G", "H");
        graph1.addEdge("F", "C");
        graph1.addEdge("F", "H");
        graph1.addEdge("", "");
        graph1.addEdge("C", "B");
        graph1.addEdge("I", "F");

        QueueInterface<String> depthFirstTraversal = graph1.getDepthFirstTraversal("A");
        System.out.println("DFT:  \n-------------------------------------------------------");
        while(!depthFirstTraversal.isEmpty())
        {
            System.out.println(depthFirstTraversal.dequeue() + "-> ");
        }

    }

    @Test
    public void getBFTempty() {
        Graph <String> graph1 = new Graph<>();
        //creating the vertexes
        graph1.addVertex("A");
        graph1.addVertex("");
        graph1.addVertex("C");
        graph1.addVertex("");
        graph1.addVertex("");
        graph1.addVertex("F");
        graph1.addVertex("");
        graph1.addVertex("");
        graph1.addVertex("");
                
        //creating the edges between them in order
        graph1.addEdge("A", "B");
        graph1.addEdge("A", "D");
        graph1.addEdge("", "");
        graph1.addEdge("B", "E");
        graph1.addEdge("G", "G");
        graph1.addEdge("", "");
        graph1.addEdge("E", "");
        graph1.addEdge("", "");
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
@Test

public void preorderdupe() {
            // Represent each leaf as a one-node tree
            BinaryTreeInterface<String> dTree = new BinaryTree<>();
            dTree.setTree("D", null, null);
    
            BinaryTreeInterface<String> dupeTree = new BinaryTree<>();
            dupeTree.setTree("D", null, null);
    
            BinaryTreeInterface<String> gTree = new BinaryTree<>();
            gTree.setTree("G", null, null);
    
            BinaryTreeInterface<String> hTree = new BinaryTree<>();
            hTree.setTree("H", null, null);
    
            BinaryTreeInterface<String> emptyTree = new BinaryTree<>();
    
            // Form larger subtrees
            BinaryTreeInterface<String> eTree = new BinaryTree<>();
            eTree.setTree("E", dupeTree, gTree); // Subtree rooted at E
    
            BinaryTreeInterface<String> bTree = new BinaryTree<>();
            bTree.setTree("B", dTree, eTree); // Subtree rooted at B
    
            BinaryTreeInterface<String> cTree = new BinaryTree<>();
            cTree.setTree("C", emptyTree, hTree); // Subtree rooted at C
    
            BinaryTreeInterface<String> aTree = new BinaryTree<>();
            aTree.setTree("A", bTree, cTree); // Desired tree rooted at A
    
            System.out.println("");
            // Display root, height, number of nodes
            System.out.println("\n-------------------------------------------------------");
            System.out.println("Root of tree contains " + aTree.getRootData());
            System.out.println("Height of tree is " + aTree.getHeight());
            System.out.println("Tree has " + aTree.getNumberOfNodes() + " nodes");
    
            // Display nodes in preorder
            System.out.println("A preorder traversal visits nodes in this order:");
            Iterator<String> preorder =aTree.getPreorderIterator();
            while (preorder.hasNext())
            System.out.print(preorder.next() + " ");
            System.out.println();}
}
