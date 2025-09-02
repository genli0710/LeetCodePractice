package leetcode.editor.en

import kotlin.math.max

class largest_rectangle_in_histogram {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun largestRectangleArea1(heights: IntArray): Int {
            //这个不太行,要找当前最小值
            var start = 0
            var end = heights.size - 1
            var sorted = heights.sorted()
            var minHeightIndex = 0
            var minHeight = sorted[minHeightIndex]
            var maxRect = heights.max()
            while (start <= end) {
                maxRect = max(maxRect, minHeight * (end - start + 1))
                if (heights[start] < heights[end]) {
                    start++
                } else {
                    end--
                }
            }
            return maxRect
        }

        fun largestRectangleArea2(heights: IntArray): Int {
            // TLE
            val size = heights.size
            var maxRect = heights.max()

            for (i in heights.indices) {
                var start = i
                var end = start
                var min = heights[start]
                while (end < size && start >= 0) {
                    maxRect = max(maxRect, min * (end - start + 1))
                    if (start - 1 >= 0 && end + 1 < size) {
                        val left = heights[start - 1]
                        val right = heights[end + 1]
                        if (left > right) {
                            start--
                            if (heights[start] < min) {
                                min = heights[start]
                            }
                        } else {
                            end++
                            if (heights[end] < min) {
                                min = heights[end]
                            }
                        }
                    } else if (end + 1 < size) {
                        end++
                        if (heights[end] < min) {
                            min = heights[end]
                        }
                    } else if (start > 0) {
                        start--
                        if (heights[start] < min) {
                            min = heights[start]
                        }
                    } else {
                        break
                    }
                }
            }
            return maxRect
        }

        fun largestRectangleArea(heights: IntArray): Int {
            //monotonic stack
            // 储存下标
            val indexStack = ArrayDeque<Int>()
            var maxArea = 0
            val n = heights.size
            for (i in 0..n) {
                val currentHeight = if (i < n) heights[i] else 0
                while (indexStack.isNotEmpty() && currentHeight < heights[indexStack.last()]) {
                    val popH = heights[indexStack.removeLast()]
                    val w = if (indexStack.isEmpty()) i else i - indexStack.last() - 1
                    maxArea = max(maxArea, w * popH)
                }
                indexStack.addLast(i)
            }
            return maxArea
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(
                solution.largestRectangleArea(
                    intArrayOf(5, 4, 1, 2)
                )
            )
        }
    }
}