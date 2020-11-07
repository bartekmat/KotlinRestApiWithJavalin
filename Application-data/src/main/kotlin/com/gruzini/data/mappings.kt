package com.gruzini.data

import com.gruzini.models.Arena
import com.gruzini.models.Coach
import com.gruzini.models.Player
import com.gruzini.models.Team
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toArena() : Arena = Arena(
        id = this[Arenas.id],
        name = this[Arenas.name],
        seats = this[Arenas.seats]
)

fun ResultRow.toTeam() : Team = Team(
        id = this[Teams.id],
        name = this[Teams.name],
        abbreviation = this[Teams.abbreviation],
        state = this[Teams.state],
        city = this[Teams.city],
        arenaId = this[Teams.arenaId],
        coachId = this[Teams.coachId]
)

fun ResultRow.toCoach() : Coach = Coach(
        id = this[Coaches.id],
        firstName = this[Coaches.firstName],
        surname = this[Coaches.surname],
        age = this[Coaches.age],
        exp = this[Coaches.exp],
        teamId = this[Coaches.teamId]
)

fun ResultRow.toPlayer() : Player = Player(
        id = this[Players.id],
        firstName = this[Players.firstName],
        surname = this[Players.surname],
        height = this[Players.height],
        weight = this[Players.weight],
        age = this[Players.age],
        exp = this[Players.exp],
        teamId = this[Players.teamId]
)
