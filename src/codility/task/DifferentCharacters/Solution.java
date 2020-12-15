package codility.task.DifferentCharacters;

public class Solution {
    public int solution(String S, int K){
        if( K == 0 ){
            return S.length();
        }
        int len = S.length();
        int[] diff = new int[26];
        for(int i =0; i < S.length(); i++){
            char ch = S.charAt(i);
            diff[ch-'a'] += 1;
        }

        int minLen = S.length();

        for(int i = 0 ; i < len; i++){
            int[] del = new int[26];
            if(valid(diff,del,K)){
                return 0;
            }
            for(int j = i; j < len ; j++){
                char cur = S.charAt(j);
                del[cur-'a'] += 1;
                int curLen = j - i + 1;
                if(curLen >= minLen){
                    continue;
                }
                if(valid(diff,del,K)){
                    minLen = Math.min(minLen, curLen);
                }
            }
        }
        if(minLen == S.length()){
            return -1;
        }
        return minLen;

    }
    private boolean valid(int[] a, int[] b, int K){
        int[] c = new int[26];
        for(int i = 0; i < a.length; i++){
            c[i] = a[i] - b[i];
        }
        int cnt = 0;
        for(int x : c){
            if(x != 0){
                cnt++;
            }
        }
        if(cnt == K){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abaacbca";
        int res = sol.solution(s,2);
        System.out.println(res);


    }

}
