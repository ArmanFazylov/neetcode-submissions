class Solution {
    // my first solution, O(n^2) time, space: O(m)
    public String longestCommonPrefix(String[] strs) {
        // edge case:
        if (strs == null || strs.length == 0) return "";
        
        // get min
        String minStr = "";
        int min = Integer.MAX_VALUE;

        for (String s : strs) {
            if (s.length() < min) {
                min = s.length();
                minStr = s;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < min; i++) {
            Character c = minStr.charAt(i);
            for (String s : strs) {
                if (s.charAt(i) != c) 
                    return sb.toString();
            }
            sb.append(c);
        }

        return sb.toString();
    }
}