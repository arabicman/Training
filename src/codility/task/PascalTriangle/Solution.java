package codility.task.PascalTriangle;

public class Solution {
    public int solution(boolean[] P){
        if(P.length == 1){
            return P[0]?1:0;
        }
        boolean[] prev = P;
        int cnt = 0;
        for(boolean b : P){
            if(b){
                cnt++;
            }
        }
        for(int i = P.length - 1; i >= 1; i--){
            boolean[] cur = new boolean[i];
            for(int j = 0; j < cur.length; j++){
                cur[j] = prev[j] || prev[j+1];
                if(cur[j]){
                    cnt++;
                }
            }
            prev = cur;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean[] arr = {true, false, false, true, false};
        int res = sol.solution(arr);
        System.out.println(res);
    }
}
