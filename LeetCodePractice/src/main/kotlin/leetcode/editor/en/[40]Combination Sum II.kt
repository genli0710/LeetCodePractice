package leetcode.editor.en

import leetcode.editor.common.*
import java.util.ArrayDeque

class combination_sum_ii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
            candidates.sort()
            val result = mutableListOf<List<Int>>()
            val stack = ArrayDeque<Int>()
            fun dfs(sum: Int, start: Int) {
                if (sum == target) {
                    result.add(stack.toList())
                    return
                }
                for (i in start until candidates.size) {
                    if (i > start && candidates[i] == candidates[i - 1]) continue
                    if (candidates[i] + sum > target) break
                    stack.addLast(candidates[i])
                    dfs(sum + candidates[i], i + 1)
                    stack.removeLast()
                }
            }
            dfs(0, 0)

            return result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.combinationSum2(
                intArrayOf(1, 2, 3, 3, 3),
                8
            )
        }
    }
}