package leetcode.editor.en

import leetcode.editor.common.*

class h_index {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun hIndex(citations: IntArray): Int {
            // 0 1 3 5 6
            // 1 1 3
            citations.sort()
            var index = 0
            val size = citations.size
            for (i in 0 until size) {
                val papers = size - i
                if (citations[i] >= papers) {
                    index = size - i
                    break
                }
            }
            return index
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(
                solution.hIndex(
                    intArrayOf(3, 0, 6, 1, 6)
                )
            )
            println(
                solution.hIndex(
                    intArrayOf(1, 3, 1)
                )
            )
            println(
                solution.hIndex(
                    intArrayOf(100)
                )
            )

            println(
                solution.hIndex(
                    intArrayOf(1, 3, 1)
                )
            )
        }
    }
}