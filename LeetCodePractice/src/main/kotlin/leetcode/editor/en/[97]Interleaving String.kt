package leetcode.editor.en

import java.util.ArrayDeque

class interleaving_string {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isInterleave1(s1: String, s2: String, s3: String): Boolean {
            //TLE
            if (s1.length + s2.length != s3.length) return false
            if (s3.length < s1.length || s3.length < s2.length) return false
            val stack = ArrayDeque<Char>()

            fun dfs(start: Int, tempS3: StringBuilder): Boolean {
                if (stack.size == s1.length) {
                    val res = stack.joinToString("") == s1
                    val replace = tempS3.toString().replace("_", "")
                    if (res) {
//                        println("temp=$tempS3 replace=$replace")
                    }
                    return res && replace == s2
                }

                for (i in start until s3.length) {
                    stack.addLast(s3[i])
                    tempS3[i] = '_'
                    val found = dfs(i + 1, tempS3)
                    if (found) {
                        return true
                    }
                    stack.removeLast()
                    tempS3[i] = s3[i]
                }
                return false
            }

            return dfs(0, StringBuilder(s3))
        }

        fun isInterleave(s1: String, s2: String, s3: String): Boolean {
            //TLE
            if (s1.length + s2.length != s3.length) return false
            if (s3.length < s1.length || s3.length < s2.length) return false

            val dp = Array(s1.length + 1) {
                BooleanArray(s2.length + 1)
            }
            dp[0][0] = true
            for (i in 1..s1.length) {
                dp[i][0] = dp[i - 1][0] && s1[i - 1] == s3[i - 1]
            }
            for (j in 1..s2.length) {
                dp[0][j] = dp[0][j - 1] && s2[j - 1] == s3[j - 1]
            }
            for (i in 1..s1.length) {
                for (j in 1..s2.length) {
                    val up = dp[i - 1][j] && s1[i - 1] == s3[i + j - 1]
                    val left = dp[i][j - 1] && s2[j - 1] == s3[i + j - 1]
                    dp[i][j] = up || left
                }
            }

            return dp[s1.length][s2.length]
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(
                solution.isInterleave(
                    "aab", "axy", "aaxaby"
                )
            )
//            println(
//                solution.isInterleave(
//                    "", "", ""
//                )
//            )
//            println(
//                solution.isInterleave(
//                    "aabcc", "dbbca", "aadbbbaccc"
//                )
//            )
        }
    }
}