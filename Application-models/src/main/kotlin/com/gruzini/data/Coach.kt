package com.gruzini.data

data class Coach (
        private val id: Long,
        private val firstName: String,
        private val surname: String,
        private val age: Int,
        private val exp: Int,
        private val teamId: Long
)