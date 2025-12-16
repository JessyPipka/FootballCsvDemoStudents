package parser

import model.Player
import model.Position

object CsvParser {

    fun parsePlayers(resourceName: String = "fakePlayers.csv"): List<Player> {
        val stream = javaClass.classLoader.getResourceAsStream(resourceName)
            ?: error("Resource $resourceName not found")

        return stream.bufferedReader().useLines { lines ->
            lines.drop(1) // skip header
                .map { parsePlayer(it) }
                .toList()
        }
    }

    private fun parsePlayer(line: String): Player {
        val cells = line.split(";")
        require(cells.size >= 12) { "Invalid line: $line" }

        val position = Position.fromCode(cells[3])
            ?: error("Unknown position code: ${cells[3]}")

        return Player(
            name = cells[0],
            team = cells[1],
            city = cells[2],
            position = position,
            nationality = cells[4],
            agency = cells[5].ifBlank { null },
            transferCost = cells[6].toInt(),
            participations = cells[7].toInt(),
            goals = cells[8].toInt(),
            assists = cells[9].toInt(),
            yellowCards = cells[10].toInt(),
            redCards = cells[11].toInt()
        )
    }
}
