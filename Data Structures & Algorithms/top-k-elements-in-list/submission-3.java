// solution using MinHeap
// same logic: 1) create freq map 2) put inverse of it in minheap, deleting once hitting k 3) pop k
// elements from it time: O(nlogk), space: O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // build freq map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int c = map.getOrDefault(nums[i], 0);
            map.put(nums[i], c + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            minHeap.offer(e);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (minHeap.size() > 0) {
            res[i++] = minHeap.poll().getKey();
        }

        return res;
    }
}
