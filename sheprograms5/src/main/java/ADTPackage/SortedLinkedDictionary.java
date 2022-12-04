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
	private Node<K,V> firstNode; // Reference to first node of chain
	private int numberOfEntries; 
	
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
         Node<K,V> currentNode = firstNode;
         Node<K,V> nodeBefore = null;
         
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
            Node<K,V> newNode = new Node<K,V>(key, value, firstNode); // Create new node
            
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
        Node<K,V> currentNode = firstNode;
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
        Node<K,V> currentNode = firstNode;
        while (currentNode != null) {
            if (key.equals(currentNode.getKey())) {
                contains = true;
                break;
            } // end if
            currentNode = currentNode.getNextNode();
        } // end while
        return contains;
    } // end contains

    public Iterator<K> getKeyIterator() {
        return new KeyIterator();
    }

    public Iterator<V> getValueIterator() {
        return new ValueIterator();
    }

    public boolean isEmpty() {
        if (numberOfEntries == 0) {
            return true;
        } 
        else {
            return false;
        }
    } // end isEmpty

    public int getSize() {
        return numberOfEntries;
    } // end getSize

    public void clear() {
       initializeDataFields();
    } // end clear

   /* Constructors and the methods getKey, getValue, setValue, getNextNode,
      and setNextNode are here. There is no setKey. */
	private class Node<k, v> {
		private K key;
		private V value;
		private Node<K,V> next;

        private Node (K searchKey, V dataValue) {
            key = searchKey;
            value = dataValue;
            next = null;
        } // end constructor

        private Node (K searchKey, V dataValue, Node<K,V> nextNode) {
            key = searchKey;
            value = dataValue;
            next = nextNode;
        } // end constructor

        private Node<K,V> getNextNode() {
            return next;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        } 

        private void setNextNode(Node<K,V> nextNode) {
            next = nextNode;
        }

        private void setValue(V newValue) {
            value = newValue;
        }
	} // end Node

    private class KeyIterator implements Iterator<K> {
        private Node<K,V> nextNode;

        private KeyIterator() {
            nextNode = firstNode;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public K next() {
            K result;
            if (hasNext()) {
                result = nextNode.getKey();
                nextNode = nextNode.getNextNode();
            }  
            else {
                throw new IllegalCallerException("Illegal call to next(); iterator is after end of list");
            }
            return result;
        }
    } // end KeyIterator

    private class ValueIterator implements Iterator<V> {
        private Node<K,V> nextNode;
        private ValueIterator() {
            nextNode = firstNode;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public V next() {
            V result;
            if (hasNext()) {
                result = nextNode.getValue();
                nextNode = nextNode.getNextNode();
            }  
            else {
                throw new IllegalCallerException("Illegal call to next(); iterator is after end of list");
            }
            return result;
        }
    } // end ValueIterator 
} // end SortedLinkedDictionary