package JavaDS.Graphs;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {
    static class Graph {
        ArrayList<ArrayList<Integer>> adj;  // using adjacency list approach
        Graph(int size) {
            this.adj = new ArrayList<>();   // initialise array for vertices
            for (int i = 0; i < size; i++) {
                adj.add(new ArrayList<>()); // initialise array for edges of each vertex
            }
        }
    }

    // Time: O(V+E), Space: O(V)
    static boolean isCycleDfs(Graph g) {
        boolean[] visited = new boolean[g.adj.size()];
        boolean[] recStack = new boolean[g.adj.size()]; // recStack[] keeps track of vertices in the recursion stack (i.e. in the current connected component)
        for (int i = 0; i < visited.length; i++) { // works for disconnected graph as well
            if (!visited[i])
                if (dfsUtil(g, i, visited, recStack)) return true;
        }
        return false;
    }
    static boolean dfsUtil(Graph g, int u, boolean visited[], boolean recStack[]) { // keeping track of prev node to avoid detecting cycle when traversal gets back to previous node
        visited[u] = true;
        recStack[u] = true;
        for (int v : g.adj.get(u)) {
            if (!visited[v]) {
                if (dfsUtil(g, v, visited, recStack)) return true;
            }
            else if (recStack[v]) return true;  // if the already visited neighbour lies in the recursion stack (of the current connected component)
        }
        recStack[u] = false;    //same node (u) can be reached by multiple connected components
        return false;
    }
}
