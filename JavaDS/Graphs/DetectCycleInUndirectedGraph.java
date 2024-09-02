package JavaDS.Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycleInUndirectedGraph {
    static class Graph {
        ArrayList<ArrayList<Integer>> adj;  // using adjacency list approach
        Graph(int size) {
            this.adj = new ArrayList<>();   // initialise array for vertices
            for (int i = 0; i < size; i++) {
                adj.add(new ArrayList<>()); // initialise array for edges of each vertex
            }
        }
    }

    static Graph createUndirectedGraph(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of undirected graph");
        Graph g=new Graph(sc.nextInt());
        for(int i=0;i<g.adj.size();i++){
            System.out.println("Enter the connecting value for"+i);
            int j=sc.nextInt();
            while (j!=-1){
                g.adj.get(i).add(j);
                g.adj.get(j).add(i);
                j=sc.nextInt();
            }
        }
        return g;
    }

    // Time: O(V+E), Space: O(V)
    static boolean isCycleDfs(Graph g) {
        boolean visited[] = new boolean[g.adj.size()];
        for (int i = 0; i < visited.length; i++) { // works for disconnected graph as well
            if (!visited[i])
                if (dfsUtil(g, i, visited, -1)) return true;
        }
        return false;
    }
    static boolean dfsUtil(Graph g, int u, boolean visited[], int prev) { // keeping track of prev node to avoid detecting cycle when traversal gets back to previous node
        visited[u] = true;
        for (int v : g.adj.get(u)) {
            if (!visited[v]) {
                if (dfsUtil(g, v, visited, u)) return true;
            }
            else if (prev != v) return true;
        }
        return false;
    }

    static void printGraph(Graph g) {
        for (int i=0;i<g.adj.size();i++){
            System.out.print(i+":");
            for (int j=0;j<g.adj.get(i).size();j++){
                System.out.print(g.adj.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }

    public static void main (String args[]) {
        System.out.println("Create new undirected graph");
        Graph g =createUndirectedGraph();
        printGraph(g);
        System.out.println("\nIs cycle present in undirected graph: " + isCycleDfs(g));
    }
}
