package leetcode.editor.en

import leetcode.editor.common.*
import java.util.ArrayDeque

class flatten_binary_tree_to_linked_list {

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
        fun flatten1(root: TreeNode?): Unit {
            // preorder
            if (root == null) return
            val queue = ArrayDeque<TreeNode>()
            queue.addLast(root)
            val path = mutableListOf<TreeNode>()
            fun dfs(node: TreeNode?) {
                if (node == null) return
                path.add(node)
                dfs(node.left)
                dfs(node.right)
            }

            dfs(root)

            for (i in 0 until path.size - 1) {
                path[i].right = path[i + 1]
                path[i].left = null
            }
            path[path.lastIndex].right = null
            path[path.lastIndex].left = null
        }

        fun flatten(root: TreeNode?): Unit {
            if (root == null) return

            // find left node's rightmost(RM),
            // RM.right = cur's right,
            // cur.right = cur.left
            fun findRightMost(node: TreeNode): TreeNode {
                if (node.right == null) return node
                return findRightMost(node.right!!)
            }

            var cur = root
            while (cur!=null) {
                if (cur.left != null) {
                    val rightMost = findRightMost(cur.left!!)
                    rightMost.right = cur.right
                    cur.right = cur.left
                    cur.left = null
                } else {
                    cur = cur.right
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.flatten(
                TreeNode.createRoot(
                    arrayOf(1, 2, 5, 3, 4, null, 6)
                )
            )
        }
    }
}