package leetcode.algorithm.Q621_TaskScheduler;

import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // A _ _ _ A _ _ _ A _ _ _ A       => idle = 9 (when n = 3)
        // A B _ _ A B _ _ A B _ _ A B     => idle = 6  (if count[24] == count[25])
        // A B C _ A B C _ A B C _ A B C   => idle = 3  (if count[23] == count[24])
        // A B C D A B C D A B C D A B C D => idle = 0   (return tasks.length)
        // A B C D E A B C D E A B C D E A B C D E => idle = -3 (return tasks.length)
        int[] count = new int[26];
        for(char c : tasks){
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int max = count[25] - 1;
        int idle = max * n;
        for(int i = 24; i >= 0; i--){
            idle = idle - Math.min(max, count[i]);
            if(idle <= 0){
                break;
            }
        }
        return idle > 0 ? idle + tasks.length : tasks.length;
    }

}
