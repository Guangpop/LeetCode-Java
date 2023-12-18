//Roman numerals are represented by seven different symbols: I, V, X, L, C, D 
//and M. 
//
// 
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// For example, 2 is written as II in Roman numeral, just two ones added 
//together. 12 is written as XII, which is simply X + II. The number 27 is written as 
//XXVII, which is XX + V + II. 
//
// Roman numerals are usually written largest to smallest from left to right. 
//However, the numeral for four is not IIII. Instead, the number four is written as 
//IV. Because the one is before the five we subtract it making four. The same 
//principle applies to the number nine, which is written as IX. There are six 
//instances where subtraction is used: 
//
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900. 
// 
//
// Given a roman numeral, convert it to an integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "III"
//Output: 3
//Explanation: III = 3.
// 
//
// Example 2: 
//
// 
//Input: s = "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
// 
//
// Example 3: 
//
// 
//Input: s = "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 15 
// s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M'). 
// It is guaranteed that s is a valid roman numeral in the range [1, 3999]. 
// 
//
// Related Topics Hash Table Math String 👍 13043 👎 797


// [13]_RomanToInteger

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    enum roman {
        V(5, false, null, null),
        L(50, false, null, null),
        D(500, false, null, null),
        M(1000, false, null, null),
        C(100, true, D, M),
        X(10, true, L, C),
        I(1, true, V, X);

        private int num;
        private boolean isCombo;
        private roman combo1;
        private roman combo2;

        roman(int i, boolean b, roman c1, roman c2) {
            num = i;
            isCombo = b;
            combo1 = c1;
            combo2 = c2;
        }

        public int getValue(roman next) {
            if (isCombo) {
                if (next != null && (next == combo1 || next == combo2)) {
                    return 0-num;
                }
            }

            return num;
        }
    }

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0 ; i < s.length() ; ++i) {
            roman next = null;
            if (i+1 < s.length()) {
                next = roman.valueOf(""+s.charAt(i+1));
            }
            int romanValue =
                    roman.valueOf(""+s.charAt(i))
                            .getValue(next);

            result += romanValue;
        }

        return result;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
