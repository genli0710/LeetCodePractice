package leetcode.editor.en

import leetcode.editor.common.*

class linked_list_cycle {

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
        fun hasCycle(head: ListNode?): Boolean {
            var slow = head
            var fast = head

            if (slow?.next == null && fast?.next == null) {
                return false
            }
            while (slow != null && fast != null) {
                slow = slow.next
                fast = fast.next?.next
                if (slow == fast) {
                    return true
                }
            }
            return false
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