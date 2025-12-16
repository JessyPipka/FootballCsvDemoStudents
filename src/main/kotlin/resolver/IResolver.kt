package resolver

import model.Player
import model.Team

interface IResolver {

    // Выведите количество игроков, интересы которых не представляет агенство.
    fun countWithoutAgency(players: List<Player>): Int

    // Выведите автора наибольшего числа голов из числа защитников и их количество.
    fun bestScorerDefender(players: List<Player>): Pair<String, Int>?

    // Выведите русское название позиции самого дорогого немецкого игрока.
    fun expensiveGermanPlayerPosition(players: List<Player>): String?

    // Выберите команду с наибольшим числом удалений на одного игрока.
    fun rudestTeam(players: List<Player>): Team?
}
