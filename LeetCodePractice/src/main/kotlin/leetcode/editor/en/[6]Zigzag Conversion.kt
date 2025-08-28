package leetcode.editor.en

class zigzag_conversion {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun convert(s: String, numRows: Int): String {
            if (numRows == 1) {
                return s
            }
            val space = Array(numRows){
                StringBuilder()
            }
            var row = 0
            var step = 1 // 0 down 1 up
            s.forEach {
                space[row].append(it)
                row += step
                if (row == numRows - 1 || row == 0) {
                    step = -step
                }
            }
            return buildString {
                space.forEach { append(it) }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(1 xor 1)
            println(0 xor 1)

        }
    }
}