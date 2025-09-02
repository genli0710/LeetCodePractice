package leetcode.editor.en

import leetcode.editor.common.*

class word_ladder {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun ladderLength1(beginWord: String, endWord: String, wordList: List<String>): Int {
            // hash check
            val hashSet = wordList.toHashSet()
            val deque = ArrayDeque<String>()
            if (!hashSet.contains(endWord)) {
                return 0
            }
            var step = 1
            val stepSet = HashSet<String>()
            stepSet.add(beginWord)
            deque.addLast(beginWord)
            while (deque.isNotEmpty()) {
                val length = deque.size
                repeat(length) {
                    val current = deque.removeFirst()
                    if (current == endWord) {
                        return step
                    }
                    for (i in current.indices) {
                        for (char in 'a'..'z') {
                            val temp = StringBuilder(current)
                            temp.setCharAt(i, char)
                            val nextWord = temp.toString()
                            if (hashSet.contains(nextWord) && !stepSet.contains(nextWord)) {
                                deque.addLast(nextWord)
                                stepSet.add(nextWord)
                            }
                        }
                    }
                }
                step++
            }
            return 0
        }

        fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
            val queue = ArrayDeque<String>()
            val visited = HashSet<String>()
            val map = HashMap<String, HashSet<String>>()
            for (word in wordList) {
                for (i in word.indices) {
                    val sb = StringBuilder(word)
                    sb.setCharAt(i, '*')
                    val set = map.getOrPut(sb.toString()) {
                        HashSet()
                    }
                    set.add(word)
                }
            }
            // start checking
            visited.add(beginWord)
            queue.add(beginWord)
            var step = 1
            while (queue.isNotEmpty()) {
                val length = queue.size
                repeat(length) {
                    val current = queue.removeFirst()
                    if (current == endWord) {
                        return step
                    }
                    for (i in current.indices) {
                        val sb = StringBuilder(current)
                        sb.setCharAt(i, '*')
                        val matches = map[sb.toString()]?.filter { !visited.contains(it) }
                        if (matches != null) {
                            visited.add(current) //入队时就标记,避免重复添加
                            queue.addAll(matches)
                        }
                    }
                }
                step++
            }
            return 0
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            println(
                solution.ladderLength(
                    "hit", "cog",
                    listOf("hot", "dot", "dog", "lot", "log", "cog")
                )
            )
//        println(
//            solution.ladderLength(
//                "a", "c",
//                listOf("a", "b", "c")
//            )
//        )
        }
    }
}