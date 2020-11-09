package com.gruzini.daoServices

import com.gruzini.dao.PlayerDao
import com.gruzini.dao.TeamDao
import com.gruzini.mappers.PlayerDaoMapper
import com.gruzini.mappers.TeamDaoMapper
import com.gruzini.services.TeamService

class TeamDaoService (private val teamService: TeamService, private val playerMapper: PlayerDaoMapper, private val teamMapper: TeamDaoMapper) {
    fun getPlayers(id: Long) : List<PlayerDao> {
        return teamService.getPlayers(id).map(playerMapper::map)
    }
    fun getTeams() : List<TeamDao> {
        return teamService.getTeams().map(teamMapper::map)
    }
    fun getTeamById(id: Long) : TeamDao {
        return teamMapper.map(teamService.getTeamById(id))
    }
}