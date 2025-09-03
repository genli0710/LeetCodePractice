package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.min

class sqrtx {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun mySqrt(x: Int): Int {
            if (x == 1 || x == 2) return 1
            var start = 1
            var end = x / 2
            while (start <= end) {
                val mid = start + (end - start) / 2
                if (x / mid == mid) {
                    return mid
                }
                if (x / mid > mid) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }
            return start - 1
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(solution.mySqrt(2147395599))
//            println(solution.mySqrt(8))
//            println(solution.mySqrt(9))
//            println(solution.mySqrt(10))
//            println(solution.mySqrt(16))
//            println(solution.mySqrt(24))
        }
    }
}