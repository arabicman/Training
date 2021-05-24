package leetcode.algorithm.Q204_CountPrimes;

import java.util.*;

public class TimeExceedSolution {
    static Set<Integer> set = new TreeSet<>();
    static {
        set.add(2);
    }


    public int countPrimes(int n) {
        if (n <= 2){
            return 0;
        }
        if(n == 3){
            return 1;
        }
        int res = 0;
        for(int i = 2; i < n ; i++){
            if(i%2 != 0){
                if(isPrime(i)){
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isPrime(int n){
        if(set.contains(n)){
            return true;
        }
        for(Integer i: set){
            if(n % i == 0){
                return false;
            }
        }
        set.add(n);
        return true;
    }

    public static void main(String[] args) {
        TimeExceedSolution timeExceedSolution = new TimeExceedSolution();
        int res = timeExceedSolution.countPrimes(499979);
        System.out.println(res);
    }

}
