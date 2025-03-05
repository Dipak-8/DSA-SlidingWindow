class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int l = 0, r = 0;
        int count = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('a', -1);
        charMap.put('b', -1);
        charMap.put('c', -1);
        while(r < n) {
            char c = s.charAt(r);
            charMap.put(c, r);
            if(charMap.get('a') != -1 && 
                charMap.get('b') != -1 && charMap.get('c') != -1) {
                l = Math.min(charMap.get('a'), 
                        Math.min(charMap.get('b'), charMap.get('c'))
                    );
                count += l + 1;
            }
            r++;
        }
        return count;
    }
}