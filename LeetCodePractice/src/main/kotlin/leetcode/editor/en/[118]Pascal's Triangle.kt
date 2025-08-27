package leetcode.editor.en

import leetcode.editor.common.*

class pascals_triangle {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun generate(numRows: Int): List<List<Int>> {
            val dp = Array(numRows) { HashMap<Int, Int>() }
            dp[0][0] = 1
            for (i in 0 until numRows) {
                for (j in 0..i) {
                    if (j == 0 || j == i) {
                        dp[i][j] = 1
                    } else {
                        dp[i][j] = dp[i - 1][j]!! + dp[i - 1][j - 1]!!
                    }
                }
            }

            val lists = dp.map { it.values.toList() }
            return lists
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