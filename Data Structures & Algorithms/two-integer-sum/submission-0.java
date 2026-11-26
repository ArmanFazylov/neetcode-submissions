class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{0,0};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer opp = target - nums[i];
            Integer oppIdx = map.get(opp);
            if (oppIdx != null)
                return new int[]{Math.min(i,oppIdx), Math.max(i,oppIdx)};
            else
                map.put(nums[i], i);
        }
        return new int[]{0,0}; 
    }
}
