package leetcode.editor.en

class sort_colors {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun sortColors1(nums: IntArray): Unit {
            val counts = IntArray(3)
            nums.forEach { counts[it]++ }

            var index = 0
            for (color in 0..2) {
                repeat(counts[color]) {
                    nums[index++] = color
                }
            }
        }

        fun sortColors(nums: IntArray): Unit {
            var p0 = 0
            var cur = 0
            var p2 = nums.size - 1
            while (cur <= p2) {
                val currentValue = nums[cur]
                if (currentValue == 0) {
                    //交换cur和p0对应的值,p1++, cur++
                    val temp = nums[cur]
                    nums[cur] = nums[p0]
                    nums[p0] = temp
                    p0++
                    cur++
                } else if (currentValue == 1) {
                    cur++
                } else if (currentValue == 2) {
                    //交换cur和p2对应的值,p2--
                    val temp = nums[cur]
                    nums[cur] = nums[p2]
                    nums[p2] = temp
                    p2--
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.sortColors(intArrayOf(2, 0, 2, 1, 1, 0))
        }
    }
}