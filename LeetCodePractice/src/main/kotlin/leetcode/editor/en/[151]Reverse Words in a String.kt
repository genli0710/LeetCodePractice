package leetcode.editor.en

import leetcode.editor.common.*

class reverse_words_in_a_string {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun reverseWords1(s: String): String {
            //normal way
            return s.split(" ").filter { it.trim().isNotEmpty() }.reversed().joinToString(" ")
        }

        fun reverseWords(s: String): String {
            // better way o(1) space
            val chars = s.toCharArray()
            chars.reverse()
            var i = 0
            var write = 0
            while (i < chars.size) {
                if (chars[i] != ' ') {
                    val start = write
                    while (i < chars.size && chars[i] != ' ') {
                        chars[write] = chars[i]
                        write++
                        i++
                    }

                    chars.reverse(start, write)

                    if (i < chars.size) {
                        chars[write++] = ' '
                    }
                } else {
                    i++
                }
            }
            if (chars.last() == ' ') {
                return chars.slice(0 until write - 1).joinToString("")
            } else {
                return chars.slice(0 until write).joinToString("")
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(solution.reverseWords("a    good example"))
            println(solution.reverseWords("     aaa     "))
        }
    }
}