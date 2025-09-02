package leetcode.editor.en

class find_all_anagrams_in_a_string {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findAnagrams1(s: String, p: String): List<Int> {
            // wrong answer
            val LengthP = p.length
            if (s.length < LengthP) return emptyList()
            val sortP = p.toCharArray().sorted().joinToString()
            val res = mutableListOf<Int>()
            val starts = s.withIndex().filter {
                it.value == sortP.first()
            }.map { it.index }


            for (i in starts) {
                if (i + LengthP > s.length) break
                if (sortP == s.substring(i, i + LengthP).toCharArray().sorted().joinToString()) {
                    res.add(i)
                }
            }
            return res
        }

        fun findAnagrams(s: String, p: String): List<Int> {
            val lengthP = p.length
            val size = s.length
            val frequencyP = IntArray(26)
            val frequencyCur = IntArray(26)
            if (s.length < lengthP) return emptyList()

            //init frequencyP
            p.forEach { frequencyP[it - 'a'] += 1 }
            //init frequencyCur
            for (i in 0 until lengthP) {
                frequencyCur[s[i] - 'a'] += 1
            }

            fun compare(frequencyP: IntArray, frequencyCur: IntArray): Boolean {
                for (i in 0..25) {
                    if (frequencyP[i] != frequencyCur[i]) {
                        return false
                    }
                }
                return true
            }

            val res = hashSetOf<Int>()
            for (i in 0..size - lengthP) {
                if (compare(frequencyP, frequencyCur)) {
                    res.add(i)
                }
                if (i + lengthP < size) {
                    frequencyCur[s[i] - 'a'] -= 1
                    frequencyCur[s[i + lengthP] - 'a'] += 1
                }
            }
            return res.toList()
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
//            println(solution.findAnagrams("abab", "ab"))
            println(solution.findAnagrams("abab", "ab"))

        }
    }
}