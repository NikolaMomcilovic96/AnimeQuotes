package com.raywenderlich.animequotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.animequotes.R
import com.raywenderlich.animequotes.service.AnimeModel
import kotlinx.android.synthetic.main.anime_list_item.view.*

class AnimeRecyclerViewAdapter : RecyclerView.Adapter<AnimeRecyclerViewAdapter.MyViewHolder>() {

    private var newList = emptyList<AnimeModel>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.anime_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.animeTitleTextView.text = newList[position].anime
        holder.itemView.characterTextView.text = newList[position].character
        holder.itemView.quoteTextView.text = ",, " + newList[position].quote + " ''"
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    fun setData(quotes: List<AnimeModel>) {
        newList = quotes
        notifyDataSetChanged()
    }

}