package leetcode.editor.en

import leetcode.editor.common.*
import java.util.ArrayDeque

class symmetric_tree {

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
        fun isSymmetric1(root: TreeNode?): Boolean {
            if (root == null) return true

            fun compare(left: TreeNode?, right: TreeNode?): Boolean {
                if (left == null && right == null) return true

                if (left?.`val` == right?.`val`) {
                    val isLeft = compare(left?.left, right?.right)
                    val isRight = compare(left?.right, right?.left)
                    return isLeft && isRight
                } else {
                    return false
                }
            }
            return compare(root.left, root.right)
        }

        fun isSymmetric(root: TreeNode?): Boolean {
            if (root == null) return true
            val stack = ArrayDeque<Pair<TreeNode?, TreeNode?>>()
            if (root.left != null || root.right != null) {
                stack.addLast(root.left to root.right)
            }
            while (stack.isNotEmpty()) {
                val size = stack.size
                repeat(size) {
                    val node = stack.removeFirst()
                    if (node.first?.`val` != node.second?.`val`) {
                        return false
                    }
                    if (node.first?.left != null || node.second?.right != null) {
                        stack.addLast(node.first?.left to node.second?.right)
                    }
                    if (node.first?.right != null || node.second?.left != null) {
                        stack.addLast(node.first?.right to node.second?.left)
                    }
                }
            }
            return true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.isSymmetric(
                TreeNode.createRoot(
                    arrayOf(1, 2, 2, 3, 4, 4, 3)
                )
            ).print(true)
            solution.isSymmetric(
                TreeNode.createRoot(
                    arrayOf(1, 2, 2, null, 3, null, 3)
                )
            ).print(false)
            solution.isSymmetric(
                TreeNode.createRoot(
                    arrayOf(0, 1)
                )
            ).print(false)
            solution.isSymmetric(
                TreeNode.createRoot(
                    arrayOf(2, 3, 3, 4, null, 5, 4)
                )
            ).print(false)
        }
    }
}