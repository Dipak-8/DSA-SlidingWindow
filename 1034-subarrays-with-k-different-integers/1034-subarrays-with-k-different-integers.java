class Solution {
    public int countSubArrays(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while(map.size() > k) {
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                if(map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubArrays(nums, k) - countSubArrays(nums, k - 1);
    }
}