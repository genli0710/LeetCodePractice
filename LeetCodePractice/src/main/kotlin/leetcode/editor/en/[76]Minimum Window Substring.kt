package leetcode.editor.en

import leetcode.editor.common.*

class minimum_window_substring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minWindow(origin: String, target: String): String {
            if (origin.length < target.length) return ""
            val targetCount = IntArray(128)
            val windowCount = IntArray(128)
            var required = target.length
            target.forEach {
                targetCount[it - 'A'] += 1
            }
            var start = 0
            var end = target.length - 1
            for (i in start..end) {
                if (targetCount[origin[i] - 'A'] > 0 && windowCount[origin[i] - 'A'] < targetCount[origin[i] - 'A']) {
                    required--
                }
                windowCount[origin[i] - 'A'] += 1
            }

            var result = ""
            while (end < origin.length) {
                if (required == 0) {
                    val substring = origin.substring(start, end + 1)
                    if (result.isEmpty() || substring.length < result.length) {
                        result = substring
                    }

                    if (targetCount[origin[start] - 'A'] > 0 && windowCount[origin[start] - 'A'] == targetCount[origin[start] - 'A']) {
                        // if this char is need to target, require +1
                        required++
                    }
                    windowCount[origin[start] - 'A'] -= 1
                    start++
                    continue
                }
                end++
                if (end < origin.length) {
                    if (targetCount[origin[end] - 'A'] > 0 && windowCount[origin[end] - 'A'] < targetCount[origin[end] - 'A']) {
                        // if this char is need to target, require -1
                        required--
                    }
                    windowCount[origin[end] - 'A'] += 1
                }
            }
            return result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
//            println(
//                solution.minWindow(
//                    "ADOBECODEBANC",
//                    "ABC"
//                )
//            )
            println(
                solution.minWindow(
                    "bba", "ba"
                )
            )
        }
    }
}