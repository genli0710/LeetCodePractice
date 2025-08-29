package leetcode.editor.en

import leetcode.editor.common.*

class longest_palindrome {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestPalindrome(s: String): Int {
            val arr = IntArray('z' - 'A' + 1)
            s.forEach {
                arr[it - 'A']++
            }
            var length = 0

            var hasOdd = 0
            arr.forEach {
                if (it % 2 == 0) {
                    length += it
                }
                if (it % 2 == 1) {
                    length += it - 1
                    hasOdd = 1
                }
            }
            return length + hasOdd
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.longestPalindrome("aaaa")
        }
    }
}