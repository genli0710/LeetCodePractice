package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.max
import kotlin.math.min

class container_with_most_water {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxArea(height: IntArray): Int {
            var start = 0
            var end = height.size - 1
            var max = -1
            while (start < end) {
                max = max(max, (end - start) * min(height[start], height[end]))
                if (height[start] < height[end]) {
                    start++
                } else {
                    end--
                }
            }
            return max
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))
        }
    }
}