//Java：Sort Colors

//Given an array nums with n objects colored red, white, or blue, sort them in-
//place so that objects of the same color are adjacent, with the colors in the 
//order red, white, and blue. 
//
// We will use the integers 0, 1, and 2 to represent the color red, white, and 
//blue, respectively. 
//
// You must solve this problem without using the library's sort function. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,0,1]
//Output: [0,1,2]
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] is either 0, 1, or 2. 
// 
//
// 
// Follow up: Could you come up with a one-pass algorithm using only constant 
//extra space? 
//
// Related Topics Array Two Pointers Sorting 👍 18233 👎 642


public class P75_SortColors{
    public static void main(String[] args) {
        Solution solution = new P75_SortColors().new Solution();
        // TO TEST
        solution.sortColors(new int[]{2,0,2,1,1,0});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        mergeSort(0, nums.length-1, new int[nums.length], nums);
    }

    public void mergeSort(int left, int right, int[] temp, int[] nums) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid, temp, nums);
            mergeSort(mid+1, right, temp, nums);
            merge(left, right, mid, temp, nums);
        }
    }

    public void merge(int left, int right, int mid, int[] temp, int[] nums) {
        int i = left;
        int j = mid+1;
        int temp_index = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[temp_index++] = nums[i++];
            } else {
                temp[temp_index++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[temp_index++] = nums[i++];
        }

        while (j <= right) {
            temp[temp_index++] = nums[j++];
        }

        temp_index = 0;
        while (left <= right) {
            nums[left++] = temp[temp_index++];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}