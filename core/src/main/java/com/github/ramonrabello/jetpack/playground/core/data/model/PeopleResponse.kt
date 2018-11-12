package com.github.ramonrabello.jetpack.playground.core.data.model

data class PeopleResponse(
        private val cont: Int,
        private val next: String,
        private val previous: String,
        val results: List<PersonResponse>
)