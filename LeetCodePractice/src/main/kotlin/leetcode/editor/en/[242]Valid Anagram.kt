package leetcode.editor.en

import leetcode.editor.common.*

class valid_anagram {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isAnagram(s: String, t: String): Boolean {
            if (s.length != t.length) {
                return false
            }
            val map = mutableMapOf<Char, Int>()
            s.forEach {
                if (map.containsKey(it)) {
                    map[it] = map[it]!!.plus(1)
                } else {
                    map[it] = 1
                }
            }

            t.forEach {
                if (map.containsKey(it) && map[it]!! > 0) {
                    map[it] = map[it]!!.minus(1)
                } else {
                    return false
                }
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
            solution.isAnagram("anagram", "nagaram")
        }
    }
}