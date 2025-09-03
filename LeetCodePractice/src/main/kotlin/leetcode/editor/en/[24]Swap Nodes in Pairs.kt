package leetcode.editor.en

import leetcode.editor.common.*

class swap_nodes_in_pairs {

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
        fun swapPairs(head: ListNode?): ListNode? {
            val dummy = ListNode(-1)
            dummy.next = head
            var cur: ListNode? = dummy
            while (cur?.next != null && cur.next?.next != null) {
                val first = cur.next
                val second = cur.next?.next
                val nextPair = second?.next

                cur.next = second
                second?.next = first
                first?.next = nextPair

                cur = first
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
            solution.swapPairs(
                ListNode.create(intArrayOf(1, 2, 3, 4))
            )
        }
    }
}