package leetcode.editor.en

import leetcode.editor.common.*

class contains_duplicate {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun containsDuplicate(nums: IntArray): Boolean {
            val size = nums.size
            val size2 = nums.toHashSet().size
            return size != size2
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