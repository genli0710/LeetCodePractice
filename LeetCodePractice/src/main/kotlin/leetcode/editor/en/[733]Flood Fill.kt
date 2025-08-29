package leetcode.editor.en

class flood_fill {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
            val w = image[0].size
            val h = image.size
            val startColor = image[sr][sc]
            if (startColor == color) {
                return image
            }

            fun dfs(row: Int, col: Int) {
                if (col < 0 || row < 0 || col > w - 1 || row > h - 1) {
                    return
                }
                if (image[row][col] == startColor) {
                    image[row][col] = color

                    dfs(row - 1, col)
                    dfs(row, col - 1)
                    dfs(row + 1, col)
                    dfs(row, col + 1)
                }
            }
            dfs(sr, sc)
            return image
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.floodFill(
                arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)),
                0,
                0,
                0
            )
        }
    }
}