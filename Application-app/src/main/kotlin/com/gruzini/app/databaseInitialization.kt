package com.gruzini.app

import com.gruzini.app.dbInit.arenas
import com.gruzini.app.dbInit.coaches
import com.gruzini.app.dbInit.lakers
import com.gruzini.app.dbInit.teams
import org.jetbrains.exposed.sql.Database

fun initializeData(db: Database) {
    arenas(db)
    teams(db)
   // coaches(db)
    players(db)
}

private fun players(db: Database) {
    lakers(db)
}