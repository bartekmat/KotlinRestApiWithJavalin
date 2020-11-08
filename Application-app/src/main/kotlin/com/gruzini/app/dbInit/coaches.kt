package com.gruzini.app.dbInit

import com.gruzini.data.Coaches
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun coaches(db: Database) {
    transaction(db) {
        Coaches.insert {
            it[id] = 5
            it[firstName] = "Doc"
            it[surname] = "Rivers"
            it[age] = 59
            it[exp] = 21
            it[teamId] = 5
        }
        Coaches.insert {
            it[id] = 1
            it[firstName] = "Frank"
            it[surname] = "Vogel"
            it[age] = 47
            it[exp] = 9
            it[teamId] = 1
        }
        Coaches.insert {
            it[id] = 3
            it[firstName] = "Dwayne"
            it[surname] = "Casey"
            it[age] = 63
            it[exp] = 11
            it[teamId] = 3
        }
        Coaches.insert {
            it[id] = 2
            it[firstName] = "Tom"
            it[surname] = "Thibodeau"
            it[age] = 62
            it[exp] = 8
            it[teamId] = 2
        }
        Coaches.insert {
            it[id] = 4
            it[firstName] = "Jim"
            it[surname] = "Boylen"
            it[age] = 55
            it[exp] = 2
            it[teamId] = 4
        }
    }
}