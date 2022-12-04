package ADTPackage;
import java.util.EmptyStackException;
/**
    A class of stacks whose entries are stored in a chain of nodes.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public final class LinkedStack<T> implements StackInterface<T>
{
	private T[] stack;
   private int topIndex;

   private Node topNode; // References the first node in the chain
  
   public LinkedStack()
   {
      topNode = null;
   } // end default constructor
  
//  < Implementations of the stack operations go here. >
//  . . .
private boolean integrityOK = false;
private void checkIntegrity()
{
   if (!integrityOK)
      throw new SecurityException("ArrayBag object is corrupt.");
} // end checkIntegrity
	private class Node
	{
      private T data; // Entry in stack
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         this(dataPortion, null);
      } // end constructor
      
      private Node(T dataPortion, Node linkPortion)
      {
         next = linkPortion;
      } // end constructor
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
	} // end Node

    public void push(T newEntry) {
      Node newNode = new Node(newEntry, topNode);
      topNode = newNode; 
    }

    public T pop() {
      T top = peek();  // Might throw EmptyStackException

      // Assertion: topNode != null
      topNode = topNode.getNextNode();
   
      return top;
    }

    @Override
    public T peek() {
      checkIntegrity();
      if (isEmpty())
         throw new EmptyStackException();
      else
      return stack[topIndex];
   } // end peek

    @Override
    public boolean isEmpty() {
      return topIndex < 0;
   } // end isEmpty

    @Override
    public void clear() {
      checkIntegrity();
      while (topIndex > -1){
         stack[topIndex] = null;
         topIndex--;
      } // end while
   } // end clear
} // end LinkedStack
