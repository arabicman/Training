package leetcode.algorithm.Qxxx_MapReduce;

import java.util.Iterator;

public class Solution {

    public static class Map{
        public void map(String key, String value,
                        OutputCollector<String, Integer> output){
            //key is the article's url
            //value is the content of the article
            String[] tokens = value.split(" ");
            for(String word : tokens){
                output.collect(word, 1);
            }
        }
    }

    public static class Reduce{
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output){
            int sum = 0;
            while(values.hasNext()){
                sum += values.next();
            }
            output.collect(key, sum);
        }
    }
}

class OutputCollector<K, V>{
    public void collect(K key, V value){

    }
}