package leetcode.editor.en

class find_the_index_of_the_first_occurrence_in_a_string {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun strStr(haystack: String, needle: String): Int {
            if (haystack.length < needle.length) {
                return -1
            }
            if (haystack.length == needle.length) {
                return if (haystack == needle) 0 else -1
            }
            val possibleStart = mutableListOf<Int>()
            val first = needle[0]
            haystack.forEachIndexed { index, v ->
                if (v == first) {
                    possibleStart.add(index)
                }
            }
            possibleStart.forEach { start ->
                var found = true
                for (j in needle.indices) {
                    if (start + j >= haystack.length) {
                        found = false
                        break
                    }
                    if (haystack[start + j] != needle[j]) {
                        found = false
                        break
                    }
                }
                if (found) {
                    return start
                }
            }
            return -1
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.strStr(
                "mississippi", "issipi"
            )
        }
    }
}