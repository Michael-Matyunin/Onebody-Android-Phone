package com.example.onebody_test3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_layout)

        val logoutButton: Button = findViewById(R.id.buttonLogout)

        // Установка обработчика нажатия на кнопку "Выйти"
        logoutButton.setOnClickListener {
            // Создание интента для запуска MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Запуск MainActivity
            startActivity(intent)
            // Завершение текущей активности (com.example.onebody_test3.ProfileActivity)
            finish()
        }

        val calendarButton: Button = findViewById(R.id.buttonCalendar)
        calendarButton.setOnClickListener {
            // Создание интента для запуска KalendarActivity
            val intent = Intent(this, KalendarActivity::class.java)
            // Запуск KalendarActivity
            startActivity(intent)
        }

        // Здесь вы можете добавить код для настройки профиля, загрузки данных и т. д.
    }
}
