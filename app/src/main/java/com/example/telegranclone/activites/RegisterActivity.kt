package com.example.telegranclone.activites

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.telegranclone.R
import com.example.telegranclone.databinding.ActivityRegisterBinding
import com.example.telegranclone.ui.fragments.EnterPhoneNumberFragment
import com.example.telegranclone.utilits.initFirebase
import com.example.telegranclone.utilits.replaceFragment
import kotlinx.android.synthetic.main.activity_register.*

//import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRegisterBinding
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_register)
        initFirebase()
    }

    override fun onStart() {
        super.onStart()
        mToolbar = mBinding.registerToolbar
//        register_toolbar_title.text = getString(R.string.register_title_your_phone)
        registerToolbar.title = getString(R.string.register_title_your_phone)
        setSupportActionBar(mToolbar)
                replaceFragment(EnterPhoneNumberFragment())
    }
}