package ADTPackage;
import java.util.Iterator;

public class UnsortedLinkedDictionary<K, V> implements DictionaryInterface<K,V>{
    private Node firstNode; // Reference to first node of chain
    private int numberOfEntries;

    public UnsortedLinkedDictionary() {
        initializeDataFields();
    }

    private void initializeDataFields()
    {
        firstNode = null;
        numberOfEntries = 0;
    }

    // <Implementations of methods in DictionaryInterface>
    public V add(K key, V value) {
        if ((key == null) || (value == null)) {
            throw new IllegalArgumentException("Error! Cannot add null to dictionary!");
        }
        else {
            if (this.contains(key)) {
                return this.getValue(key);
            }
            else {
                Node newNode = new Node(key, value, firstNode);
                firstNode = newNode;
                numberOfEntries++;
                return null;
            }
        }
    }

    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Error! Cannot add null to dictionary!");
        }
        else {
            if (this.contains(key)) {
                numberOfEntries--;
                return this.getValue(key);
            }
            else {
                return null;
            }
        }
    }

    public V getValue(K key) {
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (key.equals(currentNode.getKey())) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    public boolean contains(K key) {
        boolean contains = false;
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (key.equals(currentNode.getKey())) {
                contains = true;
                break;
            }
            currentNode = currentNode.getNextNode();
        }
        return contains;
    }

    public Iterator<K> getKeyIterator() {
        return new KeyIterator();
    } // end getKeyIterator

    private class KeyIterator implements Iterator<K> {
        Iterator<Entry<K, V>> localIterator;
        
        public KeyIterator() {
            localIterator = bst.getInorderIterator();
        } // end default constructor
        
        public boolean hasNext() {
            return localIterator.hasNext();
        } // end hasNext
        
        public K next() {
            Entry<K, V> nextEntry = localIterator.next();
            return nextEntry.getKey();
        } // end next
        
        public void remove() {
            throw new UnsupportedOperationException();
        } // end remove
    } // end KeyIterator

    @Override
    public Iterator<V> getValueIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean isEmpty() {
        if (numberOfEntries == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getSize() {
        return numberOfEntries;
    }

    public void clear() {
        initializeDataFields();
    }

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
    } // end Node
} // end UnsortedLinkedDictionary