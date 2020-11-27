package codility.indeed.LongestPassword;

//   https://app.codility.com/programmers/lessons/90-tasks_from_indeed_prime_2015_challenge/longest_password/

public class Solution {
    public int solution(String S){

        String[] arr = S.split(" ");
        int maxV = 0;
        for(String s : arr){
            if(isValid(s)){
                maxV = Math.max(maxV, s.length());
            }
        }
        return maxV == 0 ? -1: maxV;
    }

    private boolean isValid(String str){
        int letter = 0;
        int digit = 0;
        for(int i = 0 ; i < str.length(); i++){
            char ith = str.charAt(i);
            if(('A'<=ith&&ith<='Z')||('a'<=ith&&ith<='z')){
                letter++;
            }else if('0'<=ith&&ith<='9'){
                digit++;
            }else{
                return false;
            }
        }
        if(letter%2 == 0 && digit%2 == 1){
            return true;
        }else{
            return false;
        }

    }
}
