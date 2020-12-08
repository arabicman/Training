package codility.task.TreeRange;

import java.util.*;

public class Solution {

    public int solution(int[] T){
        int n = T.length;
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            if(T[i] != i){
                adj[i].add(T[i]);
                adj[T[i]].add(i);
            }
        }
        int[][] range = new int[n-1][2];
        for(int i = 0; i < n-1; i++){
            range[i] = getRange(adj, i);
        }
        int res = n;
        for(int i = 0; i < n; i++){
            int lower = i; int upper = i;
            for(int j = i+1; j < n; j++){
                if(range[j-1][0] < lower){
                    break;
                }
                upper = Math.max(upper, range[j-1][1]);
                if(upper == j){
                    res += 1;
                }
            }
        }
        return res;

    }

    private int[] getRange(List<Integer>[]adj, int start){
        int n = adj.length;
        int[] res = new int[2];
        res[0] = start; res[1] = start + 1;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(start);
        while(!queue.isEmpty()){
            Integer i = queue.pollFirst();
            if(i == start + 1){
                break;
            }
            for(Integer j : adj[i]){
                if( !j.equals(parent[i]) ){
                    queue.offerLast(j);
                    parent[j] = i;
                }
            }
        }
        int lower = start; int upper = start + 1;
        int i = start + 1;
        while (i != -1){
            lower = Math.min(lower, i);
            upper = Math.max(upper, i);
            i = parent[i];
        }
        res[0] = lower; res[1] = upper;
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] t = {2,0,2,2,1,0};
        int res = sol.solution(t);
        System.out.println(res);
    }


}
