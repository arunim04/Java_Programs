package JavaDS.Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumSpanningTree {
    static class GraphNode implements Comparable<GraphNode> {
        int val;        // holds vertex value
        int weight;     // holds weight of the edge to the vertex
        GraphNode(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }

        public int compareTo(GraphNode that) {
            return this.weight - that.weight;
        }
    }

    static class Graph {
        ArrayList<ArrayList<GraphNode>> adj;  // using adjacency list approach
        Graph(int size) {
            this.adj = new ArrayList<>();   // initialise array for vertices
            for (int i = 0; i < size; i++) {
                adj.add(new ArrayList<>()); // initialise array for edges of each vertex
            }
        }
    }

    // Time: O(V+E), Space: O(V+E)
    static Graph createUndirectedGraph() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of undirected graph");
        Graph g = new Graph(sc.nextInt());
        for (int u = 0; u < g.adj.size(); u++) {
            System.out.println("Enter connecting value(s) for " + u + " and weight(s) of paths to them");
            System.out.println("Enter value");
            int v = sc.nextInt();
            while (v != -1) {
                System.out.println("Enter weight");
                int weight = sc.nextInt();
                g.adj.get(u).add(new GraphNode(v,weight));
                g.adj.get(v).add(new GraphNode(u,weight));
                System.out.println("Enter value");
                v = sc.nextInt();
            }
        }
        return g;
    }

    static void printGraph(Graph g) {
        for (int i = 0; i < g.adj.size(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < g.adj.get(i).size(); j++)
                System.out.print(g.adj.get(i).get(j).val + " " + g.adj.get(i).get(j).weight + ", ");
            System.out.println();
        }
    }

    // Time: O(E*log2(E)), Space: O(V+E)
    static int mstBfs(Graph g) {    // using bfs as we check all the neighbours of each vertex
        if (g.adj.size() == 0) return 0;

        int minDistSum = 0;
        boolean visited[] = new boolean[g.adj.size()];
        PriorityQueue<GraphNode> pq = new PriorityQueue<>();
        pq.add(new GraphNode(0,0));

        System.out.println("Traversal: ");
        while (!pq.isEmpty()) {
            GraphNode u = pq.remove();
            if (visited[u.val])
                continue;
            visited[u.val] = true;
            minDistSum += u.weight;
            System.out.print(u.val + " ");
            for (GraphNode v : g.adj.get(u.val)) {
                if (!visited[v.val]) {
                    pq.add(v);
                }
            }
        }
        return minDistSum;
    }

    public static void main (String args[]) {
        System.out.println("Create new undirected graph");
        Graph g = createUndirectedGraph();
        printGraph(g);
        System.out.println("\nMin distance for MST: " + mstBfs(g));
    }

}
