package com.wordpress.giuliohome.testviewmodel.ui.tweet

import android.app.Application
import android.app.PendingIntent.getActivity
import android.arch.lifecycle.ViewModel
import com.wordpress.giuliohome.testviewmodel.data.Word
import android.arch.lifecycle.LiveData
import android.support.annotation.NonNull
import com.wordpress.giuliohome.testviewmodel.data.WordRepository
import com.wordpress.giuliohome.testviewmodel.data.WordDao







public class TweetViewModel(@NonNull application: Application) : ViewModel() {

    private val mRepository: WordRepository

    private val mWordDao: WordDao? = null
    private var mAllWords: LiveData<List<Word>>? = null

    init {
        mRepository = WordRepository(application)
        mAllWords = mRepository.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>> {
        return mAllWords!!
    }

    fun insert(word: Word) {
        mRepository.insert(word)
    }
}
