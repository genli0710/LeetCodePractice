package leetcode.editor.en

import leetcode.editor.common.*

class binary_tree_zigzag_level_order_traversal {

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
        fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
            if (root == null) return emptyList()
            val L2R = 0
            val R2L = 1
            var direction = L2R
            val queue = ArrayDeque<TreeNode>()
            val result = mutableListOf<List<Int>>()
            queue.addLast(root)
            while (queue.isNotEmpty()) {
                val list = queue.toList()
                if (direction == L2R) {
                    result.add(list.map { it.`val` })
                    direction = R2L
                } else {
                    result.add(list.map { it.`val` }.reversed())
                    direction = L2R
                }
                val size = queue.size
                repeat(size) {
                    val node = queue.removeFirst()
                    node.left?.let {
                        queue.addLast(it)
                    }
                    node.right?.let {
                        queue.addLast(it)
                    }
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
            solution.zigzagLevelOrder(
                TreeNode.createRoot(
                    arrayOf(3, 9, 20, null, null, 15, 7)
                )
            )
            solution.zigzagLevelOrder(
                TreeNode.createRoot(
                    arrayOf(1)
                )
            )
        }
    }
}