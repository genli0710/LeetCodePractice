package leetcode.editor.en

import leetcode.editor.common.*

class partition_list {

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
        fun partition(head: ListNode?, x: Int): ListNode? {
            val head1 = ListNode(Int.MIN_VALUE)
            val head2 = ListNode(Int.MIN_VALUE)

            var cur1: ListNode? = head1
            var cur2: ListNode? = head2
            var cur = head
            while (cur != null) {
                if (cur.`val` < x) {
                    cur1?.next = cur
                    cur1 = cur1?.next
                } else {
                    cur2?.next = cur
                    cur2 = cur2?.next
                }
                val temp = cur.next
                cur.next = null
                cur = temp
            }
            cur1?.next = head2.next
            return head1.next
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
//            solution.partition(
//                ListNode.create(
//                    intArrayOf(1, 4, 3, 2, 5, 2)
//                ), 3
//            )
            solution.partition(
                ListNode.create(
                    intArrayOf(2,1)
                ), 2
            )
        }
    }
}