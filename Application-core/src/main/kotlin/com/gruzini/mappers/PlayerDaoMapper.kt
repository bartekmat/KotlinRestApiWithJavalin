package com.gruzini.mappers

import com.gruzini.dao.PlayerDao
import com.gruzini.models.Player

class PlayerDaoMapper() {
    fun map(player: Player): PlayerDao {
        return PlayerDao(
                firstName = player.firstName,
                surname = player.surname,
                number = player.number,
                position = player.position
        )
    }
}

