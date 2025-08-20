package leetcode.editor.cn

import leetcode.editor.common.*
import kotlin.math.cos
import kotlin.math.min

class min_cost_climbing_stairs {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minCostClimbingStairs1(cost: IntArray): Int {
            // recursion way
            val number = cost.size
            val cache = IntArray(number + 1) { -1 }

            fun dfs(n: Int): Int {
                if (n == 0 || n == 1) {
                    return cost[n]
                }

                if (cache[n] != -1) {
                    return cache[n]
                }

                if (n == number) {
                    val min = min(dfs(n - 1), dfs(n - 2))
                    cache[n] = min
                    return min
                }

                val cost = cost[n] + min(dfs(n - 1), dfs(n - 2))
                cache[n] = cost
                return cost
            }

            return dfs(number)
        }

        fun minCostClimbingStairs2(cost: IntArray): Int {
            // DP way
            val newCost = cost + 0
            val size = cost.size
            val dp = IntArray(size + 1)
            dp[0] = newCost[0]
            dp[1] = newCost[1]
            for (i in 2..size) {
                dp[i] = newCost[i] + min(dp[i - 1], dp[i - 2])
            }

            return dp[size]
        }

        fun minCostClimbingStairs(cost: IntArray): Int {
            // DP way
            val newCost = cost + 0
            val size = cost.size
            var last1 = newCost[1]
            var last2 = newCost[0]
            for (i in 2..size) {
                val minCost = newCost[i] + min(last1, last2)
                last2 = last1
                last1 = minCost
            }

            return last1
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(solution.minCostClimbingStairs(intArrayOf(10, 15, 20)))
        }
    }
}