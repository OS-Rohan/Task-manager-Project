package com.example.personaltaskmanager.db

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.personaltaskmanager.databinding.TaskInterfaceLayoutBinding

class task_adapter(val click_listner: handleclicks, private val task : List<task_entity>): RecyclerView.Adapter<task_adapter.Viewholder>() {

    interface handleclicks{
        fun edit (taskinfo: task_entity)
        fun delete (taskinfo: task_entity)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Viewholder {
        val binding = TaskInterfaceLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(
        holder: Viewholder,
        position: Int
    ) {

        val fullDescription = task[position].discription
        val shortDescription = if (fullDescription.length > 15) {                           // just a normal adapter class for recycler view
            "${fullDescription.take(20)}..."
        } else {
            fullDescription
        }

        with((holder.binding)) {
            titleTv.text = task[position].Title
            discriptionTv.text = shortDescription
            dateTv.text = "Due: ${task[position].duedate}"
            editBtn.setOnClickListener {
                click_listner.edit(task[position])
            }
            deleteBtn.setOnClickListener {
                click_listner.delete(task[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return task.size
    }


    inner class Viewholder(val binding : TaskInterfaceLayoutBinding): RecyclerView.ViewHolder(binding.root)
}