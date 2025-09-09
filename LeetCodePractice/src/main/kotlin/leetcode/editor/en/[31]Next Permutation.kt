package leetcode.editor.en

import leetcode.editor.common.*

class next_permutation {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun nextPermutation1(nums: IntArray): Unit {
            if (nums.size == 1) return
            var start = nums.size - 2
            var end = nums.size - 1
            while (start >= 0) {
                if (nums[start] < nums[end]) {
                    val temp = nums[start]
                    nums[start] = nums[end]
                    nums[end] = temp
                    break
                } else {
                    start--
                }
            }
            if (start < 0) {
                nums.sort()
            }
            println("result is =${nums.contentToString()}")
        }

        fun nextPermutation(nums: IntArray): Unit {
            if (nums.size == 1) return
            var i = nums.size - 2
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--
            }
            var minIndex = i + 1
            var minValue = Int.MAX_VALUE
            if (i >= 0) {
                for (j in nums.size - 1 downTo i + 1) {
                    if (nums[j] > nums[i] && nums[j] < minValue) {
                        minValue = nums[j]
                        minIndex = j
                    }
                }
                val temp = nums[minIndex]
                nums[minIndex] = nums[i]
                nums[i] = temp
            }
            //swap
            var start = i + 1
            var end = nums.size - 1
            while (start < end) {
                val tmp = nums[start]
                nums[start] = nums[end]
                nums[end] = tmp
                start++
                end--
            }
            println(nums.contentToString())
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.nextPermutation(
                intArrayOf(1, 2, 3)
            )
            solution.nextPermutation(
                intArrayOf(3, 2, 1)
            )
            solution.nextPermutation(
                intArrayOf(1, 1, 5)
            )
            solution.nextPermutation(
                intArrayOf(1, 2, 7, 4, 3, 1)
            )
            solution.nextPermutation(
                intArrayOf(2, 3, 1, 3, 3)
            )
        }
    }
}