package leetcode.editor.en

import leetcode.editor.common.*

class recover_binary_search_tree {

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
        fun recoverTree(root: TreeNode?): Unit {
            val path = mutableListOf<TreeNode>()
            fun inOrder(node: TreeNode?) {
                if (node == null) {
                    return
                }
                inOrder(node.left)
                path.add(node)
                inOrder(node.right)
            }
            inOrder(root)

            var first: TreeNode? = null
            var second: TreeNode? = null
            for (i in 1 until path.size) {
                if (path[i].`val` < path[i - 1].`val`) {
                    if (first == null) {
                        first = path[i - 1]
                        second = path[i]
                    } else {
                        second = path[i]
                    }
                }
            }
            if (first != null && second != null) {
                val temp = first.`val`
                first.`val` = second.`val`
                second.`val` = temp
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.recoverTree(
                TreeNode.createRoot(
                    arrayOf(3, 1, 4, null, null, 2)
                )
            )
        }
    }
}