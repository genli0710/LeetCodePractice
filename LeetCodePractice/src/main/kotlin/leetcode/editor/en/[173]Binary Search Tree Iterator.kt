package leetcode.editor.en

import leetcode.editor.common.*

class binary_search_tree_iterator {

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
    class BSTIterator1(root: TreeNode?) {

        val queue = ArrayDeque<TreeNode>()

        init {
            if (root != null) {
                fun dfs(node: TreeNode?) {
                    if (node == null) return
                    dfs(node.left)
                    queue.add(node)
                    dfs(node.right)
                }
                dfs(root)
                queue
            }
        }

        fun next(): Int {
            return queue.removeFirst().`val`
        }

        fun hasNext(): Boolean {
            return queue.isNotEmpty()
        }

    }

    class BSTIterator(root: TreeNode?) {
        val stack = ArrayDeque<TreeNode>()

        init {
            pushLeft(root)
        }

        private fun pushLeft(root: TreeNode?) {
            var cur = root
            while (cur != null) {
                stack.addLast(cur)
                cur = cur.left
            }
        }

        fun next(): Int {
            val cur = stack.removeLast()
            if (cur.right != null) {
                pushLeft(cur.right)
            }
            return cur.`val`
        }

        fun hasNext(): Boolean {
            return stack.isNotEmpty()
        }

    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * var obj = BSTIterator(root)
     * var param_1 = obj.next()
     * var param_2 = obj.hasNext()
     */
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val bst = BSTIterator(
                TreeNode.createRoot(
                    arrayOf(7, 3, 15, null, null, 9, 20)
                )
            )
            bst.next().print(3)
            bst.next().print(7)
            bst.hasNext().print(true)
            bst.next().print(9)
            bst.hasNext().print(true)
            bst.next().print(15)
            bst.hasNext().print(true)
            bst.next().print(20)
            bst.hasNext().print(false)
        }
    }
}