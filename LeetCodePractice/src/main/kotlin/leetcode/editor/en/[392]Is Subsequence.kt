package leetcode.editor.en

import leetcode.editor.common.*

class is_subsequence {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isSubsequence1(s: String, t: String): Boolean {
            var p1 = 0
            var p2 = 0
            while (p1 < s.length && p2 < t.length) {
                if (s[p1] != t[p2]) {
                    p2++
                } else {
                    p1++
                    p2++
                }
            }
            return p1 == s.length
        }

        fun isSubsequence2(s: String, t: String): Boolean {
            if (s.isEmpty()) return true
            if (t.isEmpty() || s.length >= t.length) return s == t
//            println("s=$s t=$t")
            val dp = Array(t.length) {
                IntArray(26) {
                    -1
                }
            }

            for (i in 0..t.length) {
                for (j in i + 1 until t.length) {
                    if (dp[i][t[j] - 'a'] == -1) {
                        dp[i][t[j] - 'a'] = j
//                        println("${t[i]}->${t[j]} in $j")
                    }
                }
            }
            var i = 1
            var k = t.indexOfFirst { it == s[0] }
            while (i < s.length) {
                if (dp[k][s[i] - 'a'] != -1) {
                    k = dp[k][s[i] - 'a']
                    i++
                } else {
                    return false
                }
            }
            return true
        }

        fun isSubsequence(s: String, t: String): Boolean {
            if (s.isEmpty()) return true
            if (t.isEmpty() || s.length >= t.length) return s == t
//            println("s=$s t=$t")
            val dp = Array(t.length + 1) {
                IntArray(26) {
                    -1
                }
            }

            for (i in t.length - 1 downTo 0) {
                for (j in 0 until 26) {
                    dp[i][j] = dp[i + 1][j]
                }
                dp[i][t[i] - 'a'] = i
            }

            var pos = 0
            for (char in s) {
                pos = dp[pos][char - 'a']
                if (pos == -1) return false
                pos++
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
            println(solution.isSubsequence("abc", "ahbgdc"))
            println(solution.isSubsequence("axc", "ahbgdc"))
//            println(solution.isSubsequence("adc", "ahbgdc"))
//            println(solution.isSubsequence("gdc", "ahbgdc"))
//            println(solution.isSubsequence("gdc", "ahbgcd"))
//            println(solution.isSubsequence("aza", "abzba"))
        }
    }
}