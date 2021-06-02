package com.example.livedemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.listitem.view.*

class ListAdapter (
    private val list: MutableList<Item>
        ) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

            class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.listitem,
                parent,
                false
            )
        )
    }

    fun addItem(item: Item){
        list.add(item)
        notifyItemInserted(list.size - 1)
    }

    fun deleteFinishedItem(){
        list.removeAll { item ->
            item.isChecked
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val curItem = list[position]
        holder.itemView.apply {
            tvListItem.text = curItem.title
            checkBox.isChecked = curItem.isChecked
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}