package leetcode.editor.en

class search_in_rotated_sorted_array {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun search1(nums: IntArray, target: Int): Int {
            // exceed time limit
            if (nums.size == 1) return if (nums[0] == target) 0 else -1
            var isRotated = false
            var rotateIndex = -1
            for (i in 1 until nums.size) {
                if (nums[i] < nums[i - 1]) {
                    isRotated = true
                    rotateIndex = i
                    break
                }
            }
            if (!isRotated) {
                val index = nums.binarySearch(target)
                return if (index >= 0) index else -1
            }
            if (nums[0] <= target && target <= nums[rotateIndex - 1]) {
                val index = nums.binarySearch(target, 0, rotateIndex)
                return if (index >= 0) index else -1
            } else {
                val index = nums.binarySearch(target, rotateIndex, nums.size)
                return if (index >= 0) index else -1
            }
        }

        fun search(nums: IntArray, target: Int): Int {
            // time O(logN)
            var start = 0
            var end = nums.size - 1
            while (start <= end) {
                val mid = (start + end) / 2
                if (nums[mid] == target) {
                    return mid
                }
                val isLeftValid = nums[mid] >= nums[start]
                if (isLeftValid) {
                    if (target <= nums[mid] && target >= nums[start]) {
                        val index = nums.binarySearch(target, start, mid + 1)
                        return if (index >= 0) index else -1
                    } else {
                        start = mid + 1
                    }
                } else {
                    if (target <= nums[nums.size - 1] && target >= nums[mid]) {
                        val index = nums.binarySearch(target, mid, nums.size)
                        return if (index >= 0) index else -1
                    } else {
                        end = mid - 1
                    }
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
//            solution.search(
//                intArrayOf(4, 5, 6, 7, 0, 1, 2),
//                3
//            )
            solution.search(
                intArrayOf(3, 1),
                3
            )
        }
    }
}