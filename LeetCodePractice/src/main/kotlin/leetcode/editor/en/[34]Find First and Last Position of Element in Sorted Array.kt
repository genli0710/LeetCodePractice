package leetcode.editor.en

import leetcode.editor.common.*

class find_first_and_last_position_of_element_in_sorted_array {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun searchRange(nums: IntArray, target: Int): IntArray {
            var start = 0
            var end = nums.size - 1
            var result = mutableListOf<Int>()

            while (start <= end) {
                val mid = (start + end) / 2
                if (nums[mid] == target) {
                    result.add(mid)
                    var temp = mid + 1
                    while (temp < nums.size) {
                        if (nums[temp] == nums[mid]) {
                            result.add(temp)
                            temp++
                        } else {
                            break
                        }
                    }
                    temp = mid - 1
                    while (temp >= 0) {
                        if (nums[temp] == nums[mid]) {
                            result.add(temp)
                            temp--
                        } else {
                            break
                        }
                    }
                    result.sort()
                    return intArrayOf(result.first(), result.last())
                } else if (nums[mid] > target) {
                    end = mid
                    while (end >= 0) {
                        if (nums[end] == nums[mid]) {
                            end--
                        } else {
                            break
                        }
                    }
                } else {
                    start = mid
                    while (start < nums.size) {
                        if (nums[start] == nums[mid]) {
                            start++
                        } else {
                            break
                        }
                    }
                }
            }
            return intArrayOf(-1, -1)
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
//            println(
//                solution.searchRange(
//                    intArrayOf(5, 7, 7, 8, 8, 10),
//                    8
//                ).contentToString()
//            )
            println(
                solution.searchRange(
                    intArrayOf(1, 4),
                    4
                ).contentToString()
            )
//            solution.searchRange(
//                intArrayOf(5,7,7,8,8,10),
//                8
//            )
        }
    }
}