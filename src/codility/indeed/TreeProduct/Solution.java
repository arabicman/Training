package codility.indeed.TreeProduct;

import java.util.*;

public class Solution {
    public String solution(int[] A, int[] B){
        List<Integer> listA = new ArrayList<>();
        for(int a : A){
            listA.add(a);
        }

        List<Integer> listB = new ArrayList<>();
        int max = 0;
        for(int b : B){
            listB.add(b);
        }
        int[][] memo = new int[A.length][A.length];

        for(int i = 0; i < A.length - 1; i++){

            for(int j = i+1; j < A.length; j++){
                if(memo[i][j] != 0 || memo[j][i] != 0){
                    max = Math.max(max, memo[i][j]);
                    max = Math.max(max, memo[j][i]);
                }else{
                    List<List<Integer>> div = divide(listA,listB,i);
                    Integer lSize = div.get(4).get(0);
                    List<List<Integer>> div2 = divide(div.get(2),div.get(3),j-i-1);
                    memo[i][j] = lSize * div2.get(4).get(0) * div2.get(4).get(1);
                    max = Math.max(max,memo[i][j]);
                }
            }

        }
        return ""+max;

    }

    private List<List<Integer>> divide(List<Integer> A, List<Integer> B, int index){

        boolean[] visited = new boolean[A.size()];
        visited[index] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> setA = new HashSet<>();
        setA.add(A.get(index));
        Set<Integer> setB = new HashSet<>();
        setB.add(B.get(index));
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> listAA = new ArrayList<>();
        List<Integer> listAB = new ArrayList<>();
        List<Integer> listBA = new ArrayList<>();
        List<Integer> listBB = new ArrayList<>();

        res.add(listAA);res.add(listAB);res.add(listBA);res.add(listBB);
        boolean init = false;
        while(!queue.isEmpty() || !init){
            init = true;
            while(!queue.isEmpty()){           // poll out all the node in the queue
                Integer curIdx = queue.poll();
                visited[curIdx] = true;
                if(setA.contains(A.get(curIdx))||setA.contains(B.get(curIdx))){
                    setA.add(A.get(curIdx));
                    setA.add(B.get(curIdx));
                    listAA.add(A.get(curIdx));
                    listAB.add(B.get(curIdx));
                }else if(setB.contains(A.get(curIdx))||setB.contains(B.get(curIdx))){
                    setB.add(A.get(curIdx));
                    setB.add(B.get(curIdx));
                    listBA.add(A.get(curIdx));
                    listBB.add(B.get(curIdx));
                }else{

                }
            }
            for(int i = 0; i < A.size(); i++){
                if(!visited[i]){
                    if(setA.contains(A.get(i))|| setA.contains(B.get(i))
                    || setB.contains(A.get(i))|| setB.contains(B.get(i)) ){
                        queue.add(i);
                    }
                }
            }

        }
        List<Integer> sizeList = new ArrayList<>();
        sizeList.add(setA.size());
        sizeList.add(setB.size());
        res.add(sizeList);
        return res;
    }


}
