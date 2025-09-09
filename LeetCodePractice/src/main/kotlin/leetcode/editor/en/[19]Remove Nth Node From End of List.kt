package leetcode.editor.en

import leetcode.editor.common.*

class remove_nth_node_from_end_of_list {

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
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            var sz = 0
            var cur = head
            while (cur != null) {
                sz++
                cur = cur.next
            }
            if (sz < n) {
                return null
            }
            if (sz == 1 && n == 1) {
                return null
            }
            var dummy: ListNode? = ListNode(-1)
            dummy?.next = head
            var slow = dummy
            var fast = dummy
            repeat(n) {
                fast = fast?.next
            }
            var prev = slow
            while (fast != null) {
                prev = slow
                slow = slow?.next
                fast = fast?.next
            }
//            println("要删除的是${prev?.next?.`val`}")
            prev?.next = prev?.next?.next

            return dummy?.next
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.removeNthFromEnd(
                ListNode.create(intArrayOf(1, 2)), 2
            )
        }
    }
}