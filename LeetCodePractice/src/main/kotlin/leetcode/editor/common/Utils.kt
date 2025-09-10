package leetcode.editor.common

fun <T> T.print(expected: Any? = null) {
    if (expected == null) {
        println(this)
    } else {
        println("$this expected: $expected")
    }
}