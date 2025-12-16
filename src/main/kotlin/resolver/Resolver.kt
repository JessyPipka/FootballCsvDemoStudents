package resolver

import model.Player
import model.Position
import model.Team

class Resolver : IResolver {

    override fun countWithoutAgency(players: List<Player>): Int =
        players.filter { it.agency.isNullOrBlank() }.count()

    override fun bestScorerDefender(players: List<Player>): Pair<String, Int>? =
        players
            .filter { it.position == Position.DEFENDER }
            .maxByOrNull { it.goals }
            ?.let { it.name to it.goals }

    override fun expensiveGermanPlayerPosition(players: List<Player>): String? =
        players
            .filter { it.nationality.equals("Germany", ignoreCase = true) }
            .maxByOrNull { it.transferCost }
            ?.position
            ?.russianName

    override fun rudestTeam(players: List<Player>): Team? =
        players
            .groupBy { it.team to it.city }
            .mapValues { (_, members) -> members.map { player -> player.redCards }.average() }
            .maxByOrNull { it.value }
            ?.let { (key, _) -> Team(name = key.first, city = key.second) }
}
