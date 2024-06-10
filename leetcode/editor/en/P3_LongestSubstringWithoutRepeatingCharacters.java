//Java：Longest Substring Without Repeating Characters

//Given a string s, find the length of the longest substring without repeating 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 39426 👎 1867


import java.util.*;

public class P3_LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
        solution.lengthOfLongestSubstring("abcabcbb");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap<>();

        int ndx = 0;
        int maxSize = 0;
        for (int x = 0 ; x < s.length() ; ++x) {
            if (m.containsKey(s.charAt(x))) {
                ndx = Math.max(ndx, m.get(s.charAt(x)) + 1);
            }
            maxSize = Math.max(maxSize, x - ndx + 1);
            m.put(s.charAt(x), x);
        }

        return maxSize;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}