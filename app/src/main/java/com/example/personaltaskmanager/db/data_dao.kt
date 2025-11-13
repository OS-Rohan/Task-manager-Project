package com.example.personaltaskmanager.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface data_dao {   // a DAO file for room database

    @Insert
    fun add_task(task: task_entity)

    @Update
    fun update_task(task: task_entity)

    @Delete
    fun delete_task(task: task_entity)

    @Query("SELECT * FROM task_entity")
    fun fetch_task(): List<task_entity>

}