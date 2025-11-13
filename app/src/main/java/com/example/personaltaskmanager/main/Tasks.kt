package com.example.personaltaskmanager.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Dao
import androidx.room.Room
import com.example.personaltaskmanager.databinding.ActivityTasksBinding
import com.example.personaltaskmanager.db.data_dao
import com.example.personaltaskmanager.db.room_database
import com.example.personaltaskmanager.db.task_adapter
import com.example.personaltaskmanager.db.task_entity

class Tasks : AppCompatActivity(), task_adapter.handleclicks {
    lateinit var binding: ActivityTasksBinding    //here in this file you can see the interface of the RecyclerViews
    lateinit var adapter : task_adapter
    private lateinit var Dao : data_dao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Room.databaseBuilder(this, room_database::class.java, "task_database").allowMainThreadQueries().build()


        Dao = database.getDao()

        tasks()

        binding.swipeRefreshLayout.setOnRefreshListener {
            tasks()
            binding.swipeRefreshLayout.isRefreshing = false
        }

            binding.addUesr.setOnClickListener {
            val task_intent = Intent(this@Tasks, task_info::class.java)
            startActivity(task_intent)
        }

    }

    private fun tasks() {
        Dao.fetch_task().apply {
            adapter= task_adapter(this@Tasks,this)
            binding.taskRv.adapter = adapter
        }
    }

    override fun edit(taskinfo: task_entity) {
        val task_intent = Intent(this@Tasks, task_info::class.java)
        task_intent.putExtra("task_data",taskinfo)
        startActivity(task_intent)
        finish()
    }

    override fun delete(taskinfo: task_entity) {
        Dao.delete_task(taskinfo)
        tasks()
    }
}