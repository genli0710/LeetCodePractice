package leetcode.editor.en

import leetcode.editor.common.*

class coin_change_ii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun change(amount: Int, coins: IntArray): Int {
            val dp = IntArray(amount + 1)
            dp[0] = 1
            for (coin in coins) {
                for (i in 1..amount) {
                    if (i - coin < 0) continue
                    dp[i] += dp[i - coin]
                }
            }

            return dp[amount]
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.change(5, intArrayOf(1, 2, 5))
        }
    }
}