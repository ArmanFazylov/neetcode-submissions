class Solution {
    // sorting solution (not optimal)
    // build list from freq map on reverse
    // sort list
    // pop list k times
    // space: O(n), time: O(nlogn)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int c = map.getOrDefault(nums[i], 0);
            map.put(nums[i], c + 1);
        }

        List<Pair> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            list.add(new Pair(e.getKey(), e.getValue()));
        }

        list.sort((a, b) -> b.value() - a.value());
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).key();
        }

        return res;
        
    }

    private record Pair(int key, int value) {}
}
