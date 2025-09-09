package leetcode.editor.en

class rotate_image {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun rotate1(matrix: Array<IntArray>): Unit {
            val n = matrix.size
            val rotated = Array<BooleanArray>(n) {
                BooleanArray(n)
            }

            fun chainSwap(startI: Int, startJ: Int, i: Int, j: Int, value: Int) {
                val newI = j
                val newJ = n - 1 - i
                val temp = matrix[newI][newJ]
//                println("$i,$j = $value -> $newI,$newJ = $temp")
                matrix[newI][newJ] = value
                rotated[i][j] = true
                if (newI == startI && newJ == startJ && rotated[newI][newJ]) {
                    return
                } else {
                    chainSwap(startI, startJ, newI, newJ, temp)
                }
            }

            for (i in matrix.indices) {
                for (j in matrix.indices) {
                    if (!rotated[i][j]) {
                        chainSwap(i, j, i, j, matrix[i][j])
                        println(matrix.contentDeepToString())
                    }
                }
            }
        }

        fun rotate(matrix: Array<IntArray>): Unit {
            for (i in matrix.indices) {
                for (j in i + 1 until matrix.size) {
                    println("swap(${matrix[i][j]}) (${matrix[j][i]})")
                    val temp = matrix[i][j]
                    matrix[i][j] = matrix[j][i]
                    matrix[j][i] = temp
                }
            }

            for (i in matrix.indices) {
                for (j in 0 until matrix.size / 2) {
                    val temp = matrix[i][j]
                    matrix[i][j] = matrix[i][matrix.size - 1 - j]
                    matrix[i][matrix.size - 1 - j] = temp
                }
            }
            println(matrix.contentDeepToString())
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.rotate(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(5, 6, 7),
                    intArrayOf(9, 10, 11),
                )
            )
        }
    }
}