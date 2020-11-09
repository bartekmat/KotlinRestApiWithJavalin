package com.gruzini.services

import com.gruzini.data.repositories.TeamRepository
import com.gruzini.exceptions.NotFoundException
import com.gruzini.models.Player
import com.gruzini.models.Team

class TeamService(private val repository: TeamRepository) {
    fun getTeams(): List<Team> {
        return repository.fetchAll()
    }

    fun getTeamById(id: Long): Team {
        return repository.fetchById(id) ?: throw NotFoundException("Arena with id $id not found")
    }

    fun getPlayers(id: Long): List<Player> {
        return repository.fetchPlayers(id)
    }
}