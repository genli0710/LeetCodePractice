package leetcode.editor.en

import leetcode.editor.common.*

class length_of_last_word {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun lengthOfLastWord(s: String): Int {
            return s.trim().split(' ').last().length
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