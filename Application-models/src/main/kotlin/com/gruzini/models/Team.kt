package com.gruzini.models

data class Team (private val id: Long,
                 private val city: String,
                 private val name: String,
                 private val abbreviation: String,
                 private val state: State,
                 private val arenaId: Long,
                 private val coachId: Long
                    )