package leetcode.editor.cn

import leetcode.editor.common.*

class find_pivot_index {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun pivotIndex1(nums: IntArray): Int {
            // dp[i]代表以i为pivot时,左右两边的和
            val dp = Array<Pair<Int, Int>>(nums.size) { 0 to 0 }
            dp[0] = 0 to nums.sum() - nums[0]
            if (dp[0].first == dp[0].second) {
                return 0
            }

            for (i in 1 until nums.size) {
                dp[i] = dp[i - 1].first + nums[i - 1] to dp[i - 1].second - nums[i]
                if (dp[i].first == dp[i].second) {
                    return i
                }
            }
            return -1
        }

        fun pivotIndex(nums: IntArray): Int {
            // dp way rolling variables
            var left = 0
            var right = nums.sum() - nums[0]
            if (left == right) {
                return 0
            }

            for (i in 1 until nums.size) {
                left += nums[i - 1]
                right -= nums[i]
                if (left == right) {
                    return i
                }
            }
            return -1
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            solution.pivotIndex(intArrayOf(2, 1, -1))
            // put your test code here
        }
    }
}