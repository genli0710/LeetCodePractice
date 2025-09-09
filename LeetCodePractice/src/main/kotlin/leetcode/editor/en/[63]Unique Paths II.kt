package leetcode.editor.en

import leetcode.editor.common.*

class unique_paths_ii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun uniquePathsWithObstacles(grid: Array<IntArray>): Int {
            val m = grid.size
            val n = grid[0].size
            val dp = Array(m) {
                IntArray(n)
            }
            if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
                return 0
            }
            dp[0][0] = 1
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (i == 0 && j == 0) continue
                    if (grid[i][j] == 1) {
                        dp[i][j] = 0
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1]
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j]
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                    }
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