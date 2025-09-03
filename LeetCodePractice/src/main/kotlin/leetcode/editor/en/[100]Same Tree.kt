package leetcode.editor.en

import leetcode.editor.common.*

class same_tree {

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
        fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
            if (p == null && p == q) {
                return true
            }

            val l = isSameTree(p?.left, q?.left)
            val r = isSameTree(p?.right, q?.right)

            return l && r && p?.`val` == q?.`val`
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