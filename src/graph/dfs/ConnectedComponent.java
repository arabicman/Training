package graph.dfs;

import graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;


public class ConnectedComponent {
    private Graph G;
    // private boolean[] visited;
    private int[] visited;
    private int ccCount = 0;


    public ConnectedComponent(Graph G){
        this.G = G;
        visited = new int[G.V()];
        for(int i = 0; i < visited.length; i++){
            visited[i] = -1;
        }
        for(int v = 0 ; v < G.V(); v++){
            if(visited[v] == -1){
                dfs(v, ccCount);
                ccCount++;
            }
        }
    }

    private void dfs(int v, int ccid){
        visited[v] = ccid;
        for(int w : G.adj(v)){
            if(visited[w] == -1){
                dfs(w,ccid);
            }
        }
    }

    public int ccCount(){
        return ccCount;
    }

    public boolean isConnected(int v, int w){
        G.validateVertex(v);
        G.validateVertex(w);
        return visited[v] == visited[w];
    }

    public ArrayList<Integer>[] components(){
        ArrayList<Integer>[] res = new ArrayList[ccCount];
        for(int i = 0; i < ccCount; i++){
            res[i] = new ArrayList<>();
        }
        for(int v = 0; v < G.V(); v++){
            res[visited[v]].add(v);
        }
        return res;
    }



    public static void main(String[] args) {
        Graph g = new Graph("graphs/2conn-components.txt");
        ConnectedComponent cc = new ConnectedComponent(g);
        System.out.println(cc.ccCount());
        System.out.println(Arrays.toString(cc.visited));
        System.out.println(cc.isConnected(0,5));
        int idx = 0;
        for(ArrayList<Integer> co : cc.components() ){
            System.out.println( idx +": "+co);
            idx++;
        }
    }
}
