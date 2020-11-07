package com.gruzini.rest

import com.gruzini.exceptions.NotFoundException
import com.gruzini.services.ArenaService
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path

class Rest(private val arenaService: ArenaService) : Runnable {
    override fun run() {
        gruziniRestfulApplication.start(7700)
    }

    private val gruziniRestfulApplication = Javalin
            .create()
            .apply {
                exception(NotFoundException::class.java) { _, ctx -> ctx.status(404) }
                exception(Exception::class.java) { _, ctx -> ctx.json("Internal server error") }
                error(404) { ctx -> ctx.json("404 - Not found") }
            }
            .routes {
                get("/") {
                    it.json("Welcome to Gruzini application")
                }
                path("/arenas") {
                    get { it.json(arenaService.getArenas()) }
                    path(":id") {
                        get {it.json(it.pathParam("id").toLong())}
                    }
                }
            }
}