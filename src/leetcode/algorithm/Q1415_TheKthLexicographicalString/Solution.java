package leetcode.algorithm.Q1415_TheKthLexicographicalString;

public class Solution {
    private static char[] arr = {'a', 'b', 'c'};
    private static char[] a = {'b', 'c'};
    private static char[] b = {'a', 'c'};
    private static char[] c = {'a', 'b'};

    public String getHappyString(int n, int k) {

        if(n == 1 && k <= 3 && k >= 1){
            return String.valueOf(arr[k-1]);
        }
        if( k == 0 || k > Math.pow(2,n-1)*3){
            return "";
        }
        StringBuilder sb = new StringBuilder();

        //Step 1: find L1
        int total = (int)Math.pow(2, n-1) * 3;
        int first =  (k-1)  / (total/3);
        char cur = arr[first];
        sb.append(cur);
        int remain = (k-1) - ((first) * (total/3));
        //Step 2: other level
        for(int i = n-2; i >= 0; i--){
            int other = remain/(int)(Math.pow(2,i));
            remain = remain - (other * (int)Math.pow(2,i));
            switch (cur){
                case 'a':
                    cur = a[other];
                    break;
                case 'b':
                    cur = b[other];
                    break;
                case 'c':
                    cur = c[other];
                    break;
                default:
                    break;
            }
            sb.append(cur);
        }
        return sb.toString();

    }
}
