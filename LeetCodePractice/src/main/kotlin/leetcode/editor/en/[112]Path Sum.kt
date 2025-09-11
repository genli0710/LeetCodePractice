package leetcode.editor.en

import leetcode.editor.common.*

class path_sum {

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
        fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
            if (root == null) return false

            var found = false
            fun dfs(node: TreeNode?, sum: Int) {
                if (node != null && node.left == null && node.right == null) {
                    if (node.`val` + sum == targetSum) {
                        found = true
                        return
                    }
                    return
                }
                if (node?.left != null) {
                    dfs(node.left, sum + node.`val`)
                }
                if (node?.right != null) {
                    dfs(node.right, sum + node.`val`)
                }
            }
            dfs(root, 0)
            return found
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.hasPathSum(
                TreeNode.createRoot(
                    arrayOf(1, 2, 3)
                ),
                3
            )
        }
    }
}