package leetcode.editor.en

import leetcode.editor.common.*

class permutations {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun permute(nums: IntArray): List<List<Int>> {
            nums.sort()
            val result = mutableListOf<List<Int>>()
            val deque = ArrayDeque<Int>()
            val used = BooleanArray(nums.size)
            fun backtrack() {
                if (deque.size == nums.size) {
                    result.add(deque.toList())
                    return
                }
                for (idx in nums.indices) {
                    if (used[idx]) {
                        continue
                    }
                    deque.addLast(nums[idx])
                    used[idx] = true
                    backtrack()
                    deque.removeLast()
                    used[idx] = false
                }
            }
            backtrack()

            return result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.permute(intArrayOf(1, 2, 3))
        }
    }
}