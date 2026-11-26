// brute force, time:O(n^2), for each element run array 
// more efficient, sort than run count, time: O(nlogn), space: O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        // edge case:
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);

        int count = 1;
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            //edge case
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] - nums[i - 1] == 1) {
                count += 1;
                max = Math.max(max, count);
            } else {
                count = 1;
            }

        }

        return max;
    }
}
