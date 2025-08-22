package leetcode.editor.cn

import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

class paint_the_house {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minCostDP(costs: Array<IntArray>): Int {
            // write your code here
            //dp way
            val row = costs.size
            val col = costs[0].size
            val dp = Array(row) {
                IntArray(col) { 0 }
            }

            //初始化第一行
            for (j in costs[0].indices) {
                dp[0][j] = costs[0][j]
            }

            for (i in 1 until row) {
                for (j in costs[0].indices) {
                    val lastLineMin = dp[i - 1].filterIndexed { index, _ -> index != j }.min()
                    dp[i][j] = costs[i][j] + lastLineMin
                }
            }

            return dp[row - 1].min()
        }

        fun minCost(costs: Array<IntArray>): Int {
            //recursion way
            val row = costs.size
            val col = costs[0].size
            val cache = Array(row) {
                IntArray(col) { -1 }
            }

            // 返回值: 到当前点的最小值
            fun dfs(i: Int, nextJ:Int):Int {
                if (i < 0) {
                    return 0
                }

                if (cache[i][nextJ] != -1) {
                    return cache[i][nextJ]
                }


                var min = Int.MAX_VALUE
                for (j in 0 until col) {
                    if (nextJ == j) continue
                    val ret = dfs(i - 1, j) + costs[i][j]
                    if (ret < min) {
                        min = ret
                    }
                }
                cache[i][nextJ] = min
                return min
            }

            for (j in 0 until col) {
                dfs(row-1, j)
            }
            return cache[row - 1].min()
        }


        fun minCostII(costs: Array<IntArray>): Int {
            // write your code here
            //dp way
            val row = costs.size
            val col = costs[0].size
            val dp = Array(row) {
                IntArray(col) { 0 }
            }

            //初始化第一行
            for (j in costs[0].indices) {
                dp[0][j] = costs[0][j]
            }

            for (i in 1 until row) {
                var minIndex1 = 0
                var minValue1 = Int.MAX_VALUE
                var minValue2 = Int.MAX_VALUE
                dp[i - 1].forEachIndexed { index, v ->
                    if (v < minValue1) {
                        minValue2 = minValue1
                        minValue1 = v
                        minIndex1 = index
                    } else if (v < minValue2) {
                        minValue2 = v
                    }
                }

                for (j in costs[0].indices) {
                    if (j == minIndex1) {
                        dp[i][j] = costs[i][j] + minValue2
                    } else {
                        dp[i][j] = costs[i][j] + minValue1
                    }
                }
            }

            return dp[row - 1].min()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            println(
                solution.minCost(
                    arrayOf(
                        intArrayOf(1, 10, 5),
                        intArrayOf(8, 2, 7),
                        intArrayOf(6, 9, 3)
                    )
                )
            )
            // put your test code here
        }
    }
}