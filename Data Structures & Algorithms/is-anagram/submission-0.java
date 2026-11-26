class Solution {
    public boolean isAnagram(String s, String t) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            Integer c = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), ++c);
        }

        for (int i = 0; i < t.length(); i++) {
            Integer c = map.get(t.charAt(i));
            if (c == null) return false;
            if ((c - 1) == 0) map.remove(t.charAt(i));
            else map.put(t.charAt(i), c - 1);
        }
        return map.isEmpty();
    }
}
