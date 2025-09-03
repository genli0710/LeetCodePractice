package leetcode.editor.en

import leetcode.editor.common.*

class remove_duplicates_from_sorted_array {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun removeDuplicates(nums: IntArray): Int {
            if (nums.size == 1) {
                return 1
            }
            var start = 0
            var end = start + 1
            var count = nums.size
            var size = nums.size
            while (end < size) {
                if (nums[start] == nums[end]) {
                    for (i in end until nums.size - 1) {
                        nums[i] = nums[i + 1]
                    }
                    size--
                    count--
                } else {
                    start = end
                    end++
                }
            }

            return count
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(solution.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
        }
    }
}