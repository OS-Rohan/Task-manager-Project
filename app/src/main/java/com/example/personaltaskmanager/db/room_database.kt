package com.example.personaltaskmanager.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [task_entity::class],version=1)
abstract class room_database: RoomDatabase() {

    abstract fun getDao(): data_dao
}