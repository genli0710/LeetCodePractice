package leetcode.editor.en

import leetcode.editor.common.*

class combinations {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun combine(n: Int, k: Int): List<List<Int>> {
            val nums = IntArray(n) {
                it + 1
            }
            val deque = ArrayDeque<Int>()
            val result = mutableListOf<List<Int>>()

            fun dfs(start: Int) {
                if (deque.size == k) {
                    result.add(deque.toList())
                    return
                }

                for (i in start until n) {
                    deque.addLast(nums[i])
                    dfs(i + 1)
                    deque.removeLast()
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
            solution.combine(4, 2)
        }
    }
}