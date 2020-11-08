package com.gruzini.services

import com.gruzini.data.repositories.CoachRepository
import com.gruzini.exceptions.NotFoundException
import com.gruzini.models.Coach

class CoachService(private val repository: CoachRepository) {
    fun getCoaches(): List<Coach> {
        return repository.fetchAll()
    }

    fun getCoachById(id: Long): Coach {
        return repository.fetchById(id) ?: throw NotFoundException("Arena with id $id not found")
    }
}