package leetcode.algorithm.Q767_ReorganizeString;


import java.util.Arrays;

public class Solution {
    public String reorganizeString(String S) {

        int[] freq = new int[26];
        int distinct = 0;
        for(char c : S.toCharArray()){
            if(freq[c -'a'] == 0){
                distinct ++;
            }
            freq[c - 'a'] ++;
        }
        Pair[] desc = new Pair[distinct];
        int idx = 0;
        for( int i = 0; i < 26; i++){
            if(freq[i] != 0){
                desc[idx] = new Pair((char)('a'+i), freq[i]);
                idx ++;
            }
        }
        Arrays.sort(desc, (Pair a, Pair b) -> b.i - a.i);
        if(desc[0].i - 1 > (S.length()-1)/2){
            return "";
        }
        char[] descArr = new char[S.length()];
        idx = 0;
        for(Pair p : desc){
            int times = p.i;
            while(times > 0){
                descArr[idx] = p.ch;
                idx ++;
                times --;
            }
        }
        char[] res = new char[S.length()];
        int head = 0;
        int mid = (S.length() - 1)/2 + 1;
        idx = 0;
        while(idx < res.length){
            if(idx == res.length - 1){
                res[idx] = descArr[head];
                idx++;
            }else{
                res[idx] = descArr[head];
                head++;
                res[idx+1] = descArr[mid];
                mid++;
                idx += 2;
            }

        }
        return new String(res);
    }

    class Pair{
        char ch;
        int i;
        Pair(char ch, int i){
            this.ch = ch;
            this.i = i;
        }
    }




}
