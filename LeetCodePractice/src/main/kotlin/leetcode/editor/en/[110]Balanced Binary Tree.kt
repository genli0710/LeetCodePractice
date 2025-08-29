package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.abs
import kotlin.math.max

class balanced_binary_tree {

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
        fun isBalanced(root: TreeNode?): Boolean {

            var result = true
            fun dfs(root: TreeNode?): Int {
                if (root == null) {
                    return 0
                }
                val left = dfs(root.left)
                val right = dfs(root.right)
                if (result && abs(left - right) > 1) {
                    result = false
                }
                return max(left, right) + 1
            }


            dfs(root)
            return result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.isBalanced(TreeNode.createRoot(arrayOf(1,2,2,3,null,null,3,4,null,null,4)))
//            solution.isBalanced(TreeNode.createRoot(arrayOf(3,9,20,null,null,15,7)))
        }
    }
}