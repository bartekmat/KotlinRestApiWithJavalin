package com.gruzini.data.repositories

import com.gruzini.models.Arena
import com.gruzini.data.Arenas
import com.gruzini.data.toArena
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class ArenaRepository(private val db: Database) {

    fun fetchAll(): List<Arena> {
        return transaction(db) {
            Arenas.selectAll().map { it.toArena() }
        }
    }

    fun fetchById(id: Long): Arena? {
        return transaction(db) {
            Arenas.select { Arenas.id.eq(id) }.firstOrNull()?.toArena()
        }
    }
}