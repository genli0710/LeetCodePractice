package leetcode.editor.en

import leetcode.editor.common.*

class four_sum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
            // 去重和剪枝是难点
            nums.sort()
            val res = mutableListOf<List<Int>>()
            val size = nums.size
            for (i in 0 until size - 3) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue
                }
                if (nums[i] * 1L + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break
                }
                if (nums[i] * 1L + nums[size - 1] + nums[size - 2] + nums[size - 3] < target) {
                    continue
                }

                for (j in i + 1 until size - 2) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue
                    }
                    if (nums[i] * 1L + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break
                    }

                    if (nums[i] * 1L + nums[j] + nums[size - 1] + nums[size - 2] < target) {
                        continue
                    }

                    var left = j + 1
                    var right = nums.size - 1
                    while (left < right) {
                        val sum: Long = nums[i] * 1L + nums[j] + nums[left] + nums[right]
                        if (sum == target * 1L) {
                            res.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++
                            }
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--
                            }
                            left++
                            right--
                        } else if (sum < target) {
                            left++
                        } else {
                            right--
                        }
                    }
                }
            }
            return res
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            // put your test code here
            println(solution.fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0))
            println(solution.fourSum(intArrayOf(2, 2, 2, 2, 2), 8))
            println(solution.fourSum(intArrayOf(-2, -1, -1, 1, 1, 2, 2), 0))
            println(solution.fourSum(intArrayOf(0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000), 1000000000))
        }
    }
}