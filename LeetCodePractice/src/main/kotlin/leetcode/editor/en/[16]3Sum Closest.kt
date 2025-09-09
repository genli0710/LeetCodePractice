package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.abs
import kotlin.math.min

class sum_closest {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun threeSumClosest1(nums: IntArray, target: Int): Int {
            //brutal force
            nums.sort()
            var min = Int.MAX_VALUE
            var nearest = Int.MAX_VALUE
            for (start in nums.indices) {
                for (i in start + 1 until nums.size) {
                    for (j in i + 1 until nums.size) {
                        val current = nums[start] + nums[i] + nums[j]
                        if (abs(current - target) < min) {
                            min = abs(current - target)
                            nearest = current
                        }
                    }
                }
            }
            return nearest
        }

        fun threeSumClosest(nums: IntArray, target: Int): Int {
            nums.sort()
            var minDistance = Int.MAX_VALUE
            var minSum = Int.MAX_VALUE
            for (i in nums.indices) {
                var left = i + 1
                var right = nums.size - 1
                while (left < right) {
                    val sum = nums[i] + nums[left] + nums[right]
                    val d = abs(sum - target)
                    if (d < minSum) {
                        minSum = d
                        minDistance = sum
                    }
                    if (sum == target) {
                        return sum
                    } else if (sum > target) {
                        right--
                    } else {
                        left++
                    }
                }
            }
            return minDistance
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(solution.threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
            println(solution.threeSumClosest(intArrayOf(0, 0, 0), 1))
        }
    }
}