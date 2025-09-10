package leetcode.editor.en

import leetcode.editor.common.*

class summary_ranges {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun summaryRanges(nums: IntArray): List<String> {
            if (nums.isEmpty()) return emptyList()
            if (nums.size == 1) return listOf(nums[0].toString())

            val paths = mutableListOf<String>()
            var left = 0
            for (i in 1 until nums.size) {
                if (nums[i] - nums[i - 1] != 1) {
                    if (left == i - 1) {
                        paths.add(nums[left].toString())
                    } else {
                        paths.add("${nums[left]}->${nums[i - 1]}")
                    }
                    left = i
                }
            }

            if (left == nums.size - 1) {
                paths.add(nums[left].toString())
            } else {
                paths.add("${nums[left]}->${nums.last()}")
            }
            return paths
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.summaryRanges(
                intArrayOf(0, 1, 2, 4, 5, 7)
            ).print("[\"0->2\",\"4->5\",\"7\"]")
            solution.summaryRanges(
                intArrayOf(0, 2, 3, 4, 6, 8, 9)
            ).print("[\"0\",\"2->4\",\"6\",\"8->9\"]")
        }
    }
}