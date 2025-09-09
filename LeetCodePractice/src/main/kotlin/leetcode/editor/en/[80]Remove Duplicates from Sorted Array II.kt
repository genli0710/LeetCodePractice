package leetcode.editor.en

import leetcode.editor.common.*

class remove_duplicates_from_sorted_array_ii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun removeDuplicates(nums: IntArray): Int {
            if (nums.size <= 2) {
                return nums.size
            }
            var slot = 2
            var count = if (nums[0] == nums[1]) 2 else 1
            var lastNum = nums[1]

            for (i in 2 until nums.size) {
                if (nums[i] == lastNum) {
                    if (count < 2) {
                        nums[slot] = nums[i]
                        slot++
                        count++
                    }
                } else {
                    count = 1
                    lastNum = nums[i]
                    nums[slot] = nums[i]
                    slot++
                }
            }
            return slot
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.removeDuplicates(
                intArrayOf(1, 1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 5)
            )
        }
    }
}