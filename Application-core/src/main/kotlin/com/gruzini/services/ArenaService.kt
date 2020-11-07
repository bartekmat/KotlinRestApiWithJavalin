package com.gruzini.services

import com.gruzini.data.repositories.ArenaRepository
import com.gruzini.exceptions.NotFoundException
import com.gruzini.models.Arena

class ArenaService (private val repository: ArenaRepository) {
    fun getArenas(): List<Arena> {
        return repository.fetchAll()
    }
    fun getArenaById(id: Long): Arena {
        return repository.fetchById(id)?: throw NotFoundException("Arena with id $id not found")
    }
}