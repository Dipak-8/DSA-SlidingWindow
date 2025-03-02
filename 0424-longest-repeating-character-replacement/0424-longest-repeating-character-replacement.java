class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;  
        int n = s.length();
        int maxLen = 0;  
        int maxFreq = 0;  
        int[] hash = new int[26]; 

        while (r < n) {
            char c = s.charAt(r);
            hash[c - 'A']++; 
            // Track the highest occurring character in the window
            maxFreq = Math.max(maxFreq, hash[c - 'A']); 
            int len = r - l + 1;
            // Count of characters to be replaced
            int ct = len - maxFreq; 
             // If replacements exceed k, shrink window from the left
            if (ct > k) {
                hash[s.charAt(l) - 'A']--;
                l++;
            } else { // Update the maximum valid window size
                maxLen = Math.max(maxLen, len);
            }
            r++;
        }
        return maxLen;
    }
}
