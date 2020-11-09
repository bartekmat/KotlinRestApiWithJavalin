package com.gruzini.dao

import com.gruzini.models.Position

class PlayerDao(
        private val firstName: String,
        private val surname: String,
        private val number: Int,
        private val position: Position
)