package leetcode.algorithm.Q785_IsGraphBipartite;


public class Solution {
    int[] parent;
    public boolean isBipartite(int[][] graph) {
        parent = new int[graph.length];
        for(int i = 0; i < parent.length; i++) parent[i] = i;
        for(int i = 0; i < parent.length; i++){
            int[] nodes = graph[i];
            for(int n : nodes){
                if(find(i) == find(n)) return false;
                union(n, nodes[0]);
            }
        }
        return true;
    }

    private void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px != py) parent[px] = py;
    }

    private int find(int node){
        if(parent[node] == node) return node;
        parent[node] = find(parent[node]);
        return parent[node];
    }
}
