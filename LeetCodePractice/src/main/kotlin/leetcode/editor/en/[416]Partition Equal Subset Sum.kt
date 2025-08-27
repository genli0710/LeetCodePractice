package leetcode.editor.en

import leetcode.editor.common.*

class partition_equal_subset_sum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun canPartition(nums: IntArray): Boolean {
            val sum = nums.sum()
            if (sum % 2 == 1) {
                return false
            }
            val target = sum / 2

            val dp = BooleanArray(target + 1)
            dp[0] = true
            for (i in 1 until nums.size) {
                val num = nums[i]
                for (j in target downTo num) {
                    dp[j] = dp[j] || dp[j - num]
                }
            }

            return dp[target]
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