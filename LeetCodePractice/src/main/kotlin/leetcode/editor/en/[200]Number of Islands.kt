package leetcode.editor.en

class number_of_islands {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun numIslands(grid: Array<CharArray>): Int {
            val r = grid.size
            val c = grid[0].size
            val arr = grid.map { it.toMutableList() }

            fun findStart(arr: List<MutableList<Char>>): Pair<Int, Int>? {
                for (i in arr.indices) {
                    for (j in arr[0].indices) {
                        if (arr[i][j] == '1') {
                            return Pair(i, j) // 找到后立即返回
                        }
                    }
                }
                return null // 如果没找到，返回 null
            }

            fun dfs(i: Int, j: Int): Boolean {
                if (i < 0 || j < 0 || i >= r || j >= c) {
                    return false
                }

                if (arr[i][j] == '1') {
                    arr[i][j] = '#'
                    dfs(i - 1, j)
                    dfs(i, j - 1)
                    dfs(i + 1, j)
                    dfs(i, j + 1)
                    return true
                }
                return false
            }

            var count = 0
            var start = findStart(arr)
            while (start != null) {
                val dfs = dfs(start.first, start.second)
                if (dfs) count++
                start = findStart(arr)
            }

            return count
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            val grid1 = arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0')
            )
            val result1 = solution.numIslands(grid1)

            val grid2 = arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1')
            )
            val result2 = solution.numIslands(grid2)
        }
    }
}