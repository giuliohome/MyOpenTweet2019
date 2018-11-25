package com.wordpress.giuliohome.testviewmodel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wordpress.giuliohome.testviewmodel.ui.tweet.TweetFragment
import android.support.v7.widget.LinearLayoutManager
import com.wordpress.giuliohome.testviewmodel.adapters.WordListAdapter
import android.support.v7.widget.RecyclerView



class TweetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tweet_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TweetFragment.newInstance())
                .commitNow()
        }
    }

}
