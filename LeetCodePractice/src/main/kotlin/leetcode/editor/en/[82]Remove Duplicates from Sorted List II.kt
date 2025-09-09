package leetcode.editor.en

import leetcode.editor.common.*

class remove_duplicates_from_sorted_list_ii {

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
            if (head == null) return null
            if (head.next == null) return head
            val dummy = ListNode(-1)
            dummy.next = head
            var prev: ListNode? = dummy
            var start: ListNode? = head
            var end: ListNode? = head.next
            while (end != null) {
                if (start?.`val` == end.`val`) {
                    while (start.`val` == end?.`val`) {
                        end = end.next
                    }
                    prev?.next = end
                    start = end
                    end = end?.next
                } else {
                    prev = start
                    start = end
                    end = end.next
                }
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
            solution.deleteDuplicates(
                ListNode.create(intArrayOf(1, 1))
            )
            solution.deleteDuplicates(
                ListNode.create(intArrayOf(1, 1, 1, 2, 3))
            )
            solution.deleteDuplicates(
                ListNode.create(intArrayOf(1, 2, 3, 3, 4, 4, 5))
            )
        }
    }
}