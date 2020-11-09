package com.gruzini.models

data class Team (val id: Long,
                 val city: String,
                 val name: String,
                 val abbreviation: String,
                 val state: State,
                 val arenaId: Long,
                 val coachId: Long
                    )