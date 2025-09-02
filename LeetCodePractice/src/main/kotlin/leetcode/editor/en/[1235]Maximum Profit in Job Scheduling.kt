package leetcode.editor.en

import leetcode.editor.common.*
import java.util.TreeMap
import kotlin.math.max

class maximum_profit_in_job_scheduling {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun jobScheduling1(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
            val info = mutableListOf<Triple<Int, Int, Int>>()
            startTime.forEachIndexed { i, _ ->
                info.add(Triple(startTime[i], endTime[i], profit[i]))
            }
            info.sortBy { it.second }
            val dp = IntArray(startTime.size)
            dp[0] = info[0].third

            for (i in 1 until info.size) {
                val curInfo = info[i]
//                val availableTask = info.filter { it.second <= curInfo.first }
//                dp[i]= max(dp[i-1]+curInfo.third, )
            }
            return dp.max()
        }

        fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
            val info = mutableListOf<Triple<Int, Int, Int>>()
            startTime.forEachIndexed { i, _ ->
                info.add(Triple(startTime[i], endTime[i], profit[i]))
            }
            info.sortBy { it.second }

            // key = endtime value = profit
            val dp = TreeMap<Int,Int>()
            dp[info[0].second] = info[0].third

            for (i in 1 until info.size) {
                val curInfo = info[i]
                val lastJobDp = dp.floorEntry(curInfo.first)
                val lasJobProfit =lastJobDp?.value ?: 0
                val currentProfit = lasJobProfit + curInfo.third

                val prevMax = dp.lastEntry().value
                if (currentProfit > prevMax) {
                    dp[curInfo.second] = currentProfit
                }
            }
            return dp.lastEntry().value
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.jobScheduling(
                intArrayOf(1, 2, 3, 4, 6),
                intArrayOf(3, 5, 10, 6, 9),
                intArrayOf(20, 20, 100, 70, 60)
            )
        }
    }
}