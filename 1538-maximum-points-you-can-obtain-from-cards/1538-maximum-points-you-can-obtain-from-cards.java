class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l = 0, r = n - 1;
        int leftSum = 0, rightSum = 0;
        int maxSum = 0;

        for(int i=0; i<k; i++) {
            leftSum += cardPoints[i];
        }
        maxSum = leftSum;
        for(int i=k-1; i>=0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[r];
            r--;
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }
}