package leetcode.editor.en

import leetcode.editor.common.*

class evaluate_reverse_polish_notation {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun evalRPN(tokens: Array<String>): Int {
            val stack = ArrayDeque<String>()
            val operators = arrayOf("+", "-", "*", "/")
            tokens.forEach {
                if (it !in operators) {
                    stack.addLast(it)
                } else {
                    val b = stack.removeLast()
                    val a = stack.removeLast()
                    when (it) {
                        "+" -> {
                            stack.addLast((a.toInt() + b.toInt()).toString())
                        }
                        "-" -> {
                            stack.addLast((a.toInt() - b.toInt()).toString())
                        }
                        "*" -> {
                            stack.addLast((a.toInt() * b.toInt()).toString())
                        }
                        "/" -> {
                            stack.addLast((a.toInt() / b.toInt()).toString())
                        }
                    }
                }
            }
            return stack.removeLast().toInt()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.evalRPN(
                arrayOf("4","13","5","/","+")
            )
        }
    }
}