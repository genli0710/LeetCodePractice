package leetcode.editor.en

import leetcode.editor.common.*

class kth_smallest_element_in_a_bst {

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
        fun kthSmallest(root: TreeNode?, k: Int): Int {
            if (root == null) return 0
            val result = mutableListOf<Int>()
            fun dfs(node: TreeNode?) {
                if (node == null) return
                dfs(node.left)
                result.add(node.`val`)
                dfs(node.right)
            }

            dfs(root)
            return result[k - 1]
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