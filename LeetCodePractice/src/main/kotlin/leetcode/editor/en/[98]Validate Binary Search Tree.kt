package leetcode.editor.en

import leetcode.editor.common.*

class validate_binary_search_tree {

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
        fun isValidBST(root: TreeNode?): Boolean {

            val arr = mutableListOf<Int>()
            fun inOrderTraversal(root: TreeNode?) {
                if (root == null) {
                    return
                }
                inOrderTraversal(root.left)
                arr.add(root.`val`)
                inOrderTraversal(root.right)
            }
            inOrderTraversal(root)
            for (i in 1 until arr.size) {
                if (arr[i] <= arr[i - 1]) {
                    return false
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
        }
    }
}