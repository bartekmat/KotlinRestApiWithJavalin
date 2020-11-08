package com.gruzini.app

import com.gruzini.data.Arenas
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun initializeData (db: Database) {
    transaction(db) {
        Arenas.insert {
            it[id] = 1
            it[name] = "Wells Fargo Center"
            it[seats] = 20478
        }
        Arenas.insert {
            it[id] = 2
            it[name] = "United Center"
            it[seats] = 20917
        }
        Arenas.insert {
            it[id] = 3
            it[name] = "Staples Center"
            it[seats] = 18997
        }
        Arenas.insert {
            it[id] = 4
            it[name] = "Madison Square Garden"
            it[seats] = 19812
        }
        Arenas.insert {
            it[id] = 5
            it[name] = "The Palace of Auburn Hills"
            it[seats] = 22076
        }
    }
}