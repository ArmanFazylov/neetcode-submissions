// first let's count freqs
// next, we must use sorting...
// use TreeSet of Map.Entry with caveat on when counts are equal
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            int c = map.getOrDefault(i, 0);
            map.put(i, c + 1);
        }

        TreeSet<Map.Entry<Integer, Integer>> set = new TreeSet<>(
            new Comparator<Map.Entry<Integer,Integer>>() {
                @Override
                public int compare(
                    Map.Entry<Integer, Integer> a, 
                    Map.Entry<Integer, Integer> b) {
                        if (a.getValue() < b.getValue()) 
                            return 1;
                        else if (a.getValue() > b.getValue())
                            return -1;
                        else {
                            if (a.getKey() < b.getKey()) {
                                return 1;
                            } else if (a.getKey() > b.getKey())
                                return -1;
                            return 0;
                        }
                }
            }
        );


        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            set.add(e);
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : set) {
            if (k-- == 0) break;
            res.add(e.getKey());
        }

        return res.stream().mapToInt(x -> x).toArray();
     }
}
