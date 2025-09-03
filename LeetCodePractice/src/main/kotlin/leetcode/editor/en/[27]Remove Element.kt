package leetcode.editor.en

class remove_element {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun removeElement1(nums: IntArray, `val`: Int): Int {
            var size = nums.size
            var i = 0
            while (i < size) {
                if (nums[i] == `val`) {
                    for (j in i until size - 1) {
                        nums[j] = nums[j + 1]
                    }
                    size--
                } else {
                    i++
                }
            }
            return size
        }

        fun removeElement(nums: IntArray, `val`: Int): Int {
            var start = 0
            var end = nums.size - 1
            var count = 0
            while (start <= end) {
                while (end >= 0 && nums[end] == `val`) {
                    count++
                    end--
                }
                while (start < nums.size && nums[start] != `val`) {
                    start++
                }
                if (start < end) {
                    val temp = nums[start]
                    nums[start] = nums[end]
                    nums[end] = temp
                    end--
                    count++
                }
            }
            return nums.size - count
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
//            solution.removeElement(
//                intArrayOf(0, 1, 2, 2, 3, 0, 4, 2),
//                2
//            )
            solution.removeElement(
                intArrayOf(1),
                1
            )
        }
    }
}