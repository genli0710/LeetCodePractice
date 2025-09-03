package leetcode.editor.en

import leetcode.editor.common.*

class merge_sorted_array {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
            if (m == 0) {
                nums2.forEachIndexed { idx, v ->
                    nums1[idx] = v
                }
                return
            }
            var p1 = m - 1
            var p = nums1.size - 1
            var p2 = n - 1
            while (p >= 0 && p2 >= 0) {
                if (p1 < 0) {
                    nums1[p] = nums2[p2]
                    p2--
                    p--
                    continue
                }
                if (nums1[p1] > nums2[p2]) {
                    nums1[p] = nums1[p1]
                    p1--
                    p--
                } else {
                    nums1[p] = nums2[p2]
                    p2--
                    p--
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
            solution.merge(
                intArrayOf(1, 2, 3, 0, 0, 0),
                3,
                intArrayOf(2, 5, 6),
                3
            )
//            solution.merge(
//                intArrayOf(2, 0),
//                1,
//                intArrayOf(1),
//                1
//            )
        }
    }
}