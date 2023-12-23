//Java：Longest Common Prefix

//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lowercase English letters. 
// 
//
// Related Topics String Trie 👍 16522 👎 4341


import java.util.List;

public class P14_LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new P14_LongestCommonPrefix().new Solution();
        // TO TEST
        solution.longestCommonPrefix(new String[]{"dog","racecar","car"});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";

        for (int charIndex = 0 ; charIndex < strs[0].length() ; ++charIndex) {
            for (int strIndex = 0 ; strIndex < strs.length ; ++strIndex) {
                if (strs[strIndex].length() <= charIndex ||
                        strs[strIndex].charAt(charIndex) !=
                        strs[0].charAt(charIndex)) return result;
            }
            result += strs[0].charAt(charIndex);

        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}