//Java：Number of Dice Rolls With Target Sum

//You have n dice, and each die has k faces numbered from 1 to k. 
//
// Given three integers n, k, and target, return the number of possible ways (
//out of the kⁿ total ways) to roll the dice, so the sum of the face-up numbers 
//equals target. Since the answer may be too large, return it modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: n = 1, k = 6, target = 3
//Output: 1
//Explanation: You throw one die with 6 faces.
//There is only one way to get a sum of 3.
// 
//
// Example 2: 
//
// 
//Input: n = 2, k = 6, target = 7
//Output: 6
//Explanation: You throw two dice, each with 6 faces.
//There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
// 
//
// Example 3: 
//
// 
//Input: n = 30, k = 30, target = 500
//Output: 222616187
//Explanation: The answer must be returned modulo 10⁹ + 7.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n, k <= 30 
// 1 <= target <= 1000 
// 
//
// Related Topics Dynamic Programming 👍 4637 👎 148


public class P1155_NumberOfDiceRollsWithTargetSum{
    public static void main(String[] args) {
        Solution solution = new P1155_NumberOfDiceRollsWithTargetSum().new Solution();
        // TO TEST
        System.out.println(solution.numRollsToTarget(2, 6, 7));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        if (n*k < target) return 0;
        // dice num, target
        int[][] result = new int[n+1][target+1];

        result[0][0] = 1;
        int module = (int) (1e9+7);
        for (int x = 1 ; x <= n ; ++x) {
            for (int y = 1 ; y <= k ; ++y) {
                // result = stair
                for (int z = y ; z <= target ; ++z) {
                    //                                       result - stair
                    result[x][z] = (result[x][z] + result[x - 1][z - y]) % module;
                }
            }
        }

        return result[n][target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}