package leetcode.editor.en

import leetcode.editor.common.*

class rotate_list {

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
        fun rotateRight(head: ListNode?, k: Int): ListNode? {
            if (head == null) return null
            val realK = getRealK(head, k)
            val dummpy = ListNode(-1)
            dummpy.next = head
            var slow = head
            var fast = head
            repeat(realK) {
                fast = fast?.next
            }
            while (fast?.next != null) {
                slow = slow?.next
                fast = fast?.next
            }
            if (fast == slow) {
                return head
            }
            val temp = dummpy.next
            dummpy.next = slow?.next
            fast?.next = temp
            slow?.next = null
            return dummpy.next
        }

        private fun getRealK(head: ListNode, k: Int): Int {
            var count = 0
            var counter: ListNode? = head
            while (counter != null) {
                count++
                counter = counter.next
            }
            return k % count
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.rotateRight(
                ListNode.create(intArrayOf(0, 1, 2)), 3
            )
        }
    }
}