fun main() {
    fun part1(input: List<String>): Int {
        val data = input.map { j ->
            j.split(",")
                .map { k ->
                    k.split("-")
                        .map { it.toInt() }
                }
                .map { (it.first()..it.last()).toList() }
        }.filter { it.first().containsAll(it.last()) || it.last().containsAll(it.first()) }

        return data.size
    }

    fun part2(input: List<String>): Int {
        val data = input.map { j ->
            j.split(",")
                .map { k ->
                    k.split("-")
                        .map { it.toInt() }
                }
                .map { (it.first()..it.last()).toList() }
        }.filter {
            it.first().intersect(it.last().toSet()).toSet().isNotEmpty()
        }

        return data.size
    }

    val testInput = getTestInput()
    check(part1(testInput) == 2)

    val input = getInput()
    println(part1(input))
    check(part2(testInput) == 4)
    println(part2(input))
}
