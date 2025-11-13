package com.example.personaltaskmanager.main

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.personaltaskmanager.databinding.ActivityTaskInfoBinding
import com.example.personaltaskmanager.db.data_dao
import com.example.personaltaskmanager.db.room_database
import com.example.personaltaskmanager.db.task_entity
import java.util.Calendar

@Suppress("DEPRECATION")
class task_info : AppCompatActivity() {
    companion object{
        const val update ="Update"
        const val add = "Save"
        const val edit_task = "task_data"

    }
    lateinit var binding: ActivityTaskInfoBinding     // in this file is the interface where we take input from user then update or edit it

    private lateinit var Dao : data_dao
    var taskid = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        binding= ActivityTaskInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val database = Room.databaseBuilder(this, room_database::class.java, "task_database").allowMainThreadQueries().build()


        Dao = database.getDao()

        if (intent.hasExtra(edit_task)){
            val getintent = intent.getParcelableExtra<task_entity>(edit_task)
            binding.apply{
                saveBtn.text = update
                saveBtn.icon=null
                textInputTitle.setText(getintent?.Title)
                description.setText(getintent?.discription)
                dateInput.setText(getintent?.duedate)
                taskid = getintent!!.id
            }
        }
        else{
            binding.saveBtn.text = add
        }

        binding.saveBtn.setOnClickListener {
            val title = binding.textInputTitle.text.toString().trim()
            val discription = binding.description.text.toString().trim()
            val date = binding.dateInput.text.toString().trim()

            if(binding.saveBtn.text==add){
                addnewtask(title,discription,date)
            }
            else{
                updatetask(title,discription,date)
            }

        }

        binding.dateInput.setOnClickListener {
            showDatePicker()
        }
    }

    private fun updatetask(title: String, discription: String, date: String) {
        val task = task_entity(taskid, title, discription, date)
        Dao.update_task(task)
        startActivity(Intent(this,Tasks::class.java))
        finish()
    }

    private fun addnewtask(title: String, discription: String, date: String) {
        val task = task_entity(taskid, title, discription, date)
        Dao.add_task(task)
        finish()
    }

    @SuppressLint("DefaultLocale")
    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->

            val formattedDate =String.format("%02d/%02d/%04d", selectedDay, selectedMonth + 1, selectedYear)

            binding.dateInput.setText(formattedDate)

        }, year, month, day)
        datePicker.show()
    }
}