package leetcode.editor.en

import leetcode.editor.common.*

class letter_combinations_of_a_phone_number {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun letterCombinations(digits: String): List<String> {
            if (digits.isEmpty()) {
                return emptyList()
            }
            val map2 = mutableMapOf<Char, MutableList<String>>(
                '2' to mutableListOf("a", "b", "c"),
                '3' to mutableListOf("d", "e", "f"),
                '4' to mutableListOf("g", "h", "i"),
                '5' to mutableListOf("j", "k", "l"),
                '6' to mutableListOf("m", "n", "o"),
                '7' to mutableListOf("p", "q", "r", "s"),
                '8' to mutableListOf("t", "u", "v"),
                '9' to mutableListOf("w", "x", "y", "z")
            )

            var list = listOf("")
            for (d in digits) {
                val letters = map2[d]!!
                list = list.flatMap {
                    letters.map { letter ->
                        it + letter
                    }
                }
            }
            return list
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.letterCombinations("234")
        }
    }
}