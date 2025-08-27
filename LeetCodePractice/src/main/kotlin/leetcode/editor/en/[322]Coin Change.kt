package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.min

class coin_change {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun coinChange(coins: IntArray, amount: Int): Int {
            if (amount == 0) {
                return 0
            }
            val dp = IntArray(amount + 1) {
                Int.MAX_VALUE - 1
            }
            dp[0] = 0
            coins.sort()
            for (j in 1..amount) {
                for (k in coins) {
                    if (j - k < 0) break
                    dp[j] = min(dp[j], dp[j - k] + 1)
                }
            }

            return if (dp[amount] == Int.MAX_VALUE - 1) -1 else dp[amount]
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(solution.coinChange(intArrayOf(1, 2, 5), 11))
        }
    }
}