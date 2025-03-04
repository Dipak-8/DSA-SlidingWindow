class Solution {
    public int countSubArray(int[] nums, int k) {
        if(k < 0)  return 0;
        int l = 0, r = 0;
        int count = 0;
        int oddCount = 0;
        int n = nums.length;
        
        while(r < n) {
            oddCount += nums[r] % 2;
            while(oddCount > k) {
                oddCount -= nums[l] % 2;
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int atMostOdd = countSubArray(nums, k);
        int atMostOddMinusOne = countSubArray(nums, k - 1);

        return atMostOdd - atMostOddMinusOne;
    }
}
