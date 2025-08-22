package leetcode.editor.en

class longest_arithmetic_subsequence {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestArithSeqLength1(nums: IntArray): Int {
            //dp way
            val dp = Array(nums.size) {
                IntArray(1001) {
                    1
                }
            }

            // dp定义: d[i][d] 前i+1个元素,d为公差的最大序列长度
            // d可能为负数,所以要特殊处理下, +500的offset
            for(i in 1 until nums.size){
                for (j in 0 until i) {
                    val d = nums[i] - nums[j]
                    if (dp[j][d + OFFSET] == 1) {
                        dp[i][d + OFFSET] = 2
                    } else {
                        dp[i][d + OFFSET] = dp[j][d + OFFSET] + 1
                    }
                }
            }

            return dp.maxOf { row -> row.max() }
        }

        fun longestArithSeqLength(nums: IntArray): Int {
            //key = d value = i
            val dp = Array(nums.size) { HashMap<Int, Int>() }

            for (i in 1 until nums.size) {
                for (j in 0 until i) {
                    val d = nums[i] - nums[j]
                    // 获取i位置的信息
                    val mapI = dp[i]
                    // 获取j位置的信息
                    val mapJ = dp[j]
                    val value = mapJ.getOrDefault(d, 1)
                    if (value == 1) {
                        mapI[d] = 2
                    } else {
                        mapI[d] = mapJ.getOrDefault(d, 1) + 1
                    }
                }
            }

//            return dp.map { it -> it.values }.flatten().max()
            return dp.maxOf { it -> it.values.maxOrNull() ?: 0 }
        }

        companion object {
            const val OFFSET = 500
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            solution.longestArithSeqLength(intArrayOf(3,6,9,12))
        }
    }
}