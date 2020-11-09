package com.gruzini.dao

import com.gruzini.models.Arena
import com.gruzini.models.State

data class TeamDao(
        val city: String,
        val name: String,
        val abbreviation: String,
        val state: State,
        val arena: Arena,
        val players: List<PlayerDao>

)