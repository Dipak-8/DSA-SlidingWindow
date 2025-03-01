class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int l = 0, r = 0;
        int[] hash = new int[255];
        Arrays.fill(hash, -1);
        
        while(r < s.length()) {
            char c = s.charAt(r);
            if(hash[c] != -1) {
                if(hash[c] >= l) 
                    l = hash[c] + 1;
            } 
            int len = r - l + 1;
            maxLen = Math.max(len, maxLen);
            hash[c] = r;
            r++; 
        }
        return maxLen;
    }
}