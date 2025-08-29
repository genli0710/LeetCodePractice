package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.max

class insert_interval {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            if (intervals.isEmpty()) {
                return arrayOf(newInterval)
            }

            //[1,2],[3,5],[4,8],[6,7],[8,10],[12,16]
            val arr = intervals.toMutableList()
            arr.add(newInterval)
            arr.sortBy { it[0] }
            val result = mutableListOf<IntArray>()
            result.add(arr[0])
            for (i in 1 until arr.size) {
                val last = result.last()
                val current = arr[i]
                if (current[0] <= last[1]) {
                    last[1] = max(last[1], current[1])
                } else {
                    result.add(current)
                }
            }

            return result.toTypedArray()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            val arrays = solution.insert(
                arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16)),
                intArrayOf(4, 8)
            )
//            val arrays = solution.insert(
//                arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)),
//                intArrayOf(2, 5)
//            )
//            val arrays = solution.insert(
//                arrayOf(intArrayOf(1, 5)),
//                intArrayOf(6, 8)
//            )

            arrays
        }
    }
}