package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.max
import kotlin.math.min

class trapping_rain_water {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun trap1(height: IntArray): Int {
            //dp way
            val dpLeft = IntArray(height.size)
            val dpRight = IntArray(height.size)
            dpLeft[0] = height[0]
            for (i in 1 until height.size) {
                dpLeft[i] = max(dpLeft[i - 1], height[i])
            }
            dpRight[height.size - 1] = height.last()
            for (i in height.size - 2 downTo 0) {
                dpRight[i] = max(dpRight[i + 1], height[i])
            }
            var sum = 0
            for (i in height.indices) {
                val min = min(dpRight[i], dpLeft[i]) - height[i]
                sum += if (min > 0) min else 0
            }
            return sum
        }

        fun trap(height: IntArray): Int {
            //2 pointers way
            var left = 0
            var right = height.size - 1
            var maxLeft = 0
            var maxRight = 0
            var sum = 0
            while (left <= right) {
                if (height[left] < height[right]) {
                    if (height[left] >= maxLeft) {
                        maxLeft = height[left]
                    } else {
                        sum += maxLeft - height[left]
                    }
                    left++
                } else {
                    if (height[right] >= maxRight) {
                        maxRight = height[right]
                    } else {
                        sum += maxRight - height[right]
                    }
                    right--
                }
            }
            return sum
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