package leetcode.editor.en

import leetcode.editor.common.*
import java.util.HashSet
import kotlin.math.pow

class happy_number {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isHappy(n: Int): Boolean {
            var cur = n
            var sum = 0
            val set = HashSet<Int>()
            set.add(n)
            while (cur > 0) {
                val a = cur % 10
                cur /= 10
                sum += a * a
                if (cur == 0) {
//                    println("sum is $sum")
                    if (sum == 1) {
                        return true
                    }
                    if (set.contains(sum)) {
                        return false
                    }
                    set.add(sum)
                    cur = sum
                    sum = 0
                }
            }
            return false
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
//            solution.isHappy(19)
            for (i in 0..999) {
                val happy = solution.isHappy(i)
                if (happy) {
                    println("hasppy $i")
                }
            }
        }
    }
}