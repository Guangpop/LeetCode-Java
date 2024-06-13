//Java：Zigzag Conversion

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
//of rows like this: (you may want to display this pattern in a fixed font for 
//better legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a 
//number of rows: 
//
// 
//string convert(string s, int numRows);
// 
//
// 
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// Example 3: 
//
// 
//Input: s = "A", numRows = 1
//Output: "A"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of English letters (lower-case and upper-case), ',' and '.'. 
// 1 <= numRows <= 1000 
// 
//
// Related Topics String 👍 7568 👎 14551


import java.util.Arrays;
import java.util.stream.Collectors;

public class P6_ZigzagConversion{
    public static void main(String[] args) {
        Solution solution = new P6_ZigzagConversion().new Solution();
        // TO TEST
        solution.convert("PAYPALISHIRING", 3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) {
            return s;
        }

        int n = (2 * numRows) - 2;
        String[] temp = new String[numRows];

        for (int it = 0 ; it < temp.length ; ++it) {
            temp[it] = "";
        }

        for (int i = 0 ; i < s.length() ; ++i) {
            int line = i % n;
            if (line < numRows) {
                temp[line] += s.charAt(i);
            } else {
                temp[2 * numRows - line - 2] += s.charAt(i);
            }
        }

        return Arrays.stream(temp).collect(Collectors.joining());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}