package leetcode.editor.en

import leetcode.editor.common.*

class rotting_oranges {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun orangesRotting(grid: Array<IntArray>): Int {
            val m = grid.size
            val n = grid[0].size
            val queue = ArrayDeque<Pair<Int, Int>>()
            val arr = grid.map { it.toMutableList() }

            var good = 0
            for (i in arr.indices) {
                for (j in arr[0].indices) {
                    if (arr[i][j] == 2) {
                        queue.addLast(i to j)
                    }
                    if (arr[i][j] == 1) {
                        good++
                    }
                }
            }

            var minutes = 0
            while (queue.isNotEmpty() && good > 0) {
                val length = queue.size

                repeat(length) {
                    val (i, j) = queue.removeFirst()
                    if (i > 0 && arr[i - 1][j] == 1) {
                        arr[i - 1][j] = 2
                        good--
                        queue.addLast(i - 1 to j)
                    }
                    if (j > 0 && arr[i][j - 1] == 1) {
                        arr[i][j - 1] = 2
                        good--
                        queue.addLast(i to j - 1)
                    }
                    if (i < m - 1 && arr[i + 1][j] == 1) {
                        arr[i + 1][j] = 2
                        good--
                        queue.addLast(i + 1 to j)
                    }
                    if (j < n - 1 && arr[i][j + 1] == 1) {
                        arr[i][j + 1] = 2
                        good--
                        queue.addLast(i to j + 1)
                    }
                }
                minutes++
            }

            return if (good==0) minutes else -1
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            // Example 1
            val grid1 = arrayOf(
                intArrayOf(2, 1, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 1, 1)
            )
            val result1 = solution.orangesRotting(grid1)
            println("Example 1: Input = [[2,1,1],[1,1,0],[0,1,1]] -> Output = $result1")

            val grid2 = arrayOf(
                intArrayOf(2, 1, 1)
            )
            val result2 = solution.orangesRotting(grid2)
            println("Example 1: Input = [[2,1,1]] -> Output = $result2")
        }
    }
}