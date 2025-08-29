package leetcode.editor.en

import leetcode.editor.common.*

class ransom_note {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun canConstruct(ransomNote: String, magazine: String): Boolean {
            val map = HashMap<Char,Int>()
            repeat(26){
                map['z'- it] = 0
            }
            magazine.forEach {
                map[it] = map[it]!!.plus(1)
            }
            ransomNote.forEach {
                if (map.containsKey(it) && map[it]!! > 0) {
                    map[it] = map[it]!!.minus(1)
                }
                else return false
            }
            return true
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            solution.canConstruct("aa", "aab")
        }
    }
}