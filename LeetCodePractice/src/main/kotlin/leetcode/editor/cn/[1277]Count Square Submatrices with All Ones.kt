package leetcode.editor.cn

import leetcode.editor.common.*
import kotlin.math.min

class count_square_submatrices_with_all_ones {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun countSquares1(matrix: Array<IntArray>): Int {
            //dp way
            val dp = matrix.clone()
            for (i in 1 until dp.size) {
                for (j in 1 until dp[0].size) {
                    if (dp[i][j] == 0) continue
                    dp[i][j] = minOf(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
                }
            }
            return dp.flatMap { it.map { it } }.sum()
        }

        fun countSquares(matrix: Array<IntArray>): Int {
            // recursion way
            val cache = Array(matrix.size) { IntArray(matrix[0].size) { -1 } }

            fun dfs(m: Int, n: Int): Int {
                if (m < 0 || n < 0) {
                    return 0
                }

                if (cache[m][n] != -1) {
                    return cache[m][n]
                }
                return if (matrix[m][n] == 1) {
                    val result = minOf(dfs(m - 1, n - 1), dfs(m - 1, n), dfs(m, n - 1)) + 1
                    cache[m][n] = result
                    result
                } else {
                    cache[m][n] = 0
                    0
                }
            }

            var totalSquares = 0
            for (i in matrix.indices) {
                for (j in matrix[0].indices) {
                    totalSquares += dfs(i, j) // 遍历每个点，并累加它的结果
                }
            }

            return cache.flatMap { it.map { it } }.sum()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()

            println(
                solution.countSquares(
                    arrayOf(
                        intArrayOf(0, 1, 1, 1),
                        intArrayOf(1, 1, 1, 1),
                        intArrayOf(0, 1, 1, 1),
                    )
                )
            )
            // put your test code here
        }
    }
}