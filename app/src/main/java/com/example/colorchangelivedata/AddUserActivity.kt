package com.example.colorchangelivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add_user.*

class AddUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        val userViewModel = ViewModelProviders.of(this).get(UsersViewModel::class.java)
        userViewModel.userAddData.observe(this, Observer { t -> Snackbar.make(root_add_user,t,Snackbar.LENGTH_LONG).show() }
        )
        add_user_btn.setOnClickListener {
            userViewModel.addNewUse(User(edit_name.text.toString()))
        }
    }
}

class UsersViewModel : ViewModel(){
    private val userLiveData = MutableLiveData<User>()
    val userAddData: LiveData<String> = Transformations.map(userLiveData,::somFun)

    private fun somFun(user: User) = "New User ${user.username} added to Database"

    fun addNewUse(user: User) = apply { userLiveData.value = user }
}
