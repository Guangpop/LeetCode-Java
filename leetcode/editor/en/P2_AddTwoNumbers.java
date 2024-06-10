//Java：Add Two Numbers

//You are given two non-empty linked lists representing two non-negative 
//integers. The digits are stored in reverse order, and each of their nodes contains a 
//single digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the 
//number 0 itself. 
//
// 
// Example 1: 
// 
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have 
//leading zeros. 
// 
//
// Related Topics Linked List Math Recursion 👍 30826 👎 6121


public class P2_AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new P2_AddTwoNumbers().new Solution();
        // TO TEST
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

        solution.addTwoNumbers(l1, l2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

 //Definition for singly-linked list.
 public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int increase = 0;
        while(l1 != null || l2 != null || increase != 0) {
            if(l1 != null) {
                increase += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                increase += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(increase % 10);
            increase = increase / 10;
            current = current.next;
        }

        return result.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}