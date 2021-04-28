package leetcode.algorithm.Q944_DeleteColumnsToMakeSorted;

public class Solution {
    public int minDeletionSize(String[] strs) {

        int res = 0;
        for(int i = 0; i < strs[0].length(); i++){
            int cnt = 0;
            for(int j = 1; j < strs.length; j++){
                if(strs[j].charAt(i) - strs[j-1].charAt(i) < 0){
                    break;
                }
                cnt++;
            }
            if(cnt < strs.length - 1){
                res ++;
            }
        }
        return res;

    }
}
