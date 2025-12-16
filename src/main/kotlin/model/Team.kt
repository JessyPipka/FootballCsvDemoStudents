package model

/**
 * Represents a football club.
 *
 * @property name The club name, e.g. "Nevada whales" from fakePlayers.csv.
 * @property city The city the club belongs to, e.g. "South Carolina" from fakePlayers.csv.
 */
data class Team(
    val name: String,
    val city: String
)
