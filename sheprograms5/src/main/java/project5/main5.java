package project5;
import ADTPackage.*;
import java.util.Iterator;

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

        // Represent each leaf as a one-node tree
BinaryTreeInterface<String> dTree = new BinaryTree<>();
dTree.setTree("D", null, null);

BinaryTreeInterface<String> fTree = new BinaryTree<>();
fTree.setTree("F", null, null);

BinaryTreeInterface<String> gTree = new BinaryTree<>();
gTree.setTree("G", null, null);

BinaryTreeInterface<String> hTree = new BinaryTree<>();
hTree.setTree("H", null, null);

BinaryTreeInterface<String> emptyTree = new BinaryTree<>();

// Form larger subtrees
BinaryTreeInterface<String> eTree = new BinaryTree<>();
eTree.setTree("E", fTree, gTree); // Subtree rooted at E

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
System.out.println();
     }
}
