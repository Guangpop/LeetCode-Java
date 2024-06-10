//Java：Height Checker

//A school is trying to take an annual photo of all the students. The students 
//are asked to stand in a single file line in non-decreasing order by height. Let 
//this ordering be represented by the integer array expected where expected[i] is 
//the expected height of the iᵗʰ student in line. 
//
// You are given an integer array heights representing the current order that 
//the students are standing in. Each heights[i] is the height of the iᵗʰ student in 
//line (0-indexed). 
//
// Return the number of indices where heights[i] != expected[i]. 
//
// 
// Example 1: 
//
// 
//Input: heights = [1,1,4,2,1,3]
//Output: 3
//Explanation: 
//heights:  [1,1,4,2,1,3]
//expected: [1,1,1,2,3,4]
//Indices 2, 4, and 5 do not match.
// 
//
// Example 2: 
//
// 
//Input: heights = [5,1,2,3,4]
//Output: 5
//Explanation:
//heights:  [5,1,2,3,4]
//expected: [1,2,3,4,5]
//All indices do not match.
// 
//
// Example 3: 
//
// 
//Input: heights = [1,2,3,4,5]
//Output: 0
//Explanation:
//heights:  [1,2,3,4,5]
//expected: [1,2,3,4,5]
//All indices match.
// 
//
// 
// Constraints: 
//
// 
// 1 <= heights.length <= 100 
// 1 <= heights[i] <= 100 
// 
//
// Related Topics Array Sorting Counting Sort 👍 1170 👎 87


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1051_HeightChecker{
    public static void main(String[] args) {
        Solution solution = new P1051_HeightChecker().new Solution();
        // TO TEST
        solution.heightChecker(new int[]{1,1,4,2,1,3});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int heightChecker(int[] heights) {
        int temp[] = Arrays.copyOf(heights, heights.length);
        mergeSort(0, heights.length-1, temp, new int[heights.length]);

        int result = 0;
        for (int x = 0 ; x < heights.length ; ++x) {
            if(heights[x] != temp[x]) {
                ++result;
            }
        }

        return result;
    }

    private void mergeSort(int left, int right, int[] raw, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid, raw, temp);
            mergeSort(mid+1, right, raw, temp);
            merge(left, right, mid, raw, temp);
        }
    }

    private void merge(int left, int right, int mid, int[] raw, int[] temp) {
        int i = left;
        int j = mid+1;
        int tempIndex = 0;
        while (i <= mid && j <= right) {
            if (raw[i] < raw[j]) {
                temp[tempIndex] = raw[i++];
            } else {
                temp[tempIndex] = raw[j++];
            }
            ++tempIndex;
        }

        while (i <= mid) {
            temp[tempIndex++] = raw[i++];
        }
        while (j <= right) {
            temp[tempIndex++] = raw[j++];
        }

        tempIndex = 0;
        while (left <= right) {// copy for range of this merge
            raw[left++] = temp[tempIndex++];
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}