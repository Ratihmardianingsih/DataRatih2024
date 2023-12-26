package com.example.todolistapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "note_tb")
data class Note(
    val judul: String,
    val deskripsi: String,
    val tanggal: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
