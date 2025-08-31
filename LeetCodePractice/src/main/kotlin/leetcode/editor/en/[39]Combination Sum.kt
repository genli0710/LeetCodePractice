package leetcode.editor.en

class combination_sum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            val result = mutableListOf<List<Int>>()
            val stack = ArrayDeque<Int>()

            candidates.sort()
            fun backTracking(i: Int, sum: Int) {
                if (sum == target) {
                    result.add(stack.toList())
                    return
                }
                if (sum > target) {
                    return
                }
                for (idx in i until candidates.size) {
                    val candidate = candidates[idx]
                    if (sum + candidate > target) {
                        break
                    }
                    stack.addLast(candidate)
                    backTracking(idx, sum + candidate)
                    stack.removeLast()
                }

            }
            backTracking(0,0)
            return result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.combinationSum(
                intArrayOf(2, 3, 6, 7),
                7
            )
        }
    }
}