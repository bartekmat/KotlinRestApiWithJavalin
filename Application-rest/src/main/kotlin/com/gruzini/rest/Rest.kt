package com.gruzini.rest

import com.gruzini.exceptions.NotFoundException
import com.gruzini.services.ArenaService
import com.gruzini.services.CoachService
import com.gruzini.services.PlayerService
import com.gruzini.services.TeamService
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path

class Rest(
        private val arenaService: ArenaService,
        private val teamService: TeamService,
        private val playerService: PlayerService,
        private val coachService: CoachService
) : Runnable {
    override fun run() {
        app.start(7700)
    }

    private val app = Javalin
            .create()
            .apply {
                // Configuration of Json Mapper
                // - I use GSon instead of the default for Javalin that is Jackson
                // - the reason is that Jackson requires fields to be public/have getters&setters
                // - GSon overcomes this problem
                configureJsonMapper()

                // Setting status code to 404 on NotFoundException
                exception(NotFoundException::class.java) { _, ctx -> ctx.status(404) }

                // Sending message about internal error on any other unhandled exception
                exception(Exception::class.java) { _, ctx -> ctx.json("Internal server error") }

                // 404 error results in sending proper message
                error(404) { ctx -> ctx.json("404 - Not found") }
            }

    init {
        app.routes {
            get("/") {
                it.json("Welcome to Gruzini application")
            }

            path("/arenas") {
                get { ctx ->
                    ctx.json(arenaService.getArenas())
                }
                path(":id") {
                    get { it.json(arenaService.getArenaById(it.pathParam("id").toLong())) }
                }
            }

            path("/teams") {
                get { ctx ->
                    ctx.json(teamService.getTeams())
                }
                path(":id") {
                    get { it.json(teamService.getTeamById(it.pathParam("id").toLong())) }
                }
            }

            path("/players") {
                get { ctx ->
                    ctx.json(playerService.getPlayers())
                }
                path(":position") {
                    get {
                        println("received paremeter" + it.pathParam("position"))
                        it.json(playerService.getPlayersByPosition(it.pathParam("position"))) }
                }
            }

            path("/coaches") {
                get { ctx ->
                    ctx.json(coachService.getCoaches())
                }
                path(":id") {
                    get { it.json(coachService.getCoachById(it.pathParam("id").toLong())) }
                }
            }

        }
    }
}