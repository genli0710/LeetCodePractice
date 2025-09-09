package leetcode.editor.en

import leetcode.editor.common.*

class jump_game {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun canJump(nums: IntArray): Boolean {
            val size = nums.size
            val dp = BooleanArray(size)
            dp[0] = true
            for(i in 1 until size){
                for (j in 0 until i) {
                    dp[i] = dp[i] || dp[j] && (nums[j] >= i - j)
                }
            }
            return dp[size - 1]
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(
                solution.canJump(
                    intArrayOf(2, 3, 1, 1, 4)
                )
            )
            println(
                solution.canJump(
                    intArrayOf(3,2, 1, 0, 4)
                )
            )
        }
    }
}