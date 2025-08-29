package leetcode.editor.en

import leetcode.editor.common.*

class binary_search {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun search1(nums: IntArray, target: Int): Int {
            // cheating
            return nums.binarySearch(target)
        }

        fun search(nums: IntArray, target: Int): Int {
            var start = 0
            var end = nums.size - 1
            while (start <= end) {
                var mid = (start + end) / 2
                if (nums[mid] == target) {
                    return mid
                }
                if (target > nums[mid]) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }
            return -1
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