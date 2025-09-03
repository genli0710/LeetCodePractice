package leetcode.editor.en

import leetcode.editor.common.*

class remove_duplicates_from_sorted_list {

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
        fun deleteDuplicates(head: ListNode?): ListNode? {
            var cur = head
            while (cur?.next != null) {
                if (cur.`val` == cur.next!!.`val`) {
                    cur.next = cur.next?.next
                } else {
                    cur = cur.next
                }
            }
            return head
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