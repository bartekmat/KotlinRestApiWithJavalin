package com.gruzini.app.dbInit

import com.gruzini.data.Teams
import com.gruzini.models.State
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun teams(db: Database) {
    transaction(db) {
        Teams.insert {
            it[id] = 1
            it[name] = "Lakers"
            it[abbreviation] = "LAL"
            it[state] = State.CALIFORNIA
            it[city] = "Los Angeles"
            it[arenaId] = 3
            it[coachId] = 1
        }
        Teams.insert {
            it[id] = 2
            it[name] = "Knicks"
            it[abbreviation] = "NYK"
            it[state] = State.NEW_YORK
            it[city] = "New York"
            it[arenaId] = 4
            it[coachId] = 2
        }
        Teams.insert {
            it[id] = 3
            it[name] = "Pistons"
            it[abbreviation] = "DET"
            it[state] = State.MICHIGAN
            it[city] = "Detroit"
            it[arenaId] = 5
            it[coachId] = 3
        }
        Teams.insert {
            it[id] = 4
            it[name] = "Bulls"
            it[abbreviation] = "CHI"
            it[state] = State.ILLINOIS
            it[city] = "Chicago"
            it[arenaId] = 2
            it[coachId] = 4
        }
        Teams.insert {
            it[id] = 5
            it[name] = "76'ers"
            it[abbreviation] = "PHI"
            it[state] = State.PENNSYLVANIA
            it[city] = "Philadelphia"
            it[arenaId] = 1
            it[coachId] = 5
        }
    }
}