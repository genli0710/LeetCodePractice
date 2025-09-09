package leetcode.editor.en

class group_anagrams {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            return strs.groupBy { it.toCharArray().sorted().toString() }.values.toList().sortedBy { it.size }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(
                solution.groupAnagrams(
                    arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
                )
            )
        }
    }
}