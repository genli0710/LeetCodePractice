package leetcode.editor.en

import leetcode.editor.common.*

class reverse_linked_list {

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
        fun reverseList1(head: ListNode?): ListNode? {
            // stack way
            val deque= ArrayDeque<ListNode?>()
            var dummy = head
            while (dummy != null) {
                deque.addLast(dummy)
                dummy = dummy.next
            }

            dummy = ListNode(-1)
            val newHead = dummy
            while (deque.isNotEmpty() && dummy != null) {
                dummy.next = deque.removeLast()
                dummy = dummy.next
            }
            dummy?.next =null
            return newHead.next
        }

        fun reverseList(head: ListNode?): ListNode? {
            var prev:ListNode? = null
            var cur = head

            while (cur != null) {
                //记住下一个cur的位置
                val temp = cur.next
                //cur的方向调转
                cur.next = prev

                //往后走
                prev = cur
                cur = temp
            }
            return prev
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