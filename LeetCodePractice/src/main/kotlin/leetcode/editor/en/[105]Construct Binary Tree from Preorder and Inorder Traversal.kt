package leetcode.editor.en

import leetcode.editor.common.*

class construct_binary_tree_from_preorder_and_inorder_traversal {

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
        fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
            if (preorder.isEmpty()) return null
            val rootInPre = preorder[0]
            val rootInIn = inorder.withIndex().find { it.value == rootInPre }!!.index
            val leftArrayIn = inorder.slice(0 until rootInIn).toIntArray()
            val rightArrayIn = inorder.slice(rootInIn + 1 until inorder.size).toIntArray()

            val leftArrayPre = preorder.slice(1..leftArrayIn.size).toIntArray()
            val rightArrayPre = preorder.slice(leftArrayIn.size + 1 until preorder.size).toIntArray()

            val node = TreeNode(rootInPre)
            node.left = buildTree(leftArrayPre, leftArrayIn)
            node.right = buildTree(rightArrayPre, rightArrayIn)

            return node
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            val buildTree = solution.buildTree(
                intArrayOf(3, 9, 20, 15, 7),
                intArrayOf(9, 3, 15, 20, 7),
            )
            buildTree
        }
    }
}