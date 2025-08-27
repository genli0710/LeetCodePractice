package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.max

class longest_common_subsequence {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestCommonSubsequence(text1: String, text2: String): Int {
            val dp = Array(text1.length + 1) { IntArray(text2.length + 1) { 0 } }
            val newText1 = " ${text1}"
            val newText2 = " ${text2}"
            for (i in 1 .. text1.length) {
                for (j in 1 .. text2.length) {
                    if (newText1[i] == newText2[j]) {
                        dp[i][j] = dp[i - 1][j - 1] +1
                    }else {
                        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
                    }
                }
            }

            return dp[text1.length][text2.length]
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