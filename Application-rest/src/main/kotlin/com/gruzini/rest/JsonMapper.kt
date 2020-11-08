package com.gruzini.rest

import com.google.gson.GsonBuilder
import io.javalin.plugin.json.JavalinJson
import io.javalin.plugin.json.ToJsonMapper

// anonymous class that is instance of ToJsonMapper and uses GSon to turn objects into JSons
fun configureJsonMapper() {
    val gson = GsonBuilder().create()
    JavalinJson.toJsonMapper = object : ToJsonMapper {
        override fun map(obj: Any): String = gson.toJson(obj)
    }
}