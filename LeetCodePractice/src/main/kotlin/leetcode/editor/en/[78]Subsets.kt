package leetcode.editor.en

import leetcode.editor.common.*

class subsets {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun subsets1(nums: IntArray): List<List<Int>> {
            nums.sort()
            val arr = mutableListOf<List<Int>>()
            arr.add(emptyList())
            for (element in nums) {
                val newList = mutableListOf<List<Int>>()
                for (set in arr) {
                    newList.add((set + element).toMutableList())
                }
                arr.addAll(newList)
            }
            return arr
        }

        fun subsets(nums: IntArray): List<List<Int>> {
            // backtracking
            val deque = ArrayDeque<Int>()
            val result = mutableListOf<List<Int>>()
            fun backtrack(i: Int) {
                result.add(deque.toList())
                for (index in i until nums.size) {
                    deque.addLast(nums[index])
                    backtrack(index + 1)
                    deque.removeLast()
                }
            }
            backtrack(0)
            return result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.subsets(intArrayOf(1, 2, 3))
        }
    }
}