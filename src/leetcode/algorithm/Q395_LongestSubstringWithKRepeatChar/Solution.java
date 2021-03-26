package leetcode.algorithm.Q395_LongestSubstringWithKRepeatChar;

public class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        if (k<2) return s.length();
        return helper(s, 0, s.length(), k);
    }

    public int helper(String s, int l, int r, int k) {
        if (l>=r) return 0;

        // build freq map
        int[] freq = new int[26];
        for (int i=l; i<r; i++) freq[s.charAt(i)-'a']++;

        // check if valid
        boolean valid = true;
        for (int i=0; i<26 && valid; i++) {
            if (freq[i] > 0 && freq[i] < k) valid = false;
        }
        if (valid) return r-l;

        // if not for each invalid character start a new split search
        int best = 0, start=l;
        for (int i=l; i<r; i++) {
            if (freq[s.charAt(i) -'a'] < k) {
                best = Math.max(best, helper(s, start, i, k));//回头看
                start = i+1;//向前走
            }//如果freq(cur) >= k , 则继续看下一个
        }
        best = Math.max(best, helper(s, start, r, k));//看最后
        return best;
    }

}
