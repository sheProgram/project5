package ADTPackage;
import java.util.EmptyStackException;
/**
    A class of stacks whose entries are stored in a chain of nodes.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public class LinkedStack<T> implements StackInterface<T>
{
   private Node topNode; // References the first node in the chain
  
   public LinkedStack()
   {
      topNode = null;
   } // end default constructor

   /**
     * Removes all entries from this bag.
     * 
     * @author Frank M. Carrano, Timothy M. Henry
     * @version 5.0
     */
    public void clear() {
      topNode = null;
  } // end clear

    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0

  public void push(T newEntry) {
      Node newNode = new Node(newEntry, topNode);
      topNode = newNode;
  } // end push

  // @author Frank M. Carrano, Timothy M. Henry
  // @version 5.0
  public T peek() {
      if (isEmpty())
          throw new EmptyStackException();
      else
          return topNode.getData();
  } // end peek

  // @author Frank M. Carrano, Timothy M. Henry
  // @version 5.0
  public T pop() {
      T top = peek(); // Might throw EmptyStackException

      // Assertion: topNode != null
      topNode = topNode.getNextNode();

      return top;
  } // end pop

  /**
   * @author Frank M. Carrano, Timothy M. Henry
   * @version 5.0
   */
  public boolean isEmpty() {
      return topNode == null;
  } // end isEmpty

  // @version 5.0 */
  private class Node {
      private T data; // Entry in bag
      private Node next; // Link to next node

      private Node(T dataPortion) {
          this(dataPortion, null);
      } // end constructor

      private Node(T dataPortion, Node nextNode) {
          data = dataPortion;
          next = nextNode;
      } // end constructor

      private T getData() {
          return data;
      } // end getData

      private Node getNextNode() {
          return next;
      } // end getNextNode

  } // end Node

} // end LinkedStack
