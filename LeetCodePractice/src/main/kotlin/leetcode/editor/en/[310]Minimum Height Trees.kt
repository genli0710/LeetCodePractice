package leetcode.editor.en

class minimum_height_trees {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
            if (edges.isEmpty()) return listOf(0)
            val degree = IntArray(n)
            val graph = Array(n) { mutableListOf<Int>() }
            for (edge in edges) {
                val start = edge[0]
                val end = edge[1]

                graph[start] += end
                graph[end] += start
                degree[start] += 1
                degree[end] += 1
            }


            val arrayDeque = ArrayDeque<Int>()
            for (i in degree.indices) {
                if (degree[i] == 1) {
                    arrayDeque.addLast(i)
                }
            }

            var remain = n
            while (remain > 2) {
                val size = arrayDeque.size
                remain -= size
                repeat(size) {
                    val leaf = arrayDeque.removeFirst()
                    val adjacent = graph[leaf]
                    degree[leaf] -= 1

                    for (adj in adjacent) {
                        degree[adj] -= 1
                        if (degree[adj] == 1) {
                            arrayDeque.addLast(adj)
                        }
                    }
                }
            }
            return arrayDeque
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.findMinHeightTrees(
                4,
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(1, 2),
                    intArrayOf(1, 3)
                )
            )
        }
    }
}