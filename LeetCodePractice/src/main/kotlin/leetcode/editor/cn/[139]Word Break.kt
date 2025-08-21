package leetcode.editor.cn

class word_break {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun wordBreakOld(s: String, wordDict: List<String>): Boolean {
            // dp way abc ["e","f","abc"]
            val size = s.length
            val wordSet = wordDict.toSet()
            val dp = BooleanArray(size + 1) { false }
            val lengthArr = wordDict.map { it.length }.distinct().sorted()
            dp[0] = true

            for (i in 1..size) {
                for (j in lengthArr) {
                    if (j > i) break
                    val result = dp[i - j] && s.substring(i - j until i) in wordSet
                    if (result) {
                        dp[i] = true
                        break
                    }
                }
            }
            return dp[size]
        }

        fun wordBreak(s: String, wordDict: List<String>): Boolean {
            // recursion way
            val wordSet = wordDict.toSet()
            val lenArr = wordDict.map { it.length }.distinct().sorted()
            val cache = Array<Boolean?>(s.length + 1) { null }


            fun dfs(i: Int): Boolean {
                if (i == 0) {
                    return true
                }

                if (cache[i] != null) {
                    return cache[i]!!
                }

                for (j in lenArr) {
                    if(j>i)break
                    if (dfs(i - j) && s.substring(i - j until i) in wordSet) {
                        cache[i] = true
                        return true
                    }
                }
                cache[i] = false
                return false
            }

            return dfs(s.length)
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            println(solution.wordBreak("abc", listOf("e", "f", "abc")))
            // put your test code here
        }
    }
}