package com.example.todolistapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface NoteDao {
    @Insert
    suspend fun addNote(note: Note)

    @Query("SELECT * FROM note_tb ORDER BY id DESC")
    suspend fun getAllNote(): List<Note>

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}