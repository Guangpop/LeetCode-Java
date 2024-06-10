//Java：Subarray Sums Divisible by K

//Given an integer array nums and an integer k, return the number of non-empty 
//subarrays that have a sum divisible by k. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [4,5,0,-2,-3,1], k = 5
//Output: 7
//Explanation: There are 7 subarrays with a sum divisible by k = 5:
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// Example 2: 
//
// 
//Input: nums = [5], k = 9
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 2 <= k <= 10⁴ 
// 
//
// Related Topics Array Hash Table Prefix Sum 👍 6819 👎 291


import java.util.ArrayList;
import java.util.*;

public class P974_SubarraySumsDivisibleByK{
    public static void main(String[] args) {
        Solution solution = new P974_SubarraySumsDivisibleByK().new Solution();
        // TO TEST
        solution.subarraysDivByK(new int[]{-1, 2, 9}, 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> result = new HashMap<>();
        result.put(0, 1);
        int r = 0;
        int sum = 0;
        int solK = 0;
        for (int x = 0 ; x < nums.length ; ++ x) {
            r += nums[x];
            solK = ((r % k) + k) % k;
            if (result.containsKey(solK)) {
                result.put(solK, result.get(solK)+1);
                if (result.get(solK) > 1) {
                    sum += result.get(solK) -1;
                }
            } else {
                result.put(solK, 1);
            }
        }

        return sum;
    }
}
class Solution2 {
    public int subarraysDivByK(int[] nums, int k) {
        int result = 0;
        for (int x = 0 ; x < nums.length ; ++x) {
            int r = 0;
            for (int y = x ; y < nums.length ; ++y) {
                r += nums[y];
                if(r % k == 0) {
                    //result.add(Arrays.copyOfRange(nums, x, y+1));
                    ++result;
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}