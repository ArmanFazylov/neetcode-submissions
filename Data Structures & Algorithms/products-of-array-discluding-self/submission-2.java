/*
    solution using division and tracing zeroes
    3 caveats regarding zeroes:
        1. if > 1 zeroes, then all zeroes
        2. if 1 zero, then only it has product of numbers, rest are 0
        3. if no zeroes, then use division of total product 

        time: O(n), space: O(n)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int p = 1;
        int zeroes = 0;
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++;
                if (zeroes > 1) // case 1, early exit
                    return new int[nums.length];
            } else {
                p *= nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { // case 2, early exit
                res = new int[nums.length];
                res[i] = p;
                return res;
            } else {
                res[i] = p / nums[i]; // case 3
            }
        }

        return res;
    }
}  
