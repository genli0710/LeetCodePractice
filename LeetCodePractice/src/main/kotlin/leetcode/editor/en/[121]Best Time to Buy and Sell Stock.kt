package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.max

class best_time_to_buy_and_sell_stock {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxProfit(prices: IntArray): Int {
            // dp[i]代表前N天的最大利润
            val dp = IntArray(prices.size)
            dp[0] = 0
            var min = prices[0]
            for (i in 1 until prices.size) {
                if (prices[i] < min) {
                    min = prices[i]
                } else {
                    dp[i] = max(dp[i - 1], prices[i] - min)
                }
            }
            return dp.max()
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