package com.gruzini.models

data class Player (
        val id: Long,
        val firstName: String,
        val surname: String,
        val number: Int,
        val position: Position,
        val height: Int,
        val weight: Int,
        val age: Int,
        val careerLength: Int,
        val teamId: Long
)