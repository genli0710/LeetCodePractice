package leetcode.editor.en

import leetcode.editor.common.*

class restore_ip_addresses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //start 2025-09-07 13:15:05
        //end 2025-09-07 13:59:31
        fun restoreIpAddresses(s: String): List<String> {
            if (s.length < 4) return emptyList()

            val result = mutableListOf<String>()
            val stack = ArrayDeque<String>()

            fun dfs(start: Int) {
                if (stack.size == 4) {
                    if (start == s.length) result.add(stack.joinToString("."))
                    return
                }
                for (j in 3 downTo 1) {
                    if (start + j > s.length) continue

                    val sub = s.substring(start until start + j)
                    if (sub.length > 1 && sub.startsWith('0')) continue

                    if (sub.toInt() > 255) continue

                    stack.addLast(sub)
                    dfs(start + j)
                    stack.removeLast()
                }
            }
            dfs(0)

            return result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(solution.restoreIpAddresses("25525511135"))
            println(solution.restoreIpAddresses("101023"))
        }
    }
}