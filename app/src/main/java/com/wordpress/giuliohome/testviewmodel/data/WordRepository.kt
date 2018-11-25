package com.wordpress.giuliohome.testviewmodel.data

import android.app.Application
import android.os.AsyncTask
import android.arch.lifecycle.LiveData


class WordRepository internal constructor(application: Application) {

    private var mWordDao: WordDao? = null
    private var mAllWords: LiveData<List<Word>>? = null

    fun getAllWords(): LiveData<List<Word>> {
        return this!!.mAllWords!!
    }

    init {
        val db = WordRoomDatabase.getDatabase(application)
        mWordDao = db!!.wordDao()
        mAllWords = mWordDao!!.allWords
    }


    fun insert(word: Word) {
        val check = mWordDao
        if (check != null) {
            insertAsyncTask(check).execute(word)
        }
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: WordDao) :
        AsyncTask<Word, Void, Unit>() {

        override fun doInBackground(vararg params: Word) {
            mAsyncTaskDao.insert(params[0])
            return
        }
    }
}