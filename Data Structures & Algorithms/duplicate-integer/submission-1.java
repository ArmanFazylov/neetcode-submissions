class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            // set rejects dups
            if (!set.add(i)) 
                return true; // has dups
        }
        return false;
    }
}