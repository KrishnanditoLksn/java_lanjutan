package org.example.generics.gencollections

class SportsTeam(private var teamName: String) {
    private var teamMember: MutableList<Player> = ArrayList()
    private var totalwins: Int = 0
    private var totalLosses: Int = 0
    private var totalTies: Int = 0

    fun addTeamMember(
        player: Player,
    ) {
        if (teamMember.contains(player)) {
            println("Duplicate !!!")
        }
        teamMember.add(player)
    }

    fun listTeamMember() {
        println("$teamName Roster ")
        println(teamMember)
    }

    fun ranking(): Int {
        return (totalLosses * 2) + totalTies + 1
    }

    fun setScore(ourScore: Int, theirScore: Int): String {
        var message: String = "lost"
        if (ourScore > theirScore) {
            totalwins++
            message = "beat"
        } else if (ourScore == theirScore) {
            totalTies++
            message = "tied"
        } else {
            totalLosses++
        }
        return message
    }

    override fun toString(): String {
        return "teamName='$teamName', " +
                "teamMember=$teamMember, " +
                "totalwins=$totalwins, " +
                "totalLosses=$totalLosses, " +
                "totalTies=$totalTies)"
    }
}