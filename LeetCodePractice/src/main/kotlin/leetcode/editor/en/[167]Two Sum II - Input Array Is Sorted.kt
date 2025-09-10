package leetcode.editor.en

import leetcode.editor.common.*

class two_sum_ii_input_array_is_sorted {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun twoSum(numbers: IntArray, target: Int): IntArray {
            for (i in 1 until numbers.size) {
                val find = target - numbers[i]
                val index = numbers.binarySearch(find, 0, i)
                if (index >= 0) {
                    return intArrayOf(index + 1, i + 1)
                }
            }
            return intArrayOf()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(solution.twoSum(intArrayOf(2, 7, 11, 15), 9).contentToString())
            println(solution.twoSum(intArrayOf(2, 3, 4, 6), 6).contentToString())
            println(solution.twoSum(intArrayOf(-1, 0), -1).contentToString())
        }
    }
}