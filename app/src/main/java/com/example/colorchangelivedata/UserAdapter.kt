package com.example.colorchangelivedata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(context: Context, var userlist: List<User>): RecyclerView.Adapter<UserViewModel>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewModel {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.user,parent,false)
        return  UserViewModel(view)
    }

    override fun getItemCount(): Int = userlist.size

    override fun onBindViewHolder(holder: UserViewModel, position: Int) {
        val user = userlist[position]
        holder.userName.text = user.username
    }

}

class UserViewModel(itemView: View): RecyclerView.ViewHolder(itemView){
    var userName :TextView = itemView.findViewById(R.id.userNameTextView)
}