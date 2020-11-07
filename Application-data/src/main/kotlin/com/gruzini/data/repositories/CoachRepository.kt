package com.gruzini.data.repositories

import com.gruzini.data.Coach
import com.gruzini.data.Coaches
import com.gruzini.data.toCoach
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class CoachRepository(private val db: Database) {

    fun fetchAll(): List<Coach> {
        return transaction(db) {
            Coaches.selectAll().map { it.toCoach() }
        }
    }

    fun fetchById(id: Long): Coach? {
        return transaction(db) {
            Coaches.select { Coaches.id.eq(id) }.firstOrNull()?.toCoach()
        }
    }
}