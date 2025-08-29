package leetcode.editor.en

import leetcode.editor.common.*

class middle_of_the_linked_list {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    class Solution {
        fun middleNode(head: ListNode?): ListNode? {
            var slow = head
            var fast = head
            while (fast?.next != null) {
                slow = slow?.next
                fast = fast.next?.next
            }
            return slow
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
        }
    }
}