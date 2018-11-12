package com.github.ramonrabello.jetpack.playground.core.data.model

data class PersonResponse(
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val gender: String
) {
    companion object {
        const val MALE = "male"
        const val FEMALE = "female"
        const val ROBOT = "n/a"
    }

    fun isMale() = MALE == gender
    fun isFemale() = FEMALE == gender
    fun isRobot() = ROBOT == gender
}