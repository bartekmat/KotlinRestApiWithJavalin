package com.gruzini.models

data class Player (
        private val id: Long,
        private val firstName: String,
        private val surname: String,
        private val number: Int,
        private val position: Position,
        private val height: Int,
        private val weight: Int,
        private val age: Int,
        private val exp: Int,
        private val teamId: Long
)