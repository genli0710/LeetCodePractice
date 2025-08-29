package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.max

class maximum_subarray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxSubArray(nums: IntArray): Int {
            val dp = IntArray(nums.size)
            dp[0] = nums[0]
            for (i in 1 until nums.size) {
                dp[i] = max(dp[i - 1] + nums[i], nums[i])
            }
            return dp.max()
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