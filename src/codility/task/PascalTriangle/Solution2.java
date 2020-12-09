package codility.task.PascalTriangle;

public class Solution2 {
    public int solution(boolean[] P){

        double cnt = 0;
        double n = P.length;
        for(int i = 0; i < P.length; i++){
            if(!P[i]){
                double zeros = 0;
                while(i < P.length && !P[i] ){
                    zeros++;
                    i++;
                }
                if(zeros == 1){
                    cnt++;
                }else{
                    double cur = ((zeros + 1)*zeros)/2;
                    cnt+=cur;
                }

            }
        }
        double total = ((n+1)*n)/2;
        if(total - cnt >= 1000000000){
            return 1000000000;
        }else{
            return  (int)(total - cnt);
        }

    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        boolean[] arr = {true, false, false, true, false};
        int res = sol.solution(arr);
        System.out.println(res);
    }
}
