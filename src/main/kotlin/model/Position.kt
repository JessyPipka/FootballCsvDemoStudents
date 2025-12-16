package model

enum class Position(val russianName: String) {
    GOALKEEPER("вратарь"),
    DEFENDER("защитник"),
    MIDFIELD("полузащитник"),
    FORWARD("нападающий");

    companion object {
        fun fromCode(code: String): Position? = values().firstOrNull {
            it.name.equals(code.trim(), ignoreCase = true)
        }
    }
}
