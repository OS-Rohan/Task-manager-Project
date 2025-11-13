# 🪴 Personal Task Manager – Android Task Manager App

Personal Task Manager is a lightweight and offline-first Android Task Manager built with Kotlin and Room Database.  
It helps users organize their daily tasks easily — add, edit, delete, and mark them as complete — all in a simple and modern interface.


---

## 🚀 About the Project

Task Nest was developed as a project for the test from CreativeIT Institute .  
The main goal was to understand the fundamentals of Android app development and database integration using Kotlin and Room.

---

## 🧰 Tech Stack

| Category                   | Tools & Libraries 				   |
|____________________________|_____________________________________________________|
|   Language                 | Kotlin 	      					   |
|   Database                 | Room Database 					   |
|   UI Components            | RecyclerView, CardView, FloatingActionButton 	   |
|   Design Framework         | Material Design 					   |
|   Utilities                | View Binding, DatePicker, SearchView, AlertDialog   |
|   Extra Library Implement  | Room,Kapt,Swipe to refresh, Percelize               |    

---

## 🧩 Key Features

- ➕ Add new tasks  
- ✏️ Edit and update existing tasks  
- 🗑️ Delete with confirmation dialogs  
- ✅ Mark tasks as completed    
- 📅 Choose due dates with a date picker  
- 📴 Works completely offline (local database)
- 🔄️ Refresh the tasks

---

## ⚙️ System Architecture

### Data Layer
- Built using **Room Database**
- Implements an `Entity`, `DAO`, and `Database` class
- Example entity:
  ```kotlin
  @Entity(tableName = "tasks")
  data class Task(
      @PrimaryKey(autoGenerate = true) val id: Int = 0,
      val title: String,
      val description: String,
      val dueDate: String,
      val isCompleted: Boolean = false
  )

## 🌇 UI Layer

- Displays task list using RecyclerView

- Uses separate views for adding, editing, and viewing tasks

 - Incorporates Material Design components for better UX



## 🧠 Challenges & Solutions

Problem	Solution


|Room dependency error         |	Added kapt in Gradle build file			|
|______________________________|________________________________________________________|
|RecyclerView not refreshing   |	Used notifyDataSetChanged()			|
|Date format inconsistency     |	Applied SimpleDateFormat with correct Locale	|
|SearchView reset issue        |	Manually cleared search logic			|


## 🎨 User Interface Highlights


-   Clean and modern Material Design layout

-   Swipe down to Refresh

-   Toasts and dialogs for user feedback

-   Purple & Black accent theme with rounded card corners



## 📚 What I Learned

Setting up and using Room Database

Implementing custom RecyclerView adapters

Working with View Binding for type safety

Managing Activity lifecycle

Writing cleaner and well-documented code

Using Logcat for debugging



##🔮 Future Enhancements

Task categories and priority levels

Reminder notifications

Cloud sync using Firebase

Dark mode support

Task statistics and progress graph

Swipe gesture to delete



## 🏁 Conclusion

Developing Personal Task Manager gave me hands-on experience with Android app development — from building UI with Material Design to managing data using Room Database.
It taught me that real learning happens not just by reading theory, but by building something real and solving problems along the way.


## 📸 Screenshots

<!-- First row: 4 images -->
<p float="left">
  <img src="https://github.com/user-attachments/assets/372f3396-5e8e-45cf-8a37-84a60619cb14" width="200" />
  <img src="https://github.com/user-attachments/assets/3d51a1b4-6c3e-4cfe-900d-bf3b4752c9df" width="200" />
  <img src="https://github.com/user-attachments/assets/26730d93-5122-4bdb-b5c1-aa71473229c8" width="200" />
  <img src="https://github.com/user-attachments/assets/f641d803-acb4-43bd-ae2e-a89c993e5fa6" width="200" />
</p>

<!-- Second row: 3 images -->
<p float="left">
  <img src="https://github.com/user-attachments/assets/23905375-0472-4218-ac40-c6b7f4762bef" width="200" />
  <img src="https://github.com/user-attachments/assets/5a52af16-99b0-43f1-8779-9f084b413360" width="200" />
  <img src="https://github.com/user-attachments/assets/b97d0413-2a31-4efb-9f2a-38d287cd9601" width="200" />
</p>






##Developed by:

👨‍💻 Md. Omar Sayed Roham

📩 srrd.famili13@gmail.com
