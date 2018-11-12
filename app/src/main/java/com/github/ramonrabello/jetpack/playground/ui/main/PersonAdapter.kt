package com.github.ramonrabello.jetpack.playground.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.ramonrabello.jetpack.playground.R
import com.github.ramonrabello.jetpack.playground.core.data.model.PersonResponse
import kotlinx.android.synthetic.main.person_item.view.*

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    private val peopleList = mutableListOf<PersonResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)
        return PersonViewHolder(itemView)
    }

    override fun getItemCount() = peopleList.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(peopleList[position])
    }

    fun updatePeopleList(newList: List<PersonResponse>) {
        peopleList.addAll(newList)
        val diffUtilCallback = DiffUtilCallback(peopleList, newList)
        val diffUtil = DiffUtil.calculateDiff(diffUtilCallback)
        diffUtil.dispatchUpdatesTo(this)
    }

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: PersonResponse) {
            with(itemView) {
                personName.text = item.name
                personHeight.text = item.height
                personMass.text = item.mass
                personHairColor.text = item.hairColor
                when {
                    item.isFemale() -> personGenderImage.setImageResource(R.drawable.ic_female)
                    item.isMale() -> personGenderImage.setImageResource(R.drawable.ic_male)
                    item.isRobot() -> personGenderImage.setImageResource(R.drawable.ic_robot)
                }
            }
        }
    }

    private class DiffUtilCallback(
            private val oldList: List<PersonResponse>,
            private val newList: List<PersonResponse>
    ) : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                oldList[oldItemPosition].name == newList[newItemPosition].name

        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                oldList[oldItemPosition] == newList[newItemPosition]
    }

}