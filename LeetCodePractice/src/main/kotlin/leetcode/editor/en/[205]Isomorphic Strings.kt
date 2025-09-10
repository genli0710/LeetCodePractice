package leetcode.editor.en

import leetcode.editor.common.*

class isomorphic_strings {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isIsomorphic1(s: String, t: String): Boolean {
            //b a d c
            //b a b a
            if (s.length == 1 && s.length == t.length) return true
            // s char to t char
            val map = HashMap<Char, Char>()
            for (i in s.indices) {
                val key = s[i]
                val value = t[i]
                val entry = map[key]
                val hasValue = map.containsValue(value)
                if (entry != null && entry != value) {
                    return false
                }
                if (hasValue && value != map[key]) {
                    return false
                }
                map[s[i]] = t[i]
            }
            return true
        }

        fun isIsomorphic(s: String, t: String): Boolean {
            if (s.length != t.length) return false

            val s2t = HashMap<Char, Char>()
            val t2s = HashMap<Char, Char>()

            for (i in s.indices) {
                val c1 = s[i]
                val c2 = t[i]

                if (s2t.containsKey(c1) && s2t[c1] != c2) return false
                if (t2s.containsKey(c2) && t2s[c2] != c1) return false

                s2t[c1] = c2
                t2s[c2] = c1
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
            solution.isIsomorphic("egg", "add").print()
            solution.isIsomorphic("foo", "bar").print()
            solution.isIsomorphic("paper", "title").print()
            solution.isIsomorphic("badc", "baba").print()
        }
    }
}