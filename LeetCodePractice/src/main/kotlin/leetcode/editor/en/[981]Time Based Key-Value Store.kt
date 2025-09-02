package leetcode.editor.en

import leetcode.editor.common.*

class time_based_key_value_store {

    //leetcode submit region begin(Prohibit modification and deletion)
    class TimeMap() {
        val data = HashMap<String, MutableList<Pair<Int, String>>>()

        fun set(key: String, value: String, timestamp: Int) {
            val get = data[key]
            if (get != null) {
                get.add(timestamp to value)
            } else {
                data[key] = mutableListOf(timestamp to value)
            }
        }

        fun get(key: String, timestamp: Int): String {
            val get = data[key]
            if (get != null) {
                val index = get.binarySearchBy(timestamp) {
                    it.first
                }
                if (index == -1) {
                    return ""
                }
                if (index >= 0) {
                    return get[index].second
                } else {
                    return get[-(index + 1)-1].second
                }


            } else {
                return ""
            }
        }
    }

    /**
     * Your TimeMap object will be instantiated and called as such:
     * var obj = TimeMap()
     * obj.set(key,value,timestamp)
     * var param_2 = obj.get(key,timestamp)
     */
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val timeMap = TimeMap()
            timeMap.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1.
            println(
                timeMap.get(
                    "foo",
                    1
                )
            )
            println(
                timeMap.get(
                    "foo",
                    3
                )
            )
            timeMap.set("foo", "bar2", 4)
            println(timeMap.get("foo", 4))
            println(timeMap.get("foo", 5))
        }
    }
}