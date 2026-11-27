/*
    Optimal solution using set
    algo:
    loop over set, search for el that has no left-neighbors (v - 1)
    that el will be starting point
    keep adding 1 to it and checking set if match found (count++, max), else try 
    next element

    time: O(n), space: O(n)

*/
class Solution {
    public int longestConsecutive(int[] nums) {
        // edge case:
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);

        int max = 1;
        int count = 1;

        for (int i : set) {
            // check if i has prev element
            int prev = i - 1;
            boolean isLeft = !set.contains(prev);
            count = 1;
            if (isLeft) {
                int next = i + 1;
                while (set.contains(next)) {
                    count++;
                    max = Math.max(max, count);
                    next++;
                }
            }
        }

        return max;
    }
}
