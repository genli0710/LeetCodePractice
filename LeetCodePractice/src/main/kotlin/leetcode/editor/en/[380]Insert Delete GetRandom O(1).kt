package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.random.Random

class insert_delete_getrandom_o1 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet() {
        val arr = mutableListOf<Int>()
        val map = HashMap<Int, Int>()

        fun insert(`val`: Int): Boolean {
            if (map.contains(`val`)) {
                return false
            } else {
                arr.add(`val`)
                map[`val`] = arr.size - 1
                return true
            }
        }

        fun remove(`val`: Int): Boolean {
            if (map.contains(`val`)) {
                // 被删的元素的位置
                val index = map[`val`]!!
                if (index != arr.lastIndex) {

                    val lastValue = arr.last()
                    arr[index] = lastValue
                    map[lastValue] = index
                }
                arr.removeLast()
                map.remove(`val`)

                return true
            } else {
                return false
            }
        }

        fun getRandom(): Int {
            val randomIndex = Random.nextInt(arr.size)
            return arr[randomIndex]
        }

    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * var obj = RandomizedSet()
     * var param_1 = obj.insert(`val`)
     * var param_2 = obj.remove(`val`)
     * var param_3 = obj.getRandom()
     */
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val solution = Solution()
            // put your test code here
            val set = RandomizedSet()
            println(set.insert(-20))   // true
            println(set.insert(-47))   // true
            println(set.remove(-20))   // true
            println(set.remove(-47))   // true
            println(set.insert(-119))  // true
            println(set.insert(-119))  // false
            println(set.remove(-119))  // true
            println(set.insert(-99))   // true
            println(set.remove(-99))   // true
            println(set.insert(-121))  // true

            // 第一次 getRandom
            println("getRandom: ${set.getRandom()}") // 期望: -121
        }
    }
}