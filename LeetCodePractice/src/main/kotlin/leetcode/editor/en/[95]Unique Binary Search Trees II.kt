package leetcode.editor.en

import leetcode.editor.common.*
import java.util.ArrayDeque

class unique_binary_search_trees_ii {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    // start 2025-09-07 14:12:35
    // end
    class Solution {
        fun generateTrees(n: Int): List<TreeNode?> {
            if (n == 0) return emptyList()

            fun build(start: Int, end: Int): List<TreeNode?> {
                val res = mutableListOf<TreeNode?>()
                if (start > end) {
                    res.add(null)
                    return res
                }

                for (i in start..end) {
                    val leftTrees = build(start, i - 1)
                    val rightTress = build(i + 1, end)
                    for (l in leftTrees) {
                        for (r in rightTress) {
                            val root = TreeNode(i)
                            root.left = l
                            root.right = r
                            res.add(root)
                        }
                    }
                }
                return res
            }

            return build(1, n)
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.generateTrees(3)
        }
    }
}