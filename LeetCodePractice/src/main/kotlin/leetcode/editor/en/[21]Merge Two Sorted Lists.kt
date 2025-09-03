package leetcode.editor.en

import leetcode.editor.common.*

class merge_two_sorted_lists {

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
        fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
            if (list1 == null) return list2
            if (list2 == null) return list1
            var l1= list1
            var l2 = list2
            if (l1.`val` > l2.`val`) {
                val temp = l1
                l1 = l2
                l2 = temp
            }
            val head = l1
            var prev:ListNode? = null
            while (l1 != null && l2 != null) {
                if (l1.`val` <= l2.`val`) {
                    prev = l1
                    l1 = l1.next
                }else {
                    val nextL2 = l2.next
                    prev?.next = l2
                    l2.next = l1
                    prev = l2
                    l2 = nextL2
                }
            }
            if (l2 != null) {
                prev?.next = l2
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
            solution.mergeTwoLists(
                ListNode.create(intArrayOf(1, 3, 5)),
                ListNode.create(intArrayOf(2, 4, 6))
            )
        }
    }
}