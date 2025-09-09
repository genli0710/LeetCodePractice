package leetcode.editor.en

import leetcode.editor.common.*

class permutations_ii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun permuteUnique(nums: IntArray): List<List<Int>> {
            nums.sort()
            val result = mutableListOf<List<Int>>()
            val current = ArrayDeque<Int>()
            val visited = BooleanArray(nums.size)
            fun dfs() {
                if (current.size == nums.size) {
                    result.add(current.toList())
                    return
                }

                for (i in nums.indices) {
                    if (i > 0 && nums[i] == nums[i - 1] && !visited[i-1]) {
                        continue
                    }
                    if (visited[i]) {
                        continue
                    }
                    visited[i] = true
                    current.addLast(nums[i])
                    dfs()
                    visited[i] = false
                    current.removeLast()
                }
            }

            dfs()
            return result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.permuteUnique(intArrayOf(1, 1, 2))
        }
    }
}