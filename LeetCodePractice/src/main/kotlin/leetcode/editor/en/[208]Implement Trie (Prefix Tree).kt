package leetcode.editor.en

import leetcode.editor.common.*

class implement_trie_prefix_tree {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie() {
        val root = Node()

        class Node(val value: String = "") {
            val children = HashMap<String, Node>()
            var isWord = false
        }

        fun insert(word: String) {
            var cur = root
            word.forEach {
                val key = it.toString()
                cur = cur.children.getOrPut(key) { Node(key) }
            }
            if (word.isNotEmpty()) {
                cur.isWord = true
            }
        }

        fun getNode(word: String): Node? {
            var cur = root
            var i = 0
            while (i < word.length) {
                val key = word[i].toString()
                if (cur.children.containsKey(key)) {
                    cur = cur.children[key]!!
                } else {
                    return null
                }
                i++
            }
            return cur
        }

        fun search(word: String): Boolean {
            val cur = getNode(word)
            return cur != null && cur.isWord
        }

        fun startsWith(prefix: String): Boolean {
            val cur = getNode(prefix)
            return cur != null
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * var obj = Trie()
     * obj.insert(word)
     * var param_2 = obj.search(word)
     * var param_3 = obj.startsWith(prefix)
     */
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val trie = Trie()
            trie.insert("apple")
            trie.search("apple")
            trie.search("app")
        }
    }
}