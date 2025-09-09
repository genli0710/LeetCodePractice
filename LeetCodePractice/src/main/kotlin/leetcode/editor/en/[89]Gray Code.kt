package leetcode.editor.en

import java.util.ArrayDeque
import kotlin.math.pow

class gray_code {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun grayCode1(n: Int): List<Int> {
            // order is incorrect
            val result = mutableListOf<List<Int>>()
            val stack = ArrayDeque<Int>()

            fun dfs() {
                if (stack.size == n) {
                    result.add(stack.toList())
                    return
                }
                for (i in 0..1) {
                    stack.addLast(i)
                    dfs()
                    stack.removeLast()
                }

            }
            dfs()
            return result.map {
                it.fold(0) { acc, bit ->
                    (acc shl 1) or bit
                }
            }
        }

        fun grayCode2(n: Int): List<Int> {
            val total = 2.0.pow(n).toInt()
            val set = LinkedHashSet<String>()
            val first = IntArray(n).joinToString("") { "$it" }
            set.add(first)
            var current = first
            for (i in 1 until total) {
                for (j in 0 until n) {
                    val sb = StringBuilder(current)
                    val i1 = '1' - current[j]
                    sb[j] = i1.digitToChar()
                    val str = sb.toString()
                    if (!set.contains(str)) {
                        set.add(str)
                        current = str
                        break
                    }
                }
            }
            return set.toList().map {
                it.map { char ->
                    char - '0'
                }.fold(0) { acc, bit ->
                    (acc shl 1) or bit
                }
            }
        }

        fun grayCode(n: Int): List<Int> {
            val result = mutableListOf<Int>()
            result.add(0)
            for (i in 0 until n) {
                val add = 1 shl i
                for (j in result.size - 1 downTo 0) {
                    result.add(result[j] + add)
                }
            }
            return result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(solution.grayCode(2))
            println(solution.grayCode(3))
            println(solution.grayCode(4))
            println(solution.grayCode(5))
        }
    }
}