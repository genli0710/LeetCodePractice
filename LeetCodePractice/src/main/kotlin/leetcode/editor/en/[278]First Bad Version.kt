package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.min

class first_bad_version {

    //leetcode submit region begin(Prohibit modification and deletion)
    /* The isBadVersion API is defined in the parent class VersionControl.
          fun isBadVersion(version: Int) : Boolean {} */
    open class VersionControl() {
        open fun isBadVersion(n:Int): Boolean {
            return false
        }

        open fun firstBadVersion(n: Int): Int {return 0}
    }

    class Solution : VersionControl() {
        override fun firstBadVersion(n: Int): Int {
            var start = 1
            var end = n
            var min = Int.MAX_VALUE
            while (start <= end) {
                var mid = start + (end - start) / 2
                if (isBadVersion(mid)) {
                    if (mid < min) {
                        min = mid
                    }
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            }
            return min
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