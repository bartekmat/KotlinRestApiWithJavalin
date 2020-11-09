package com.gruzini.data.repositories

import com.gruzini.data.Players
import com.gruzini.data.Teams
import com.gruzini.data.toPlayer
import com.gruzini.data.toTeam
import com.gruzini.models.Player
import com.gruzini.models.Position
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class PlayerRepository(private val db: Database) {

    fun fetchAll(): List<Player> {
        return transaction(db) {
            Players.selectAll().map { it.toPlayer() }
        }
    }

    fun fetchById(id: Long): Player? {
        return transaction(db) {
            Players.select { Players.id.eq(id) }.firstOrNull()?.toPlayer()
        }
    }

    fun fetchByPosition(position: String): List<Player> {
        return transaction(db) {
            Players.select { Players.position.eq(Position.valueOf(position.toUpperCase())) }
                    .orderBy(Players.surname)
                    .map { it.toPlayer() }
        }
    }

    fun fetchByTeam(team: String): List<Player> {
        return transaction(db) {
            val selectedTeam = Teams.select { Teams.name eq team.toLowerCase().replaceFirst(team[0], team[0].toUpperCase()) }.map { it.toTeam() }.first()
            return@transaction Players.select { Players.teamId eq selectedTeam.id }.map { it.toPlayer() }
        }
    }
}