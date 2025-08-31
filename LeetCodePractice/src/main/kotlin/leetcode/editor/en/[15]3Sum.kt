package leetcode.editor.en

import leetcode.editor.common.*

class three_sum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun threeSum(arr: IntArray): List<List<Int>> {
            arr.sort()
            val result = mutableListOf<List<Int>>()
            for (i in arr.indices) {
                if (arr[i] > 0) {
                    break
                }

                if (i > 0 && arr[i] == arr[i - 1]) {
                    continue
                }

                var start = i + 1
                var end = arr.size - 1
                val target = 0 - arr[i]
                while (start < end) {
                    val sum = arr[start] + arr[end]
                    if (sum == target) {
                        result.add(listOf(arr[i], arr[start], arr[end]))
                        while (start < end && arr[start] == arr[start + 1]) {
                            start++
                        }
                        while (start < end && arr[end] == arr[end - 1]) {
                            end--
                        }
                        start++
                        end--
                    } else if (sum < target) {
                        start++
                    } else {
                        end--
                    }
                }
            }
            return result.distinct()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
        }
    }
}