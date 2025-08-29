package leetcode.editor.common

class TreeNode {
    var `val`: Int = 0
    var left: TreeNode? = null
    var right: TreeNode? = null

    constructor()

    constructor(x: Int) {
        `val` = x
    }

    constructor(x: Int, left: TreeNode?, right: TreeNode?) {
        `val` = x
        this.left = left
        this.right = right
    }


    companion object {
        // 按照力扣的序列化规则输入生成二叉树，返回根节点
        fun createRoot(nums: Array<Int?>): TreeNode? {
            if (nums.size == 0) {
                return null
            }
            val root = TreeNode(nums[0]!!)
            val tree = arrayOfNulls<TreeNode>(nums.size)
            tree[0] = root
            for (i in 1 until nums.size) {
                if (nums[i] != null) {
                    tree[i] = TreeNode(nums[i]!!)
                }
            }
            for (i in nums.indices) {
                if (tree[i] != null) {
                    if (2 * i + 1 < nums.size) {
                        tree[i]!!.left = tree[2 * i + 1]
                    }
                    if (2 * i + 2 < nums.size) {
                        tree[i]!!.right = tree[2 * i + 2]
                    }
                }
            }
            return root
        }
    }
}