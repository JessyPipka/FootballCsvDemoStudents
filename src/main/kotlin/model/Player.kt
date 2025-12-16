package model

import java.math.BigDecimal

/**
 * Represents a player row from [src/main/resources/fakePlayers.csv].
 *
 * Column mapping:
 * - Name
 * - Team (club name)
 * - City (club city)
 * - Position
 * - Nationality
 * - Agency (may be absent)
 * - Transfer cost
 * - Participations
 * - Goals
 * - Assists
 * - Yellow cards
 * - Red cards
 */
data class Player(
    val name: String,
    val team: Team,
    val position: String,
    val nationality: String,
    val agency: String?,
    val transferCost: BigDecimal,
    val participations: Int,
    val goals: Int,
    val assists: Int,
    val yellowCards: Int,
    val redCards: Int
)
