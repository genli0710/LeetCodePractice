package leetcode.editor.en

import leetcode.editor.common.*
import kotlin.math.min

class min_stack {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack() {
        val arr = mutableListOf<Int>()

        // first 上一个最大值 second当前最大值
        val minArr = mutableListOf<Int>()

        fun push(`val`: Int) {
            arr.add(`val`)
            if (minArr.isEmpty()) {
                minArr.add(`val`)
            } else {
                val min = minArr.last()
                if (`val` <= min) {
                    minArr.add(`val`)
                }

            }
        }

        fun pop() {
            val last = arr.removeLast()
            if (minArr.last() == last) {
                minArr.removeLast()
            }
        }

        fun top(): Int {
            return arr.last()
        }

        fun getMin(): Int {
            return minArr.last()
        }

    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * var obj = MinStack()
     * obj.push(`val`)
     * obj.pop()
     * var param_3 = obj.top()
     * var param_4 = obj.getMin()
     */
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val stack = MinStack()
            // push(0)
            println("操作: push(0)")
            stack.push(0)

            // push(1)
            println("操作: push(1)")
            stack.push(1)

            // push(0)
            println("操作: push(0)")
            stack.push(0)

            // getMin()
            val getMinResult1 = stack.getMin()
            println("操作: getMin() -> 结果: $getMinResult1") // 预期: 0

            // pop()
            println("操作: pop()")
            stack.pop()

            // getMin()
            val getMinResult2 = stack.getMin()
            println("操作: getMin() -> 结果: $getMinResult2") // 预期: 0

            // pop()
            println("操作: pop()")
            stack.pop()

            // getMin()
            val getMinResult3 = stack.getMin()
            println("操作: getMin() -> 结果: $getMinResult3") // 预期: 0

            // pop()
            println("操作: pop()")
            stack.pop()

            // push(-2)
            println("操作: push(-2)")
            stack.push(-2)

            // push(-1)
            println("操作: push(-1)")
            stack.push(-1)

            // push(-2)
            println("操作: push(-2)")
            stack.push(-2)

            // getMin()
            val getMinResult4 = stack.getMin()
            println("操作: getMin() -> 结果: $getMinResult4") // 预期: -2

            // pop()
            println("操作: pop()")
            stack.pop()

            // top()
            val topResult = stack.top()
            println("操作: top() -> 结果: $topResult") // 预期: -1

            // getMin()
            val getMinResult5 = stack.getMin()
            println("操作: getMin() -> 结果: $getMinResult5") // 预期: -2

            // pop()
            println("操作: pop()")
            stack.pop()

            // getMin()
            val getMinResult6 = stack.getMin()
            println("操作: getMin() -> 结果: $getMinResult6") // 预期: -2

            // pop()
            println("操作: pop()")
            stack.pop()

            println("----------------------------------------")
            println("测试结束。")
        }
    }
}