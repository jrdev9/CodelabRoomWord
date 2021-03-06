package com.jrdev9.codelabroomword.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.jrdev9.codelabroomword.models.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM words")
    void deleteAll();

    @Query("SELECT * from words ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();
}