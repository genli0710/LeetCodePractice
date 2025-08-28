package leetcode.editor.en

class generate_parentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun generateParenthesis1(n: Int): List<String> {
            val set = mutableListOf<String>()
            fun dfs(sb: StringBuilder, left: Int, right: Int) {
                if (sb.length == n * 2) {
                    set.add(sb.toString())
                    return
                }

                if (left > 0) {
                    sb.append("(")
                    dfs(sb, left - 1, right)
                    sb.deleteCharAt(sb.length - 1)
                }
                if (right > left) {
                    sb.append(")")
                    dfs(sb, left, right - 1)
                    sb.deleteCharAt(sb.length - 1)
                }
            }

            dfs(StringBuilder(""), n, n)

            return set
        }

        fun generateParenthesis(n: Int): List<String> {
            val dp = Array(n + 1) {
                mutableListOf<String>()
            }
            dp[0] = mutableListOf("")
            for (i in 1..n) {
                for (j in 0 until i) {
                    for (first in dp[j]) {
                        for (second in dp[i - j - 1]) {
                            dp[i].add("($first)$second")
                        }
                    }
                }
            }

            return dp[n]
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
//            println(solution.generateParenthesis(1))
            println("-----")
            println(solution.generateParenthesis(2))
            println("-----")
//            println(solution.generateParenthesis(3))
        }
    }
}