package leetcode.editor.en

import leetcode.editor.common.*

class climbing_stairs {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun climbStairs(n: Int): Int {
            if(n==1) return 1
            val dp = IntArray(n + 1)
            dp[0] = 1
            dp[1] = 1
            for (i in 2..n) {
                dp[i] = dp[i-1]+dp[i-2]
            }
            return dp[n]
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