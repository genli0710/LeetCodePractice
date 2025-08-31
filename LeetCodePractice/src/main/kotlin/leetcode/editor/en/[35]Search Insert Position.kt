package leetcode.editor.en

import leetcode.editor.common.*

class search_insert_position {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun searchInsert1(nums: IntArray, target: Int): Int {
            // 1 3 5 7 9
            var start = 0
            var end = nums.size
            var mid = 0
            while (start < end) {
                mid = (start + end) / 2
                if (target == nums[mid]) {
                    return mid
                }
                if (target > nums[mid]) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }
            if (end < 0) {
                return 0
            }
            if (end < nums.size && target > nums[end]) {
                return end + 1
            }

            return end
        }

        fun searchInsert2(nums: IntArray, target: Int): Int {
            // 1 3 5 7 9
            var start = 0
            var end = nums.size - 1
            var mid = 0
            while (start <= end) {
                mid = start + (end - start) / 2
                if (target == nums[mid]) {
                    return mid
                }
                if (target > nums[mid]) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }
            return start
        }

        fun searchInsert(nums: IntArray, target: Int): Int {
            var start = 0
            var end = nums.size - 1
            var mid = 0
            while (start <= end) {
                mid = start + (end - start) / 2
                val num = nums[mid]
                if (num == target) {
                    return mid
                }
                if (target > num) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }
            return start
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.searchInsert(intArrayOf(1, 3), 2)
        }
    }
}