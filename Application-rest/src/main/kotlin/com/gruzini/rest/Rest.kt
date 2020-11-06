package com.gruzini.rest

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get

class Rest() : Runnable {
    override fun run() {
        gruziniRestfulApplication.start(7700)
    }

    private val gruziniRestfulApplication = Javalin
            .create()
            .routes {
                get("/") {
                    it.json("Welcome to Gruzini application")
                }
            }
}