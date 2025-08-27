package leetcode.editor.en

import leetcode.editor.common.*

class unique_paths {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun uniquePaths(m: Int, n: Int): Int {
            val dp = Array(m) { IntArray(n) { 1 } }
            for (i in 1 until m) {
                for (j in 1 until n) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
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