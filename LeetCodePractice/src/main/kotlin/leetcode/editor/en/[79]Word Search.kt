package leetcode.editor.en

import leetcode.editor.common.*

class word_search {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun exist1(board: Array<CharArray>, word: String): Boolean {
            val start = word.first()
            val starts = mutableListOf<Pair<Int, Int>>()
            val m = board.size
            val n = board[0].size
            if (word.length > m * n) return false

            for (i in board.indices) {
                for (j in board[0].indices) {
                    if (board[i][j] == start) {
                        starts.add(i to j)
                    }
                }
            }

            val visited = Array(board.size) {
                BooleanArray(board[0].size)
            }

            fun dfs(i: Int, j: Int, charIndex: Int): Boolean {
                if (i !in 0 until m || j !in 0 until n) {
                    return false
                }

                if (!visited[i][j] && board[i][j] == word[charIndex]) {
                    if (charIndex == word.length - 1) {
                        return true
                    }
                    visited[i][j] = true
                    val a= dfs(i - 1, j, charIndex + 1)
                    val b= dfs(i, j - 1, charIndex + 1)
                    val c= dfs(i + 1, j, charIndex + 1)
                    val d= dfs(i, j + 1, charIndex + 1)
                    visited[i][j] = false
                    return a || b || c || d
                }
                return false
            }

            for (k in starts) {
                if (dfs(k.first, k.second, 0)) {
                    return true
                }
            }
            return false
        }

        fun exist(board: Array<CharArray>, word: String): Boolean {
            // 剪枝策略,减少starts的数目
            val m = board.size
            val n = board[0].size
            if (word.length > m * n) return false
            val countFirst = board.flatMap { it.asIterable() }.count { it == word.first() }
            val countLast = board.flatMap { it.asIterable() }.count { it == word.last() }
            val newWord = if (countLast < countFirst) word.reversed() else word
            val start = if (countLast < countFirst) word.last() else word.first()
            val starts = mutableListOf<Pair<Int, Int>>()

            for (i in board.indices) {
                for (j in board[0].indices) {
                    if (board[i][j] == start) {
                        starts.add(i to j)
                    }
                }
            }

            val visited = Array(board.size) {
                BooleanArray(board[0].size)
            }

            fun dfs(i: Int, j: Int, charIndex: Int): Boolean {
                if (i !in 0 until m || j !in 0 until n) {
                    return false
                }

                if (!visited[i][j] && board[i][j] == newWord[charIndex]) {
                    if (charIndex == newWord.length - 1) {
                        return true
                    }
                    visited[i][j] = true
                    val a= dfs(i - 1, j, charIndex + 1)
                    val b= dfs(i, j - 1, charIndex + 1)
                    val c= dfs(i + 1, j, charIndex + 1)
                    val d= dfs(i, j + 1, charIndex + 1)
                    visited[i][j] = false
                    return a || b || c || d
                }
                return false
            }

            for (k in starts) {
                if (dfs(k.first, k.second, 0)) {
                    return true
                }
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
            println(
                solution.exist(
                    arrayOf(
                        charArrayOf(
                            'A', 'B', 'C', 'E'
                        ), charArrayOf(
                            'S', 'F', 'C', 'S'
                        ), charArrayOf(
                            'A', 'D', 'E', 'E'
                        )
                    ),
                    "ABCB"
                )
            )
        }
    }
}