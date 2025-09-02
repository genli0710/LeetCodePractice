package leetcode.editor.en

import leetcode.editor.common.*
import java.util.PriorityQueue

class merge_k_sorted_lists {

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
        fun mergeKLists1(lists: Array<ListNode?>): ListNode? {
            //min heap way
            val minHeap = PriorityQueue<ListNode>() { n1, n2 ->
                n1.`val` - n2.`val`
            }
            lists.forEach {
                if (it != null) {
                    minHeap.add(it)
                }
            }
            val dummy = ListNode(-1)
            var cur: ListNode? = dummy

            while (minHeap.isNotEmpty()) {
                val currentMin = minHeap.poll()
                cur?.next = currentMin
                if (currentMin.next != null) {
                    minHeap.add(currentMin.next)
                }
                cur = cur?.next
            }
            return dummy.next
        }

        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            // Divide & conquer way
            val queue = ArrayDeque<ListNode>()
            lists.forEach { if (it != null) queue.addLast(it) }

            fun merge(a: ListNode, b: ListNode): ListNode? {
                val dummy = ListNode(-1)
                var cur: ListNode? = dummy
                var p1: ListNode? = a
                var p2: ListNode? = b
                while (p1 != null && p2 != null) {
                    if (p1.`val` < p2.`val`) {
                        cur?.next = p1
                        p1 = p1.next
                    } else {
                        cur?.next = p2
                        p2 = p2.next
                    }
                    cur = cur?.next
                }
                cur?.next = p1 ?: p2
                return dummy.next
            }

            while (queue.size > 1) {
                val a = queue.removeFirst()
                val b = queue.removeFirst()
                val c = merge(a, b)
                if (c != null) {
                    queue.addLast(c)
                }
            }
            return queue.lastOrNull()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.mergeKLists(
                arrayOf(
                    ListNode.create(intArrayOf(1, 4, 5)),
                    ListNode.create(intArrayOf(1, 3, 4)),
                    ListNode.create(intArrayOf(2, 6)),
                )
            )
        }
    }
}