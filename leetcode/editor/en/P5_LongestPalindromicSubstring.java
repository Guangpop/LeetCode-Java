//Java：Longest Palindromic Substring

//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
//
// Related Topics Two Pointers String Dynamic Programming 👍 29096 👎 1768


public class P5_LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        // TO TEST
        solution.longestPalindrome("babad");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {

        int s_size = s.length();
        int result_start = 0;

        boolean[][] result = new boolean[s_size][s_size];

        // for string size = 1
        int maxLength = 1;
        for (int i = 0 ; i < s_size ; ++i) {
            result[i][i] = true;
        }

        // for string size = 2
        for (int i = 0 ; i < s_size-1 ; ++i) {
            if(s.charAt(i) == s.charAt(i+1)) {
                result[i][i+1] = true;
                result_start = i;
                maxLength = 2;
            }
        }

        for (int s_range = 3 ; s_range <= s_size ; ++s_range) {
            for (int i = 0 ; i < s_size - s_range + 1 ; ++i) {
                int j = i + s_range - 1;
                if (result[i+1][j-1] == true && // shorter substring
                    s.charAt(i) == s.charAt(j)) {

                    result[i][j] = true;

                    if(s_range > maxLength) {
                        maxLength = s_range;
                        result_start = i;
                    }
                }
            }
        }

        return s.substring(result_start, result_start+maxLength);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}