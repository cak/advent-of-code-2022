fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInput = getTestInput()
    check(part1(testInput) == 1)

    val input = getInput()
    println(part1(input))
    println(part2(input))
}
