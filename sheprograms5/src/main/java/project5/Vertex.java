package project5;
import java.util.Iterator;
import java.util.NoSuchElementException;
import ADTPackage.*; // Classes that implement various ADTs
/**
 A class of vertices for a graph.
 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.0
 */
class Vertex<T> implements VertexInterface<T>
{
   private T label;
   private ListWithIteratorInterface<Edge> edgeList; // Edges to neighbors
   private boolean visited;                          // True if visited
   private VertexInterface<T> previousVertex;        // On path to this vertex
   private double cost;                              // Of path to this vertex
   
   public Vertex(T vertexLabel)
   {
      label = vertexLabel;
      edgeList = new LinkedListWithIterator<>();
      visited = false;
      previousVertex = null;
      cost = 0;
   } // end constructor

   protected class Edge
   {
      private VertexInterface<T> vertex; // Vertex at end of edge
      private double weight;
      
      protected Edge(VertexInterface<T> endVertex, double edgeWeight)
      {
         vertex = endVertex;
         weight = edgeWeight;
      } // end constructor
      
      protected Edge(VertexInterface<T> endVertex)
      {
         vertex = endVertex;
         weight = 0;
      } // end constructor

      protected VertexInterface<T> getEndVertex()
      {
         return vertex;
      } // end getEndVertex
      
      protected double getWeight()
      {
         return weight; 
      } // end getWeight
   } // end Edge

public T getLabel() {
    return label;
}

public void visit() {
visited=true;    
}

public void unvisit() {
visited=false;    
}

public boolean isVisited() {
    return visited;
}

public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
   boolean result = false;

   if (!this.equals(endVertex))
   {  // Vertices are distinct
      Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
      boolean duplicateEdge = false;

      while (!duplicateEdge && neighbors.hasNext())
      {
         VertexInterface<T> nextNeighbor = neighbors.next();
         if (endVertex.equals(nextNeighbor))
            duplicateEdge = true;
      } // end while

      if (!duplicateEdge)
      {
         edgeList.add(new Edge(endVertex, edgeWeight));
         result = true;
      } // end if
   } // end if

   return result;
} // end connect

public boolean connect(VertexInterface<T> endVertex)
{
   return connect(endVertex, 0);
} // end connect

public Iterator<VertexInterface<T>> getNeighborIterator() {
   return new NeighborIterator();
} // end getNeighborIterator

private class NeighborIterator implements Iterator<VertexInterface<T>> {
   private Iterator<Edge> edges;
   
   private NeighborIterator()
   {
      edges = edgeList.getIterator();
   } // end default constructor
   
   public boolean hasNext()
   {
      return edges.hasNext();
   } // end hasNext
   
   public VertexInterface<T> next()
   {
      VertexInterface<T> nextNeighbor = null;
      
      if (edges.hasNext())
      {
         Edge edgeToNextNeighbor = edges.next();
         nextNeighbor = edgeToNextNeighbor.getEndVertex();
      }
      else
         throw new NoSuchElementException();
      
      return nextNeighbor;
   } // end next
   
   public void remove()
   {
      throw new UnsupportedOperationException();
   } // end remove
} // end NeighborIterator


public Iterator<Double> getWeightIterator() {
    return new WeightIterator();
}

private class WeightIterator implements Iterator<Double>
{
    private Iterator<Edge> edges;

    private WeightIterator()
    {
        edges = edgeList.getIterator();
    }

    public boolean hasNext()
    {
        return edges.hasNext();
    }

    public Double next()
    {
        double weight;
        if (edges.hasNext()) {
            Edge edgeToNextNeighbor = edges.next();
            weight = edgeToNextNeighbor.getWeight();
        }
        else {
            throw new NoSuchElementException();
        }
        return weight;
    }
}

public boolean hasNeighbor() {
   return !edgeList.isEmpty();
} // end hasNeighbor

public VertexInterface<T> getUnvisitedNeighbor() {
   VertexInterface<T> result = null;

   Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
   while ( neighbors.hasNext() && (result == null) )
   {
      VertexInterface<T> nextNeighbor = neighbors.next();
      if (!nextNeighbor.isVisited())
         result = nextNeighbor;
   } // end while

   return result;
} // end getUnvisitedNeighbor

public void setPredecessor(VertexInterface<T> predecessor) {
   previousVertex=predecessor;    
}


public VertexInterface<T> getPredecessor() {
   return previousVertex;
}

public boolean hasPredecessor() {
   return previousVertex != null;
}

public void setCost(double newCost) {
cost=newCost;    
}

public double getCost() {
   return cost;
}

} // end Vertex
