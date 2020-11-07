package com.gruzini.app

import com.gruzini.data.repositories.ArenaRepository
import com.gruzini.data.repositories.CoachRepository
import com.gruzini.data.repositories.PlayerRepository
import com.gruzini.data.repositories.TeamRepository
import com.gruzini.rest.Rest
import org.jetbrains.exposed.sql.Database

fun main () {
    val database = Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver", user = "root", password = "")

    val arenaRepository = ArenaRepository(database)
    val teamRepository = TeamRepository(database)
    val playerRepository = PlayerRepository(database)
    val coachRepository = CoachRepository(database)



    Rest().run()
}