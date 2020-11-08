package com.gruzini.services

import com.gruzini.data.repositories.PlayerRepository
import com.gruzini.exceptions.NotFoundException
import com.gruzini.models.Player

class PlayerService(private val repository: PlayerRepository) {
    fun getPlayers(): List<Player> {
        return repository.fetchAll()
    }

    fun getPlayerById(id: Long): Player {
        return repository.fetchById(id) ?: throw NotFoundException("Arena with id $id not found")
    }
}