package leetcode.editor.cn

import kotlin.math.absoluteValue
import kotlin.math.max

class longer_contiguous_segments_of_ones_than_zeros {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun checkZeroOnes1(s: String): Boolean {
            // dp way
            if (s.length == 1) {
                return s[0] == '1'
            }

            val size = s.length
            val dp1 = IntArray(size + 1)
            val dp0 = IntArray(size + 1)
            var count1 = 0
            var count0 = 0
            for (i in 1..size) {
                if (s[i - 1] == '1') {
                    count1++
                    count0 = 0
                } else {
                    count1 = 0
                    count0++
                }
                dp1[i] = max(dp1[i - 1], count1)
                dp0[i] = max(dp0[i - 1], count0)
            }
            return dp1[size] > dp0[size]
        }

        fun checkZeroOnes2(s: String): Boolean {
            // double index
            val arr = IntArray(2)
            val max = IntArray(2)
            for (i in s.indices) {
                arr[s[i] - '0']++
                arr[(s[i] - '1').absoluteValue] = 0
                max[1] = max(max[1], arr[1])
                max[0] = max(max[0], arr[0])
            }
            return max[1] > max[0]
        }

        fun checkZeroOnes3(s: String): Boolean {
            // dp way2 end-at dp1[i] 以s[i-1]结尾的连续1个数
            val size = s.length
            var last1 = 0
            var last0 = 0
            var max1 = 0
            var max0 = 0
            for (i in s.indices) {
                last1 = if (s[i] == '1') last1 + 1 else 0
                last0 = if (s[i] == '0') last0 + 1 else 0
                max1 = max(max1, last1)
                max0 = max(max0, last0)
            }

            return max1 > max0
        }

        fun checkZeroOnes4(s: String): Boolean {
            // recursion way
            val cache = Array(2) {
                IntArray(s.length) { -1 }
            }

            val max = IntArray(2)

            fun dfs(n: Int, char: Char): Int {
                if (n < 0) {
                    return 0
                }

                if (cache[char - '0'][n] != -1) {
                    return cache[char - '0'][n]
                }
                var ret = dfs(n - 1, char)
                if (s[n] == char) {
                    ret++
                } else {
                    ret = 0
                }

                max[char - '0'] = max(max[char - '0'], ret)

                cache[char - '0'][n] = ret
                return ret
            }
            dfs(s.length - 1, '1')
            dfs(s.length - 1, '0')
            return max[1] > max[0]
        }

        fun checkZeroOnes5(s: String): Boolean {

            fun dfs(n: Int, char: Char): Pair<Int, Int> {
                // 1101
                if (n < 0) {
                    return 0 to 0
                }

                val ret = dfs(n - 1, char)
                return if (s[n] == char) {
                    max(ret.first, ret.second + 1) to ret.second + 1
                } else {
                    ret.first to 0
                }
            }
            return dfs(s.length - 1, '1').first > dfs(s.length - 1, '0').first
        }

        fun checkZeroOnes(s: String): Boolean {

            fun dfs(n: Int, char: Char, count: Int, max: Int): Int {
                // 1101
                if (n < 0) {
                    return max
                }
                val newCount = if (s[n] == char) count + 1 else 0
                val newMax = max(newCount, max)
                return dfs(n - 1, char, newCount, newMax)
            }
            return dfs(s.length - 1, '1', 0, 0) > dfs(s.length - 1, '0', 0, 0)
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            println(solution.checkZeroOnes("110111"))
            // put your test code here
        }
    }
}