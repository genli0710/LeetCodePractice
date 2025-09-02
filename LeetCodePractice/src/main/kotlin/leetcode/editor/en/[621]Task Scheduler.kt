package leetcode.editor.en

import leetcode.editor.common.*
import java.util.PriorityQueue

class task_scheduler {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Task(val index: Int, var count: Int, var time: Int)

        fun leastInterval(tasks: CharArray, n: Int): Int {
            val heap = PriorityQueue<Task>() { t1, t2 ->
                t2.count - t1.count
            }
            val queue = ArrayDeque<Task>()
            val taskArr = Array<Task>(26) {
                Task(it, 0, 0)
            }
            tasks.forEach {
                taskArr[it - 'A'].count += 1
            }
            heap.addAll(taskArr.filter { it.count > 0 })

            var time = 0
            while (heap.isNotEmpty() || queue.isNotEmpty()) {
                if (heap.size > 0) {
                    val cur = heap.poll()
                    cur.count -= 1
                    cur.time = time + n
                    if (cur.count > 0) {
                        queue.addLast(cur)
                    }
                }

                while (queue.isNotEmpty() && queue.first().time == time) {
                    heap.add(queue.removeFirst())
                }
                time++
            }

            return time
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(
                solution.leastInterval(
                    charArrayOf(
                        'A', 'A', 'A', 'B', 'B', 'B'
                    ),
                    2
                )
            )

            println(
                solution.leastInterval(
                    charArrayOf(
                        'A', 'A', 'A', 'B', 'B', 'B'
                    ),
                    3
                )
            )

            println(
                solution.leastInterval(
                    charArrayOf(
                        'A', 'C', 'A', 'B', 'D', 'B'
                    ),
                    1
                )
            )
        }
    }
}