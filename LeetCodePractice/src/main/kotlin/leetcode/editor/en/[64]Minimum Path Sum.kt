package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.min

class minimum_path_sum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minPathSum(grid: Array<IntArray>): Int {
            val m = grid.size
            val n = grid[0].size
            val dp = Array(m) { IntArray(n) }
            for (index in 0 until m) {
                dp[index][0] = if (index == 0) grid[0][0] else grid[index][0] + dp[index - 1][0]
            }
            for (index in 0 until n) {
                dp[0][index] = if (index == 0) grid[0][0] else grid[0][index] + dp[0][index - 1]
            }

            for (i in 1 until m) {
                for (j in 1 until n) {
                    dp[i][j] = grid[i][j] + min(dp[i - 1][j], dp[i][j - 1])
                }
            }
            return dp[m - 1][n - 1]
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
        }
    }
}