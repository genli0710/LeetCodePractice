package leetcode.editor.en

import leetcode.editor.common.*

class majority_element {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun majorityElement1(nums: IntArray): Int {
            val map = HashMap<Int, Int>()
            for (it in nums) {
                map[it] = map.getOrDefault(it, 0) + 1
                if (map[it]!! > nums.size / 2) {
                    return it
                }
            }
            return -1
        }
        fun majorityElement(nums: IntArray): Int {
            var candidate = 0
            var diff = 0
            for (it in nums) {
                if (diff == 0) {
                    candidate = it
                }
                diff += if (candidate == it) 1 else -1
            }
            return candidate
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