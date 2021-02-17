package leetcode.algorithm.Q1286_IteratorForCombination;

class CombinationIterator {
    int[] pointers;
    char[] chars;
    char[] buf;

    public CombinationIterator(String characters, int combinationLength) {
        chars = characters.toCharArray();
        pointers = new int[combinationLength];
        buf = new char[combinationLength];
        for(int i = 0; i < combinationLength; i++){
            pointers[i] = i;
            buf[i] = chars[i];
        }

    }

    public String next() {
        String s = new String(buf);
        increasePointers();
        return s;

    }

    private void increasePointers(){
        for(int j = pointers.length - 1; j >= 0; j--){
            if(pointers[j] < chars.length - (pointers.length - j)){
                buf[j] = chars[++pointers[j]];
                while(++j < pointers.length){
                    pointers[j] = pointers[j - 1] + 1;
                    buf[j] = chars[pointers[j]];
                }
                return;
            }
        }
        buf = null;
    }

    public boolean hasNext() {
        return buf != null;
    }

}
