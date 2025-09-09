package leetcode.editor.en

import leetcode.editor.common.*
import java.util.ArrayDeque

class simplify_path {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun simplifyPath(path: String): String {
            val split = path.split('/')
            val stack = ArrayDeque<String>()
            for (i in split.indices) {
                val it = split[i]
                if (it.isEmpty()) {
                    continue
                } else if (it == ".") {
                    continue
                } else if (it == "..") {
                    if (stack.isNotEmpty()) {
                        stack.removeLast()
                    }
                } else {
                    stack.addLast(it)
                }
            }

            return stack.joinToString("/", "/")
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(solution.simplifyPath("/.../a/../b/c/../d/./"))
            println(solution.simplifyPath("/../"))
            println(solution.simplifyPath("/home//foo/"))
            println(solution.simplifyPath("/home/user/Documents/../Pictures"))
        }
    }
}