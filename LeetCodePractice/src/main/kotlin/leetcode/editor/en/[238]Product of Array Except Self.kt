package leetcode.editor.en

class product_of_array_except_self {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun productExceptSelf(nums: IntArray): IntArray {
            val arrLeft = IntArray(nums.size)
            val arrRight = IntArray(nums.size)
            var product = 1
            arrLeft[0] = product
            for (i in 1 until nums.size) {
                product *= nums[i - 1]
                arrLeft[i] = product
            }

            product = 1
            arrRight[nums.size - 1] = product
            for (i in nums.size - 2 downTo 0) {
                product *= nums[i + 1]
                arrRight[i] = product
            }

            return arrLeft.mapIndexed { index, i ->
                arrLeft[index] * arrRight[index]
            }.toIntArray()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.productExceptSelf(intArrayOf(2,3,4,5))
        }
    }
}