package leetcode.editor.en

import leetcode.editor.common.*

class add_two_numbers {

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
        fun addTwoNumbers1(l1: ListNode?, l2: ListNode?): ListNode? {
            var head1 = l1
            var head2 = l2
            var head3: ListNode? = ListNode(-1)
            val resultNode = head3
            var isCarry = false
            while (head2 != null && head1 != null) {
                val result = head1.`val` + head2.`val` + if (isCarry) 1 else 0
                if (result >= 10) {
                    head3?.next = ListNode(result % 10)
                    isCarry = true
                } else {
                    head3?.next = ListNode(result)
                    isCarry = false
                }
                head1 = head1.next
                head2 = head2.next
                head3 = head3?.next
            }
            var head4 = head1 ?: head2
            while (head4 != null) {
                val result = head4.`val` + if (isCarry) 1 else 0
                if (result >= 10) {
                    head3?.next = ListNode(result % 10)
                    isCarry = true
                } else {
                    head3?.next = ListNode(result)
                    isCarry = false
                }
                head4 = head4.next
                head3 = head3?.next
            }
            if (isCarry) {
                head3?.next = ListNode(1)
            }

            return resultNode?.next
        }

        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            var head1 = l1
            var head2 = l2
            var head3: ListNode? = ListNode(-1)
            val resultNode = head3
            var carry = 0
            while (head2 != null || head1 != null || carry != 0) {
                val result = (head1?.`val` ?: 0) +
                        (head2?.`val` ?: 0) +
                        carry
                head3?.next = ListNode(result % 10)
                carry = result / 10
                head1 = head1?.next
                head2 = head2?.next
                head3 = head3?.next
            }
            return resultNode?.next
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