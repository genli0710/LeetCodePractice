package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.min

class edit_distance {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minDistance(word1: String, word2: String): Int {
            val dp = Array(word1.length + 1) { IntArray(word2.length + 1) }
            for (index in dp[0].indices) {
                dp[0][index] = index
            }
            for (index in dp.indices) {
                dp[index][0] = index
            }

            for (i in 1..word1.length) {
                for (j in 1..word2.length) {
                    if (word1[i - 1] == word2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1]
                    } else {
                        dp[i][j] = minOf(dp[i][j - 1], dp[i - 1][j - 1], dp[i - 1][j]) + 1
                    }
                }
            }

            return dp[word1.length][word2.length]
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