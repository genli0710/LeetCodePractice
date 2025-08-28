package leetcode.editor.en

import leetcode.editor.common.*

class longest_common_prefix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestCommonPrefix(strs: Array<String>): String {
            if (strs.isEmpty()) {
                return ""
            }
            val min = strs.minOf { it.length }
            for (i in 0 until min) {
                val cur = strs[0][i]
                for (s in strs) {
                    if (s[i] != cur) {
                        return strs[0].substring(0, i)
                    }
                }
            }
            return strs[0].substring(0, min)
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.longestCommonPrefix(
                arrayOf("ab","a")
            )
        }
    }
}