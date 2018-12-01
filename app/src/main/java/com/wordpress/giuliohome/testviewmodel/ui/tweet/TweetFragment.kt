package com.wordpress.giuliohome.testviewmodel.ui.tweet

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wordpress.giuliohome.testviewmodel.R
import com.wordpress.giuliohome.testviewmodel.adapters.WordListAdapter
import com.wordpress.giuliohome.testviewmodel.data.Word
import com.wordpress.giuliohome.testviewmodel.utils.MyViewModelFactory
import android.support.v4.os.HandlerCompat.postDelayed
import java.util.*


class TweetFragment : Fragment() {

    companion object {
        fun newInstance() = TweetFragment()
    }

    private lateinit var viewModel: TweetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.tweet_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val recyclerView = getView()!!.findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = WordListAdapter(this.context!!)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.context!!)

        val app = getActivity()!!.getApplication()

        viewModel = ViewModelProviders.of(this, MyViewModelFactory(app))
            .get(TweetViewModel::class.java)

        //viewModel = ViewModelProviders.of(this).get(TweetViewModel::class.java)
        // TODO: Use the ViewModel

        viewModel.getAllWords().observe(this, Observer<List<Word>>() {
                // Update the cached copy of the words in the adapter.
            if (it != null){
                adapter.setWords(it)
            }
        })
        val timer = Timer()
        var counter = 0
        val monitor = object : TimerTask() {
            override fun run() {
                if (counter >= 10) {
                    viewModel.clear()
                    counter = 0
                    timer.cancel()
                } else {
                    viewModel.insert(Word("ciao..." + counter))
                    counter += 1
                }
            }
        }

        timer.schedule(monitor, 2000, 2000)

    }

}
