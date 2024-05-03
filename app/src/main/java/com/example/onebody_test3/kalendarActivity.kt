package com.example.onebody_test3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.CalendarView
import android.widget.TextView

class KalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kalendar_layout)

        val calendarView: CalendarView = findViewById(R.id.calendar)
        val dateTextView: TextView = findViewById(R.id.date_view)

        // Установка обработчика выбора даты в календаре
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Обновление текста с выбранной датой
            val dateText = "$dayOfMonth/${month + 1}/$year"
            dateTextView.text = dateText
        }
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Создаем интент для запуска NotesActivity
            val intent = Intent(this, NotesActivity::class.java)
            // Передаем выбранную дату в NotesActivity
            intent.putExtra("year", year)
            intent.putExtra("month", month)
            intent.putExtra("dayOfMonth", dayOfMonth)
            // Запускаем NotesActivity
            startActivity(intent)
        }
    }
}
