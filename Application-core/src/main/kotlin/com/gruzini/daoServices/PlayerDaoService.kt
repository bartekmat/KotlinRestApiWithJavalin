package com.gruzini.daoServices

import com.gruzini.dao.PlayerDao
import com.gruzini.mappers.PlayerDaoMapper
import com.gruzini.services.PlayerService

class PlayerDaoService (private val playerService: PlayerService, private val daoMapper: PlayerDaoMapper) {
    fun getPlayers(): List<PlayerDao> {
        return playerService.getPlayers().map(daoMapper::map)
    }
    fun getPlayersByPosition(position: String): List<PlayerDao> {
        return playerService.getPlayersByPosition(position).map(daoMapper::map)
    }
}