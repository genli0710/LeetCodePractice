package leetcode.editor.en

import leetcode.editor.common.*

class invert_binary_tree {

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

        private fun TreeNode.printByLevel() {
            val queue = ArrayDeque<TreeNode>()
            queue.addLast(this)
            while (queue.isNotEmpty()) {
                val node = queue.removeLast()
                print("${node.`val`},")
                node.left?.let {
                    queue.addFirst(it)
                }
                node.right?.let {
                    queue.addFirst(it)
                }
            }
            println()
        }

        fun invertTree1(root: TreeNode?): TreeNode? {
            // create new tree
            if(root==null) return null

            root.printByLevel()

            fun dfs(root: TreeNode?, newTree: TreeNode?) {
                if (root == null || newTree == null) {
                    return
                }
                newTree.right = root.left?.let {
                    TreeNode(it.`val`)
                }
                newTree.left = root.right?.let {
                    TreeNode(it.`val`)
                }

                dfs(root.left, newTree.right)
                dfs(root.right, newTree.left)
            }

            val newTree = TreeNode(root.`val`)
            dfs(root, newTree)

            newTree.printByLevel()
            return newTree
        }

        fun invertTree(root: TreeNode?): TreeNode? {
            // invert without new node
            if (root == null) {
                return null
            }
            val temp = root.left
            root.left = invertTree(root.right)
            root.right = invertTree(temp)
            return root
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.invertTree(TreeNode.createRoot(arrayOf(4,2,7,1,3,6,9)))
        }
    }
}