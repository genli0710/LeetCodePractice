package leetcode.editor.en

import leetcode.editor.common.*
import java.util.*
import kotlin.math.max

class merge_intervals {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            intervals.sortBy { it[0] }
            val result = mutableListOf<MutableList<Int>>()
            result.add(intervals[0].toMutableList())
            for (i in 1 until intervals.size) {
                val last = result.last()
                val right = last[1]
                val interval = intervals[i]
                if (interval[0] <= right) {
                    result.last()[1] = max(interval[1], right)
                } else {
                    result.add(interval.toMutableList())
                }
            }

            return result.map { it.toIntArray() }.toTypedArray()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            val intervals1 = arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18)
            )
            val result1 = solution.merge(intervals1)
            println("输出: ${Arrays.deepToString(result1)}")
            println("预期: [[1, 6], [8, 10], [15, 18]]")
            println("---")
        }
    }
}