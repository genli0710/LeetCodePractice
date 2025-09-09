package leetcode.editor.en

import java.util.ArrayDeque

class subsets_ii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun subsetsWithDup(nums: IntArray): List<List<Int>> {
            nums.sort()
            val result = mutableListOf<List<Int>>()
            val stack = ArrayDeque<Int>()

            fun dfs(start: Int) {
                result.add(stack.toList())
                for (i in start until nums.size) {
                    if (i > start && nums[i] == nums[i - 1]) continue
                    stack.addLast(nums[i])
                    dfs(i + 1)
                    stack.removeLast()
                }
            }

            dfs(0)
            return result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(
                solution.subsetsWithDup(
                    intArrayOf(1, 2, 2)
                )
            )
        }
    }
}