package leetcode.editor.en

import leetcode.editor.common.*

class binary_tree_right_side_view {

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
        fun rightSideView1(root: TreeNode?): List<Int> {
            if (root == null) return emptyList()
            val deque = ArrayDeque<TreeNode>()
            deque.addLast(root)
            val result = mutableListOf<Int>()
            while (deque.isNotEmpty()) {
                val length = deque.size
                for (i in 0 until length) {
                    val node = deque.removeFirst()
                    if (i == length - 1) {
                        result.add(node.`val`)
                    }
                    node.left?.let {
                        deque.addLast(it)
                    }
                    node.right?.let {
                        deque.addLast(it)
                    }
                }
            }
            println(result)
            return result
        }

        fun rightSideView(root: TreeNode?): List<Int> {
            val result = mutableListOf<Int>()

            fun dfs(root: TreeNode?, depth: Int) {
                if (root == null) return

                if (result.size == depth) {
                    result.add(root.`val`)
                }

                dfs(root.right, depth + 1)
                dfs(root.left, depth + 1)
            }
            dfs(root, 0)
            return result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.rightSideView(
                TreeNode.createRoot(
                    arrayOf(
                        1, 2, 3, null, 5, null, 4
                    )
                )
            )
        }
    }
}