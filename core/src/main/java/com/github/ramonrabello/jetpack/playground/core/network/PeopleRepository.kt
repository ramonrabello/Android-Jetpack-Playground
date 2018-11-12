package com.github.ramonrabello.jetpack.playground.core.network

class PeopleRepository(private val peopleApi: PeopleApi) {

    fun loadPeople() = peopleApi.loadPeople()

    fun loadPerson(id: Int) = peopleApi.loadPersonById(id)

}
