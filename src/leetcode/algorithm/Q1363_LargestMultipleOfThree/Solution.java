package leetcode.algorithm.Q1363_LargestMultipleOfThree;

import java.util.Arrays;

public class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int[] buckets = new int[10];
        int sum = 0;
        for (int v : digits) {
            buckets[v]++;
            sum += v;
        }

        int[] numSet1 = {1, 4, 7};
        int[] numSet2 = {2, 5, 8};
        if (sum % 3 == 1) {
            removeHelper(buckets, numSet1, numSet2);
        } else if (sum % 3 == 2) {
            removeHelper(buckets, numSet2, numSet1);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (buckets[i] > 0) {
                while (buckets[i] > 0) {
                    result.append(i);
                    buckets[i]--;
                }
            }
        }

        int p = 0;
        while (p < result.length() - 1 && result.charAt(p) == '0') {
            p++;
        }

        return result.substring(p);
    }

    public void removeHelper(int[] buckets, int[] remove1Set, int[] remove2Set) {
        int counter = 0;
        for (int num : remove1Set) {
            if (buckets[num] > 0) {
                buckets[num]--;
                counter = 1;
                break;
            }
        }

        if (counter == 0) {
            for (int num : remove2Set) {
                if (buckets[num] >= 2) {
                    buckets[num] -= 2;
                    counter = 2;
                } else if (buckets[num] == 1) {
                    buckets[num] = 0;
                    counter++;
                }

                if (counter == 2) {
                    break;
                }
            }
        }
    }
}
