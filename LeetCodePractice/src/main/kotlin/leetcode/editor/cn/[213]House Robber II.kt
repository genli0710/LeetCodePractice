package leetcode.editor.cn

import leetcode.editor.common.*
import kotlin.math.max

class house_robber_ii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun rob198(nums: IntArray): Int {
            // space o(1) version
            if (nums.size == 1) {
                return nums[0]
            }

            var last2 = nums[0]
            var last1 = max(nums[0], nums[1])

            for (i in 2 until nums.size) {
                val max = max(last2 + nums[i], last1)
                last2 = last1
                last1 = max
            }

            return last1
        }

        fun rob(nums: IntArray): Int {
            when (nums.size) {
                1 -> return nums[0]
                2 -> return max(nums[0], nums[1])
            }
            val plan1 = nums.sliceArray(0 until nums.size-1)
            val plan2 = nums.sliceArray(1 until nums.size)

            return max(rob198(plan1), rob198(plan2))
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