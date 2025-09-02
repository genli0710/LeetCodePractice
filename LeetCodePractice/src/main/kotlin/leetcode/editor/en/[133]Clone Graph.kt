package leetcode.editor.en

class clone_graph {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a Node.

     */
//    class Node(var `val`: Int) {
//        var neighbors: ArrayList<Node?> = ArrayList<Node?>()
//    }

    class Solution {
        fun cloneGraph(node: Node?): Node? {
            if (node == null) return null
            if (node.neighbors.isEmpty()) return Node(1)
            val graph = HashMap<Int, MutableList<Int>>()
            val queue = ArrayDeque<Node>()
            val visited = HashSet<Int>()
            queue.addLast(node)
            visited.add(node.`val`)
            while (queue.isNotEmpty()) {
                val cur = queue.removeFirst()
                visited.add(cur.`val`)
                cur.neighbors.forEach {
                    val list = graph.getOrPut(cur.`val`) {
                        mutableListOf()
                    }
                    if (it != null) {
                        list.add(it.`val`)
                        if (!visited.contains(it.`val`)) {
                            visited.add(it.`val`)
                            queue.addLast(it)
                        }
                    }
                }
            }
            // create node with graph
            val nodeMap = HashMap<Int, Node>()

            graph.forEach {
                val start = it.key
                val neighbors = it.value
                val cur = nodeMap.getOrPut(start) {
                    Node(start)
                }
                neighbors.forEach { nb ->
                    cur.neighbors.add(nodeMap.getOrPut(nb) { Node(nb) })
                }
            }

            return nodeMap[1]
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            val node1 = Solution.Node(1)
            val node2 = Solution.Node(2)
            val node3 = Solution.Node(3)
            val node4 = Solution.Node(4)
            node1.neighbors = arrayListOf(node2, node4)
            node2.neighbors = arrayListOf(node1, node3)
            node3.neighbors = arrayListOf(node2, node4)
            node4.neighbors = arrayListOf(node1, node3)
            solution.cloneGraph(node1)
        }
    }
}