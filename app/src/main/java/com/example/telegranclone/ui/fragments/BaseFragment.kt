package com.example.telegranclone.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.telegranclone.MainActivity
import com.example.telegranclone.R
import com.example.telegranclone.utilits.APP_ACTIVITY
import com.example.telegranclone.utilits.hideKeyboard

open class BaseFragment (layout: Int) : Fragment(layout) {


    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.mAppDrawer.disableDrawer()
        hideKeyboard()
    }

    override fun onStop() {
        super.onStop()
        APP_ACTIVITY.mAppDrawer.enableDrawer()
    }
}