fun main() {
    fun partOneAndTwo(input: String, i: Int): Int {
        val arrayInput = input.toCharArray()
        var index = i
        while (index < arrayInput.size) {
            val setInput = arrayInput.slice((index - i) until index).toSet()
            if (setInput.size == i) {
                return index
            }

            index++
        }

        return index
    }


    val testInput = getTestInputString()
    println(partOneAndTwo(testInput, 4))
    check(partOneAndTwo(testInput, 4) == 7)

    val input = getInputString()
    println(partOneAndTwo(input, 4))
    check(partOneAndTwo("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 14) == 26)
    println(partOneAndTwo(input, 14))
}
