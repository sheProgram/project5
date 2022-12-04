package ADTPackage;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
   A class that implements the ADT list by using a chain of linked nodes.
   The list has an iterator. The class is similar to LList.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class LinkedListWithIterator<T> implements ListWithIteratorInterface<T>
{
   private Node firstNode;
   private int  numberOfEntries;
   private boolean integrityOK = false;

   public LinkedListWithIterator()
   {
      initializeDataFields();
   } // end default constructor

   private void initializeDataFields()
   {
       firstNode = null;
       numberOfEntries = 0;
   }

/*	< Implementations of the methods of the ADT list go here;
     you can see them in Chapter 12, beginning at Segment 12.7 >
   . . . */
   
   public Iterator<T> iterator()
   {
	   return new IteratorForLinkedList();
   } // end iterator

	public Iterator<T> getIterator()
	{
	   return iterator();
	} // end getIterator
   
	private class IteratorForLinkedList implements Iterator<T>
	{
      private Node nextNode;

		private IteratorForLinkedList()
		{
			nextNode = firstNode;
		} // end default constructor

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            return null;
        }
		
      // Implementations of the methods in the interface Iterator go here.

	} // end IteratorForLinkedList
	
	private class Node
	{
      private T data; // Entry in list
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         data = dataPortion;
         next = null;
      } // end constructor
      
      private Node(T dataPortion, Node nextNode)
      {
         data = dataPortion;
         next = nextNode;
      } // end constructor
      
      private T getData()
      {
         return data;
      } // end getData
      
      private void setData(T newData)
      {
         data = newData;
      } // end setData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node

    @Override
    public void add(T newEntry) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void add(int newPosition, T newEntry) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T remove(int givenPosition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T getEntry(int givenPosition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T[] toArray() {
        checkIntegrity();
        // The cast is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast

        for (int index = 0; index < numberOfEntries; index++) 
        {
            //result[index] = bag[index];
        } // end for
            
        return result;
    } // end toArray

    // Throws an exception if this object is not initialized.
    private void checkIntegrity() {
      if (!integrityOK)
         throw new SecurityException("ArrayBag object is corrupt.");
    } // end checkIntegrity

    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        
        while (!found && (currentNode != null))
        {
           if (anEntry.equals(currentNode.getData()))
              found = true;
           else
              currentNode = currentNode.getNextNode();
        } // end while
        
        return found;
    } // end contains

    public int getLength() {
        return numberOfEntries;
    } // end getLength

    public boolean isEmpty() {
        return numberOfEntries == 0; 
    } // end isEmpty
} // end LinkedListWithIterator




