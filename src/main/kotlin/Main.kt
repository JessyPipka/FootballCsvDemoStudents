import parser.CsvParser
import resolver.IResolver
import resolver.Resolver

fun main() {
    val players = CsvParser.parsePlayers()
    val resolver: IResolver = Resolver()

    println("Players without agency: ${resolver.countWithoutAgency(players)}")
    resolver.bestScorerDefender(players)?.let { (name, goals) ->
        println("Best defender scorer: $name with $goals goals")
    }
    resolver.expensiveGermanPlayerPosition(players)?.let { position ->
        println("Most expensive German player position: $position")
    }
    resolver.rudestTeam(players)?.let { team ->
        println("Rudest team: ${team.name} (${team.city})")
    }
}
