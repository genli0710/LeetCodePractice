package leetcode.editor.en

import kotlin.math.max

class unique_binary_search_trees {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun numTrees(n: Int): Int {
            val dp = IntArray(n + 1)
            dp[0] = 1
            dp[1] = 1
            for (i in 2..n) {
                for (j in 0 until i) {
                    dp[i] += dp[j] * dp[i - j - 1]
                }
            }
            return dp[n]
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.numTrees(19)
        }
    }
}