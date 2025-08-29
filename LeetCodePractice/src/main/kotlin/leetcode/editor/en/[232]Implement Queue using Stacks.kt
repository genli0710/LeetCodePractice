package leetcode.editor.en

import kotlin.collections.ArrayDeque

class implement_queue_using_stacks {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue() {
        val forwardQueue = ArrayDeque<Int>()
        val reverseQueue = ArrayDeque<Int>()

        fun push(x: Int) {
            if (empty()) {
                forwardQueue.addLast(x)
            } else if (forwardQueue.isNotEmpty()) {
                forwardQueue.addLast(x)
            } else if (reverseQueue.isNotEmpty()) {
                repeat(reverseQueue.size) {
                    forwardQueue.addLast(reverseQueue.removeLast())
                }
                forwardQueue.addLast(x)
            }
        }

        fun pop(): Int {
            if (reverseQueue.isNotEmpty()) {
                return reverseQueue.removeLast()
            }

            if (forwardQueue.isNotEmpty()) {
                repeat(forwardQueue.size) {
                    reverseQueue.addLast(forwardQueue.removeLast())
                }
                return reverseQueue.removeLast()
            }
            return -1
        }

        fun peek(): Int {
            if (reverseQueue.isNotEmpty()) {
                return reverseQueue.last()
            }

            if (forwardQueue.isNotEmpty()) {
                repeat(forwardQueue.size) {
                    reverseQueue.addLast(forwardQueue.removeLast())
                }
                return reverseQueue[reverseQueue.lastIndex]
            }
            return -1
        }

        fun empty(): Boolean {
            return reverseQueue.isEmpty() && forwardQueue.isEmpty()
        }

    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * var obj = MyQueue()
     * obj.push(x)
     * var param_2 = obj.pop()
     * var param_3 = obj.peek()
     * var param_4 = obj.empty()
     */
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val solution = Solution()
            // put your test code here
            val queue = MyQueue()
            queue.push(1)
            queue.push(2)
            queue.push(3)
            queue.push(4)
            println(queue.pop())
            queue.push(5)
            println(queue.pop())
            println(queue.pop())
            println(queue.pop())
            println(queue.pop())
        }
    }
}