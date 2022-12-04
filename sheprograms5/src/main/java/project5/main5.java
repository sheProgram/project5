package project5;
public class main5 {
    public static void main (String[] args){
    //The graph: {V, E}
        GraphInterface<Character> pgraph = new Graph<>();

        //Add vertices to the graph
        pgraph.addVertex('A');
        pgraph.addVertex('B');
        pgraph.addVertex('C');
        pgraph.addVertex('D');
        pgraph.addVertex('E');
        pgraph.addVertex('F');
        pgraph.addVertex('G');
        pgraph.addVertex('H');
        pgraph.addVertex('I');

        //Connect the vertices
        pgraph.addEdge('A', 'B');
        pgraph.addEdge('A', 'E');
        pgraph.addEdge('A', 'D');
        pgraph.addEdge('B', 'E');
        pgraph.addEdge('D', 'G');
        pgraph.addEdge('E', 'F');
        pgraph.addEdge('E', 'H');
        pgraph.addEdge('G', 'H');
        pgraph.addEdge('H', 'I');
        pgraph.addEdge('F', 'H');
        pgraph.addEdge('F', 'C');
        pgraph.addEdge('C', 'B');

    
    }
}
