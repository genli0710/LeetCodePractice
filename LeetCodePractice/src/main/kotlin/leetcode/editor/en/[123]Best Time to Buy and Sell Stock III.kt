package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.max

class best_time_to_buy_and_sell_stock_iii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxProfit1(prices: IntArray): Int {
            val size = prices.size
            val K = 2
            val dp = Array(size) {
                Array(K + 1) {
                    IntArray(2)
                }
            }
            dp[0][1][0] = 0
            dp[0][1][1] = -prices[0]
            dp[0][2][0] = 0
            dp[0][2][1] = -prices[0]
            for (i in 1 until size) {
                for (j in 1..K) {
                    dp[i][j][0] = max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i])
                    dp[i][j][1] = max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i])
                }
            }

            return dp[size - 1][2][0]
        }

        fun maxProfit(prices: IntArray): Int {
            val size = prices.size
            var s1 = -prices[0] //第一次买入
            var s2 = 0 //k=1 第一次空仓
            var s3 = -prices[0] //第二次买入
            var s4 = 0 //k=2 第二次空仓
            for (i in 1 until size) {
                s1 = max(s1, -prices[i])
                s2 = max(s2, s1 + prices[i])
                s3 = max(s3, s2 - prices[i])
                s4 = max(s4, s3 + prices[i])
            }

            return s4
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