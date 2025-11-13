package com.example.personaltaskmanager.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity
@Parcelize
data class task_entity(@PrimaryKey(autoGenerate = true) val id: Int, val Title: String, val discription: String, val duedate: String): Parcelable


//entity of room database