package leetcode.editor.en

import leetcode.editor.common.*
import java.util.LinkedList

class populating_next_right_pointers_in_each_node_ii {
    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null

        companion object {
            // 按照力扣的序列化规则输入生成二叉树，返回根节点
            fun createRoot(nums: Array<Int?>): Node? {
                if (nums.size == 0) {
                    return null
                }
                val root = Node(nums[0]!!)
                val tree = arrayOfNulls<Node>(nums.size)
                tree[0] = root
                for (i in 1 until nums.size) {
                    if (nums[i] != null) {
                        tree[i] = Node(nums[i]!!)
                    }
                }
                for (i in nums.indices) {
                    if (tree[i] != null) {
                        if (2 * i + 1 < nums.size) {
                            tree[i]!!.left = tree[2 * i + 1]
                        }
                        if (2 * i + 2 < nums.size) {
                            tree[i]!!.right = tree[2 * i + 2]
                        }
                    }
                }
                return root
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun connect(root: Node?): Node? {
            if (root == null) return null
            val queue = ArrayDeque<Node>()
            queue.addLast(root)
            while (queue.isNotEmpty()){
                val list = queue.toList()
                for (i in 1 until list.size) {
                    list[i - 1].next = list[i]
                }

                val size = queue.size
                repeat(size) {
                    val node = queue.removeFirst()
                    node.left?.let {
                        queue.addLast(it)
                    }
                    node.right?.let {
                        queue.addLast(it)
                    }
                }
            }
            return root
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.connect(
                Node.createRoot(
                    arrayOf(1, 2, 3, 4, 5, null, 7)
                )
            )
        }
    }
}