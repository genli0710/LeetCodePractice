package leetcode.editor.en

import leetcode.editor.common.*
import java.util.HashSet

class longest_consecutive_sequence {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun longestConsecutive(nums: IntArray): Int {
            val map = nums.associateWith { false }.toMutableMap()
            var max = 0
            for (it in map.keys) {
                var tempMax = 1
                var cur = it
                if (map[cur] == true) continue
                while (map.contains(cur + 1) && map[cur + 1] == false) {
                    map[cur + 1] = true
                    tempMax++
                    cur++
                }
                cur = it
                while (map.contains(cur - 1) && map[cur - 1] == false) {
                    map[cur - 1] = true
                    tempMax++
                    cur--
                }
                if (tempMax > max) {
                    max = tempMax
                }
            }
            return max
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
//            solution.longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)).print()// 0,0,1,2,3,4,5,6,7,8
            solution.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)).print()// 0,0,1,2,3,4,5,6,7,8
        }
    }
}