class Solution {
    // use hashset, time: O(n), space: O(n)
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        boolean added = true;
        
        for (int i = 0; i < nums.length; i++) {
            added = set.add(nums[i]);
            if (!added)
                return true;
        }

        return false;
    }
}