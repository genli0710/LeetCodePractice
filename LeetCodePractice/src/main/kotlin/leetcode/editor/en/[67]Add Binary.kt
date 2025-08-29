package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.abs

class add_binary {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun addBinary(a: String, b: String): String {
            val diff = a.length - b.length
            var aa = a
            var bb = b
            //补齐 方便计算
            if (diff > 0) {
                aa = a.reversed()
                bb = ("0".repeat(abs(diff)) + b).reversed()
            } else {
                aa = ("0".repeat(abs(diff)) + a).reversed()
                bb = b.reversed()
            }
            var carry = 0
            val sb = StringBuilder()
            for (i in aa.indices) {
                val ret = (aa[i] - '0') + (bb[i] - '0') + carry
                carry = if (ret > 1) {
                    1
                } else {
                    0
                }
                sb.append(ret % 2)
            }

            if (carry > 0) {
                sb.append(carry)
            }

            return sb.reversed().toString()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.addBinary("1", "111")
        }
    }
}