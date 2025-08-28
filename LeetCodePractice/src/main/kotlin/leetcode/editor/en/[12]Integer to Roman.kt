package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.pow

class integer_to_roman {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun intToRoman(num: Int): String {
            val map = linkedMapOf(
                "M" to 1000,
                "CM" to 900,
                "D" to 500,
                "CD" to 400,
                "C" to 100,
                "XC" to 90,
                "L" to 50,
                "XL" to 40,
                "X" to 10,
                "IX" to 9,
                "V" to 5,
                "IV" to 4,
                "I" to 1,
            )
            val ret = StringBuilder()
            var temp = num
            for (it in map) {
                if (temp >= it.value) {
                    val n = temp / it.value
                    temp -= it.value * n
                    ret.append(it.key.repeat(n))
                }
            }
            return ret.toString()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.intToRoman(3749)
        }
    }
}