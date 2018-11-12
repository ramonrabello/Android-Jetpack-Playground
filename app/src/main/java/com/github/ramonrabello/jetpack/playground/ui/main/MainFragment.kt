package com.github.ramonrabello.jetpack.playground.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ramonrabello.jetpack.playground.R
import com.github.ramonrabello.jetpack.playground.core.coroutines.scope.LifecycleScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {

    private val peopleAdapter by lazy { PersonAdapter() }
    private val lifecycleScope = LifecycleScope()
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(lifecycleScope)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        peopleListRecyclerView.adapter = peopleAdapter
        peopleListRecyclerView.layoutManager = LinearLayoutManager(activity)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        observePeopleListChanges()
        observePeopleListLoaded()
        observeError()
    }

    private fun observePeopleListChanges() {
        viewModel.peopleListChanges().observe(this@MainFragment, Observer { peopleList ->
            peopleAdapter.updatePeopleList(peopleList)
        })
    }

    private fun observePeopleListLoaded() {
        viewModel.peopleListLoaded().observe(this@MainFragment, Observer { wasListLoaded ->
            loadingProgressBar.visibility = if (wasListLoaded) View.GONE else View.VISIBLE
            peopleListRecyclerView.visibility = if (wasListLoaded) View.VISIBLE else View.GONE
        })
    }

    private fun observeError() {
        viewModel.errorMessage().observe(this@MainFragment, Observer { errorMessageId ->
            Snackbar.make(main, errorMessageId, Snackbar.LENGTH_SHORT).show()
        })
    }
}
