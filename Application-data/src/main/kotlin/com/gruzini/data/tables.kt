package com.gruzini.data

import com.gruzini.models.State
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Teams : Table() {
    val id: Column<Long> = long("id").autoIncrement()
    val name: Column<String> = varchar("name", 255)
    val abbreviation: Column<String> = varchar("abbreviation", 255)
    val state: Column<State> = enumerationByName("state", 255, State::class)
    val city: Column<String> = varchar("city", 255)
    val arenaId: Column<Long> = long("arenaId")
    val coachId: Column<Long> = long("coachId")

    override val primaryKey = PrimaryKey(id, name = "PK_Teams_Id")
}

object Players : Table () {
    val id: Column<Long> = long("id").autoIncrement()
    val firstName: Column<String> = varchar("firstName", 50)
    val surname: Column<String> = varchar("surname", 50)
    val height: Column<Int> = integer("height")
    val weight: Column<Int> = integer("weight")
    val age: Column<Int> = integer("age")
    val exp: Column<Int> = integer("experience")
    val teamId: Column<Long> = long("teamId")

    override val primaryKey = PrimaryKey(Teams.id, name = "PK_Players_Id")
}

object Coaches : Table () {
    val id: Column<Long> = long("id").autoIncrement()
    val firstName: Column<String> = varchar("firstName", 50)
    val surname: Column<String> = varchar("surname", 50)
    val age: Column<Int> = integer("age")
    val exp: Column<Int> = integer("experience")
    val teamId: Column<Long> = long("teamId")

    override val primaryKey = PrimaryKey(Teams.id, name = "PK_Coaches_Id")
}

object Arenas : Table () {
    val id: Column<Long> = long("id").autoIncrement()
    val name: Column<String> = varchar("name", 255)
    val seats: Column<Int> = integer("seats")

    override val primaryKey = PrimaryKey(Teams.id, name = "PK_Arenas_Id")
}

