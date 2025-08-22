package leetcode.editor.cn

class longest_increasing_subsequence {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun lengthOfLIS1(nums: IntArray): Int {
            // dp way
            val dp = IntArray(nums.size)
            dp[0] = 1
            for (i in 1 until nums.size) {
                dp[i] = 1
                for (j in 0 until i) {
                    if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1
                    }
                }
            }
            return dp.max()
        }

        fun lengthOfLIS2(nums: IntArray): Int {
            //recursion way
            val cache = IntArray(nums.size) { -1 }

            fun dfs(i: Int): Int {
                if (i < 0) {
                    return 0
                }

                if (cache[i] != -1) {
                    return cache[i]
                }

                var result = 1
                for (j in 0 until i) {
                    val jLength = dfs(j)
                    if (nums[i] > nums[j] && jLength + 1 > result) {
                        result = jLength + 1
                    }
                }

                cache[i] = result
                return result
            }

            dfs(nums.size - 1)

            return cache.max()
        }

        fun lengthOfLIS3(nums: IntArray): Int {
            // greedy way
            //temp[i] 代表长度为n+1的子串的最后一位数字是啥
            val temp = IntArray(nums.size)
            temp[0] = nums[0]
            var count = 1

            fun findPosition2Insert(temp: IntArray, count: Int, num: Int): Int {
                var start = 0
                var end = count - 1
                while (start <= end) {
                    val mid = (start + end) / 2
                    val midNum = temp[mid]
                    if (num == midNum) {
                        return mid
                    }
                    if (num > midNum) {
                        start = mid + 1
                    } else {
                        end = mid - 1
                    }
                }
                return start
            }

            for (i in 1 until nums.size) {
                val index = findPosition2Insert(temp, count, nums[i])
                temp[index] = nums[i]
                if (index + 1 > count) {
                    count = index + 1
                }
            }

            return count
        }

        fun lengthOfLIS4(nums: IntArray): Int {
            // greedy way
            //temp[i] 代表长度为n+1的子串的最后一位数字是啥
            val temp = IntArray(nums.size)
            temp[0] = nums[0]
            var count = 1

            for (i in 1 until nums.size) {
                val index = temp.binarySearch(nums[i], 0, count)
                val insertIndex = if (index >= 0) index else (-index - 1)
                temp[insertIndex] = nums[i]
                if (insertIndex + 1 > count) {
                    count = insertIndex + 1
                }
            }

            return count
        }

        fun lengthOfLIS(nums: IntArray): Int {
            // greedy way
            //temp[i] 代表长度为n+1的子串的最后一位数字是啥
            val temp = mutableListOf<Int>()

            for (num in nums) {
                val index = temp.binarySearch(num)
                val insertIndex = if (index >= 0) index else (-index - 1)
                if (insertIndex >= temp.size) {
                    temp.add(num)
                } else {
                    temp[insertIndex] = num
                }
            }

            return temp.size
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            solution.lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18))

            val index = intArrayOf(1, 3, 5, 7, 9).binarySearch(11)
            println(index)
            val insertIndex = if (index >= 0) index else (-index - 1)
            println("insertIndex $insertIndex")
            // put your test code here
        }
    }
}