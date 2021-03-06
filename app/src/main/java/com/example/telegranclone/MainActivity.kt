package com.example.telegranclone

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.telegranclone.activites.RegisterActivity
import com.example.telegranclone.databinding.ActivityMainBinding
import com.example.telegranclone.models.User
import com.example.telegranclone.ui.fragments.ChatFragment
import com.example.telegranclone.ui.objects.AppDrawer
import com.example.telegranclone.utilits.*
import com.theartofdev.edmodo.cropper.CropImage


class MainActivity : AppCompatActivity() {


    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolbar: androidx.appcompat.widget.Toolbar
    lateinit var mAppDrawer: AppDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        initFirebase()
        initUser{
            initFields()
            initFunc()
        }
    }


    private fun initFunc(){
        if(AUTH.currentUser != null) {
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(ChatFragment(),false)
        }else{
            replaceActivity(RegisterActivity())
        }
    }

    private fun initFields(){
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)

    }

    override fun onStart() {
        super.onStart()
        AppStates.updateState(AppStates.ONLINE)
    }

    override fun onStop() {
        super.onStop()
        AppStates.updateState(AppStates.OFFLINE)
    }
}