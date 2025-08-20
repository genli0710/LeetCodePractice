package leetcode.editor.cn

import kotlin.math.max

class house_robber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun rob1(nums: IntArray): Int {
            // recursion version
            val cache = IntArray(nums.size) { -1 }

            fun dfs(index: Int): Int {
                if (index == 0) {
                    return nums[0]
                }
                if (index == 1) {
                    return max(nums[0], nums[1])
                }

                if (cache[index] != -1) {
                    return cache[index]
                }

                val max = max(
                    dfs(index - 2) + nums[index],
                    dfs(index - 1)
                )

                cache[index] = max
                return max
            }

            return dfs(nums.size - 1)
        }

        fun rob2(nums: IntArray): Int {
            // dp version
            if (nums.size == 1) {
                return nums[0]
            }

            val dp = IntArray(nums.size)
            dp[0] = nums[0]
            dp[1] = max(nums[0],nums[1])

            for (i in 2 until nums.size) {
                dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
            }

            return dp[nums.size - 1]
        }

        fun rob(nums: IntArray): Int {
            // space o(1) version
            if (nums.size == 1) {
                return nums[0]
            }

            var last2 = nums[0]
            var last1 = max(nums[0],nums[1])

            for (i in 2 until nums.size) {
                val max = max(last2 + nums[i], last1)
                last2 = last1
                last1 = max
            }

            return last1
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            solution.rob(intArrayOf(2, 1))
            // put your test code here
        }
    }
}