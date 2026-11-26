// even more elegant solution with same HashMap
class Solution {
    public boolean isAnagram(String s, String t) {
        // edge case:
        if (s.length() != t.length()) return false;
        Map<Character, Integer> mS = new HashMap<>();
        Map<Character, Integer> mT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mS.merge(s.charAt(i), 1, Integer::sum);
            mT.merge(t.charAt(i), 1, Integer::sum);
        }
        return mS.equals(mT);
    }
}
