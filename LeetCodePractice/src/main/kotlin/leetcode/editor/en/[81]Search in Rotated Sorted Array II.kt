package leetcode.editor.en

import leetcode.editor.common.*

class search_in_rotated_sorted_array_ii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun search(nums: IntArray, target: Int): Boolean {
            if (nums.size == 1) return nums[0] == target
            // 1 0 1 1 1
            var start = 0
            var end = nums.size - 1
            while ((start <= end)) {
                var mid = (start + end) / 2
                if (nums[mid] == target) {
                    return true
                }

                if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                    start++
                    end--
                    continue
                }
                if (nums[start] <= nums[mid]) {
                    if (nums[start] <= target && target < nums[mid]) {
                        end = mid - 1
                    } else {
                        start = mid + 1
                    }
                } else {
                    if (target > nums[mid] && nums[end] >= target) {
                        start = mid + 1
                    } else {
                        end = mid - 1
                    }
                }
            }
            return false
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
//            // put your test code here
//            println(solution.search(intArrayOf(2, 5, 6, 0, 0, 1, 2), 0))// true
//            println(solution.search(intArrayOf(2, 5, 6, 0, 0, 1, 2), 3))// false
            //true
            println(solution.search(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), 13))
//            println(solution.search(intArrayOf(1, 1, 1, 1, 1, 0, 1, 1, 1), 0))//true
//            println(solution.search(intArrayOf(1, 1, 1, 0, 1, 1, 1, 1, 1), 0))//true
//            println(solution.search(intArrayOf(1, 3, 5), 1))//true
//            println(solution.search(intArrayOf(1, 3, 5), 5))//true
//            println(solution.search(intArrayOf(3, 5, 1), 1))//true
        }
    }
}