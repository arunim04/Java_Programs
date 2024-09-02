package JavaDS.Graphs;

import java.util.*;

public class TopologicalSortWithDFS {
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
    static void topologicalSortDfs(Graph g){
        boolean visited[]= new boolean[g.adj.size()];
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                dfsUtil(g, i, visited, stack);
            }
            while (!stack.isEmpty()){
                System.out.print(stack.pop() + " ");
            }
        }
    }
    static void dfsUtil(Graph g,int u,boolean visited[],Stack<Integer> stack){
        visited[u]=true;
        for (int v:g.adj.get(u)){
            if(!visited[v]){
                dfsUtil(g,v,visited,stack);
            }
        }
        stack.push(u);
    }

    static void topologicalSortBFS(Graph g){
        int[] indeg=new int[g.adj.size()];
        for (ArrayList<Integer> list: g.adj){
            for (Integer e:list){
                indeg[e]++;
            }
        }
        boolean[] visited=new boolean[g.adj.size()];
        ArrayList<Integer> ansList=new ArrayList<>();
        bfsUtil(g,0,visited,ansList,indeg);
        for (int i:ansList){
            System.out.println(i);
        }
    }

    static void bfsUtil(Graph g,int ind,boolean[] visited,ArrayList<Integer> ansList,int[] indeg){
        Queue<Integer> queue=new LinkedList<>();
        for (int i=0;i<g.adj.size();i++){
            if (indeg[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int cur=queue.poll();
            ansList.add(cur);
            for (int i:g.adj.get(cur)){
                if(--indeg[i]==0){
                    queue.add(i);
                }
            }
        }
    }

    static Graph createDirectedGraph() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of undirected graph");
        Graph g = new Graph(sc.nextInt());
        for (int u = 0; u < g.adj.size(); u++) {
            System.out.println("Enter connecting value for " + u);
            int v = sc.nextInt();
            while (v != -1) {
                g.adj.get(u).add(v);
                v = sc.nextInt();
            }
        }
        return g;
    }

    static void printGraph(Graph g) {
        for (int i = 0; i < g.adj.size(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < g.adj.get(i).size(); j++)
                System.out.print(g.adj.get(i).get(j) + " ");
            System.out.println();
        }
    }

    public static void main(String args[]){
        System.out.println("Create new directed graph");
        Graph g=createDirectedGraph();
        printGraph(g);
        System.out.println("\nTopological sorting of directed graph: ");
        topologicalSortDfs(g);
    }
}
