package leetcode.editor.en

import leetcode.editor.common.*

class word_break {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun wordBreak(s: String, wordDict: List<String>): Boolean {
            val dp = BooleanArray(s.length)
            val dic:HashSet<String> = wordDict.toHashSet<String>()
            dp[0] = dic.contains(s[0].toString())
            for (i in 1 until s.length) {
                dp[i] = dic.contains(s.substring(0, i + 1))
                for (j in 0 until i) {
                    dp[i] = dp[i] || (dp[j] && dic.contains(s.substring(j + 1, i + 1)))
                }
            }
            return dp[s.length - 1]
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.wordBreak(
                "applepenapple",
                listOf("apple", "pen")
            )
        }
    }
}