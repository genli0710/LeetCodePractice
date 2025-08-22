package leetcode.editor.cn

class number_of_longest_increasing_subsequence {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findNumberOfLIS(nums: IntArray): Int {
            // dp way
            val dp = IntArray(nums.size)
            val count = IntArray(nums.size) { 1 }
            dp[0] = 1
            count[0] = 1
            for (i in 1 until nums.size) {
                dp[i] = 1
                for (j in 0 until i) {
                    if (nums[i] > nums[j]) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1
                            count[i] = count[j]
                        } else if (dp[j] + 1 == dp[i]) {
                            count[i] += count[j]
                        }
                    }
                }
            }

            val max = dp.max()
            return dp.indices.filter { dp[it] == max }.sumOf { count[it] }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            solution.findNumberOfLIS(intArrayOf(1, 3, 5, 4, 7))
            // put your test code here
        }
    }
}