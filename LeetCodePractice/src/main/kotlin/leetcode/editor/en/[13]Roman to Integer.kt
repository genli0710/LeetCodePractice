package leetcode.editor.en

import leetcode.editor.common.*

class roman_to_integer {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun romanToInt(s: String): Int {
            val map = linkedMapOf(
                "CM" to 900,
                "CD" to 400,
                "XC" to 90,
                "XL" to 40,
                "IX" to 9,
                "IV" to 4,
                "M" to 1000,
                "D" to 500,
                "C" to 100,
                "L" to 50,
                "X" to 10,
                "V" to 5,
                "I" to 1,
            )
            var i = 0
            var result = 0
            while (i + 1 < s.length) {
                val two = map[s.substring(i, i + 2)]
                val one = map[s[i].toString()]
                if (two != null) {
                    result += two
                    i += 2
                } else {
                    result += one!!
                    i++
                }
            }
            if (i < s.length) {
                result += map[s[i].toString()]!!
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
            solution.romanToInt("III")
        }
    }
}