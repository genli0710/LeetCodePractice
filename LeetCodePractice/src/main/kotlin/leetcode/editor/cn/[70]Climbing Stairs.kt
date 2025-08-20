package leetcode.editor.cn

import leetcode.editor.common.*

class climbing_stairs {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun climbStairsOld(n: Int): Int {
            if (n == 1) {
                return 1
            }
            // recursion solution
            val f = IntArray(n) { -1 }
            f[0] = 1
            f[1] = 1

            fun dfs(num: Int):Int {
                if (num == 0 || num == 1) {
                    return 1
                }

                if (f[num] != -1) {
                    return f[num]
                }

                val cache = dfs(num - 1) + dfs(num - 2)
                f[num] = cache
                return cache
            }
            return dfs(n - 1) + dfs(n - 2)
        }

        fun climbStairs(n: Int): Int {
            // dynamic programing
            if (n == 1) {
                return 1
            }

            val dp = IntArray(n)
            dp[0] = 1
            dp[1] = 2
            for (i in 2 until n) {
                dp[i] = dp[i - 1] + dp[i - 2]
            }

            return dp[n - 1]
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.climbStairs(45)
        }
    }
}