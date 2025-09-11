package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.cos

class gas_station {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
            val diff = gas.mapIndexed { index, v -> v - cost[index] }
            val sum = diff.sum()
            if (sum < 0) {
                return -1
            }
            var partitionSum = 0
            var index = 0
            for (i in diff.indices) {
                partitionSum += diff[i]
                if (partitionSum < 0) {
                    index = i + 1
                    partitionSum = 0
                }
            }
            return if (partitionSum < 0) {
                -1
            } else {
                index
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.canCompleteCircuit(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(3, 4, 5, 1, 2)
            ).print(3)
            solution.canCompleteCircuit(
                intArrayOf(5, 8, 2, 8),
                intArrayOf(6, 5, 6, 6)
            ).print(3)
            solution.canCompleteCircuit(
                intArrayOf(6, 1, 4, 3, 5),
                intArrayOf(3, 8, 2, 4, 2)
            ).print(2)
            solution.canCompleteCircuit(
                intArrayOf(3, 1, 1),
                intArrayOf(1, 2, 2)
            ).print(0)
        }
    }
}