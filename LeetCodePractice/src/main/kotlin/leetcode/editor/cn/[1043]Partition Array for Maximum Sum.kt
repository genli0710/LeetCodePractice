package leetcode.editor.cn

import leetcode.editor.common.*
import kotlin.math.max
import kotlin.math.min

class partition_array_for_maximum_sum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxSumAfterPartitioning1(arr: IntArray, k: Int): Int {
            //dp way
            // dp[i] = max(dp[i], dp[i-k] + max(arr[i-j..i-1]*k))
            val size = arr.size
            val dp = IntArray(size + 1)
            dp[0] = 0
            for (i in 1..size) {
                var maxV = 0
                for (j in 1..min(i, k)) {
                    // 求得arr尾部K个元素的最大值 maxVal
                    // 限制条件 j不能超过i,即尾部数组长度不可能大于当前计算的i长度
                    maxV = max(maxV, arr[i - j])
                    dp[i] = max(dp[i], dp[i - j] + maxV * j)
                }
            }
            return dp[size]
        }

        fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
            // recursion way
            val cache = IntArray(arr.size + 1) { -1 }

            // i 要计算的当前数组长度 i=7
            fun dfs(i: Int): Int {
                if (i == 0) {
                    return 0
                }

                if (cache[i] != -1) {
                    return cache[i]
                }

                var maxVal = 0
                var result = 0
                for (j in 1..min(i, k)) {
                    maxVal = max(maxVal, arr[i - j])
                    result = max(result, dfs(i - j) + maxVal * j)
                }
                cache[i] = result
                return result
            }

            return dfs(arr.size)
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