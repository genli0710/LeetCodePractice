package leetcode.editor.common

data class ListNode(var `val`: Int, var next: ListNode? = null) {

    companion object {
        @JvmStatic
        fun create(nums: IntArray): ListNode? {
            if (nums.isEmpty()) {
                return null
            }

            val head = ListNode(nums[0])
            var current = head
            for (i in 1 until nums.size) {
                current.next = ListNode(nums[i])
                current = current.next!!
            }
            return head
        }

        @JvmStatic
        fun print(head: ListNode?) {
            var current = head
            while (current != null) {
                val arrow = if (current.next != null) " -> " else ""
                print("${current.`val`}$arrow")
                current = current.next
            }
            println()
        }
    }
}