/*
    soln using Prefix & Suffix Products
    time: O(n), space: O(n)

*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        int[] suf = new int[n];
        // caveat init
        pref[0] = 1;
        suf[n - 1] = 1;

        // caveat excluding number[i] itself
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i + 1];
        }

        // caveat res[i] = pref[i] * suf[i]
        // prod at i = pref of prod before i * suf of prod after i
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suf[i];
        }
        return res;
    }
}  
