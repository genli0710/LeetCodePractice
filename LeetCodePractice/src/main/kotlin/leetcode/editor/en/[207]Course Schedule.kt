package leetcode.editor.en

import leetcode.editor.common.*

class course_schedule {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun canFinish1(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            val graph = HashMap<Int, HashSet<Int>>()
            prerequisites.forEach {
                val target = it[0]
                val dependency = it[1]
                val start = graph.getOrPut(target) { HashSet() }
                start.add(dependency)
            }
            val visited = BooleanArray(numCourses)
            val queue = ArrayDeque<Int>()
            for (i in 0 until numCourses) {
                for (j in 0 until numCourses) {
                    queue.addLast(j)
                    visited[j] = true
                }
                while (queue.isNotEmpty()) {
                    val length = queue.size
                    repeat(length) {
                        val course = queue.removeFirst()
                        if (graph[course] == null || graph[course]!!.size == 0) {
                            graph.forEach {
                                it.value.remove(course)
                            }
                        } else {
                            val pre = graph[course]!!
                            pre.forEach { p ->
                                if (graph[p] != null && graph[p]!!.size > 0 && !visited[p]) {
                                    queue.addLast(p)
                                }
                            }
                        }
                    }
                }
            }
            graph.forEach {
                if (it.value.size > 0) {
                    return false
                }
            }
            return true
        }

        fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            if (prerequisites.isEmpty()) return true
            val graph = List<MutableList<Int>>(numCourses) {
                mutableListOf()
            }
            val inDegree = IntArray(numCourses)
            prerequisites.forEach {
                val from = it[0]
                val to = it[1]
                graph[to].add(from)
                inDegree[from] += 1
            }
            val queue = ArrayDeque<Int>()
            for (i in inDegree.indices) {
                if (inDegree[i] == 0) {
                    queue.addLast(i)
                }
            }

            var count = 0
            while (queue.isNotEmpty()) {
                val leaf = queue.removeFirst()
                count++
                for (next in graph[leaf]) {
                    inDegree[next] -= 1
                    if (inDegree[next] == 0) {
                        queue.addLast(next)
                    }
                }
            }
            return count == numCourses
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
//            println(
//                solution.canFinish(
//                    4,
//                    arrayOf(
//                        intArrayOf(0, 1),
//                        intArrayOf(0, 3),
//                        intArrayOf(0, 2),
//                        intArrayOf(1, 2),
//                        intArrayOf(1, 3),
//                        intArrayOf(2, 3),
//                    )
//                )
//            )
//            println(
//                solution.canFinish(
//                    2,
//                    arrayOf(
//                        intArrayOf(0, 1),
//                        intArrayOf(1, 0),
//                    )
//                )
//            )
            println(
                solution.canFinish(
                    5,
                    arrayOf(
                        intArrayOf(1, 4),
                        intArrayOf(2, 4),
                        intArrayOf(3, 1),
                        intArrayOf(3, 2),
                    )
                )
            )
        }
    }
}