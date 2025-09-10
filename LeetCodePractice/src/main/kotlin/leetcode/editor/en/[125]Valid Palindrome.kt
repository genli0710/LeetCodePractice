package leetcode.editor.en

import leetcode.editor.common.*

class valid_palindrome {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isPalindrome(s: String): Boolean {
            val chars = s.lowercase().toCharArray()
            var start = 0
            var end = s.length - 1
            while (start < end) {
                while (start < s.length && chars[start] !in 'a'..'z' && chars[start] !in '0'..'9') {
                    start++
                }
                while (end >= 0 && chars[end] !in 'a'..'z' && chars[end] !in '0'..'9') {
                    end--
                }
                if (start > end) {
                    return true
                }
                if (chars[start] != chars[end]) {
                    return false
                }
                start++
                end--
            }
            return true
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
//            println(solution.isPalindrome("A man, a plan, a canal: Panama"))
//            println(solution.isPalindrome("race a car"))
//            println(solution.isPalindrome(" "))
//            println(solution.isPalindrome(",a."))
//            println(solution.isPalindrome(",."))
            println(solution.isPalindrome("0P"))
        }
    }
}