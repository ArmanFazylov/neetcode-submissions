/*
    time: O(n), space: O(1)
*/
class Solution {
    public boolean isPalindrome(String s) {
        // edge cases:
        if (s == null || s.length() < 2) return true;
        
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            Character l = s.charAt(i); 
            Character r = s.charAt(j);
            if(!Character.isLetterOrDigit(l)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(r)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(l) != Character.toLowerCase(r)) return false;
            i++;
            j--;
        }
        
        return true;

    }
}
