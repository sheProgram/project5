package ADTPackage;
import java.util.Iterator;
//import java.util.NoSuchElementException;

/**
   A class that implements the ADT dictionary by using a chain of linked nodes.
   The dictionary is sorted and has distinct search keys.
   Search keys and associated values are not null.
  
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class SortedLinkedDictionary<K extends Comparable<? super K>, V> 
             implements DictionaryInterface<K, V>
{
	private Node firstNode; // Reference to first node of chain
	private int  numberOfEntries; 
    private int lastIndex; // Index of last entry and number of entries
    
	
	public SortedLinkedDictionary()
	{
      initializeDataFields();
	} // end default constructor

    private void initializeDataFields()
    {
        firstNode = null;
        numberOfEntries = 0;
    }

   public V add(K key, V value)
	{
		V result = null;
      if ((key == null) || (value == null))
         throw new IllegalArgumentException("Cannot add null to a dictionary.");
      else
      {
         // Search chain until you either find a node containing key
         // or locate where it should be
         Node currentNode = firstNode;
         Node nodeBefore = null;
         
         while ( (currentNode != null) && (key.compareTo(currentNode.getKey()) > 0) )
         {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
         } // end while
         
         if ( (currentNode != null) && key.equals(currentNode.getKey()) )
         {
            // Key in dictionary; replace corresponding value
            result = currentNode.getValue(); // Get old value
            currentNode.setValue(value);     // Replace value
         }
         else // Key not in dictionary; add new node in proper order
         {
            // Assertion: key and value are not null
            Node newNode = new Node(key, value); // Create new node
            
            if (nodeBefore == null)
            {                                    // Add at beginning (includes empty chain)
               newNode.setNextNode(firstNode);
               firstNode = newNode;
            }
            else                                 // Add elsewhere in non-empty chain
            {
               newNode.setNextNode(currentNode); // currentNode is after new node
               nodeBefore.setNextNode(newNode);  // nodeBefore is before new node
            } // end if

            numberOfEntries++;                   // Increase length for both cases
         } // end if
      } // end if

		return result;
	} // end add

/* Implementations of other methods in DictionaryInterface.
   Private classes KeyIterator and ValueIterator (see Segment 21.20). >
   . . . */
    public V remove(K key) {
        if (key == null) {
           throw new IllegalArgumentException("Cannot add null to a dictionary.");
        } // end if
        else {
            if (this.contains(key)) {
                numberOfEntries--;
                return this.getValue(key);
            } // end if
            else {
                return null;
            } // end else
        } // end else
    } // end remove

    public V getValue(K key) {
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (key.equals(currentNode.getKey())) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNextNode();
        } // end while
        return null;
    } // end getValue

    public boolean contains(K key) {
        boolean contains = false;
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (key.equals(currentNode.getKey())) {
                contains = true;
                break;
            } // end if
            currentNode = currentNode.getNextNode();
        } // end while
        return contains;
    } // end contains

   @Override
   public Iterator<K> getKeyIterator() {
       // TODO Auto-generated method stub
       return null;
   }

   @Override
   public Iterator<V> getValueIterator() {
       // TODO Auto-generated method stub
       return null;
   }

    public boolean isEmpty() {
        return lastIndex < 1;
    } // end isEmpty

    public int getSize() {
        return lastIndex;
    } // end getSize

    public void clear() {
       initializeDataFields();
    }

   /* Constructors and the methods getKey, getValue, setValue, getNextNode,
      and setNextNode are here. There is no setKey. */
	private class Node {
		private K key;
		private V value;
		private Node next;

        private Node (K searchKey, V dataValue) {
            key = searchKey;
            value = dataValue;
            next = null;
        } // end constructor

        private Node (K searchKey, V dataValue, Node nextNode) {
            key = searchKey;
            value = dataValue;
            next = nextNode;
        } // end constructor

        private Node getNextNode() {
            return next;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        } 

        private void setNextNode(Node nextNode) {
            next = nextNode;
        }

        private void setValue(V newValue) {
            value = newValue;
        }
	} // end Node
} // end SortedLinkedDictionary