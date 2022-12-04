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
        
    }
}