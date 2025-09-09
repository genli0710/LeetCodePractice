package leetcode.editor.en

import kotlin.math.abs

class powx_n {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun myPow1(x: Double, n: Int): Double {
            //TLE
            if (n == 0) return 1.0
            val pN = abs(n)
            val realX = if (n > 0) x else 1 / x
            var dp = realX
            for (i in 2..pN) {
                dp *= realX
            }
            return dp
        }

        fun myPow(x: Double, n: Int): Double {
            if (n == 0) return 1.0
            var pN = abs(n.toLong())
            val realX = if (n > 0) x else 1 / x

            var base = realX
            var result = 1.0
            while (pN > 0) {
                if (pN % 2 == 1L) {
                    result *= base
                }
                base *= base
                pN /= 2
            }
            return result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(solution.myPow(5.0, 13))
        }
    }
}