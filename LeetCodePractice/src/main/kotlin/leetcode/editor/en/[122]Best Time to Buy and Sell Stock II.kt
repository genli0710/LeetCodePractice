package leetcode.editor.en

import kotlin.math.max

class best_time_to_buy_and_sell_stock_ii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxProfit1(prices: IntArray): Int {
            val dp = Array(prices.size) { IntArray(2) }
            dp[0][0] = 0 // 第0天 未持仓,未花钱
            dp[0][1] = -prices[0] // 第0天 持仓, 用prince[0]买入
            for (i in 1 until prices.size) {
                dp[i][0] = max(dp[i - 1][1] + prices[i], dp[i - 1][0])
                dp[i][1] = max(dp[i - 1][0] - prices[i], dp[i - 1][1])
            }

            return dp[prices.size - 1][0]
        }

        fun maxProfit(prices: IntArray): Int {
            var profit = 0
            for (i in 1 until prices.size) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1]
                }
            }
            return profit
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