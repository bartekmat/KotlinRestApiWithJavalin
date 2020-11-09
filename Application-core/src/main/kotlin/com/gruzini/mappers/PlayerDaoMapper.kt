package com.gruzini.mappers

import com.gruzini.dao.PlayerDao
import com.gruzini.models.Player
import com.gruzini.services.TeamService

class PlayerDaoMapper(private val teamService: TeamService) {
    fun map(player: Player): PlayerDao {
        return PlayerDao(
                firstName = player.firstName,
                surname = player.surname,
                number = player.number,
                position = player.position,
                team = teamService.getTeamById(player.teamId)
        )
    }
}

