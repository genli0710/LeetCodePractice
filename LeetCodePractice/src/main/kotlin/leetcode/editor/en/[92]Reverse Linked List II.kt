package leetcode.editor.en

import leetcode.editor.common.*

class reverse_linked_list_ii {

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
        fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
            if (head?.next == null) return head
            if (left == right) return head

            val dummy = ListNode(-1)
            dummy.next = head
            var prev: ListNode? = dummy
            var leftNode = head
            repeat(left - 1) {
                prev = leftNode
                leftNode = leftNode?.next
            }
            // star moving
            var cur = leftNode?.next

            repeat(right - left) {
                leftNode?.next = leftNode?.next?.next
                cur?.next = prev?.next
                prev?.next = cur

                cur = leftNode?.next
            }

            return dummy.next
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.reverseBetween(
                ListNode.create(
                    intArrayOf(1, 2, 3, 4, 5)
                ),
                2, 4
            )
        }
    }
}