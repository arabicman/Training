package codility.task.BeautifulPassword;


public class Solution {
    public int solution(String S){
        int maxLen = 0;


        for(int i = 0; i < S.length() - 1;i++){
            int[] nums = new int[10];
            int[] lts = new int[26];
            char cur = S.charAt(i);
            if(isLetter(cur)){
                lts[cur-'a'] += 1;
            }else{
                nums[cur-'0'] += 1;
            }
            for(int j = i+1; j < S.length();j++){

                char tail = S.charAt(j);

                if(isLetter(tail)){
                    lts[tail-'a'] += 1;
                }else{
                    nums[tail - '0'] += 1;
                }
                if((j-i+1) % 2 == 1 || (j-i+1) <= maxLen){
                    continue;
                }
                if(allEven(lts) && allEven(nums)){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;

    }
    private boolean isLetter(char ch){
        if(ch - 'a' >= 0 && 'z' - ch >= 0 ){
            return true;
        }else{
            return false;
        }
    }
    private boolean allEven(int[] arr){
        for(int i : arr){
            if(i%2 == 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String str = "6daa6ccaaa6d";
        int res = sol.solution(str);
        System.out.println(res);
    }
}
