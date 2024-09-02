package JavaDS.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphOps {
    static class Graph{
        ArrayList<LinkedList<Integer>> adj;
        Graph(int size){
            this.adj=new ArrayList<>();
            for(int i=0;i<size;i++){
                adj.add(new LinkedList<>());
            }
        }
    }

    // Time: O(V+E), Space: O(V+E)
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

    static Graph createDirectedGraph() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of undirected graph");
        Graph g = new Graph(sc.nextInt());
        for(int i=0;i<g.adj.size();i++){
            System.out.println("Enter connecting value for " + i);
            int j = sc.nextInt();
            while (j!=-1){
                g.adj.get(i).add(j);
                j=sc.nextInt();
            }
        }
        return g;
    }

    // Time: O(V+E), Space: O(V)
    static void bfs(Graph g){
        if(g.adj.size()==0) return;
        boolean visited[]= new boolean[g.adj.size()];
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                bfsutil(g,i,visited);
            }
        }
    }
    static void bfsutil(Graph g, int n,boolean visited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        while (!q.isEmpty()){
            int u=q.remove();
            System.out.print(u+" ");
            for(int v:g.adj.get(u)){
                if(!visited[v]){
                    visited[v]=true;
                    q.add(v);
                }
            }
        }
    }

    // Time: O(V+E), Space: O(V)
    static void dfs(Graph g) {
        boolean visited[] = new boolean[g.adj.size()];
        for (int i = 0; i < visited.length; i++) { // works for disconnected graph as well
            if (visited[i] == false)
                dfsUtil(g, i, visited);
        }
    }
    static void dfsUtil(Graph g, int u, boolean visited[]) {
        visited[u] = true;
        System.out.print(u + " ");
        for (int v : g.adj.get(u)) {
            if (!visited[v])
                dfsUtil(g, v,visited);
        }
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

    public static void main(String args[]){
        System.out.println("Create new undirected graph");
        Graph g=GraphOps.createUndirectedGraph();
        printGraph(g);
        System.out.println("\nCreate new directed graph");
        g = createDirectedGraph();
        printGraph(g);
        System.out.println("BFS traversal: ");
        bfs(g);
        System.out.println("\nDFS traversal: ");
        dfs(g);
    }
}
