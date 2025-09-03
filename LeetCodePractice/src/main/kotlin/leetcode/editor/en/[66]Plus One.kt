package leetcode.editor.en

import leetcode.editor.common.*

class plus_one {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun plusOne(digits: IntArray): IntArray {
            var carry = 0
            digits[digits.size - 1] += 1
            for (i in digits.size - 1 downTo 0) {
                val sum = digits[i] + carry
                carry = sum / 10
                digits[i] = sum % 10
            }
            if (carry == 1) {
                val newAr = IntArray(digits.size + 1)
                newAr[0] = 1
                for (i in 1 until digits.size) {
                    newAr[i] = digits[i - 1]
                }
                return newAr
            } else {
                return digits
            }


        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
        }
    }
}