class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int l = 0, r = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        Map<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        while(r < m) {
            char ch = s.charAt(r);
            if(map.containsKey(ch) && map.get(ch) > 0) {
               count++;
            }
            map.put(ch, map.getOrDefault(ch, 0) - 1);  
            
            while(count == n) {
                if(r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIndex = l;
                }
                char c = s.charAt(l);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if(map.get(c) > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        String res = (startIndex == -1) ?
                        "" : s.substring(startIndex, (startIndex + minLen));
        return res;
    }
}