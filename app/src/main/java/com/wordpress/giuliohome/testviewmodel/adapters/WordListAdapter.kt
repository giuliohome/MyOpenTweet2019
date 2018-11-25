package com.wordpress.giuliohome.testviewmodel.adapters

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.wordpress.giuliohome.testviewmodel.data.Word
import com.wordpress.giuliohome.testviewmodel.R.layout.recyclerview_item
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.wordpress.giuliohome.testviewmodel.R.id.textView
import android.widget.TextView
import com.wordpress.giuliohome.testviewmodel.R
import java.util.*

class WordListAdapter internal constructor(context: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    override fun getItemCount(): Int {
        var test : List<Word>? = null
        val check = mWords
        if (check != null )
        test = check
        if (test != null) {
            return test.size
        }
        else
            return 0
    }

    private val mInflater: LayoutInflater
    private var mWords: List<Word>? = null // Cached copy of words

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).


    inner class WordViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val wordItemView: TextView

        init {
            wordItemView = itemView.findViewById(R.id.textView)
        }
    }

    init {
        mInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val test = mWords;
        if (test != null ) {
            val current = test!![position]
            holder.wordItemView.text = current.word
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.text = "No Word"
        }
    }

    internal fun setWords(words: List<Word>) {
        mWords = words
        notifyDataSetChanged()
    }
}