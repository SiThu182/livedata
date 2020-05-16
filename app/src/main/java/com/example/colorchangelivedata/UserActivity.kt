package com.example.colorchangelivedata

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_add_user.*
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

//    companion object{
//        fun getSwtichMapLiveData(callingClassContext : Context) = Intent(callingClassContext,UserActivity::class.java)
//    }

    private val userlist : MutableList<User> = ArrayList()
    private lateinit var userAdapter : UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        recycler_user.layoutManager =LinearLayoutManager(this)
        userAdapter = UserAdapter(this,userlist)
        recycler_user.adapter = userAdapter
        val viewModel = ViewModelProviders.of(this).get(UserGetViewModel::class.java)
        searchBtn.setOnClickListener { viewModel.searchUserByName(search_user.toString()) }
        viewModel.userNameResult.observe(this, Observer {
            if (userlist.isNotEmpty())
                userlist.clear()
            userlist.addAll(it)
            userAdapter.notifyDataSetChanged()
        })

        new_user_btn.setOnClickListener {
            var intent = Intent(this@UserActivity,AddUserActivity::class.java)
            startActivity(intent)
        }
    }
}

class UserGetViewModel : ViewModel(){
    private val query = MutableLiveData<String>()
    private val userRepo = UserRepo()

    val userNameResult: LiveData<List<User>> = Transformations.switchMap(
        query,
        ::temp
    )

    private fun temp(name: String) = userRepo.searchUserLis(name)

    fun searchUserByName(name: String ) =apply { query.value = name }


}