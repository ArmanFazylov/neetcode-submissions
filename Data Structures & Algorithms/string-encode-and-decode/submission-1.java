class Solution {

    public String encode(List<String> strs) {
        // edge case:
        if (strs == null || strs.size() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int l = Integer.parseInt(str.substring(i, j)); // substring is exclusive, cause str[j] = '#'
            i = j + 1;
            j = i + l;
            res.add(str.substring(i, j)); // again exclus
            i = j; // move i to end of string
        }
        
        return res;
    }
}
