package com.gruzini.mappers

import com.gruzini.dao.TeamDao
import com.gruzini.models.Team
import com.gruzini.services.ArenaService
import com.gruzini.services.TeamService

class TeamDaoMapper(private val arenaService: ArenaService, private val teamService: TeamService, private val playerDaoMapper: PlayerDaoMapper) {
    fun map(team: Team): TeamDao {
        return TeamDao(
                name = team.name,
                city = team.city,
                abbreviation = team.abbreviation,
                state = team.state,
                arena = arenaService.getArenaById(team.arenaId),
                players = teamService.getPlayers(team.id).map(playerDaoMapper::map)
        )
    }
}