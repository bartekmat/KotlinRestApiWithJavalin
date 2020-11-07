package com.gruzini.data

data class Team (   private val id: Long,
                    private val name: String,
                    private val state: State,
                    private val city: String,
                    private val arenaId: Long,
                    private val coachId: Long
                    )