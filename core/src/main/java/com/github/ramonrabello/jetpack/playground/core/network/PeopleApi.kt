package com.github.ramonrabello.jetpack.playground.core.network

import com.github.ramonrabello.jetpack.playground.core.data.model.PeopleResponse
import com.github.ramonrabello.jetpack.playground.core.data.model.PersonResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PeopleApi {

    @GET("api/people/{id}")
    fun loadPersonById(@Path("id") id: Int): Deferred<Response<PersonResponse>>

    @GET("api/people")
    fun loadPeople(): Deferred<Response<PeopleResponse>>
}