package leetcode.editor.en

class spiral_matrix_ii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun generateMatrix1(n: Int): Array<IntArray> {
            val arr = Array(n) {
                IntArray(n)
            }
            val RIGHT = 1
            val DOWN = 2
            val LEFT = 3
            val UP = 4
            var direction = RIGHT

            var count = 1
            var i = 0
            var j = 0
            var left = 0
            var right = n - 1
            var top = 0
            var bottom = n - 1
            repeat(n * n) {
                if (direction == RIGHT) {
                    if (j <= right) {
                        arr[i][j] = count++
                        if (j == right) {
                            top += 1 //top decrease
                            i++
                            direction = DOWN
                        } else {
                            j++
                        }
                    }
                } else if (direction == DOWN) {
                    if (i <= bottom) {
                        arr[i][j] = count++
                        if (i == bottom) {
                            right -= 1 //right decrease
                            j--
                            direction = LEFT
                        } else {
                            i++
                        }
                    }
                } else if (direction == LEFT) {
                    if (j >= left) {
                        arr[i][j] = count++
                        if (j == left) {
                            bottom -= 1
                            i--
                            direction = UP
                        } else {
                            j--
                        }
                    }
                } else if (direction == UP) {
                    if (i >= top) {
                        arr[i][j] = count++
                        if (i == top) {
                            left += 1
                            j++
                            direction = RIGHT
                        } else {
                            i--
                        }
                    }
                }
            }
            return arr
        }

        fun generateMatrix(n: Int): Array<IntArray> {
            val matrix = Array(n) {
                IntArray(n)
            }

            var count = 1
            var left = 0
            var right = n - 1
            var top = 0
            var bottom = n - 1
            while (left <= right && top <= bottom) {
                for (i in left..right) {
                    matrix[top][i] = count++
                }
                top++

                for (i in top..bottom) {
                    matrix[i][right] = count++
                }
                right--

                for (i in right downTo left) {
                    matrix[bottom][i] = count++
                }
                bottom--

                for (i in bottom downTo top) {
                    matrix[i][left] = count++
                }
                left++
            }

            return matrix
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.generateMatrix(5)
        }
    }
}