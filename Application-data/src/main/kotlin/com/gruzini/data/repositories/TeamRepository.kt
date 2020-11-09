package com.gruzini.data.repositories

import com.gruzini.data.Players
import com.gruzini.data.Teams
import com.gruzini.data.toPlayer
import com.gruzini.data.toTeam
import com.gruzini.models.Player
import com.gruzini.models.Team
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class TeamRepository(private val db: Database) {

    fun fetchAll(): List<Team> {
        return transaction(db) {
            Teams.selectAll().map { it.toTeam() }
        }
    }

    fun fetchById(id: Long): Team? {
        return transaction(db) {
            Teams.select { Teams.id.eq(id) }.firstOrNull()?.toTeam()
        }
    }

    fun fetchPlayers(id: Long): List<Player> {
        return transaction(db) {
            Players.select { Players.teamId eq id }.map { it.toPlayer() }
        }
    }
}