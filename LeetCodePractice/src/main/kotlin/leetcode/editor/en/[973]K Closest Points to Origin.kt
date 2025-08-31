package leetcode.editor.en

import java.util.PriorityQueue
import kotlin.math.sqrt

class k_closest_points_to_origin {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun kClosest1(points: Array<IntArray>, k: Int): Array<IntArray> {
            // 排序
            val list = mutableListOf<Triple<Int, Int, Double>>()
            for (i in points.indices) {
                val dis =
                    sqrt((points[i][0] * points[i][0]).toDouble() + (points[i][1] * points[i][1]).toDouble())
                list.add(Triple(points[i][0], points[i][1], dis))
            }
            list.sortBy { it.third }
            return list.take(k).map {
                intArrayOf(it.first, it.second)
            }.toTypedArray()
        }

        fun kClosest2(points: Array<IntArray>, k: Int): Array<IntArray> {
            // 排序
            return points.also { it1 ->
                it1.sortBy { it[0] * it[0] + it[1] * it[1] }
            }.take(k).toTypedArray()

        }

        fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
            //大根堆
            val heap = PriorityQueue<IntArray>(k) { a, b ->
                (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
            }
            points.forEach {
                heap.add(it)
                if (heap.size > k) {
                    heap.poll()
                }
            }
            return heap.toTypedArray()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.kClosest(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(-2, 2),
                ),
                1
            )
        }
    }
}