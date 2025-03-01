class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int maxLen = 0;
        int zeroCount = 0;
        while(r < nums.length) {
            if(nums[r] == 0)
                zeroCount++;
            while(zeroCount > k) {
                if(nums[l] == 0)    
                    zeroCount--;
                l++;
            }
            // if(zeroCount > k) {
            //     if(nums[l] == 0)
            //         zeroCount--;
            //     l++;
            // }
            if(zeroCount <= k) {
                int len = r - l + 1;
                maxLen = Math.max(len, maxLen);
            }
            r++;
        }
        return maxLen;
    }
}