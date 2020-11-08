package com.gruzini.rest

import com.google.gson.GsonBuilder
import com.gruzini.exceptions.NotFoundException
import com.gruzini.services.ArenaService
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.plugin.json.JavalinJson
import io.javalin.plugin.json.ToJsonMapper

class Rest(private val arenaService: ArenaService) : Runnable {
    override fun run() {
        app.start(7700)
    }

    private val app = Javalin
            .create()
            .apply {
                // Configuration of Json Mapper
                configureJsonMapper()

                // Setting status code to 404 on NotFoundException
                exception(NotFoundException::class.java) { _, ctx -> ctx.status(404) }

                // Sending message about internal error on any other unhandled exception
                exception(Exception::class.java) { _, ctx -> ctx.json("Internal server error") }

                // 404 error results in sending proper message
                error(404) { ctx -> ctx.json("404 - Not found") }
            }

    // anonymous class that is instance of ToJsonMapper and uses GSon to turn objects into JSons
    private fun configureJsonMapper() {
        val gson = GsonBuilder().create()
        JavalinJson.toJsonMapper = object : ToJsonMapper {
            override fun map(obj: Any): String = gson.toJson(obj)
        }
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
        }
    }
}