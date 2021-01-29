package leetcode.algorithm.Q93_RestoreIPAddress;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return res;
        }
        StringBuilder sb = new StringBuilder();
        helper(s.toCharArray(), 0, 0, sb, res);
        return res;
    }

    private void helper(char[] ip, int lvl, int offset, StringBuilder sb, List<String> res){
        if(lvl == 4){
            if(sb.length() == ip.length + 4){
                res.add(sb.substring(0,sb.length()-1));
            }
            return;
        }
        if(offset < ip.length){
            helper(ip,lvl+1, offset+1, sb.append(ip[offset]).append('.'),res);
            sb.delete(sb.length()-2, sb.length());
        }
        if(offset + 1 < ip.length){
            char a = ip[offset];
            char b = ip[offset + 1];
            if(a != '0'){
                helper(ip, lvl+1, offset+2, sb.append(a).append(b).append('.'), res);
                sb.delete(sb.length() - 3, sb.length());
            }
        }
        if(offset + 2 < ip.length){
            char a = ip[offset];
            char b = ip[offset+1];
            char c = ip[offset + 2];
            if(a=='1'||a=='2' && b >= '0' && b <= '4'|| a=='2' && b =='5'&& c>='0'&&c <='5'){
                helper(ip, lvl+1, offset+3,
                        sb.append(a).append(b).append(c).append('.'),res);
                sb.delete(sb.length()-4, sb.length());
            }
         }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> ss = sol.restoreIpAddresses("010010");
        for(String s : ss){
            System.out.println(s);
        }

    }

}
