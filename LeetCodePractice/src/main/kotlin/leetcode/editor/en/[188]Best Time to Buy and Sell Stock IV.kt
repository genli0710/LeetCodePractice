package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.max

class best_time_to_buy_and_sell_stock_iv {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxProfit1(prices: IntArray): Int {
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

        fun maxProfit(k: Int, prices: IntArray): Int {
            if (k == 1) {
                return maxProfit1(prices)
            }
            val size = prices.size
            val dp = Array(size) {
                Array(k + 1) {
                    IntArray(2)
                }
            }
            for (j in 1..k) {
                dp[0][j][0] = 0
                dp[0][j][1] = -prices[0]
            }
            for (i in 1 until size) {
                for (j in 1..k) {
                    dp[i][j][0] = max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i])
                    dp[i][j][1] = max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i])
                }
            }
            return dp[size - 1][k][0]
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