package com.gruzini.services

import com.gruzini.dao.PlayerDao
import com.gruzini.data.repositories.PlayerRepository
import com.gruzini.exceptions.NotFoundException
import com.gruzini.mappers.PlayerDaoMapper
import com.gruzini.models.Player

class PlayerService(private val repository: PlayerRepository, private val daoMapper: PlayerDaoMapper) {
    fun getPlayers(): List<Player> {
        return repository.fetchAll()
    }

    fun getPlayerById(id: Long): Player {
        return repository.fetchById(id) ?: throw NotFoundException("Arena with id $id not found")
    }

    fun getPlayersByPosition(position: String): List<PlayerDao> {
        val list = repository.fetchPosition(position)
        println("fetched $list")
        val mapped = list.map(daoMapper::map)
        println("mapped $mapped")
        return mapped
    }
}