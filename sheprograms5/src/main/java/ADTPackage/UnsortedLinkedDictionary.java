package ADTPackage;

import java.util.Iterator;

public class UnsortedLinkedDictionary<K,V> implements DictionaryInterface<K,V> {
    private Node firstNode;
    private int numberOfEntries;

    public UnsortedLinkedDictionary() {
        initializeDataFields();
    }

    private void initializeDataFields()
    {
        firstNode = null;
        numberOfEntries = 0;
    }

    private class Node {
        private K key;
        private V value;
        private Node next;

        private Node (K searchKey, V dataValue) {
            key = searchKey;
            value = dataValue;
            next = null;
        }

        private Node (K searchKey, V dataValue, Node nextNode) {
            key = searchKey;
            value = dataValue;
            next = nextNode;
        }

    }

    @Override
    public V add(K key, V value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public V remove(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public V getValue(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean contains(K key) {
        // TODO Auto-generated method stub
        return false;
    }

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

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
package ADTPackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedLinkedDictionary<K, V> implements DictionaryInterface<K, V>
{
    private Node<K, V> firstNode; // Reference to first node of chain
    private int numberOfEntries;

    public UnsortedLinkedDictionary()
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
        if ((key == null) || (value == null))
        {
            throw new IllegalArgumentException("Cannot add null to a dictionary.");
        } else
        {
            if (this.contains(key))
            {
                return this.getValue(key);
            } else
            {
                Node<K, V> newNode = new Node<K, V>(key, value, firstNode);
                firstNode = newNode;
                numberOfEntries++;
                return null;
            }
        }

    }

    public V remove(K key)
    {
        if ((key == null))
        {
            throw new IllegalArgumentException("Cannot remove null from a dictionary.");
        } else
        {
            if (this.contains(key))
            {
                numberOfEntries--;
                return this.getValue(key);
            } else
            {
                return null;
            }
        }
    }

    public V getValue(K key)
    {
        Node<K, V> currentNode = firstNode;
        //Node<K, V> nodeBefore = null;
        while (currentNode != null)
        {
            if (key.equals(currentNode.getKey()))
            {
                return (V) currentNode.getValue();
            }
            //nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
        } // end while
        return null;
    }

    public boolean contains(K key)
    {
        boolean contains = false;
        Node<K, V> currentNode = firstNode;
        //Node<K, V> nodeBefore = null;
        while ((currentNode != null))
        {
            if (key.equals(currentNode.getKey()))
            {
                contains = true;
                break;
            }
            //nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
        } // end while
        return contains;
    }

    public Iterator<K> getKeyIterator()
    {
        return new KeyIterator();
    }

    public Iterator<V> getValueIterator()
    {
        return new ValueIterator();
    }

    public boolean isEmpty()
    {
        if (numberOfEntries == 0)
        {
            return true;
        } else
        {
            return false;
        }
    }

    public int getSize()
    {
        return numberOfEntries;
    }

    public void clear()
    {
        initializeDataFields();
    }

    private class Node<k, v>
    {
        private K key;
        private V value;

        private Node<K, V> next; // Link to next node

        private Node(K keyPortion, V dataPortion)
        {
            key = keyPortion;
            value = dataPortion;
            next = null;
        } // end constructor

        private Node(K keyPortion, V dataPortion, Node<K, V> nextNode)
        {
            key = keyPortion;
            value = dataPortion;
            next = nextNode;
        } // end constructor

        private Node<K, V> getNextNode()
        {
            return next;
        } // end getNextNode

        private K getKey()
        {
            return key;
        }

        private V getValue()
        {
            return value;
        }

        /*private void setNextNode(Node<K, V> nextNode)
        {
            next = nextNode;
        } // end setNextNode */

    }

    private class KeyIterator implements Iterator<K>
    {
        private Node<K, V> nextNode;

        private KeyIterator()
        {
            nextNode = firstNode;
        }

        public boolean hasNext()
        {
            return nextNode != null;
        }

        public K next()
        {
            K result;
            if (hasNext())
            {
                result = (K) nextNode.getKey();
                nextNode = nextNode.getNextNode();
            } else
            {
                throw new NoSuchElementException("Illegal call to next(); iterator is after end of list");
            }
            return result;
        }
    } // end KeyIterator


    private class ValueIterator implements Iterator<V>
    {
        private Node<K, V> nextNode;

        private ValueIterator()
        {
            nextNode = firstNode;
        }

        public boolean hasNext()
        {
            return nextNode != null;
        }
        

    }
}
        public V next()
        {
            V result;
            if (hasNext())
            {
                result = (V) nextNode.getValue();
                nextNode = nextNode.getNextNode();
            } else
            {
                throw new NoSuchElementException("Illegal call to next(); iterator is after end of list");
            }
            return result;
        }
    } // end KeyIterator
}