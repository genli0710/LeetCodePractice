package leetcode.editor.en

import leetcode.editor.common.*
import java.util.PriorityQueue
import kotlin.math.abs

class find_median_from_data_stream {
    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder() {
        val maxHeap = PriorityQueue<Int>() { n1, n2 ->
            n2 - n1
        }

        val minHeap = PriorityQueue<Int>() { n1, n2 ->
            n1 - n2
        }

        fun addNum(num: Int) {
            maxHeap.add(num)
            minHeap.add(maxHeap.poll())
            if (minHeap.size - maxHeap.size > 0) {
                maxHeap.add(minHeap.poll())
            }
        }

        fun findMedian(): Double {
            return if (maxHeap.size > minHeap.size) {
                maxHeap.peek().toDouble()
            } else {
                (maxHeap.peek() + minHeap.peek()) / 2.0
            }
        }

    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * var obj = MedianFinder()
     * obj.addNum(num)
     * var param_2 = obj.findMedian()
     */
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val m = MedianFinder()
            m.addNum(1)
            m.addNum(2)
            println(m.findMedian())
            m.addNum(3)
            println(m.findMedian())
        }
    }
}