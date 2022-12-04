fun main() {

    val abc = "abcdefghijklmnopqrstuvwxyz"
    val chars = abc + abc.uppercase()


    fun part1(input: List<String>): Int {
        val result = input
            .map { it.trim().toCharArray().toList() }
            .map {
                Pair(it.subList(0, it.size / 2), it.subList(it.size / 2, it.size))
            }.sumOf { pair ->
                pair.first
                    .intersect(pair.second.toSet())
                    .sumOf { (chars.indexOf(it) + 1) }
            }

        return result
    }

    fun part2(input: List<String>): Int {
        val result = input
            .map { it.trim().toCharArray().toList() }.chunked(3)
            .flatMap { lists ->
                lists[0]
                    .intersect(lists[1].toSet()).intersect(lists[2].toSet())

            }.sumOf { (chars.indexOf(it) + 1) }

        return result
    }

    val testInput = getTestInput()
    check(part1(testInput) == 157)


    val input = getInput()
    check(part2(testInput) == 70)

    println(part1(input))
    println(part2(input))
}
