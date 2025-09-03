package leetcode.editor.en

import leetcode.editor.common.*
import java.util.PriorityQueue

class median_of_two_sorted_arrays {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
            val maxHeap = PriorityQueue<Int>(){p1,p2->
                p1-p2
            }
            val minHeap = PriorityQueue<Int>(){p1,p2->
                p2-p1
            }
            maxHeap.addAll(nums1.toList())
            maxHeap.addAll(nums2.toList())
            while (maxHeap.size > minHeap.size) {
                minHeap.add(maxHeap.poll())
            }
            if (minHeap.size - maxHeap.size > 0) {
                return minHeap.peek() * 1.0
            } else {
                return (minHeap.peek() + maxHeap.peek()) / 2.0
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.findMedianSortedArrays(
                intArrayOf(2,2,4,4),
                intArrayOf(2,2,2,4,4)
            )
        }
    }
}