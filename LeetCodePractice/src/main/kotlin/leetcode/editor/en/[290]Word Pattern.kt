package leetcode.editor.en

import leetcode.editor.common.*

class word_pattern {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun wordPattern(pattern: String, s: String): Boolean {
            val splitS = s.split(" ")
            if (splitS.size != pattern.length) return false
            val map1 = HashMap<Char, String>()
            val map2 = HashMap<String, Char>()
            for (i in splitS.indices) {
                if (map1[pattern[i]] != null && map1[pattern[i]] != splitS[i]) return false
                if (map2[splitS[i]] != null && map2[splitS[i]] != pattern[i]) return false

                map1[pattern[i]] = splitS[i]
                map2[splitS[i]] = pattern[i]
            }
            return true
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.wordPattern(
                "abba", "dog cat cat dog"
            ).print(true)
            solution.wordPattern(
                "abba", "dog cat cat fish"
            ).print(false)
            solution.wordPattern(
                "abbc", "dog cat cat fish"
            ).print(true)
            solution.wordPattern(
                "aaaa", "dog cat cat dog"
            ).print(false)
        }
    }
}