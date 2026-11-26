class Solution {
    // first that I came up with
    // time: O(n), space: O(n)
    public int[] getConcatenation(int[] nums) {
        int l = nums.length * 2;
        int[] ans = new int[l];
        
        for (int i = 0, j = 0; i < l; i ++, j++) {
            if (j == nums.length) j = 0;
            ans[i] = nums[j];
        }

        return ans;
    }
}