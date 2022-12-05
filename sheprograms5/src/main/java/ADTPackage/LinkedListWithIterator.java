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
   private int numberOfEntries;

    public LinkedListWithIterator()
    {
        firstNode = null;
        numberOfEntries = 0;
    } // end default constructor

    public void add(T newEntry)
    {
        Node newNode = new Node(newEntry);
        if (isEmpty())
        {
            firstNode = newNode;
        }
        else
        {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode);
        }
        numberOfEntries++;
    }

    public void add(int newPosition, T newEntry)
    {
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
        {
            Node newNode = new Node(newEntry);
            if (newPosition == 1)
            {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            }
            else
            {
                Node nodeBefore = getNodeAt(newPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            }
        }
    }

    private Node getNodeAt(int givenPosition)
    {
        Node currentNode = firstNode;
        for (int counter = 1; counter < givenPosition; counter++)
            currentNode = currentNode.getNextNode();
        return currentNode;
    }

    public T remove(int givenPosition)
    {
        T result = null;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            if (givenPosition == 1)
            {
                result = firstNode.getData();
                firstNode = firstNode.getNextNode();
            }
            else
            {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData();
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);
            }
            numberOfEntries--;
            return result;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
    }

    public void clear()
    {
        firstNode = null;
        numberOfEntries = 0;
    }

    public T replace(int givenPosition, T newEntry)
    {
        if ((givenPosition >= 1 && (givenPosition <= numberOfEntries)))
        {
            Node desiredNode = getNodeAt(givenPosition);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
    }

    public T getEntry(int givenPosition)
    {
        if ((givenPosition >= 1 && (givenPosition <= numberOfEntries)))
        {
            return getNodeAt(givenPosition).getData();
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    }

    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return result;
    }
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


    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    public int getLength()
    {
        return numberOfEntries;
    }

    public boolean isEmpty()
    {
        return firstNode == null;
    }
   
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
		
        public boolean hasNext()
        {
            return nextNode != null;
        }

        public T next()
        {
            if (hasNext())
            {
                Node returnNode = nextNode;
                nextNode = nextNode.next;
                return returnNode.getData();
            }
            else
                throw new NoSuchElementException();
        }
	}} // end IteratorForLinkedList
	
 // end LinkedListWithIterator