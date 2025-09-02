package leetcode.editor.en

class spiral_matrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun spiralOrder(matrix: Array<IntArray>): List<Int> {
            var count = matrix[0].size * matrix.size
            var left = 0
            var top = 0
            var right = matrix[0].size - 1
            var bottom = matrix.size - 1
            var curX = 0
            var curY = 0
            val GO_RIGHT = 1
            val GO_DOWN = 2
            val GO_LEFT = 3
            val GO_TOP = 4
            var direction = GO_RIGHT // 1 右 2 下 3

            val result = mutableListOf<Int>()
            while (result.size < count) {
                if (direction == GO_RIGHT) {
                    if (curX < right) {
                        result.add(matrix[curY][curX])
                        curX++
                    } else {
                        result.add(matrix[curY][curX])
                        curY++
                        direction = GO_DOWN
                        top++
                    }
                } else if (direction == GO_DOWN) {
                    if (curY < bottom) {
                        result.add(matrix[curY][curX])
                        curY++
                    } else {
                        result.add(matrix[curY][curX])
                        curX--
                        direction = GO_LEFT
                        right--
                    }
                } else if (direction == GO_LEFT) {
                    if (curX > left) {
                        result.add(matrix[curY][curX])
                        curX--
                    } else {
                        result.add(matrix[curY][curX])
                        curY--
                        direction = GO_TOP
                        bottom--
                    }
                } else if (direction == GO_TOP) {
                    if (curY > top) {
                        result.add(matrix[curY][curX])
                        curY--
                    } else {
                        result.add(matrix[curY][curX])
                        curX++
                        direction = GO_RIGHT
                        left++
                    }
                }
            }
            return result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.spiralOrder(
                arrayOf(
                    intArrayOf(
                        1, 2, 3, 4
                    ),
                    intArrayOf(
                        5, 6, 7, 8
                    ),
                    intArrayOf(
                        9, 10, 11, 12
                    )
                )
            )
        }
    }
}