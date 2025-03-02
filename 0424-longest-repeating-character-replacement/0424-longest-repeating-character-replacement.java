class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int n = s.length();
        int maxLen = 0;
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(r < n) {
            char c =  s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
            int len = r - l + 1;
            int ct = len - maxFreq;
            
            if(ct > k) {
                char ch = s.charAt(l);
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                l++;
            } else {
                maxLen = Math.max(maxLen, len);
            }
            r++;
        }
        return maxLen;
    }
}