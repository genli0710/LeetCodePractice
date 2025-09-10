package leetcode.editor.en

class rotate_array {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun rotate1(nums: IntArray, k: Int): Unit {
            // circuit
            val size = nums.size
            val realK = k % size
            if (realK == size) return

            var start = 0
            var count = 0
            while (count < size) {
                var cur = start
                var prev = nums[start]
                do {
                    val next = (cur + realK) % size
                    val temp = nums[next]
                    nums[next] = prev
                    prev = temp
                    cur = next
                    count++
                } while (start != cur)
                start++
            }
            println(nums.contentToString())
        }

        fun rotate(nums: IntArray, k: Int): Unit {
            //reverse
            val realK = k % nums.size
            nums.reverse()
            nums.reverse(0, realK)
            nums.reverse(realK, nums.size)
            println(nums.contentToString())
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.rotate(
                intArrayOf(1, 2, 3, 4, 5, 6, 7), 9
            )
            solution.rotate(
                intArrayOf(-1, -100, 3, 99), 2
            )
        }
    }
}