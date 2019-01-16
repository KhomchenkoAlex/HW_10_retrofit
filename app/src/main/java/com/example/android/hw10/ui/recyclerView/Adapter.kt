package com.example.android.hw10.ui.recyclerView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.hw10.R
import com.example.android.hw10.initData.Students
import kotlinx.android.synthetic.main.user_item.view.*

class Adapter(val callback: OnItemClick): RecyclerView.Adapter<Adapter.ViewHolder>() {

    private val items = Students.studentsList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemView.username.text = item.first
    }

    override fun getItemCount(): Int = items.size

    fun getStudentGitHubUsername(position: Int): String = items[position].second

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            callback.onUserClicked(adapterPosition)
        }
    }

    interface OnItemClick {
        fun onUserClicked(position: Int)
    }
}


