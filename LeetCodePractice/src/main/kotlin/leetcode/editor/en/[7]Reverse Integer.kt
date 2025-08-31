package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.abs
import kotlin.math.pow

class reverse_integer {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun reverse1(x: Int): Int {
            val MAX = arrayOf(2, 1, 4, 7, 4, 8, 3, 6, 4, 8)
            var arr = mutableListOf<Int>()
            var isNeg = x < 0
            var cur = x
            while (cur != 0) {
                val a = cur % 10
                cur /= 10
                arr.add(abs(a))
            }

            if (arr.size > 10) {
                return 0
            } else if (arr.size == 10) {
                for (i in arr.indices) {
                    if (arr[i] > MAX[i]) {
                        return 0
                    } else if (arr[i] == MAX[i]) {
                        continue
                    } else {
                        break
                    }
                }
            }

            val mapIndexed = arr.mapIndexed { index, v ->
                v * 10.0.pow(arr.size - index - 1)
            }
            val result = mapIndexed.sumOf { it }.toInt()

            return if (isNeg) -result else result
        }

        fun reverse(x: Int): Int {
            var cur = x
            var result = 0
            while (cur != 0) {
                val remain = cur % 10
                cur /= 10
                if (result > Int.MAX_VALUE / 10 || result < Int.MIN_VALUE / 10) {
                    return 0
                }

                if (result == Int.MAX_VALUE/10 && remain > 7) {
                    return 0
                }
                if (result == Int.MIN_VALUE / 10 && remain < -8) {
                    return 0
                }

                result = result * 10 + remain
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
//            solution.reverse(-2147483648)
            println(solution.reverse(12345))
        }
    }
}