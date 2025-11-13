package com.example.personaltaskmanager.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.personaltaskmanager.main.Tasks
import com.example.personaltaskmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startV.setOnClickListener {
            val tasks_intent = Intent(this, Tasks::class.java)
            startActivity(tasks_intent)
        }


    }
}