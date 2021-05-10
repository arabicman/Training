package leetcode.algorithm.Q420_StrongPasswordChecker;

public class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        int nRep = 0, sum = 0;
        int[] m = new int[3]; //# of SSRC of 3k, 3k + 1, 3k + 2

        int i = 0, j, t;
        char c;
        while (i < n) {
            c = password.charAt(i);

            hasLower |= (c >= 'a' && c <= 'z');
            hasUpper |= (c >= 'A' && c <= 'Z');
            hasDigit |= (c >= '0' && c <= '9');

            j = i + 1;
            while ( j < n && password.charAt(j) == c) j++;

            t = j - i;
            if (t >= 3) {
                nRep += t/3;
                sum += t;
                m[t % 3] ++;
            }
            i = j;
        }

        int nMiss = (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasDigit ? 0 : 1);

        if (n < 6) return (6 - n) > nMiss ? (6 - n) : nMiss;
        if (n <= 20) return Math.max(nRep, nMiss);

        //n > 20
        int nDel = n - 20;
        if (nDel <= m[0]) return nDel + Math.max(nRep - nDel, nMiss);

        int rNDel = nDel - m[0];
        nRep -= m[0];
        if (rNDel <= 2 * m[1]) return nDel + Math.max(nRep - rNDel / 2, nMiss);

        rNDel -= 2 * m[1];
        nRep -= m[1];
        if (nDel <= sum - 2 * (m[0] + m[1] + m[2])) return nDel + Math.max(nRep - rNDel /3, nMiss);
        return nDel + nMiss;


    }
}
