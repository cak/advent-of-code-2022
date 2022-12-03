enum class RockPaperScissors(val bonus: Int) {
    ROCK(1), PAPER(2), SCISSORS(3)
}

enum class End(val score: Int) {
    LOSE(0), DRAW(3), WIN(6)
}

fun main() {

    fun letterToRPS(item: String): RockPaperScissors? {
        return when (item) {
            "A", "X" -> RockPaperScissors.ROCK
            "B", "Y" -> RockPaperScissors.PAPER
            "C", "Z" -> RockPaperScissors.SCISSORS
            else -> null
        }
    }

    fun rpsGame(opponent: RockPaperScissors, you: RockPaperScissors): Int {
        val bonus = you.bonus

        val gamePoint = when (opponent to you) {
            (RockPaperScissors.PAPER to RockPaperScissors.SCISSORS) -> 6
            (RockPaperScissors.PAPER to RockPaperScissors.PAPER) -> 3
            (RockPaperScissors.PAPER to RockPaperScissors.ROCK) -> 0
            (RockPaperScissors.ROCK to RockPaperScissors.PAPER) -> 6
            (RockPaperScissors.ROCK to RockPaperScissors.ROCK) -> 3
            (RockPaperScissors.ROCK to RockPaperScissors.SCISSORS) -> 0
            (RockPaperScissors.SCISSORS to RockPaperScissors.ROCK) -> 6
            (RockPaperScissors.SCISSORS to RockPaperScissors.SCISSORS) -> 3
            (RockPaperScissors.SCISSORS to RockPaperScissors.PAPER) -> 0
            else -> 0
        }

        return bonus + gamePoint
    }

    fun letterToEnd(item: String): End? {
        return when (item) {
            "X" -> End.LOSE
            "Y" -> End.DRAW
            "Z" -> End.WIN
            else -> null
        }
    }

    fun rpsGameTwo(opponent: RockPaperScissors, end: End): Int {
        val outcome = end.score
        val bonus = when (opponent to end) {
            (RockPaperScissors.PAPER to End.LOSE) -> RockPaperScissors.ROCK.bonus
            (RockPaperScissors.PAPER to End.DRAW) -> RockPaperScissors.PAPER.bonus
            (RockPaperScissors.PAPER to End.WIN) -> RockPaperScissors.SCISSORS.bonus
            (RockPaperScissors.ROCK to End.LOSE) -> RockPaperScissors.SCISSORS.bonus
            (RockPaperScissors.ROCK to End.DRAW) -> RockPaperScissors.ROCK.bonus
            (RockPaperScissors.ROCK to End.WIN) -> RockPaperScissors.PAPER.bonus
            (RockPaperScissors.SCISSORS to End.LOSE) -> RockPaperScissors.PAPER.bonus
            (RockPaperScissors.SCISSORS to End.DRAW) -> RockPaperScissors.SCISSORS.bonus
            (RockPaperScissors.SCISSORS to End.WIN) -> RockPaperScissors.ROCK.bonus
            else -> 0
        }
        
        return outcome + bonus
    }


    fun part1(input: List<String>): Int {
        val data = input.map { it.split(" ") }.map { Pair(letterToRPS(it.first()), letterToRPS(it.last())) }
        val total = data.sumOf {
            if (it.first == null || it.second == null) {
                0
            } else {
                rpsGame(it.first!!, it.second!!)
            }
        }
        return total
    }

    fun part2(input: List<String>): Int {
        val data = input.map { it.split(" ") }.map { Pair(letterToRPS(it.first()), letterToEnd(it.last())) }
        val total = data.sumOf {
            if (it.first == null || it.second == null) {
                0
            } else {
                rpsGameTwo(it.first!!, it.second!!)
            }
        }
        return total
    }

    val testInput = getTestInput()
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = getInput()
    println(part1(input))
    println(part2(input))
}
