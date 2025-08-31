package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.min

class matrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
            val INF = Int.MAX_VALUE / 2
            val r = mat.size
            val c = mat[0].size
            val dp = Array(mat.size) {
                IntArray(mat[0].size) {
                    INF
                }
            }
            for (i in 0 until r) {
                for (j in 0 until c) {
                    if (mat[i][j] == 0) {
                        dp[i][j] = 0
                    } else {
                        if (i > 0) dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j])
                        if (j > 0) dp[i][j] = min(dp[i][j - 1] + 1, dp[i][j])
                    }
                }
            }

            for (i in r - 1 downTo 0) {
                for (j in c - 1 downTo 0) {
                    if (mat[i][j] == 0) {
                        dp[i][j] = 0
                    } else {
                        if (i < r - 1) dp[i][j] = min(dp[i][j], dp[i + 1][j] + 1)
                        if (j < c - 1) dp[i][j] = min(dp[i][j], dp[i][j + 1] + 1)
                    }
                }
            }
            return dp
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.updateMatrix(
                arrayOf(
                    intArrayOf(0),
                    intArrayOf(0),
                    intArrayOf(0),
                )
            )
        }
    }
}