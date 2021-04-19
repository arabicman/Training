package leetcode.algorithm.Q677_MapSumPairs;

public class MapSum {
    Trie root;
    int res;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Trie();
        res = 0;
    }

    public void insert(String key, int val) {
        Trie cur = root;
        for(int i = 0; i < key.length(); i++){
            char ch = key.charAt(i);
            if(cur.children[ch - 'a'] == null){
                cur.children[ch - 'a'] = new Trie();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.val = val;
    }

    public int sum(String prefix) {
        res = 0;
        Trie cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(cur.children[ch - 'a'] == null){
                return 0;
            }
            cur = cur.children[ch - 'a'];
        }
        dfs(cur);
        return res;
    }

    class Trie{
        Trie[] children;
        int val;
        public Trie(){
            this.children = new Trie[26];
            this.val = 0;
        }
    }

    private void dfs(Trie node){
        res += node.val;
        for (int i = 0; i < 26; i++){
            if(node.children[i] != null){
                dfs(node.children[i]);
            }
        }
    }
}
