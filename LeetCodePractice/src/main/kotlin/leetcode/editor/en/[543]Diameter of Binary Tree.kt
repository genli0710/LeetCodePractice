package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.abs
import kotlin.math.max

class diameter_of_binary_tree {

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
        fun diameterOfBinaryTree(root: TreeNode?): Int {
            var max = 0
            fun dfs(node: TreeNode?): Int {
                if (node == null) {
                    return 0
                }
                val left = dfs(node.left)
                val right = dfs(node.right)
                if (left + right > max) {
                    max = left + right
                    println("${node.`val`} left=$left right=$right max=$max")
                }

                return max(left, right) + 1
            }
            dfs(root)
            return max
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.diameterOfBinaryTree(TreeNode.createRoot(arrayOf(
                1,2,3,4,5
            )))
        }
    }
}