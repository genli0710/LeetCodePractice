package leetcode.editor.en

import leetcode.editor.common.*

class string_to_integer_atoi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun myAtoi(s: String): Int {
            if (s.isEmpty()) return 0

            fun validate(s: String): Pair<String, String> {
                val result = StringBuilder()
                var trimS = s.trim()
                var symbol = "+"
                if (trimS.isEmpty()) {
                    return "+" to ""
                }
                if (trimS[0] == '+' || trimS[0] == '-') {
                    symbol = trimS[0].toString()
                    trimS = trimS.substring(1)
                }
                trimS = trimS.trimStart('0')

                for (i in trimS.indices) {
                    val it = trimS[i]
                    if (it == '0') {
                        if (i != 0) result.append(it)
                    } else if (it in '1'..'9') {
                        result.append(it)
                    } else {
                        break
                    }
                }
                return if (result.isNotEmpty()) {
                    symbol to result.toString()
                } else {
                    "+" to "0"
                }
            }

            val validS = validate(s)
            println(validS)
            val symbol = validS.first
            val numStr = validS.second
            if (numStr.isEmpty()) {
                return 0
            }

            // MAX =2147483647 MIN= -2147483648
            var result = numStr[0] - '0'
            for (i in 1 until numStr.length) {
                val intValue = numStr[i] - '0'
                if (result > Int.MAX_VALUE / 10) {
                    return if (symbol == "+") Int.MAX_VALUE else Int.MIN_VALUE
                }
                if (result == Int.MAX_VALUE / 10 && symbol == "-" && intValue >= 8) {
                    return Int.MIN_VALUE
                }
                if (result == Int.MAX_VALUE / 10 && symbol == "+" && intValue >= 7) {
                    return Int.MAX_VALUE
                }
                result = result * 10 + intValue
            }

            return if (symbol == "+") result else -result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            println(solution.myAtoi("-21474836482"))
//            println(solution.myAtoi("42"))
//            println(solution.myAtoi("1337c0d3"))
//            println(solution.myAtoi("0-1"))
//            println(solution.myAtoi("words and 987"))
        }
    }
}