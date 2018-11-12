package com.github.ramonrabello.jetpack.playground.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.ramonrabello.jetpack.playground.R
import com.github.ramonrabello.jetpack.playground.core.arch.viewmodel.ScopedViewModel
import com.github.ramonrabello.jetpack.playground.core.data.model.PersonResponse
import com.github.ramonrabello.jetpack.playground.core.network.ApiProvider
import com.github.ramonrabello.jetpack.playground.core.network.PeopleRepository
import kotlinx.coroutines.launch

class MainViewModel : ScopedViewModel() {
    private val peopleRepository by lazy { PeopleRepository(ApiProvider.providePeopleApi()) }
    private val peopleListLoadedLiveData = MutableLiveData<Boolean>()
    private val errorMessageLiveData = MutableLiveData<Int>()

    fun peopleListChanges(): LiveData<List<PersonResponse>> {
        val personListLiveData = MutableLiveData<List<PersonResponse>>()

        scope.launch {
            val result = peopleRepository.loadPeople().await()
            if (result.isSuccessful) {
                personListLiveData.postValue(result.body()?.results)
                peopleListLoadedLiveData.postValue(true)
            } else {
                errorMessageLiveData.postValue(R.string.people_list_loading_error)
            }
        }
        return personListLiveData
    }

    fun peopleListLoaded() = peopleListLoadedLiveData

    fun errorMessage() = errorMessageLiveData
}
