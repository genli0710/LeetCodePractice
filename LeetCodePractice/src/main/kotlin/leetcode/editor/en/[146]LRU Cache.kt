package leetcode.editor.en

import leetcode.editor.common.*

class lru_cache {

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache(val capacity: Int) {
        class Node(val key: Int, var value: Int) {
            var next: Node? = null
            var prev: Node? = null
        }

        private val map = HashMap<Int, Node>()
        private val head = Node(-1, -1)
        private val tail = Node(-1, -1)

        init {
            head.next = tail
            tail.prev = head
        }

        fun get(key: Int): Int {
            val current = map[key] ?: return -1
            updateToHead(current)
            return current.value
        }

        private fun updateToHead(current: Node) {
            removeNode(current)
            addToHead(current)
        }

        private fun addToHead(current: Node) {
            current.prev = head
            current.next = head.next

            head.next?.prev = current
            head.next = current
        }

        private fun removeNode(current: Node) {
            current.next?.prev = current.prev
            current.prev?.next = current.next
        }

        fun put(key: Int, value: Int) {
            val current = map[key]
            if (current == null) {
                if (map.size + 1 > capacity) {
                    val last = tail.prev
                    if (last != null) {
                        removeNode(last)
                        map.remove(last.key)
                    }
                }
                val node = Node(key, value)
                addToHead(node)
                map[key] = node
            } else {
                current.value = value
                updateToHead(current)
            }
        }

        fun print() {
            var cur: Node? = head
            println("正序")
            while (cur != null) {
                print("${cur.value}==>")
                cur = cur.next
            }
            println()
            println("倒序")
            cur = tail
            while (cur != null) {
                print("${cur.value}<==")
                cur = cur.prev
            }
            println()
        }

    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * var obj = LRUCache(capacity)
     * var param_1 = obj.get(key)
     * obj.put(key,value)
     */
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val l = LRUCache(2)
            l.put(1, 1)
            l.print()
            l.put(2, 2)
            l.print()
            println(l.get(1))
            l.print()
            l.put(3, 3)
            l.print()
            println(l.get(2))
        }
    }
}