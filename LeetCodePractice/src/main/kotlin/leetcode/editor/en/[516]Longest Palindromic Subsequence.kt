package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.max

class longest_palindromic_subsequence {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestPalindromeSubseq(s: String): Int {
            val size = s.length
            val dp = Array(size + 1) { IntArray(size + 1) }
            val reversed = s.reversed()
            for (i in 1..size) {
                for (j in 1..size) {
                    if (reversed[i - 1] == s[j - 1]) {
                        dp[i][j] = dp[i-1][j-1] +1
                    } else {
                        dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
                    }
                }
            }
            return dp[size][size]
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