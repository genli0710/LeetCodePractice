package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.max

class length_of_longest_fibonacci_subsequence {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun lenLongestFibSubseq(num: IntArray): Int {
            val indexMap = num.withIndex().associate { it.value to it.index }
            val dpMap = mutableMapOf<Pair<Int, Int>, Int>()

            for (i in 2 until num.size) {
                for (j in 1 until i) {
                    // find possible element in indexmap
                    val index = indexMap[num[i] - num[j]] ?: continue
//                    if (index >= j) {
//                        continue
//                    }

                    if (dpMap.containsKey(Pair(j, index))) {
                        dpMap[Pair(i, j)] = max(dpMap[Pair(i, j)] ?: 0, dpMap[Pair(j, index)]!! + 1)
                    } else {
                        dpMap[Pair(i, j)] = 3
                        dpMap[Pair(j, index)] = 2
                    }
                }
            }

            return dpMap.values.maxOrNull() ?: 0
        }

        fun lenLongestFibSubseq2(num: IntArray): Int {
            val indexMap = num.withIndex().associate { it.value to it.index }

            var length = 2
            for (i in 0 until num.size - 1) {
                var k = i
                var j = i + 1
                var tempLength = 2
                while (j < num.size) {
                    val first = num[k]
                    val second = num[j]
                    val targetIndex = indexMap[first + second]
                    if (targetIndex != null && k != j) {
                        tempLength++
                        k = j
                        j = targetIndex
                    } else {
                        j++
                    }
                }
                if (tempLength > length) {
                    length = tempLength
                }
            }

            return length
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
//            println(solution.lenLongestFibSubseq(intArrayOf(1, 2, 3, 4, 5, 6, 8)))
//            println(solution.lenLongestFibSubseq(intArrayOf(1, 2, 3, 4)))
//            println(solution.lenLongestFibSubseq(intArrayOf(1, 3, 7, 11, 12, 14, 18)))
            println(solution.lenLongestFibSubseq(intArrayOf(2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50)))
        }
    }
}