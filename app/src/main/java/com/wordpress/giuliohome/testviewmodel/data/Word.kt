package com.wordpress.giuliohome.testviewmodel.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.room.*


@Entity(tableName = "word_table")
class Word(
    @field:PrimaryKey
    @field:ColumnInfo(name = "word")
    val word: String
)

@Dao
interface WordDao {

    @get:Query("SELECT * from word_table ORDER BY word ASC")
    val allWords: LiveData<List<Word>>

    @Insert
    fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()
}