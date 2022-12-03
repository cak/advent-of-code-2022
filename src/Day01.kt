import java.io.File

fun main() {
    fun part1(input: String): Int {
        val elfCaf =
            input.split("\n\n").map { it.split("\n") }.map { cal -> cal.map { it.toInt() } }.map { it.sum() }.sorted()
                .reversed()
        return elfCaf[0]
    }

    fun part2(input: String): Int {
        val elfCaf =
            input.split("\n\n").map { it.split("\n") }.map { cal -> cal.map { it.toInt() } }.map { it.sum() }.sorted()
                .reversed()
        return elfCaf.take(3).sum()
    }

    val testInput = File("src", "input_test.txt").readText()
    check(part1(testInput) == 24000)

    val input = File("src", "input.txt").readText()
    println(part1(input))
    println(part2(input))
}
