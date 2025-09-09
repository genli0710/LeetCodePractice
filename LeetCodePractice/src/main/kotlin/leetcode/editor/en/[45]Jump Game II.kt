package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.min

class jump_game_ii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun jump(nums: IntArray): Int {
            val dp = IntArray(nums.size)
            dp[0] = 0
            for (i in 1 until nums.size) {
                dp[i] = Int.MAX_VALUE
                for (j in 0 until i) {
                    if (nums[j] >= i - j) {
                        dp[i] = min(dp[j] + 1, dp[i])
                    }
                }
            }
            return dp[nums.size - 1]
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.jump(intArrayOf(2, 3, 1, 1, 4))
        }
    }
}