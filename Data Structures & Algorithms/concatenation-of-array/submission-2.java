class Solution {
    // most efficient - using native functions
    // time: O(n), space: O(n)
    public int[] getConcatenation(int[] nums) {
        int l = nums.length;
        int[] ans = new int[2 * l];
        
        System.arraycopy(nums, 0, ans, 0, l);
        System.arraycopy(nums, 0, ans, l, l);

        return ans;
    }
}