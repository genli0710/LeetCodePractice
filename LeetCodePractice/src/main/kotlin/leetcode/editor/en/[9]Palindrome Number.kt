package leetcode.editor.en

import leetcode.editor.common.*

class palindrome_number {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isPalindrome1(x: Int): Boolean {
            if(x<0) return false
            val s = x.toString()
            var start = 0
            var end = s.length-1
            while (start <= end) {
                if (s[start] == s[end]) {
                    start++
                    end--
                    continue
                } else {
                    return false
                }
            }
            return true
        }

        fun isPalindrome(x: Int): Boolean {
            if (x < 0 || (x % 10 == 0 && x != 0)) return false
            var current = x
            var new = 0
            while (current > new) {
                new = new * 10 + current % 10
                current /= 10
            }
            //121
            // new=1 current = 12
            // new=12 current=1
            return new == current || new / 10 == current
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