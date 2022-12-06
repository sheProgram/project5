package project5;

import java.util.Iterator;

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

    /* Implementations of setRootData, getRootData, getHeight, getNumberOfNodes,
   isEmpty, clear, and the methods specified in TreeIteratorInterface are here.
   . . . */

    public void setRootData(T rootData) {
        root.setData(rootData);  
    } // end setRootData

    public T getRootData() {
        if (isEmpty()) {
            throw new EmptyTreeException("Error! The tree is empty!");
        }
        else {
            return root.getData();
        }
    } // end getRootData

    public int getHeight() {
        int height = 0;
        if (root != null) {
           height = root.getHeight();
        }
        return height;
    } // end getHeight

    public int getNumberOfNodes() {
        int numberOfNodes = 0;
        if (root != null) {
           numberOfNodes = root.getNumberOfNodes();
        }
        return numberOfNodes;
    } // end getNumberOfNodes

    public boolean isEmpty() {
        return root == null;
    } // end isEmpty

    public void clear() {
        root = null;
    } // end clear

    private class PreorderIterator implements Iterator<T>{
        private StackInterface<BinaryNode<T>> nodeStack;
        private BinaryNode<T> currentNode;

        public PreorderIterator(){
            nodeStack = new LinkedStack<>();
            currentNode = root;
        }

        public boolean hasNext() {
            return !nodeStack.isEmpty() || (currentNode != null);
        }

        public T next(){
            BinaryNode<T> nextNode = null;

            while(currentNode != null){
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }
            if (!nodeStack.isEmpty()){
                nextNode = nodeStack.pop();
                currentNode = nextNode.getRightChild();
            }
            else{
                throw new NoSuchElementException();
            }
            return nextNode.getData();
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<T> getPreorderIterator() {
        return new PreorderIterator();
    }

    @Override
    public Iterator<T> getLevelOrderIterator() {
        // return new LevelOrderIterator();
        return null;
    }
} // end BinaryTree
