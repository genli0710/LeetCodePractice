package leetcode.editor.en

import leetcode.editor.common.*
import java.util.HashSet
import kotlin.math.min

class contains_duplicate_ii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
            val set = HashSet<Int>()
            for (i in 0 until min(k + 1, nums.size)) {
                if (set.contains(nums[i])) {
                    return true
                }
                set.add(nums[i])
            }

            for (i in 1 until nums.size - k) {
                set.remove(nums[i - 1])
                if (set.contains(nums[i + k])) {
                    return true
                }
                set.add(nums[i + k])

            }
            return false
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.containsNearbyDuplicate(
                intArrayOf(1, 2, 3, 1), 3
            ).print()
            solution.containsNearbyDuplicate(
                intArrayOf(1, 2, 3, 1, 2, 3), 2
            ).print()
            solution.containsNearbyDuplicate(
                intArrayOf(1, 0, 1, 1), 1
            ).print()
            solution.containsNearbyDuplicate(
                intArrayOf(1), 1
            ).print()
            solution.containsNearbyDuplicate(
                intArrayOf(99, 99), 2
            ).print()
        }
    }
}