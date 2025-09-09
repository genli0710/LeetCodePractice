package leetcode.editor.en

import leetcode.editor.common.*
import java.util.PriorityQueue

class search_a_2d_matrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
            val m = matrix.size
            val n = matrix[0].size

            var start = 0
            var end = m * n - 1
            while (start <= end) {
                val mid = (start + end) / 2
                val x = mid / n
                val y = mid % n
                if (matrix[x][y] == target) {
                    return true
                } else if (matrix[x][y] > target) {
                    end = mid - 1
                } else {
                    start = mid + 1
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
//            println(
//                solution.searchMatrix(
//                    arrayOf(
//                        intArrayOf(1, 3, 5, 7),
//                        intArrayOf(10, 11, 16, 20),
//                        intArrayOf(23, 30, 34, 60),
//                    ),
//                    16
//                )
//            )
            println(
                solution.searchMatrix(
                    arrayOf(
                        intArrayOf(1,1),
                    ),
                    2
                )
            )
        }
    }
}