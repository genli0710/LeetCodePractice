package leetcode.editor.en

import leetcode.editor.common.*

class decode_ways {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun numDecodings(s: String): Int {
            if (s[0] == '0') return 0
            val dp = IntArray(s.length + 1)
            dp[0] = 1
            dp[1] = 1
            for (i in 2 until s.length + 1) {
                if (s[i - 1] == '0') {
                    if (s[i - 2] in '1'..'2') {
                        dp[i] = dp[i - 2]
                    } else return 0
                } else {
                    val sb = StringBuilder().append(s[i - 2]).append(s[i - 1]).toString().toInt()
                    dp[i] = dp[i - 1]
                    if (sb in 10..26) {
                        dp[i] += dp[i - 2]
                    }
                }
            }
            return dp[s.length]
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(solution.numDecodings("226"))//3
            println(solution.numDecodings("06"))//0
            println(solution.numDecodings("111010"))//2
        }
    }
}