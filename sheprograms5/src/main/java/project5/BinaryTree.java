package project5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import ADTPackage.*; // Needed by tree iterators

/**
   A class that implements the ADT binary tree.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class BinaryTree<T> implements BinaryTreeInterface<T>
{
   private BinaryNode<T> root;

   public BinaryTree()
   {
      root = null;
   } // end default constructor

   public BinaryTree(T rootData)
   {
      root = new BinaryNode<>(rootData);
   } // end constructor

   public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      initializeTree(rootData, leftTree, rightTree);
   } // end constructor

    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                   BinaryTreeInterface<T> rightTree)
   {
      initializeTree(rootData, (BinaryTree<T>)leftTree,
                               (BinaryTree<T>)rightTree);
   } // end setTree

	private void initializeTree(T rootData, BinaryTree<T> leftTree,
	                                        BinaryTree<T> rightTree)
	{
      // < FIRST DRAFT - See Segments 25.4 - 25.7 for improvements. >
      root = new BinaryNode<T>(rootData);
      
      if (leftTree != null)
         root.setLeftChild(leftTree.root);
      
      if (rightTree != null)
         root.setRightChild(rightTree.root);
	} // end initializeTree

    public T getRootData() {
        if (isEmpty()) {
            throw new EmptyTreeException("Error! The tree is empty!");
        }
        else {
            return root.getData();
        }
    }

    @Override
    public int getHeight() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getNumberOfNodes() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Iterator<T> getPreorderIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<T> getPostorderIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<T> getInorderIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<T> getLevelOrderIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setRootData(T rootData) {
        // TODO Auto-generated method stub
        
    }

/* Implementations of setRootData, getRootData, getHeight, getNumberOfNodes,
   isEmpty, clear, and the methods specified in TreeIteratorInterface are here.
   . . . */

} // end BinaryTree
