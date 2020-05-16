package com.example.colorchangelivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class UserRepo{
    private val userlist : MutableList<User> = ArrayList()

    init {
        for ( i in 0..100) userlist.add(User("Hello user $i"))
    }

    fun  searchUserLis(name:String): LiveData<List<User>> {
        val searchList = ArrayList<User>()
        for(user in searchList){
            if(user.username.contains(regex = Regex(name)))
                searchList.add(user)
        }
            val temp = MutableLiveData<List<User>>()
            temp.value = searchList
            return  temp


    }
}