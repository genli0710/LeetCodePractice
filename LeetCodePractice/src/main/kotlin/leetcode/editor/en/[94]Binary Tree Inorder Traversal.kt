package leetcode.editor.en

import leetcode.editor.common.*

class binary_tree_inorder_traversal {

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
        fun inorderTraversal(root: TreeNode?): List<Int> {
            if (root == null) return emptyList()
            val res = mutableListOf<Int>()

            fun dfs(root: TreeNode?) {
                if (root == null) return

                dfs(root.left)
                res.add(root.`val`)
                dfs(root.right)
            }
            dfs(root)
            return res
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
        }
    }
}