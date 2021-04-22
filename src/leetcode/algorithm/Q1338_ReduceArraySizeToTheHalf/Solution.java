package leetcode.algorithm.Q1338_ReduceArraySizeToTheHalf;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public int minSetSize(int[] arr) {
        int len = arr.length;
        int remaining = len;
        Map<Integer,Long> map = IntStream.of(arr).boxed().collect(Collectors.groupingBy((x)->Integer.valueOf(x),Collectors.counting()));
        List<Long> list = map.values().stream().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());
        int index = 0;
        while(remaining > len/2){
            remaining -= list.get(index);
            index ++;
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {9,77,63,22,92,9,14,54,8,38,18,19,38,68,58,19};
        System.out.println(solution.minSetSize(arr));
    }
}
