package leetcode.editor.en

import leetcode.editor.common.*

class construct_binary_tree_from_inorder_and_postorder_traversal {

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
        fun buildTree1(inorder: IntArray, postorder: IntArray): TreeNode? {
            fun build(
                inLeft: Int, inRight: Int,
                postLeft: Int, postRight: Int
            ): TreeNode? {
                if (inLeft == inRight) return TreeNode(inorder[inLeft])

                val rootValue = postorder[postRight]
                val rootIndex = inorder.indexOf(rootValue) // could be faster
                val node = TreeNode(rootValue)
                val leftLength = rootIndex - inLeft
                node.left = build(inLeft, rootIndex - 1, postLeft, postLeft + leftLength - 1)
                node.right = build(rootIndex + 1, inRight, postLeft + leftLength, postRight - 1)

                return node
            }
            return build(0, inorder.size - 1, 0, postorder.size - 1)
        }

        fun buildTree2(inorder: IntArray, postorder: IntArray): TreeNode? {
            val map = inorder.withIndex().associate { it.value to it.index }
            fun build(
                inLeft: Int, inRight: Int,
                postLeft: Int, postRight: Int
            ): TreeNode? {
                if (inLeft == inRight) return TreeNode(inorder[inLeft])

                val rootValue = postorder[postRight]
                val rootIndex = map[rootValue]!!
                val node = TreeNode(rootValue)
                val leftLength = rootIndex - inLeft
                node.left = build(inLeft, rootIndex - 1, postLeft, postLeft + leftLength - 1)
                node.right = build(rootIndex + 1, inRight, postLeft + leftLength, postRight - 1)

                return node
            }
            return build(0, inorder.size - 1, 0, postorder.size - 1)
        }

        fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
            val map = inorder.withIndex().associate { it.value to it.index }

            var rootPosition = postorder.lastIndex
            fun build(inL: Int, inR: Int): TreeNode? {
                if (inL > inR) return null
                val root = postorder[rootPosition--]
                val rootIndex = map[root]!!
                return TreeNode(root).apply {
                    right = build(rootIndex + 1, inR)
                    left = build(inL, rootIndex - 1)
                }
            }
            return build(0, inorder.size - 1)
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            val treeNode = solution.buildTree(
                intArrayOf(9, 3, 15, 20, 7),
                intArrayOf(9, 15, 7, 20, 3),
            )
            treeNode
        }
    }
}