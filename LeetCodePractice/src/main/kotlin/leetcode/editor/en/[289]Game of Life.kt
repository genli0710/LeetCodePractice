package leetcode.editor.en

class game_of_life {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun gameOfLife(board: Array<IntArray>): Unit {
            val m = board.size
            val n = board[0].size
            val offset = Int.MAX_VALUE / 2
            val zero2one = offset + 1
            val one2zero = offset + 2

            fun check(i: Int, j: Int): Pair<Int, Int> {
                if (i >= 0 && j >= 0 && i < m && j < n) {
                    var lifeCount = 0
                    var deadCount = 0
                    if (board[i][j] == 1 || board[i][j] == one2zero) {
                        lifeCount++
                    } else {
                        deadCount++
                    }
                    return lifeCount to deadCount
                }
                return 0 to 0
            }

            fun checkAround(i: Int, j: Int): Pair<Int, Int> {
                var lifeCount = 0
                var deadCount = 0
                val arr = Array(8) {
                    0 to 0
                }
                arr[0] = check(i + 1, j + 1)
                arr[1] = check(i - 1, j - 1)
                arr[2] = check(i - 1, j)
                arr[3] = check(i - 1, j + 1)
                arr[4] = check(i, j - 1)
                arr[5] = check(i, j + 1)
                arr[6] = check(i + 1, j - 1)
                arr[7] = check(i + 1, j)
                for (p in arr) {
                    lifeCount += p.first
                    deadCount += p.second
                }
                return lifeCount to deadCount
            }
            for (i in 0 until m) {
                for (j in 0 until n) {
                    val (life, die) = checkAround(i, j)
                    if (board[i][j] == 1) {
                        if (life < 2 || life > 3) {
                            board[i][j] = one2zero
                        }
                    } else {
                        if (life == 3) {
                            board[i][j] = zero2one
                        }
                    }
                }
            }
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (board[i][j] == zero2one) {
                        board[i][j] = 1
                    }
                    if (board[i][j] == one2zero) {
                        board[i][j] = 0
                    }
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.gameOfLife(
                arrayOf(
                    intArrayOf(
                        0, 1, 0
                    ),
                    intArrayOf(
                        0, 0, 1
                    ),
                    intArrayOf(
                        1, 1, 1
                    ),
                    intArrayOf(
                        0, 0, 0
                    )
                )
            )
            solution.gameOfLife(
                arrayOf(
                    intArrayOf(
                        1, 1
                    ),
                    intArrayOf(
                        1, 0
                    )
                )
            )
        }
    }
}