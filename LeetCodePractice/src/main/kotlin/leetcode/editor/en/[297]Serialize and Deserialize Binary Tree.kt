package leetcode.editor.en

import leetcode.editor.common.*

class serialize_and_deserialize_binary_tree {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */

    class Codec() {
        // Encodes a URL to a shortened URL.
        fun serialize(root: TreeNode?): String {
            if (root == null) return "#"
            var res = StringBuilder()
            val queue = ArrayDeque<TreeNode>()
            queue.addLast(root)
            res.append(root.`val`).append(",")
            while (queue.isNotEmpty()) {
                val length = queue.size
                repeat(length) {
                    val node = queue.removeFirst()
                    res.append(if (node.left == null) "#," else "${node.left?.`val`},")
                    res.append(if (node.right == null) "#," else "${node.right?.`val`},")
                    node.left?.let {
                        queue.addLast(it)
                    }
                    node.right?.let {
                        queue.addLast(it)
                    }
                }
            }

            return res.toString()
        }

        // Decodes your encoded data to tree.
        fun deserialize(data: String): TreeNode? {
            if (data == "#") return null
            val split = data.split(',').toMutableList()
            var index = 0
            val queue = ArrayDeque<TreeNode>()
            val root = TreeNode(split[0].toInt())
            queue.addLast(root)
            index++
            while (queue.isNotEmpty() && index < split.size) {
                val node = queue.removeFirst()
                if (split[index] != "#") {
                    val left = TreeNode(split[index].toInt())
                    node.left = left
                    queue.addLast(left)
                }
                index++

                if (index >= split.size) {
                    break
                }

                if (split[index] != "#") {
                    val right = TreeNode(split[index].toInt())
                    node.right = right
                    queue.addLast(right)
                }
                index++
            }

            return root
        }
    }

    /**
     * Your Codec object will be instantiated and called as such:
     * var ser = Codec()
     * var deser = Codec()
     * var data = ser.serialize(longUrl)
     * var ans = deser.deserialize(data)
     */
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val codec = Codec()
            val node = codec.deserialize("4,-7,-3,#,#,-9,-3,9,-7,-4,#,6,#,-6,-6,#,#,0,6,5,#,9,#,#,-1,-4,#,#,#,-2")
            val serialize = codec.serialize(node)
            println(serialize)
        }
    }
}