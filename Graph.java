import java.util.*;

public class Graph {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        //0th vertex
        graph[0].add(new Edge(0, 1, 5));

        //1st vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        //2nd vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        //3rd vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
    }

    public static void BFS (ArrayList<Edge>[] graph){

        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                BFSUtil(graph,vis);
            }
        }
    }

    public static void BFSUtil(ArrayList<Edge>[] graph, boolean vis[]){       //O(n) || O(V+E)
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){
                //visit the current
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int i=0;i<graph[curr].size();i++){
                    q.add(graph[2].get(i).dest);
                }
            }
        }
    }
    
    public static void DFS(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                DFSUtil(graph,0,vis);
            }
        }
    }

    public static void DFSUtil(ArrayList<Edge>[] graph , int curr, boolean vis[]){
        //Self Printing
        System.out.print(curr+" ");
        vis[curr] = true;
        
        //neighbour calling
        for(int i=0;i<graph[curr].size();i++){
            if(!vis[graph[curr].get(i).dest]){
                DFSUtil(graph, graph[curr].get(i).dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]){
        if(src == dest){
            return true;
        }
        vis[src] = true;

        //Neighbour Has The Destination Or Not
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        //2's Neighbours
        // for(int i=0;i<graph[2].size();i++){
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.dest);
        // }


        DFS(graph);

        // boolean vis[] = new boolean[graph.length];
        // DFS(graph,0,vis);


        // System.out.println(hasPath(graph, 0, 3, new boolean[V]));
    }
}
