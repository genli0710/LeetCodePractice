package leetcode.editor.en

import leetcode.editor.common.*

class sum_root_to_leaf_numbers {

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
        fun sumNumbers1(root: TreeNode?): Int {
            if (root == null) return 0
            var sum = 0
            val stack = ArrayDeque<Int>()
            fun dfs(node: TreeNode) {
                if (node.left == null && node.right == null) {
                    stack.addLast(node.`val`)
                    sum += stack.toList().fold(0) { acc, i ->
                        acc * 10 + i
                    }
                    stack.removeLast()
                    return
                }
                stack.addLast(node.`val`)
                node.left?.let {
                    dfs(it)
                }
                node.right?.let {
                    dfs(it)
                }
                stack.removeLast()
            }
            dfs(root)
            return sum
        }

        fun sumNumbers(root: TreeNode?): Int {
            if (root == null) return 0
            fun dfs(node: TreeNode, sum: Int): Int {
                val cur = sum * 10 + node.`val`
                if (node.left == null && node.right == null) {
                    return cur
                }
                var left = 0
                node.left?.let {
                    left = dfs(it, cur)
                }
                var right = 0
                node.right?.let {
                    right = dfs(it, cur)
                }
                return left + right
            }

            return dfs(root, 0)
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
//            solution.sumNumbers(
//                TreeNode.createRoot(
//                    arrayOf(1, 2, 3)
//                )
//            ).print(25)

            solution.sumNumbers(
                TreeNode.createRoot(
                    arrayOf(4, 9, 0, 5, 1)
                )
            ).print(1026)
        }
    }
}