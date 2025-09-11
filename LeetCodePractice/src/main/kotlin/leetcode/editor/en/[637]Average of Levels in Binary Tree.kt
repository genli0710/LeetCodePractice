package leetcode.editor.en

import leetcode.editor.common.*

class average_of_levels_in_binary_tree {

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
    class Solution {
        fun averageOfLevels(root: TreeNode?): DoubleArray {
            if (root == null) return doubleArrayOf()

            val queue = ArrayDeque<TreeNode>()
            queue.addLast(root)
            val result = mutableListOf<Double>()
            while (queue.isNotEmpty()) {
                val size = queue.size
                var sum: Double = 0.0
                repeat(size) {
                    val node = queue.removeFirst()
                    sum += node.`val`
                    node.left?.let {
                        queue.addLast(it)
                    }
                    node.right?.let {
                        queue.addLast(it)
                    }
                }
                result.add(sum / size)
            }
            return result.toDoubleArray()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.averageOfLevels(
                TreeNode.createRoot(
                    arrayOf(3, 9, 20, null, null, 15, 7)
                )
            ).contentToString().print()
        }
    }
}