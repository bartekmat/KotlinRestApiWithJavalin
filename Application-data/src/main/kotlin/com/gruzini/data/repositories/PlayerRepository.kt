package com.gruzini.data.repositories

import com.gruzini.data.Players
import com.gruzini.data.toPlayer
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

    fun fetchPosition(position: String): List<Player> {
        return transaction(db) {
            Players.select { Players.position.eq(Position.valueOf(position.toUpperCase())) }.map { it.toPlayer() }
        }
    }
}