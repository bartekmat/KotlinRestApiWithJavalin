package com.gruzini.app

import com.gruzini.data.Arenas
import com.gruzini.data.Coaches
import com.gruzini.data.Players
import com.gruzini.data.Teams
import com.gruzini.data.repositories.ArenaRepository
import com.gruzini.data.repositories.CoachRepository
import com.gruzini.data.repositories.PlayerRepository
import com.gruzini.data.repositories.TeamRepository
import com.gruzini.rest.Rest
import com.gruzini.services.ArenaService
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun main () {
    val tables = arrayOf(Arenas, Teams, Players, Coaches)
    val database = Database.connect("jdbc:postgresql://localhost:5432/javalinrest", driver = "org.postgresql.Driver", user = "postgres", password = "secret").also {
        transaction(it) {
            println("-----------------DROP CREATE------------------")
            SchemaUtils.drop(*tables)
            SchemaUtils.create(*tables)
        }
    }

    val arenaRepository = ArenaRepository(database)
    val teamRepository = TeamRepository(database)
    val playerRepository = PlayerRepository(database)
    val coachRepository = CoachRepository(database)

    val arenaService = ArenaService(arenaRepository)



    Rest(arenaService).run()
}