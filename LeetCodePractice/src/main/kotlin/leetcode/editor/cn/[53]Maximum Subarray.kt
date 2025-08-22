package leetcode.editor.cn

import leetcode.editor.common.*
import kotlin.math.max

class maximum_subarray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxSubArray1(nums: IntArray): Int {
            //dp[i] 代表以num[i]结尾的子数组的最大和,有可能是它自己一个,也可能是和前面的数组连起来
            //dp[i] = max(num[i], num[i]+dp[i-1])
            val dp = IntArray(nums.size)
            dp[0] = nums[0]
            for (i in 1 until nums.size) {
                dp[i] = max(nums[i], nums[i] + dp[i - 1])
            }
            return dp.max()
        }

        fun maxSubArray(nums: IntArray): Int {
            // recursion way
            val cache = IntArray(nums.size) { -1 }
            var max = nums[0]
            fun dfs(i: Int): Int {
                if (i == 0) return nums[0]

                if (cache[i] != -1) {
                    return cache[i]
                }

                val ret = max(nums[i], nums[i] + dfs(i - 1))
                cache[i] = ret
                if (ret > max) {
                    max = ret
                }
                return ret
            }
            dfs(nums.size - 1)

            return max
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