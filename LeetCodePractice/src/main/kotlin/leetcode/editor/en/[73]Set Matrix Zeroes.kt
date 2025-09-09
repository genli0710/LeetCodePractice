package leetcode.editor.en

import leetcode.editor.common.*

class set_matrix_zeroes {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun setZeroes1(matrix: Array<IntArray>): Unit {
            val m = matrix.size
            val n = matrix[0].size
            val setRow = HashSet<Int>()
            val setColumn = HashSet<Int>()
            for (i in matrix.indices) {
                for (j in matrix[0].indices) {
                    if (matrix[i][j] == 0) {
                        setRow.add(i)
                        setColumn.add(j)
                    }
                }
            }
            setRow.forEach {
                for (i in 0 until n) {
                    matrix[it][i] = 0
                }
            }
            setColumn.forEach {
                for (i in 0 until m) {
                    matrix[i][it] = 0
                }
            }
            println(matrix.contentDeepToString())
        }

        fun setZeroes(matrix: Array<IntArray>): Unit {
            val m = matrix.size
            val n = matrix[0].size
            var isFirstRowZero = false
            var isFirstColumZero = false
            for (i in 0 until n) {
                if (matrix[0][i] == 0) {
                    isFirstRowZero = true
                }
            }
            for (i in 0 until m) {
                if (matrix[i][0] == 0) {
                    isFirstColumZero = true
                }
            }

            for (i in 1 until m) {
                for (j in 1 until n) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0
                        matrix[0][j] = 0
                    }
                }
            }

            for (i in 1 until m) {
                for (j in 1 until n)
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0
                    }
            }

            if (isFirstRowZero) {
                for (i in 0 until n) {
                    matrix[0][i] = 0
                }
            }
            if (isFirstColumZero) {
                for (i in 0 until m) {
                    matrix[i][0] = 0
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
            solution.setZeroes(
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 0, 1),
                    intArrayOf(1, 1, 1),
                )
            )
            solution.setZeroes(
                arrayOf(
                    intArrayOf(0, 1, 2, 0),
                    intArrayOf(3, 4, 5, 2),
                    intArrayOf(1, 3, 1, 5),
                )
            )
        }
    }
}