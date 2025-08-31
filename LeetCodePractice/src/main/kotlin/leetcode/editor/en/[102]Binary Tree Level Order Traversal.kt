package leetcode.editor.en

import leetcode.editor.common.*

class binary_tree_level_order_traversal {

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
        fun levelOrder1(root: TreeNode?): List<List<Int>> {
            // custom way
            if (root == null) return listOf()

            val deque = ArrayDeque<Pair<TreeNode,Int>>()
            deque.addLast(root to 0)
            val arr = mutableListOf<Pair<TreeNode,Int>>()
            while (deque.isNotEmpty()) {
                val node = deque.removeFirst()
                arr.add(node)
                if (node.first.left != null) {
                    deque.addLast(node.first.left!! to node.second + 1)
                }
                if (node.first.right != null) {
                    deque.addLast(node.first.right!! to node.second +1)
                }
            }

            val groupBy = arr.groupBy { it.second }.map {
                val element = it.value.map {
                    it.first.`val`
                }
                element
            }

            return groupBy
        }

        fun levelOrder(root: TreeNode?): List<List<Int>> {
            // standard way
            if (root == null) return listOf()

            val deque = ArrayDeque<TreeNode>()
            deque.addLast(root)
            val result = mutableListOf<List<Int>>()
            while (deque.isNotEmpty()) {
                val levelBreadth = deque.size
                val list = mutableListOf<Int>()
                repeat(levelBreadth) {
                    val node = deque.removeFirst()
                    list.add(node.`val`)
                    node.left?.let {
                        deque.addLast(it)
                    }
                    node.right?.let {
                        deque.addLast(it)
                    }
                }
                result.add(list)
            }
            return result
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.levelOrder(
                TreeNode.createRoot(
                    arrayOf(3,9,20,null,null,15,7)
                )
            )
        }
    }
}