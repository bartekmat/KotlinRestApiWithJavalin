package com.gruzini.app

import com.gruzini.data.Arenas
import com.gruzini.data.Coaches
import com.gruzini.data.Players
import com.gruzini.data.Teams
import com.gruzini.data.repositories.ArenaRepository
import com.gruzini.data.repositories.CoachRepository
import com.gruzini.data.repositories.PlayerRepository
import com.gruzini.data.repositories.TeamRepository
import com.gruzini.mappers.PlayerDaoMapper
import com.gruzini.rest.Rest
import com.gruzini.services.ArenaService
import com.gruzini.services.CoachService
import com.gruzini.services.PlayerService
import com.gruzini.services.TeamService
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection

fun main() {
    val tables = arrayOf(Arenas, Teams, Players, Coaches)
    val database = Database.connect("jdbc:postgresql://localhost:5432/javalinrest", driver = "org.postgresql.Driver", user = "postgres", password = "secret")
            .also {
                transaction(it) {
                    addLogger(StdOutSqlLogger)
                    println("-----------------DROP CREATE------------------")
                    SchemaUtils.drop(*tables)
                    SchemaUtils.create(*tables)
                }
            }
    initializeData(database)

    val arenaRepository = ArenaRepository(db = database)
    val teamRepository = TeamRepository(db = database)
    val playerRepository = PlayerRepository(db = database)
    val coachRepository = CoachRepository(db = database)

    val arenaService = ArenaService(repository = arenaRepository)
    val teamService = TeamService(repository = teamRepository)
    val playerDaoMapper = PlayerDaoMapper(teamService = teamService)
    val playerService = PlayerService(repository = playerRepository, daoMapper = playerDaoMapper)
    val coachService = CoachService(repository = coachRepository)

    playerService.getPlayersByPosition("center")

    Rest(arenaService, teamService, playerService, coachService).run()
}