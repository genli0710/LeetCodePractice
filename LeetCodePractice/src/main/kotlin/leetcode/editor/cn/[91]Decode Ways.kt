package leetcode.editor.cn

class decode_ways {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun numDecodings1(s: String): Int {
            // recursion way
            val num = s.length - 1
            val cache = IntArray(s.length) {
                -1
            }

            fun dfs(num: Int): Int {
                if (num < 0) {
                    return 1
                }

                if (cache[num] != -1) {
                    return cache[num]
                }

                var count = 0
                if (s[num] != '0') {
                    count += dfs(num - 1)
                }
                if (num > 0 && s.substring(num - 1..num) in "10".."26") {
                    count += if (num >= 2) dfs(num - 2) else 1
                }
                cache[num] = count
                return count
            }

            return dfs(num)
        }

        fun numDecodings(s: String): Int {
            // DP way
            if (s[0] == '0') {
                return 0
            }

            val str = " $s"
            var last2 = 1
            var last1 = 1
            for (i in 2..s.length) {
                var count = 0
                if (str[i] != '0') {
                    count += last1
                }
                val twoDig = (str[i - 1] - '0') * 10 + (str[i] - '0')
                if (twoDig in 10..26) {
                    count += last2
                }
                last2 = last1
                last1 = count
            }
            return last1
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            println(solution.numDecodings("226"))
            // put your test code here
        }
    }
}