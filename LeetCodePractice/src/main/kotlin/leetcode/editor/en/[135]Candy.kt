package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.max

class candy {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun candy(ratings: IntArray): Int {
            if (ratings.size == 1) return 1
            val size = ratings.size
            val result = IntArray(size) { 1 }
            for (i in 0 until size - 1) {
                if (ratings[i + 1] > ratings[i]) {
                    result[i + 1] = result[i] + 1
                }
            }
            for (i in size - 1 downTo 1) {
                if (ratings[i - 1] > ratings[i]) {
                    result[i - 1] = max(result[i - 1], result[i] + 1)
                }
            }
            return result.sum()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.candy(
                intArrayOf(1, 0, 2)
            ).print(5)
        }
    }
}