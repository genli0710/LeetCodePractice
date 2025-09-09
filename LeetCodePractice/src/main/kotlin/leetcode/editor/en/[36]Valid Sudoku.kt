package leetcode.editor.en

import leetcode.editor.common.*

class valid_sudoku {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isValidSudoku(board: Array<CharArray>): Boolean {
            val colSet = List<HashSet<Char>>(9) { HashSet() }
            val rowSet = List<HashSet<Char>>(9) { HashSet() }
            val blockSet = List<HashSet<Char>>(9) { HashSet() }

            for (i in board.indices) {
                for (j in board[0].indices) {
                    if (board[i][j] == '.') continue
                    if (colSet[i].contains(board[i][j])) {
                        return false
                    }
                    colSet[i].add(board[i][j])
                    if (rowSet[j].contains(board[i][j])) {
                        return false
                    }
                    rowSet[j].add(board[i][j])
                    val block = (j / 3) + (i / 3) * 3
                    if (blockSet[block].contains(board[i][j])) {
                        return false
                    }
                    blockSet[block].add(board[i][j])
                }
            }
            return true
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
        }
    }
}