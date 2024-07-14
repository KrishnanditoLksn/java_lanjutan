package org.example.generics.gencollections

data class BaseballPlayer(val name: String, val pos: String)

fun main() {
    val phillies = BaseballTeam("Sragen")
    val astro = BaseballTeam("Houston")
    scoreResult(phillies, 3, astro, 5)
    val dito = BaseballPlayer("Dito", "Defender")
    phillies.addTeamMember(dito)
    phillies.listTeamMember()
}

fun scoreResult(team1: BaseballTeam, t1Score: Int, team2: BaseballTeam, t2Score: Int) {
    val msg = team1.setScore(t1Score, t2Score)
    team2.setScore(t2Score, t1Score)
    println("$team1,$msg , $team2")
}