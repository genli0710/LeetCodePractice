package leetcode.editor.en

class basic_calculator {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun calculate(s: String): Int {
            val validS = s.replace(" ", "")
            if (validS.none { it in arrayOf('+', '-', '*', '/', '(', ')') }) {
                return validS.toInt()
            }
            fun reversedPoland(s: String): List<String> {
                val queueOut = ArrayDeque<String>()
                val queueOp = ArrayDeque<String>()
                var lastIsNumber = false
                val toList = Regex("\\d+|[+\\-*/()]").findAll(s).map { it.value }.toList()
                toList.forEach {
                    when (it) {

                        in arrayOf("+", "-", "*", "/") -> {
                            val precedence = mapOf("+" to 1, "-" to 1, "*" to 2, "/" to 2)
                            while (queueOp.isNotEmpty() &&
                                queueOp.last() != "(" &&
                                precedence[queueOp.last()]!! >= precedence[it]!!
                            ) {
                                queueOut.addLast(queueOp.removeLast())
                            }
                            if (!lastIsNumber) {
                                queueOut.add("0")
                            }
                            queueOp.addLast(it)
                            lastIsNumber = false
                        }

                        "(" -> {
                            lastIsNumber = false
                            queueOp.addLast(it)
                        }

                        ")" -> {
                            while (queueOp.isNotEmpty()) {
                                val element = queueOp.removeLast()
                                if (element != "(") {
                                    queueOut.addLast(element)
                                } else {
                                    break
                                }
                            }
                        }

                        else -> {
                            lastIsNumber = true
                            queueOut.addLast(it)
                        }
                    }
                }
                while (queueOp.isNotEmpty()) {
                    val element = queueOp.removeLast()
                    queueOut.addLast(element)
                }
                return queueOut.toList()
            }

            val RPN = reversedPoland(validS)

            return evalRPN(RPN.toTypedArray())
        }

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
//            println(solution.calculate("3+4*2/(1-5)"))
            println(solution.calculate("(7)-(0)+(4)"))
        }
    }
}