package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.max

class longest_substring_without_repeating_characters {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun lengthOfLongestSubstring1(s: String): Int {
            if (s.isEmpty()) return 0
            if (s.length == 1) return 1
            var start = 0
            var end = 1
            val hashSet = HashSet<Char>()
            var max = 0
            while (start < s.length) {
                if (!hashSet.contains(s[end])) {
                    hashSet.add(s[end])
                    end++
                } else {
                    max = max((end - start), max)
                    hashSet.remove(s[start])
                    start++
                }
            }
            return max
        }

        fun lengthOfLongestSubstring(s: String): Int {
            if (s.isEmpty()) return 0
            if (s.length == 1) return 1
            var start = 0
            var end = 0
            val hashSet = HashSet<Char>()
            var max = 0
            while (end < s.length) {
                if (!hashSet.contains(s[end])) {
                    hashSet.add(s[end])
                    end++
                }else {
                    max = max(max, hashSet.size)
                    hashSet.remove(s[start])
                    start++
                }
            }
            return max(max, hashSet.size)
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.lengthOfLongestSubstring("au")
        }
    }
}