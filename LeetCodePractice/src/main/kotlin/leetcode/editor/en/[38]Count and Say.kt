package leetcode.editor.en

class count_and_say {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun countAndSay(n: Int): String {
            fun cal(input: String): String {
                val result = StringBuilder()
                var count = 1
                for (i in 1 until input.length) {
                    if (input[i] == input[i - 1]) {
                        count++
                    } else {
                        result.append(count).append(input[i - 1])
                        count = 1
                    }
                }
                result.append(count).append(input.last())
                return result.toString()
            }

            var last = "1"
            for (i in 1 until n) {
                last = cal(last)
            }
            return last
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(solution.countAndSay(4))
        }
    }
}