package leetcode.editor.en

import leetcode.editor.common.ListNode
import java.lang.IllegalArgumentException

class CreateLinkList {

    private fun print(node: ListNode?) {
        if (node == null) {
            print("null")
            return
        }

        var cur = node
        while (cur != null) {
            print("${cur.`val`} ->")
            cur = cur.next
        }
        println()
    }

    fun create(nums: IntArray): ListNode {
        val head = ListNode(nums[0])
        var cur: ListNode = head
        for (i in 1 until nums.size) {
            cur.next = ListNode(nums[i]).also {
                cur = it
            }
        }

        return head
    }

    fun insert(head: ListNode, insertNum: Int, insertIndex: Int): ListNode {
        if (insertIndex == 0) {
            val newNode = ListNode(insertNum)
            newNode.next = head
            return newNode
        }

        var cur = head
        repeat(insertIndex - 1) {
            if (head.next == null) {
                throw IllegalArgumentException("position illegal")
            }
            cur = cur.next!!
        }

        val newNode = ListNode(insertNum)
        newNode.next = cur.next
        cur.next = newNode

        return head
    }

    fun delete(head: ListNode, deleteIndex: Int): ListNode? {
        if (deleteIndex == 0) {
            return head.next
        }

        var cur = head
        repeat(deleteIndex - 1) {
            if (head.next == null) {
                throw IllegalArgumentException("position illegal")
            }
            cur = cur.next!!
        }

        val deletion = cur.next?.next
        cur.next = cur.next?.next
        deletion?.next = null
        return head
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = CreateLinkList()
            var node = solution.create(intArrayOf(1, 3, 5, 6, 7))
            solution.print(node)

//            node = solution.insert(node, 0, 1)
//            solution.print(node)

            val node2 = solution.delete(node, 1)
            solution.print(node2)
        }
    }

}