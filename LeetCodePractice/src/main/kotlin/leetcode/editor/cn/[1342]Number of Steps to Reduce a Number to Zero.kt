package leetcode.editor.cn

import leetcode.editor.common.*

class number_of_steps_to_reduce_a_number_to_zero {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun numberOfStepsOld(num: Int): Int {
            if (num == 0) {
                return 0
            }
            val f = IntArray(num + 1)
            f[0] = 1
            f[1] = 1
            for (i in 2..num) {
                f[i] = if (i % 2 == 0) f[i / 2] + 1 else f[i - 1] + 1
            }
            return f[num]
        }

        fun numberOfSteps(num: Int): Int {
            val cache = IntArray(num + 1) { -1 }

            fun dfs(n: Int): Int {
                if (n == 0) {
                    return 0
                }
                if (cache[n] != -1) {
                    return cache[n]
                }
                val result = if (n % 2 == 0) dfs(n / 2) + 1 else dfs(n - 1) + 1
                cache[n] = result
                return result
            }
            return dfs(num)
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            println(solution.numberOfSteps(8))
            // put your test code here
        }
    }
}