package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.max
import kotlin.math.min

class minimum_number_of_arrows_to_burst_balloons {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findMinArrowShots(points: Array<IntArray>): Int {
            if (points.size == 1) return 1

            points.sortBy { it[0] }
            var pair = points[0][0] to points[0][1]
            var shot = 0
            for (i in 1 until points.size) {
                val left = points[i][0]
                val right = points[i][1]
                if (left <= pair.second) {
                    pair = max(left, pair.first) to min(right, pair.second)
                } else {
                    shot++
                    pair = points[i][0] to points[i][1]
                }
            }
            return shot + 1
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.findMinArrowShots(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(4, 5),
                    intArrayOf(3, 4),
                )
            ).print()
            solution.findMinArrowShots(
                arrayOf(
                    intArrayOf(10, 16),
                    intArrayOf(2, 8),
                    intArrayOf(1, 6),
                    intArrayOf(7, 12),
                )
            ).print()
        }
    }
}