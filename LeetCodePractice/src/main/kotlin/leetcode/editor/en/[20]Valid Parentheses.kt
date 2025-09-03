package leetcode.editor.en

import leetcode.editor.common.*
import java.util.ArrayDeque

class valid_parentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isValid(s: String): Boolean {
            val stack = ArrayDeque<Char>()
            val map = mapOf(')' to '(', ']' to '[', '}' to '{')
            s.forEach {
                if (it in map.values) {
                    stack.addLast(it)
                } else if (it in map.keys) {
                    val match = map[it]!!
                    if (stack.isEmpty() ||stack.removeLast() != match) {
                        return false
                    }
                }
            }
            return stack.isEmpty()
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