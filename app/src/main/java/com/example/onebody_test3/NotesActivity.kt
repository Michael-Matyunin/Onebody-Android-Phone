
package com.example.onebody_test3

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


import java.util.ArrayList

class NotesActivity : AppCompatActivity() {

    private lateinit var notesListView: ListView
    private lateinit var notesEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var dateTextView: TextView

    private lateinit var notesAdapter: ArrayAdapter<String>
    private val notesList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notes_layout)

        // Инициализация элементов интерфейса
        notesListView = findViewById(R.id.notesListView)
        notesEditText = findViewById(R.id.notesEditText)
        saveButton = findViewById(R.id.saveButton)
        dateTextView = findViewById(R.id.dateTextView)

        // Инициализация адаптера для списка заметок
        notesAdapter = ArrayAdapter(this, R.layout.list_item_note, R.id.noteTextView, notesList)

        // Привязка адаптера к ListView
        notesListView.adapter = notesAdapter

        // Обработчик нажатия на кнопку "Сохранить"
        saveButton.setOnClickListener {
            val note = notesEditText.text.toString().trim()
            if (note.isNotEmpty()) {
                notesList.add("${notesList.size + 1}. $note")
                notesAdapter.notifyDataSetChanged()
                notesEditText.text.clear()
            }
        }

        // Получаем переданные данные из интента и отображаем дату
        val year = intent.getIntExtra("year", 0)
        val month = intent.getIntExtra("month", 0)
        val dayOfMonth = intent.getIntExtra("dayOfMonth", 0)
        val dateText = "$dayOfMonth.${month + 1}.$year"
        dateTextView.text = dateText
    }
}

