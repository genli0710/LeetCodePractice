package leetcode.editor.en

class copy_list_with_random_pointer {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Example:
     * var ti = Node(5)
     * var v = ti.`val`
     * Definition for a Node.
     * class Node(var `val`: Int) {
     *     var next: Node? = null
     *     var random: Node? = null
     * }
     */
    class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }

    class Solution {
        fun copyRandomList(node: Node?): Node? {
            val newHead = Node(-1)
            var cur = node
            var newCur: Node? = newHead
            val cache = HashMap<Node, Node>()
            while (cur != null) {
                if (cache[cur] != null) {
                    newCur?.next = cache[cur]
                } else {
                    val newNode = Node(cur.`val`)
                    newCur?.next = newNode
                    cache[cur] = newNode
                }
                cur = cur.next
                newCur = newCur?.next
            }
            newCur = newHead.next
            cur = node
            while (cur != null) {
                if (cur.random != null) {
                    val newRandom = if (cache[cur.random] != null) {
                        cache[cur.random]
                    } else {
                        val newRandomNode = Node(cur.random!!.`val`)
                        cache[cur.random!!] = newRandomNode
                        newRandomNode
                    }
                    newCur?.random = newRandom
                }
                cur = cur.next
                newCur = newCur?.next
            }

            return newHead.next
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            val nodes = Array<Node?>(5) { null }
            nodes[0] = Node(7)
            nodes[1] = Node(13)
            nodes[2] = Node(11)
            nodes[3] = Node(10)
            nodes[4] = Node(1)

            // next 链接
            for (i in 0 until nodes.size - 1) {
                nodes[i]!!.next = nodes[i + 1]
            }

            // random 链接
            nodes[0]!!.random = null
            nodes[1]!!.random = nodes[0]
            nodes[2]!!.random = nodes[4]
            nodes[3]!!.random = nodes[2]
            nodes[4]!!.random = nodes[0]
            solution.copyRandomList(nodes[0])
        }
    }
}