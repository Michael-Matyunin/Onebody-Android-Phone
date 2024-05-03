package com.example.onebody_test3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация элементов пользовательского интерфейса
        emailEditText = findViewById(R.id.editTextEmail)
        passwordEditText = findViewById(R.id.editTextPassword)
        loginButton = findViewById(R.id.buttonLogin)
        registerButton = findViewById(R.id.buttonRegister)

        // Установка обработчиков нажатия кнопок
        loginButton.setOnClickListener {
            // Получение введенных данных
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Проверка введенных данных и выполнение необходимых действий
            if (isValidEmail(email) && isValidPassword(password)) {
                // Действия в случае успешного входа
                Toast.makeText(this, "Вход выполнен", Toast.LENGTH_SHORT).show()
                // Запуск активности профиля
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            } else {
                // Действия в случае неверных данных
                Toast.makeText(this, "Неверный email или пароль", Toast.LENGTH_SHORT).show()
            }
        }

        registerButton.setOnClickListener {
            // Действия при нажатии кнопки "Регистрация"
            Toast.makeText(this, "Открыта страница регистрации", Toast.LENGTH_SHORT).show()
        }
    }

    // Функция для проверки введенного email на валидность
    private fun isValidEmail(email: String): Boolean {
        // Реализуйте здесь вашу логику проверки валидности email
        // В данном примере просто проверяем, что строка содержит символ '@'
        return email.contains('@')
    }

    // Функция для проверки введенного пароля на валидность
    private fun isValidPassword(password: String): Boolean {
        // Реализуйте здесь вашу логику проверки валидности пароля
        // В данном примере просто проверяем, что длина пароля больше 6 символов
        return password.length >= 6
    }
}
