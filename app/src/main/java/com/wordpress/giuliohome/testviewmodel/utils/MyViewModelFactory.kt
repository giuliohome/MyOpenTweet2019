package com.wordpress.giuliohome.testviewmodel.utils

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.wordpress.giuliohome.testviewmodel.ui.tweet.TweetViewModel


class MyViewModelFactory(private val mApplication: Application) :
    ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TweetViewModel(mApplication) as T
    }
}