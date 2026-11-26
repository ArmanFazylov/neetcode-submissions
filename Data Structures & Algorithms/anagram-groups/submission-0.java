class Solution {
    // my first solution
    // time: O(n*m), space: O(n*m)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>, List<String>> res = new HashMap<>();
        for (String s : strs) {
            Map<Character, Integer> m = getMap(s);
            if (res.containsKey(m)) {
                res.get(m).add(s);
            } else {
                List<String> t = new ArrayList<>();
                t.add(s);
                res.put(m, t);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<Map<Character, Integer>, List<String>> e : res.entrySet()) {
            ans.add(e.getValue());
        }
        return ans;
    }

    public Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int c = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), c + 1);
        }
        return map;
    }
}
