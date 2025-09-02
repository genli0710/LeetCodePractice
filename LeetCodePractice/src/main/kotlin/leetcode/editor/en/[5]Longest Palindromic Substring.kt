package leetcode.editor.en

import leetcode.editor.common.*

class longest_palindromic_substring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestPalindrome(s: String): String {
            if(s.length==1) return s
            val newS = s.toCharArray().joinToString("#", "#", "#")

            var result = ""
            newS.forEachIndexed { mid, _ ->
                var left = mid - 1
                var right = mid + 1
                while (left >= 0 && right < newS.length) {
                    if (newS[left] == newS[right]) {
                        val sub = newS.substring(left, right + 1)
                        if (sub.length > result.length) {
                            result = sub
                        }
                    } else {
                        break
                    }
                    left--
                    right++
                }
            }
            return result.replace("#", "")
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(solution.longestPalindrome("babad"))
            println(solution.longestPalindrome("cbbd"))
        }
    }
}